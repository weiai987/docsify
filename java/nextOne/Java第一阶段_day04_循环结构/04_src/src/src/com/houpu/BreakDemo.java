package com.houpu;

public class BreakDemo {
	public static void main(String[] args) {
		// 需求：获取第一个水仙花数
		// 在控制台输出所有的“水仙花数”
		
		
		
		
		for(int i=100 ; i<1000 ; i++) {
			// 假设i=123;
			int ge=i%100%10;
			
			int shi= i/10%10;
		
			int bai= i/100;
			
			// 它的每个位上的数字的 3次幂之和等于它本身
			if(ge*ge*ge+shi*shi*shi+bai*bai*bai==i) {
				System.out.println(i);
				
				break;
			}	
		}
	}
}
