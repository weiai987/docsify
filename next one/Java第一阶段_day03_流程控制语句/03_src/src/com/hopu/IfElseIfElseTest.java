package com.hopu;

import java.util.Scanner;

public class IfElseIfElseTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入星期数（1~7）：");
		int day = scanner.nextInt();
		

//		System.out.println(day);
		if(day==1) {
			System.out.println("星期一");
		}else if(day==2) {
			System.out.println("星期二");
		}else if(day==3) {
			System.out.println("星期三");	
		}else if(day==4) {
			System.out.println("星期四");
		}else if(day==5) {
			System.out.println("星期五");
		}else if(day==6) {
			System.out.println("星期六");
		}else if(day==7) {
			System.out.println("星期日");
		}else {
			System.out.println("输入数据有误");
		}
	}

}
