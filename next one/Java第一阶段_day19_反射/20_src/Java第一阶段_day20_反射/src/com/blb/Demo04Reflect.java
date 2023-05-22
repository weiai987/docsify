package com.blb;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class  Student{

    public void study(){
        System.out.println("好好学习，天天向上。");
    }

    private int exam(String name){
        System.out.println(name+"同学，认真考试");
        int score = 90 ;
        return score ;
    }

}

public class Demo04Reflect {

    public static void main(String[] args) throws Exception {
//      获取对应的Class对象
        Class clazz = Student.class ;
//      获取对象
        Student s = (Student) clazz.newInstance();
//       获取当前类定义的所有的属性
        Method[] methods = clazz.getDeclaredMethods();

//        遍历所有的方法
        for (Method m: methods) {
//          打印方法名称
            System.out.println(m.getName());
        }

//      获取方法名为study的方法
        Method study = clazz.getDeclaredMethod("study");
//      通过invoke方法调用这个s对象的study方法
        study.invoke(s);

//      获取方法名为exam的方法,参数类型要一致
        Method exam = clazz.getDeclaredMethod("exam",String.class);
//      私有方法，必须要设置访问权限
        exam.setAccessible(true);
//      通过invoke方法调用这个s对象的exam方法，接收方法调用的结果
        Integer result = (Integer) exam.invoke(s,"blb");
        System.out.println("考试分数为： "+result);

    }
}
