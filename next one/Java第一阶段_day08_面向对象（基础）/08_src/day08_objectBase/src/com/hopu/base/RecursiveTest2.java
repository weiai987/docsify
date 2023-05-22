package com.hopu.base;

public class RecursiveTest2 {
	public static void main(String[] args) {
		// 调用递归方法，求n的阶乘
		int res=getRecursive(6);
		System.out.println(res);	
	}
	// 使用循环实现n！
	public static int getRecursive(int n) {
		int res=1;
		for (int i = 1; i <=n; i++) {
			res*=i;
		}
		return res;
	}
}
