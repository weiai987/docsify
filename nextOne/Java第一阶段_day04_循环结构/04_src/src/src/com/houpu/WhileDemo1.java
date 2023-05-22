package com.houpu;

public class WhileDemo1 {
	public static void main(String[] args) {
		//需求：世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，假如我有一张足够大的纸，它的厚度是0.1毫米。请问，我折叠多少次，可以折成珠穆朗玛峰的高度?
//		int num=0;
//		for( double i=0.1; i<=8844430; i*=2) {
//			// 0.1 0.2 0.4 0.8 1.6
//			num++;
//		}
//		System.out.println(num);
		
		int num=0; // 计数器折叠次数
		double zt=0.1;
		while(zt<=8844430) {
			num++;
			zt*=2;
		}
		System.out.println(num);
	}
}
