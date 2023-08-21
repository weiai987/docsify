package com.example.demo.listener;

import com.example.demo.constant.GlobalConstant;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单队列监听者
 * @author :master
 * @date :20200611
 */
@Service
public class OrderListener {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 京东订单处理
     * @param order 消息
     */
    @RabbitHandler
    @RabbitListener(queues = GlobalConstant.ORDER_JD)
    public void orderJdDeal (Order order) {
        System.out.println(GlobalConstant.ORDER_JD + "====>" + order);
        orderMapper.insertSelective(order);
    }

    /**
     * 苏宁订单处理
     * @param order 消息
     */
    @RabbitHandler
    @RabbitListener(queues = GlobalConstant.ORDER_SN)
    public void orderSnDeal (Order order) {
        System.out.println(GlobalConstant.ORDER_SN + "====>" + order);
        orderMapper.insertSelective(order);
    }

    /**
     * 淘宝订单处理
     * @param order 消息
     */
    @RabbitHandler
    @RabbitListener(queues = GlobalConstant.ORDER_TB)
    public void orderTbDeal (Order order) {
        System.out.println(GlobalConstant.ORDER_TB + "====>" + order);
        orderMapper.insertSelective(order);
    }

    /**
     * 天猫订单处理
     * @param order 消息
     */
    @RabbitHandler
    @RabbitListener(queues = GlobalConstant.ORDER_TM)
    public void orderTmDeal (Order order) {
        System.out.println(GlobalConstant.ORDER_TM + "====>" + order);
        orderMapper.insertSelective(order);
    }
}
