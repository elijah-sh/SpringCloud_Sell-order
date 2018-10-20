package com.order.enums;

import lombok.Getter;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 13:58
 * @Description:
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消")
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
