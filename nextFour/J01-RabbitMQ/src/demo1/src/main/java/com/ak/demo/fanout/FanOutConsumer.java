package com.ak.demo.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanOutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue,
                    exchange = @Exchange(value = "kk",type = "fanout")
            )
    })
    public void receive(String message){
        System.out.println("----");
        System.out.println("广播信息1"+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value =@Queue,
                    exchange = @Exchange(value = "kk",type = "fanout")
            )
    })
    public void receive2(String message){
        System.out.println("----");
        System.out.println("广播信息2"+message);
    }
}
