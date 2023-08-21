package com.hopu.demo.encapsulation;

public class PrivateVariableDemo {
	public static void main(String[] args) {
		Student stu= new Student();	
//		stu.name="tom";  // 编译报错，已经无法直接访问private私有变量
		// 给私有变量赋值
		stu.setName("杨幂");
		// 获取对象私有变量的值
		String name=stu.getName();
		System.out.println(name);
		
//		PrivateMethodDemo p=new PrivateMethodDemo();
//		int[] arr= {1,2,3};
//		p.getSum(arr);
	}
}
