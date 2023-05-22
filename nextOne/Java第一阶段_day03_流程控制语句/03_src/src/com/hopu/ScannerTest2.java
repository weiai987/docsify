package com.hopu;

import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
		// 键盘录入三个学员的成绩90分、94分、82分，然后使用运算符进行比较获取成绩最高的分数并打印结果
		// 1、创建Scanner对象
		Scanner scanner = new Scanner(System.in);
		
		// 2、开始接收用户录入的学员成绩
		System.out.println("请输入第一个学生的成绩：");
		int score1 = scanner.nextInt();

		System.out.println("请输入第二个学生的成绩：");
		int score2 = scanner.nextInt();
		
		System.out.println("请输入第三个学生的成绩：");
		int score3 = scanner.nextInt();
		
//		System.out.println(score1);
//		System.out.println(score2);
//		System.out.println(score3);
		
		// 3、获取最高分  (两两比较)
		int temp=score1 > score2? score1:score2;
		
		int max = temp > score3? temp:score3;
		
		System.out.println("最高分为："+max);
	}

}
