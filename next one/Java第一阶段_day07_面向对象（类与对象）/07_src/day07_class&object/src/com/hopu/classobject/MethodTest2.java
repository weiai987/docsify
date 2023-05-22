package com.hopu.classobject;
public class MethodTest2 {
	public void print() {
		System.out.println("hello world");
	}
	
	// 2、静态有参有返回值方法
	public static int pow(int a,int n) {
		int result=1;
		for (int i = 0; i < n; i++) {
			result*=a;
		}
		return result;
	}
}