package com.hopu.classobject.test;

public class Teacher {
  	// 成员变量
  	String username;//姓名
    int age; //年龄

    // 教书的方法
    public static void teach() {
       System.out.println("教授数学课");
    }
    // 跑步的方法
    public void run(String username,int distance) {
       System.out.println(username+" 今天跑了"+distance+"m");
    }
}
