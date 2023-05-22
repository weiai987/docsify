package com.blb;

import java.lang.reflect.Constructor;

class  User{

    private String name;

    private int age ;

    // 构造方法是私有的
    private User(String name , int age ){
        this.name = name ;
        this.age = age ;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo02Reflect {

    public static void main(String[] args) throws Exception {
//      获取对应的Class对象
        Class clazz = User.class ;
//      获取想要的构造器,这里的参数列表的类型要跟定义的构造方法一致
        Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
//       由于构造方式是私有的，需要设置权限
        c.setAccessible(true);
//        通过对应的构造器创建对应的对象，这里的参数列表的值要跟构造方法的类型一致
        User user = (User) c.newInstance("blb", 18);
        System.out.println(user);
    }
}
