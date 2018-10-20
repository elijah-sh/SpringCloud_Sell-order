package com.order.service;

import com.order.dto.OrderDTO;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 14:30
 * @Description:
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
