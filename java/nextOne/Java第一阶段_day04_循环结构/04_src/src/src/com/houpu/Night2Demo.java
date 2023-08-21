package com.houpu;

public class Night2Demo {
	public static void main(String[] args) {
		// 需求:实现一个九九乘法表
		// 外层for循环，控制我们的行数
		for(int i=1;i<=9;i++) {
			// i=2
			for(int j=1 ;j<=i ; j++) {
				// 字符串拼接		1x1=1
				//                 2x1=2 
				//                 2x2=4 
				// 转义符
				System.out.print(j+"x"+i+"="+i*j+"\t");	
			}
			// 控制每一行的内部for循环完成后进行换行
			System.out.println();
		}
	}
}
