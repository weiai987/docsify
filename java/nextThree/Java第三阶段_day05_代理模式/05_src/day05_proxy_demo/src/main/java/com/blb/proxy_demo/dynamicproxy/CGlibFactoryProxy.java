package com.blb.proxy_demo.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理
 */
public class CGlibFactoryProxy implements MethodInterceptor {

    //被代理对象
    private Object target;

    public Object createProxy(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //设置方法回调MethodInterceptor实现
        enhancer.setCallback(this);
        //返回代理对象
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //扩展
        System.out.println("CGLib商店打广告！");
        //调用原来方法
        Object invoke = method.invoke(target, objects);
        System.out.println("CGLib商店做售后！");
        return invoke;
    }
}
