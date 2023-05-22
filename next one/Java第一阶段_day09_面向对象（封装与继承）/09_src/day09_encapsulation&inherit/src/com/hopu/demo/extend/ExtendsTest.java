package com.hopu.demo.extend;

public class ExtendsTest {
	public static void main(String[] args) {
		Rabbit r= new Rabbit();
		// 通过父类方法为属性赋值
		r.setName("小白兔");
		// 调用从父类继承的方法
		r.run();
		// 调用本类方法
		r.printName(r.getName());
	}
}
