package com.ak.demo.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 默认持久化队列
 */
@Component
@RabbitListener(queuesToDeclare =@Queue("hello"))
public class HelloCustomer {

    @RabbitHandler
    public void kk(String message){
        System.out.println(message);
    }
}
