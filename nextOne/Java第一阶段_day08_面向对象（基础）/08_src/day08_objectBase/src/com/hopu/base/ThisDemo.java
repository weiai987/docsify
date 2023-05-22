package com.hopu.base;

public class ThisDemo {
	public void method1() {
		System.out.println("方法1执行");
		this.method2();
	}
	public void method2() {
		System.out.println("方法2执行");
	}
}
