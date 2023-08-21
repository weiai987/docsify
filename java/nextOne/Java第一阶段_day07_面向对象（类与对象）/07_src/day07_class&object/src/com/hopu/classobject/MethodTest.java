package com.hopu.classobject;
public class MethodTest {
	//1、普通无参、无返回值方法
	public void print() {
		System.out.println("这是一个普通的无参、无返回值方法");
		return;  // 无返回值方法，return关键字可以省略
	}
	// 2、普通有参、无返回值方法
	public void printSum(int a,int b) {
		int sum=a+b;
		System.out.println(a+"与"+"b的和为："+sum);
	}
	// 3、普通有参数、有返回值的方法
	public int getMax(int a,int b) {
		int max=a>b ? a : b;
		return max;
	}
	// 4、静态有参数、有返回值的方法
	public int getAbs(int a) {
		if(a<0) {
			return -a;
		}else {
			return a;
		}
	}
}