package com.blb.ioc_demo.demo2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 电脑工厂
 */
public class ComputerFactory {

    /**
     * 创建电脑对象
     * @param computerClass
     * @return
     */
    public Computer createComputer(Class computerClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //创建对象
        Object computer = computerClass.newInstance();
        //遍历所有的属性
        Field[] fields = computerClass.getDeclaredFields();
        for(Field field : fields){
            String fName = field.getName();
            //读取自定义注解
            MyValue myValue = field.getDeclaredAnnotation(MyValue.class);
            if(myValue != null){
                //通过反射调用set方法注入值
                String mName = "set" + fName.substring(0,1).toUpperCase() + fName.substring(1);
                Method set = computerClass.getDeclaredMethod(mName, field.getType());
                set.invoke(computer,myValue.value());
            }
            MyComponent myComponent = field.getDeclaredAnnotation(MyComponent.class);
            if(myComponent != null){
                //通过反射调用set方法注入对象
                String mName = "set" + fName.substring(0,1).toUpperCase() + fName.substring(1);
                Method set = computerClass.getDeclaredMethod(mName, field.getType());
                //通过配置的类型创建对象
                Object obj = myComponent.value().newInstance();
                set.invoke(computer,obj);
            }
        }
        return (Computer) computer;
    }
}
