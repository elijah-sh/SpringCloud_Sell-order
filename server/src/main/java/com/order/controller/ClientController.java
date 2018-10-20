package com.order.controller;

import com.order.dataobject.ProductInfo;
import com.order.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/12 09:22
 * @Description:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class ClientController {

    private static final String REST_URL_PREFIX = "http://PRODUCT";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

  /*  @Autowired
    private ProductClient productClient;
*/
    //@GetMapping("/getProductMsg")
    public String getProductMsg(){
        // 第一种方式  直接使用restTemplate URL写死
        // RestTemplate restTemplate = new RestTemplate();
        // String response = restTemplate.getForObject("http://127.0.0.1:7001/product/msg",String.class);

        // 第二种方式  利用loadBanlancerClient获取URL+ restTemplate
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
         String url = String.format("http://%s:%s%s",serviceInstance.getHost(),serviceInstance.getPort(),"/product/msg");  //%s 占位符
        log.info("URL={}",url);
        String response = restTemplate.getForObject(url,String.class);
        // 第三种方式
      // String response = restTemplate.getForObject(REST_URL_PREFIX+"/product/msg",String.class);
        return response;
    }

 /*   @GetMapping("/getProductMsg")
    public String getProductMsgServer(){
        String response = productClient.productMsg();
        return response;
    }*/

    @GetMapping("/getProductList")
    public List<ProductInfo> listForOrder( ){

      //  return productClient.listForOrder(Arrays.asList("164103465734242707","157875227953464068"));
        return null;
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
     //   productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707",2),new CartDTO("157875227953464068",23)));
        return "ok";
    }

    @PostMapping("/monitor")
    public String monitor( ){
        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDER");
        String url = String.format("http://%s:%s/%s", serviceInstance.getHost(),
                serviceInstance.getPort(), "actuator/bus-refresh");
        log.info("MonitorURL={}",url);
        return HttpClientUtil.doPost(url);
    }

}
