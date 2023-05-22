package com.hopu.base;

public class ConstructorTest {
	public static void main(String[] args) {
		// 1、通过无参构造方法创建对象
		Student stu1 =new Student();
		System.out.println(stu1.username);
		System.out.println(stu1.age);

		System.out.println("========================");
		// 2、通过有参构造方法创建对象
		Student stu2 =new Student("李师师",20);
		System.out.println(stu2.username);
		System.out.println(stu2.age);
	}
}
