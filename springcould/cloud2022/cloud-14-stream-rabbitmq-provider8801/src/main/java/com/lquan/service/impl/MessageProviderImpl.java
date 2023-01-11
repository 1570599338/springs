package com.lquan.service.impl;

import cn.hutool.core.lang.UUID;
import com.lquan.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @program: springcould
 * @description:
 * @author: lquan
 * @create: 2023-01-11 16:50
 **/
@EnableBinding(Source.class)// 定义消息的推送的管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;// 消息发送通道

    @Override
    public String sendMsg() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return serial;
    }
}
