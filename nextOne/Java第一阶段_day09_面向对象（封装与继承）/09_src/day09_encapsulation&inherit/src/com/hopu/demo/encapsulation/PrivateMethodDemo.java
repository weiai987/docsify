package com.hopu.demo.encapsulation;

public class PrivateMethodDemo {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5}; 
		// 调用本类的私有方法
		int sum= getSum(arr);
		System.out.println(sum);
	}
	// 定义一个私有方法
	private static int getSum(int[] array) {
		int sum=0;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		return sum;
	}
}
