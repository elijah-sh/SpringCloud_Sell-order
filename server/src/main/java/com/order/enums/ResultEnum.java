package com.order.enums;

import lombok.Getter;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 13:58
 * @Description:
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2,"购物车信息为空")
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
