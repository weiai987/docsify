package com.hopu.base;

public class RecursiveTest {
	public static void main(String[] args) {
		// 调用递归方法，求n的阶乘
		int res=getRecursive(50000);
		System.out.println(res);	
	}
	// 递归方法，求n的阶乘
	public static int getRecursive(int n) {
		if(n==1) { // 如果为1的时候，就跳出，不再递归
			return 1;
		}else {
			 // n非1的情况下，继续调用本身，获取前一个数的递归结果
			 int res=n*getRecursive(n-1);
			 return res;
		}
	}
}
