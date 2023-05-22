package com.test;

public class Outer {
	private int age=18;
	public void method() {
		System.out.println("Outer method");
		
		Inner inner = new Inner();
		
		
	}
	public class Inner{
		private int age2=20;
		public void method2() {
//			System.out.println(age);
			
			System.out.println("Inner method");
		}
	}
}
class MyTest{
	public static void main(String[] args) {
		
	}
}