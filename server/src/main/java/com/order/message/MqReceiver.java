package com.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 16:24
 * @Description:  接受消息内容
 */
@Component
@Slf4j
public class MqReceiver {

    //  1 收到创建消息队列
    //@RabbitListener(queues = "myQueues")
    // 2 自动创建消息队列
    // @RabbitListener(queuesToDeclare = @Queue("AutoQueues"))
    // 3. 自动创建 并绑定 queues与exchange
    @RabbitListener(  bindings = @QueueBinding(
            value = @Queue("myQueue3"),
            exchange = @Exchange("myExchange")
        ))
    public void process (String message){
        log.info("Receiver Message :  {}",message);
    }


    /**
     *  数码供应商
     * @param message
     */
    @RabbitListener(  bindings = @QueueBinding(
            value = @Queue("fruitQueue"),
            key = "computer",
            exchange = @Exchange("orderExchange")
    ))
    public void computerProcess (String message){
        log.info("Receiver Computer Message :  {}",message);
    }

    /**
     *  水果供应商  接收
     * @param message
     */
    @RabbitListener(  bindings = @QueueBinding(
            value = @Queue("fruitQueue"),
            key = "fruit",
            exchange = @Exchange("orderExchange")
    ))
    public void fruitProcess (String message){
        log.info("Receiver Fruit Message :  {}",message);
    }
}
