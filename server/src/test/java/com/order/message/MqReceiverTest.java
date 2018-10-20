package com.order.message;

import com.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 16:27
 * @Description:
 */
public class MqReceiverTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue3","NOW is "+new Date());
    }
    @Test
    public void orderSend() {
        // String exchange, String routingKey, Object object computer
        amqpTemplate.convertAndSend("orderQueue","fruit"," fruit now is "+new Date());
    }
}