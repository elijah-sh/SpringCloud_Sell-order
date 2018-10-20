package com.order.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/14 20:42
 * @Description:
 */
public class MySelfRule {
    @Bean
    public IRule myRule()
    {
        return  new RandomRule();   // 随机
    }
}
