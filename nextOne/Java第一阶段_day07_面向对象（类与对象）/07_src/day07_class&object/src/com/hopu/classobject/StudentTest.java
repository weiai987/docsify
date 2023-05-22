package com.hopu.classobject;
public class StudentTest {
	  public static void main(String[] args) {
	    // 创建对象格式：类名 对象名 = new 类名();
	    Student s = new Student();
	    System.out.println(s); //com.hopu.classobject.Student@15db9742

	    // 直接输出成员变量值
	    System.out.println("姓名："+s.username); //null
	    System.out.println("年龄："+s.age); //0
	    System.out.println("----------");

	    //给成员变量赋值
	    s.username = "佐佐木希";
	    s.age = 32;

	    // 再次输出成员变量的值
	    System.out.println("姓名："+s.username); //佐佐木希
	    System.out.println("年龄："+s.age); //32
	    System.out.println("----------");

	    // 调用成员方法
	    s.study(); // "好好学习，天天向上"
	    s.run("tom",123); // 跑步
	  }	
}