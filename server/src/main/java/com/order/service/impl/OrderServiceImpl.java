package com.order.service.impl;

import com.product.client.ProductClient;
import com.order.dataobject.OrderDetail;
import com.order.dataobject.OrderMaster;
import com.order.dataobject.ProductInfo;
import com.order.dto.CartDTO;
import com.order.dto.OrderDTO;
import com.order.enums.OrderStatusEnum;
import com.order.enums.PayStatusEnum;
import com.order.repository.OrderDetailRepository;
import com.order.repository.OrderMasterRepository;
import com.order.service.IOrderService;
import com.order.utils.KeyUtil;
import com.product.common.DecreaseStockInput;
import com.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 14:32
 * @Description:
 */
@Service
public class OrderServiceImpl implements IOrderService {

   @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //   查询商品信息（调用商品服务）
       String orderId = KeyUtil.genUniqueKey();
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        //   计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            for (ProductInfoOutput productInfoOutput: productInfoList){
                if (productInfoOutput.getProductId().equals(orderDetail.getProductId())){
                    // 单价* 数量
                    orderAmout = productInfoOutput.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);

                    // 订单详情入库
                    BeanUtils.copyProperties(productInfoOutput,orderDetail);  // 只是id和数量
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //   扣库存 （调用商品服务）
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId); // 设置订单号
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result =  orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
