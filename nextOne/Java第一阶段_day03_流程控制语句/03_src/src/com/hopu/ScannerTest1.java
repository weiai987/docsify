package com.hopu;
// 1、导包
//import java.util.Scanner;

import java.util.Scanner;

public class ScannerTest1 {
	public static void main(String[] args) {
		//2、创建对象
//		Scanner sc=new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		
		// 友情提示
		System.out.println("请输入一个整数：");
		// 3、获取键盘数据
		int num = scanner.nextInt();
		
		System.out.println("接收到的数据是："+num);
	}

}
