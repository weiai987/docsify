package com.houpu;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo2 {

	public static void main(String[] args) {
		/*
		 * - **需求：**程序自动生成一个1-100之间的数字，使用程序实现猜出这个数字是多少？49
		 * 
		 * 需求：**程序自动生成一个37~79之间的数字，使用程序实现猜出这个数字是多少？49
		 * 
		 * - **效果：** 
		 * - 如果猜的数字比真实数字大，提示你猜的数据大了 
		 * - 如果猜的数字比真实数字小，提示你猜的数据小了
		 *  - 如果猜的数字与真实数字相等，提示恭喜你猜中了
		 */
		// 创建随机数对象
		Random random = new Random();
		// 生成一个随机数
		int num = random.nextInt(100)+1;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {			
			// 重复猜的数字
			System.out.println("请猜一个1~100的数字：");
			int cai = scanner.nextInt();
			
			if(cai>num) {
				System.out.println("你猜的数据大了");
			}else if(cai<num) {
				System.out.println("你猜的数据小了");
			}else {
				// 代表相等，就是猜中了
				System.out.println("恭喜你猜中了");
				
				break;  // 已经猜中，没有必要重复猜了
			}	
		}
		System.out.println("game over");
	}

}
