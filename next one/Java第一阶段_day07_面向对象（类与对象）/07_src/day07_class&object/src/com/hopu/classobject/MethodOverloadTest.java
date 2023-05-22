package com.hopu.classobject;
public class MethodOverloadTest {
	// 1、2个int类型参数的方法求和
	public int getSum(int a,int b) {
		return a+b;
	}
	// 2、2个double类型参数的方法求和
	public void getSum(double a,double b) {
		System.out.println(a+b);
	}
	// 2、3个int类型参数的方法求和
	public int getSum(int a,int b,int c) {
		return a+b+c;
	}
}