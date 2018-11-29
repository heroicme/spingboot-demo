package com.heroic.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/27
 */
@Service
public class TestRabbitListener {



    @RabbitListener(queues = "admin.queue")
    public void receive(Map book){
        System.out.println("收到消息re："+book);
    }

    @RabbitListener(queues = "admin.queue")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
