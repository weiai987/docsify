package com.blb.aop_demo.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
/*@Aspect
@Component*/
public class LogAspect {

    //配置切入点
    @Pointcut("execution(* com.blb.aop_demo.service.*Service.*(..))")
    public void before(){
    }

    //配置通知方法
    @Before("before()")
    public void beforeLog(){
        System.out.println("这是前置的通知方法！！");
    }
}
