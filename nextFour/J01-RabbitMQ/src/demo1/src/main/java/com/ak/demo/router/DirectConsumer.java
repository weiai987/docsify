package com.ak.demo.router;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectConsumer {

    String []routeKey={"error","info","waring","debug"};
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,// 临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key={"error","info","waring","debug"}
            )
    })
    public void receive(String message){
        System.out.println("接受全部信息--"+message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,// 临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),
                    key={"error"}
            )
    })
    public void receive2(String message){
        System.out.println("只接受error--"+message);
    }
}
