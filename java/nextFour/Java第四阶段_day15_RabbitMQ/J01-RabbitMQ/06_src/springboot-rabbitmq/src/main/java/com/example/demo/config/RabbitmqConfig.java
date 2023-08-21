package com.example.demo.config;

import com.example.demo.constant.GlobalConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbit一些设置 队列 交换器等
 * @author :master
 * @date :20200611
 */
@Configuration
public class RabbitmqConfig {

    /**
     * 京东订单
     * @return queue
     */
    @Bean
    public Queue orderJd () {
        return new Queue(GlobalConstant.ORDER_JD);
    }

    /**
     * 淘宝订单
     * @return queue
     */
    @Bean
    public Queue orderTb () {
        return new Queue(GlobalConstant.ORDER_TB);
    }

    /**
     * 苏宁订单
     * @return queue
     */
    @Bean
    public Queue orderSn () {
        return new Queue(GlobalConstant.ORDER_SN);
    }

    /**
     * 天猫订单
     * @return queue
     */
    @Bean
    public Queue orderTm () {
        return new Queue(GlobalConstant.ORDER_TM);
    }


    /**
     * 创建交换器
     * @return TopicExchange
     */
    @Bean
    public TopicExchange exchangeWhole () {
        return  new TopicExchange(GlobalConstant.ORDER_EXCHANGE);
    }

    /**
     * 队列绑定到交换器 规则一 淘宝天猫的
     * @param orderTm 队列
     * @param exchangeWhole 交换器
     * @return 返回binding
     */
    @Bean
    public Binding bindingTbExchange(Queue orderTm, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderTm).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE1);
    }

    /**
     * 队列绑定到交换器 规则一 淘宝天猫的
     * @param orderTm 队列
     * @param exchangeWhole 交换器
     * @return 返回binding
     */
    @Bean
    public Binding bindingTbExchange2(Queue orderTm, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderTm).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE2);
    }

    /**
     * 队列绑定到交换器 规则二 淘宝的
     * @param orderTb 队列
     * @param exchangeWhole 交换器
     * @return 返回binding
     */
    @Bean
    public Binding bindingExchange(Queue orderTb, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderTb).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE1);
    }

    @Bean
    public Binding bindingExchange2(Queue orderTb, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderTb).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE2);
    }


    /**
     * 队列绑定到交换器 规则二 苏宁的
     * @param orderSn 队列
     * @param exchangeWhole 交换器
     * @return 返回binding
     */
    @Bean
    public Binding bindingSnExchange(Queue orderSn, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderSn).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE3);
    }

    @Bean
    public Binding bindingSnExchange2(Queue orderSn, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderSn).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE2);
    }

    /**
     * 队列绑定到交换器 规则二 京东的
     * @param orderJd 队列
     * @param exchangeWhole 交换器
     * @return 返回binding
     */
    @Bean
    public Binding bindingJdongExchange(Queue orderJd, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderJd).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE4);
    }

    @Bean
    public Binding bindingJdongExchange2(Queue orderJd, TopicExchange exchangeWhole) {
        return BindingBuilder.bind(orderJd).to(exchangeWhole).with(GlobalConstant.EXCHANGE_BINDING_RULE2);
    }

}
