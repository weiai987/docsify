package com.hopu.base;

class Teacher {
	// 定义一个静态代码块
	static {
		System.out.println("静态代码块初始化。。。");
	}
	
	// 定义一个静态变量
	static String schoolName="武汉厚浦";
	String username;
	int age;
	// 定义一个静态方法
	public static void sleep() {
		System.out.println("你该休息休息了");
	}
}

public class StaticDemoTest3 {
	public static void main(String[] args) {
		// 创建多个对象并执行相关方法
		Teacher t1= new Teacher();
		t1.sleep();
		
		Teacher t2= new Teacher();
		t2.sleep();
	}
}
