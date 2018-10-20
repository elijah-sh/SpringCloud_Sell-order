package com.order.enums;

import lombok.Getter;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 13:58
 * @Description:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
