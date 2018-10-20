package com.order.message;

import com.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 16:24
 * @Description:  Stream 接受消息内容
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /**
     *   接收orderDTO对象 消息
     * @param message
     */
    @StreamListener(value = StreamClient.INPUT)
   // @SendTo(StreamClient.OUTPUT)
    public void process (OrderDTO message){
        log.info("StreamReceiver Message :  {}",message);
    }

}
