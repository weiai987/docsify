package com.ak.demo.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare =@Queue("work"))
    public void receive(String messaage){
        System.out.println("消费者1---"+messaage);
    }

    @RabbitListener(queuesToDeclare =@Queue("work"))
    public void receive2(String messaage){
        System.out.println("消费者2--"+messaage);
    }
}
