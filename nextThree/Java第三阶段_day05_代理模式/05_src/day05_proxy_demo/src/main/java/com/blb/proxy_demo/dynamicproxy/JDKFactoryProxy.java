package com.blb.proxy_demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 工厂的JDK动态代理
 */
public class JDKFactoryProxy implements InvocationHandler {

    //被代理对象
    private Object target;

    /**
     * 创建代理对象
     * @param target 被代理对象
     * @return 代理对象
     */
    public Object createProxy(Object target){
        this.target = target;
        //创建代理对象 参数1：类加载器, 参数2：代理对象实现的接口，参数3：InvocationHandler的实现对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理类的方法调用
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //功能扩展
        System.out.println("商店帮忙打广告！！");
        //调用被代理者方法
        Object invoke = method.invoke(target, args);
        System.out.println("商店帮忙做售后！！");
        return invoke;
    }
}
