package com.hopu.base;

public class VariableParamTest {
	public static void main(String[] args) {
		int rs1= getSum();
		System.out.println(rs1);
		
		int rs2= getSum(1,2);
		System.out.println(rs2);
		
	}
	
	// 定义一个可变参数方法，求取n个整数之和
	public static int getSum(int... numbers) {
		int sum=0;
		for (int i = 0; i < numbers.length; i++) {
			sum+=numbers[i];
		}
		return sum;
	}
}
