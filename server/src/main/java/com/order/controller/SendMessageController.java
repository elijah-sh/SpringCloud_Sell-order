package com.order.controller;

import com.order.dto.OrderDTO;
import com.order.message.StreamClient;
import com.order.message.StreamReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 22:21
 * @Description:
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;
    @RequestMapping("/sendMessages")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
