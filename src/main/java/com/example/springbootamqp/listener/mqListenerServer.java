package com.example.springbootamqp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class mqListenerServer {

    @RabbitListener(queues = "yyxx.news")
    public void receiveMsg(String obj){
        System.out.println("收到消息："+obj);
    }
}
