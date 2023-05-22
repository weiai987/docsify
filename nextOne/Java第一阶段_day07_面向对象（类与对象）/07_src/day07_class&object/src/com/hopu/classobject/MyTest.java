package com.hopu.classobject;

public class MyTest {
//	public static void main(String[] args) {
//	    //调用定义的方法method
//	    method();
//	}
//	//定义方法，被main方法调用
//	public static void method() {
//	  	System.out.println("这是一个方法");
//	}
	
	
	public static void main(String[] args) {
	    //调用定义的方法method
	    printSum(5,6);
	}
	//定义方法，被main方法调用
	public static void printSum(int a,int b){
		int sum = a + b;
	    System.out.println(sum);
	}
}
