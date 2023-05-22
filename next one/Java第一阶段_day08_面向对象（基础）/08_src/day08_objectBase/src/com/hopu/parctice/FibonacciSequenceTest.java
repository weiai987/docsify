package com.hopu.parctice;

public class FibonacciSequenceTest {
	public static void main(String[] args) {
		// 调用方法，获取12个月后的对数
		int total =fun(12);
		
        System.out.println("一年后兔子总对数是："+total);
	}
	// 定义递归放获取对应月数的兔子总对数
	public static int fun(int m){
		if(m==1 || m==2) {
			return 1;
		}else {
			// 递归调用，求取前2个月对数之和
			return fun(m-1)+fun(m-2);
		}
	}
}
