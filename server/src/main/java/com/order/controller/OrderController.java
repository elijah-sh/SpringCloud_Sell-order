package com.order.controller;

import com.order.VO.ResultVO;
import com.order.converter.OrderForm2OrderDTOConverter;
import com.order.dto.OrderDTO;
import com.order.enums.ResultEnum;
import com.order.exception.OrderException;
import com.order.form.OrderForm;
import com.order.service.IOrderService;
import com.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 15:00
 * @Description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    /**
     *  1. 参数检验
     *  2. 查询商品信息（调用商品服务）
     *  3. 计算总价
     *  4. 扣库存 （调用商品服务）
     *  5. 订单入库
     */
    @Autowired
    private IOrderService orderService;
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                       BindingResult bindingResult)  {

        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        // orderFrom -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY.getCode(),
                    ResultEnum.CART_EMPTY.getMessage());
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        /**
         * {
         *   "code": 0,
         *   "msg": "成功",
         *   "data": {
         *       "orderId": "147283992738221"
         *   }
         * }
         */
        return ResultVOUtil.success(map);

    }
}
