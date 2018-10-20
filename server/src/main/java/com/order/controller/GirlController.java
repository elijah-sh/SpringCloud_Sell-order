package com.order.controller;

import com.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 14:09
 * @Description:
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @RequestMapping("/print")
    public String getGirl(){

        return "Name: "+girlConfig.getName()+"\t"+"Age: "+girlConfig.getAge();
    }
}
