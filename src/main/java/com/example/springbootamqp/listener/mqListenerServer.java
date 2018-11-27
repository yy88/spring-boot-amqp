package com.example.springbootamqp.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class mqListenerServer {

    @RabbitListener(queues = "yyxx-queue")
    public void receiveMsg(String obj){
        System.out.println("收到消息yyxx-queue："+obj);
    }


    /**
     * 该注解实现了rabbitMq自动创建及绑定关系，消息监听消费
     * @param obj
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "yyxx.news", durable = "true"),
            exchange = @Exchange(value = "yy-exc", type = ExchangeTypes.DIRECT, durable = "true"),
            key = "news"
    ), containerFactory = "rabbitListenerContainerFactory")
    public void receiveMsg2(String obj){
        System.out.println("收到消息yyxx.news："+obj);
    }
}
