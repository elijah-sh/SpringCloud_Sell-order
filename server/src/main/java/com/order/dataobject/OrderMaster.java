package com.order.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 11:25
 * @Description: 订单
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderMaster {

    /** 订单id  */
    @Id
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String  buyerPhone;

    /** 买家地址 */
    private String  buyerAddress;

    /** 买家微信Openid */
    private String  buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，默认为0 新下单 */
    private Integer  orderStatus;

    /** 支付状态，默认为0 未支付 */
    private Integer  payStatus;

}
