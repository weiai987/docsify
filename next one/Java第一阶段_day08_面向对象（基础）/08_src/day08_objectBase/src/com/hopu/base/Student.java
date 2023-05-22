package com.hopu.base;

public class Student {
	// 成员变量
	String username; 
	int age;
	// 构造方法
	public Student() {
		this("陈圆圆", 18);
		System.out.println("这是一个无参构造方法");
	}
	public Student(String username, int age) {
		this.username = username;
		this.age = age;
		System.out.println("这是一个有参构造方法");
	}
	// 成员方法
	public void study(String username) {
		System.out.println(username+"在学习");
	}
}

