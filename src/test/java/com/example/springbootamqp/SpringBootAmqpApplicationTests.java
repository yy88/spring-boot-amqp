package com.example.springbootamqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        System.out.println("hello");
    }

    @Test
    /**
     * 测试发送点对点消息
     */
    public void sendDirect() {
        rabbitTemplate.convertAndSend("yy-exc", "news", "nihao from idea");
        System.out.println("发送成功");
    }

    @Test
    /**
     * 测试发送广播消息
     */
    public void sendFanout() {
        rabbitTemplate.convertAndSend("yy.fanout", "", "支付成功,009");
    }

    @Test
    /**
     * 测试发送模糊匹配消息
     */
    public void sendTopic() {
        rabbitTemplate.convertAndSend("yy.topic", "yyxx.news", "yyxx.news from idea news topic");
        System.out.println("send success");
    }

    @Test
    /**
     * 测试接收
     */
    public void receiveMsg() {
        Object o = rabbitTemplate.receiveAndConvert("it.news");
        System.out.println("receive success:"+o.toString());
    }


}
