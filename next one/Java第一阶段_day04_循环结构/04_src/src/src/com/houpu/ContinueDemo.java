package com.houpu;

public class ContinueDemo {
	public static void main(String[] args) {
		// 需求：打印1~10之间的基数
		
		for(int i=1 ;i<=10 ;i++ ) {
			
			// 如果是偶数就跳过当前循环，进入下一次循环
			if(i%2==0) {
				
				continue;
//				System.out.println(i);
			}
			System.out.println(i);
			
		}
	}
}
