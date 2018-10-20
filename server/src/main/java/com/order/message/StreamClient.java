package com.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 19:05
 * @Description:
 */
public interface StreamClient {

    String INPUT = "messageInput";
    String OUTPUT = "messageOutput";

     // 订阅  Subscribe
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
