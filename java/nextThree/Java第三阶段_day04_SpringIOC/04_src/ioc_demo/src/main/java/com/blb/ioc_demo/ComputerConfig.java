package com.blb.ioc_demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@ComponentScan(basePackages = "com.blb.ioc_demo")
@Configuration
public class ComputerConfig {

    public static void main(String[] args) {
        //创建注解应用程序上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComputerConfig.class);
        //获得对象
        Computer computer = context.getBean(Computer.class);
        computer.start();
    }
}
