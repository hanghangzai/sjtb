package com.lh.sjtb.mqsend;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lihang
 * @Package com.lh.sjtb.mqsend
 * @date 2018/8/1510:14
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

 /*   public void send(int i) {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context+i);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context+i);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }*/
}
