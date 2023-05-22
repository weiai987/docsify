package com.houpu;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		// 使用Random类，完成生成3个10以内的随机整数的操作
		Random random = new Random();
		
		// 获取随机数
//		int num = random.nextInt(10);
//		
//		System.out.println(num);

		for(int i=1;i<=3;i++) {
			System.out.println(random.nextInt(10));
		}
	}

}
