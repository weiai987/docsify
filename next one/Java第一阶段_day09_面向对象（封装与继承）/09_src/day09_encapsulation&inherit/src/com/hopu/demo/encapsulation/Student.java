package com.hopu.demo.encapsulation;

public class Student {
	// 使用private封装成员变量
	private String name;
	private int age;
	
	
	
	public Student() {
		super();
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// 提供对应的getXxx`方法 / `setXxx` 方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<=0) {
			System.out.println("学生年龄有误，不能为0");
		}else {
			this.age = age;	
		}
	}
}
