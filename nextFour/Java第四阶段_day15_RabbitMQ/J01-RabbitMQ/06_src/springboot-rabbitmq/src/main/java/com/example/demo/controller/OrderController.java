package com.example.demo.controller;

import com.example.demo.constant.GlobalConstant;
import com.example.demo.pojo.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单生成接口
 * @author :master
 * @date :200200611
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    public String generateOrder(Order order) {
        System.out.println("生产者信息：" + order.toString());
        rabbitTemplate.convertAndSend(GlobalConstant.ORDER_EXCHANGE, "com.my.tb" ,order);
        return "成功";
    }

}
