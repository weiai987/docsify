package com.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//// 声明本项目是一个Eureka服务
@EnableEurekaServer
public class EurekaApplication9201 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9201.class,args);
    }
}