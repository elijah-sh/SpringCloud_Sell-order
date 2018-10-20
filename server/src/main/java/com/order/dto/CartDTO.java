package com.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/15 16:05
 * @Description:  购物车  包含商品id和数量
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;
}
