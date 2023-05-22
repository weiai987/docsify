package com.hopu.demo.encapsulation;

public class PrivateClassDemo {
	// 定义一个私有的内部类
	private class User{
		// 私有的内部类方法
		public void test() {
			System.out.println("私有内部类测试方法");
		}
	}
	// 外部类入口main方法
	public static void main(String[] args) {
		// 创建外部内对象，通过外部内对象来访问内部类对象
		PrivateClassDemo p= new PrivateClassDemo();
		User u=p.new User();
		u.test();
	}
}
