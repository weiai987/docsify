package com.test;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		// 猜拳 1:剪刀 2：石头 3：布		
		Random random = new Random();
		// 电脑数字
		int pcnum = random.nextInt(3)+1;
		System.out.println(pcnum);
		
		// 人猜
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("请输入您猜的数：");
			int mynum = scanner.nextInt();
			// 判断
			// 方法一：
			if(pcnum==mynum) {
				System.out.println("平局！");
			}else if(pcnum==1 && mynum==2 || pcnum==2&& mynum==3 || pcnum==3&&mynum==1) {
				// 人赢的场景
				System.out.println("恭喜，你赢了");
				break;
			}else {
				// 电脑赢的场景	
				System.out.println("你输了");
				break;
			}
		}
		
		
		
//		// 方法二：
//		if(pcnum==mynum) {
//			System.out.println("平局！");
//		}else if(mynum-pcnum==1 || mynum-pcnum==-2) {
//			// 人赢的场景
//			System.out.println("恭喜，你赢了");
//		}else {
//			// 电脑赢的场景	
//			System.out.println("你输了");
//		}
		
	}

}
