package com.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/12 09:22
 * @Description:
 */
@RestController
@RequestMapping("/env")
@RefreshScope
@Slf4j
public class EnvController {

    @Value("${env}")
    private String env;

   @GetMapping("/print")
    public String geEnv(){
        return env;
    }



}
