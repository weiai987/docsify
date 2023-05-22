package com.hopu.study;

public class MoreInterfaceTest implements InterfaceA,InterfaceB {
	// 必须实现所有的接口方法
	@Override
	public void work() {
		System.out.println("该工作了");	
	}
	// 实现的接口默认方法重名，必须重写一次
	@Override
	public void eat() {
		System.out.println("重写的接口的eat()默认方法");	
	}
	public static void main(String[] args) {
		// 1、实现多接口时的接口常量使用
		System.out.println(InterfaceA.A);
		System.out.println(InterfaceB.A);
		
		// 2、接口抽象方法调用
		MoreInterfaceTest mit=new MoreInterfaceTest();
		mit.work();
		
		// 3、调用接口的静态方法
		InterfaceA.sleep();
		InterfaceB.sleep();
		
		// 4、调用默认方法
		mit.eat();
	}
}
