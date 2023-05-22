package com.test;

import java.util.Random;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		// 猜拳：1：剪刀 2：石头 3：布
		// 让电脑随机
		

		// 让人猜
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Random random = new Random();
			int pcnum = random.nextInt(3)+1;
			System.out.println(pcnum);
			
			System.out.println("请猜拳：");
			int mynum = scanner.nextInt();
			
			// 对比
			if(mynum==pcnum) {
				System.out.println("平局");
			}else if(pcnum==1 && mynum==2 || pcnum==2 && mynum==3 || pcnum==3 && mynum==1) {
				// 人赢的情况
				System.out.println("恭喜您，你赢了");
				break;
			}else {
				// 电脑赢的情况
				System.out.println("你输了");
				break;
			}
		}
		
		
	}

}
