package com.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 14:29
 * @Description:
 */
@Data
public class OrderForm {
    /** 传入的数据
     * name: "张三"
     * phone: "18868822111"
     * address: "慕课网总部"
     * openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
     * items: [{
     *     productId: "1423113435324",
     *     productQuantity: 2 //购买数量
     * }]
     */

    /** 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家手机号 */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** 买家地址 */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家微信 openid*/
    @NotEmpty(message = "openid必填")
    private String openid;

    /** 购物车 */
    @NotEmpty(message = " 购物车不能为空")
    private String items;

}
