package com.blb.aop_demo.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "com.blb.aop_demo")
@Configuration
//启动AspectJ的注解配置
@EnableAspectJAutoProxy
public class AopConfig {
}
