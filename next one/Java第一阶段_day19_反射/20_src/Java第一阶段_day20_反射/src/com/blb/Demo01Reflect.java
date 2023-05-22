package com.blb;

import java.lang.reflect.Constructor;

class Person {

}

public class Demo01Reflect {

    public static void main(String[] args) throws Exception {
//        第1种方式：
        Class clazz = Person.class ;
//		第2种：
//		Class  clazz = Class.forName("com.blb.Person");
//		第3种方式：
//		Person p  = new Person();
//		Class clazz = p.getClass();

//        通过newInstance只能通过无参构造方法获取对象
//        Person person = (Person) clazz.newInstance();

        Constructor c = clazz.getDeclaredConstructor();
        Person person = (Person) c.newInstance();

    }
}
