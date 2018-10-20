package com.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.order.dataobject.OrderDetail;
import com.order.dto.OrderDTO;
import com.order.enums.ResultEnum;
import com.order.exception.OrderException;
import com.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 16:01
 * @Description:
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert (OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            // new TypeToken<List<Person>>(){}是一个匿名内部类
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【json转换】错误，string={}",orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    ResultEnum.PARAM_ERROR.getMessage());
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
