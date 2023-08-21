package com.blb.aop_demo.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志输出通知类
 */
public class LogAdvise {

    public void beforeLog(){
        System.out.println("方法开始执行！");
    }

    public void afterLog(){
        System.out.println("方法后置执行！");
    }

    public void afterReturning(){
        System.out.println("方法返回了数据");
    }

    public void afterThrowing(){
        System.out.println("方法抛出了异常");
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around方法名：" + joinPoint.getSignature().getName());
        System.out.println("around --前置");
        //原来方法
        joinPoint.proceed();
        System.out.println("around --后置");
    }
}
