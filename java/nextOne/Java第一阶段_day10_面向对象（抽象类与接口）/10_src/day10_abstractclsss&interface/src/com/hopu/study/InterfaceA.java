package com.hopu.study;

public interface InterfaceA {
	// 1、常量
	int A=1;
	// 2、抽象方法
	public abstract void work();
	// 3、静态方法
	public static void sleep() {
		System.out.println("睡觉了A");
	}
	// 4、默认方法
	public default void eat() {
		System.out.println("吃饭了A");
	}
}
