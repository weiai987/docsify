package com.hopu.study;

public interface InterfaceName {
	// 1、常量
	public static final String DRIVER_URL = "jdbc:mysql://localhost:3306/mydb";
	// 2、抽象方法
	public abstract void work();
	// 3、静态方法
	public static void sleep() {
		System.out.println("睡觉了");
	}
	// 4、默认方法
	public default void eat() {
		System.out.println("吃饭了");
	}
}
