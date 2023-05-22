//package com.hopu.demo.extend;
//
//class Fu { 
//	int n=3; 	
//	public void run() {
//		System.out.println("Fun run()");
//	}
//	public Fu() { 
//		System.out.println("Fu()"); 
//	}
//}
//
//class Zi extends Fu { 	
//	int n=5; 
//	// 1、变量调用
//	public void test() {
//		System.out.println("Fu N="+super.n);
//		System.out.println("Fu N="+this.n);
//	}
//	
//	public void run() {
//		System.out.println("Zi run()");
//	}
//	
//	// 2、成员方法调用
//	public void runTest() {
//		super.run();
//		this.run();
//	}
//	
//	// 3、构造方法调用
//	public Zi(){ 
//		// super()调用父类空参构造方法，默认已经提供，可以省略
//		super();
//		System.out.println("Zi()");
//	}
//}
//
//public class ExtendsDemo4 { 
//	public static void main(String[] args) { 
//		// 创建子类对象 
//		Zi z = new Zi(); 	
//		z.test();
//		
//		z.runTest();
//	} 
//}
//
