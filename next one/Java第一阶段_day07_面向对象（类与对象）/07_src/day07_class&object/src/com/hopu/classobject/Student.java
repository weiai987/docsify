package com.hopu.classobject;
public class Student {
  	// 成员变量
  	String username; //姓名
    int age;  //年龄

    //成员方法
    //学习的方法
    public void study() {
       System.out.println("好好学习，天天向上");
    }
    // 跑步的方法
    public void run(String username,int distance) {
       System.out.println(username+" 今天跑了"+distance+"m");
    }
}