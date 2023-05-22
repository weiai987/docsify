package com.blb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class  Student{

    private String name;

    private int age ;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo03Reflect {

    public static void main(String[] args) throws Exception {
//      获取对应的Class对象
        Class clazz = Student.class ;
//      获取对象
        Student s = (Student) clazz.newInstance();
//       获取当前类定义的所有的属性
        Field[] fields = clazz.getDeclaredFields();
//        遍历所有的属性
        for (Field f: fields) {
//          打印字段名称
            System.out.println(f.getName());
        }
//      获取属性名为name的属性
        Field nameField = clazz.getDeclaredField("name");
//      私有的属性需要打开访问权限
        nameField.setAccessible(true);
//      给对象s的name属性赋值为blb
        nameField.set(s,"blb");

        System.out.println(s);

    }
}
