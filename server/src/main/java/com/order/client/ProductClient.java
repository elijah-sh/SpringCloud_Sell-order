package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/15 08:48
 * @Description:
 */
@FeignClient("product")               //应用名称
@Service
public interface ProductClient {

    @GetMapping("/product/msg")
    String productMsg();

    /**
     *  根据商品ID 查询 商品信息
     * @param productInfoList
     * @return
     */
    /*@PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productInfoList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);*/
}
