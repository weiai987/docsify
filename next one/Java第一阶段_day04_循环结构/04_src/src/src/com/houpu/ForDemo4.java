package com.houpu;

public class ForDemo4 {
	public static void main(String[] args) {
		// 打印1~10之间的数
		for(int i=1;i<=10;i++) {
			System.out.println(i);
		}
		
		System.out.println("=============");
		// 变异for循环
		
		int i;
		for(i=1;i<=10;) {
			System.out.println(i);
			
			i++;
		}
	}
}
