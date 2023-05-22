package com.hopu;

import java.util.Scanner;

public class IfTest2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("输入小明的成绩：");
		int score = scanner.nextInt();
		
		if(score>700) {
			// 条件成立的时候执行的
			System.out.println("可以上哈弗");
		}else {
			// 条件不成立的时候执行
			System.out.println("搬砖去");
		}
		
	}

}
