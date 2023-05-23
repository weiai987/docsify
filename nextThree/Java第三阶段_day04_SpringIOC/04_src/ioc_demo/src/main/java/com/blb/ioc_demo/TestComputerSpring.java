package com.blb.ioc_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComputerSpring {

    public static void main(String[] args) {
        //创建XML应用程序上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //通过容器获得对象
        Computer computer = (Computer) context.getBean("computer");
        computer.start();
    }
}
