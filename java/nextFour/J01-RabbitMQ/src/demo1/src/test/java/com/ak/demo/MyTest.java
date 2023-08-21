package com.ak.demo;

import org.junit.jupiter.api.Test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest(classes = RabbitmqSpringApplication.class)
public class MyTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public  void test(){

        rabbitTemplate.convertAndSend("hello","hello world");
    }

    @Test
    public  void test2(){
        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("work","work 模型");
        }
    }

    /**
     * 广播形式的发布信息
     */
    @Test
    public  void test3(){

        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("kk","","广播信息");
        }
    }

    /**
     * 测试路由模型
     */
    @Test
    public void testDirect(){
        String []routeKey={"error","info","waring","debug"};
        for(int i=0;i<10;i++){
            int temp=new Random().nextInt(100)%4;
            rabbitTemplate.convertAndSend("directs",routeKey[temp],routeKey[temp]+"的日志信息");
        }

    }

    @Test
    public void testFive(){
        String []routeKey={"user.save","user.add","admin.add","admin.save"};
        for(int i=0;i<10;i++){
            int temp=new Random().nextInt(100)%4;
            rabbitTemplate.convertAndSend("topics",routeKey[temp],routeKey[temp]+"信息");
        }
    }
}
