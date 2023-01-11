package com.lquan.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-11 17:38
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessage {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public  void  input(Message<String> message){

        System.out.println("消费者--》message"+message.getPayload()+"   端口："+this.serverPort);

    }


}
