package com.blb.aop_demo.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Log4j日志输出切面
 */
@Aspect
@Component
public class Log4jAspect {

    //创建日志对象
    private Logger logger = Logger.getLogger(Log4jAspect.class);

    //给所有的service类的所有方法加日志跟踪
    @Pointcut("execution(* com.blb.aop_demo.service.*Service.*(..))")
    public void logPointcut(){
    }

    //配置环绕通知
    @Around("logPointcut()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        //记录方法执行前时间
        long start = System.currentTimeMillis();
        //打印方法名称
        if(logger.isDebugEnabled()){
            logger.debug("当前执行方法：" + point.getSignature().getName());
        }
        //打印参数
        Object[] args = point.getArgs();
        for(Object arg : args){
            if(logger.isDebugEnabled()){
                logger.debug("参数："+arg);
            }
        }
        //打印返回值
        Object result = point.proceed();
        if(logger.isDebugEnabled()){
            logger.debug("方法返回值：" +result);
        }
        //打印执行时间
        long end = System.currentTimeMillis();
        if(logger.isDebugEnabled()){
            logger.debug("方法执行时间：" +(end - start));
        }
        return result;
    }
}
