package com.hopu.study;

public class InterfaceTest implements InterfaceName{
	@Override
	public void work() {
		System.out.println("该工作了");	
	}
	// 重写接口默认方法，去除default关键字
	@Override
	public void eat() {
		System.out.println("吃饭了22");
	}
	
	// 入口测试方法
	public static void main(String[] args) {
		InterfaceTest ift=new InterfaceTest();
		// 1.1、通过接口调用接口常量
		System.out.println(InterfaceName.DRIVER_URL);
		// 1.2、通过实现类调用接口常量
		System.out.println(InterfaceTest.DRIVER_URL);
		// 1.3、通过实现类对象调用接口常量
		System.out.println(ift.DRIVER_URL);
		
		// 2、通过实现类对象调用重写的接口方法
		ift.work();
		
		// 3、通过接口名来调用接口静态方法
		InterfaceName.sleep();
		
		// 4、通过子类对象调用重写的默认方法
		ift.eat();	
	}
}
