package com.houpu;

public class DoWhileDemo {
	public static void main(String[] args) {
		// 在控制台输出10次HelloWorld
		for(int i=1;i<=10;i++) {
			System.out.println("hello world");
		}
		System.out.println("=================");
		
		int x=11;
		while(x<=10) {
			System.out.println("hello world");
			x++;
		}
		System.out.println("==================");
		
		int y=11;
		do {
			System.out.println("hello world");
			y++;
		}while(y<=10);
	}
}
