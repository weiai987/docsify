package com.houpu;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		// ʹ��Random�࣬�������3��10���ڵ���������Ĳ���
		Random random = new Random();
		
		// ��ȡ�����
//		int num = random.nextInt(10);
//		
//		System.out.println(num);

		for(int i=1;i<=3;i++) {
			System.out.println(random.nextInt(10));
		}
	}

}
