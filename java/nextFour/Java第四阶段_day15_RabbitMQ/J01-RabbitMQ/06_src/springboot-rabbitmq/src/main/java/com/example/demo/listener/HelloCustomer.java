package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * @author :master
 * @date :20200610
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloCustomer {

    @RabbitHandler
    public void customerMessage( String messsge) {
        System.out.println(messsge + " <=== message");
    }
}
