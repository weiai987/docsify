package com.houpu;

public class ForDemo2 {

	public static void main(String[] args) {
//		// 在控制台输出1-5和5-1的数据
//		for(int i=1; i<=5; i++) {
//			System.out.println(i);
//		}
//		System.out.println("========================");
//		for(int i=5; i>0 ; i--) {
//			System.out.println(i);
//		}
//		
//		
//		// 扩展：输出1~20之间1、4、7、10、13、16这种数字
//		for(int i=1 ; i<=20 ; i+=3) {
//			System.out.println(i);
//		}
		
		// 需求： 求1~100之间的数据和，并把求和结果在控制台输出
		// 1 +2 + 3 + 4+ ...... +100
		// 100+前99个数的和
		// 99个数的和=====99+前98个数的和
		// 2个数的和======2+前1个数的和  2+1
		// 1个数的和=======1+前面0个数的和
		int sum=0;  // 声明一个变量记录前面数据的和
		for(int i=1; i<=100 ;i++ ) {
			// i只是代表当前循环过程中的数字大小
			System.out.println(i);
			// sum= 1+0
			// sum=2+1
//			sum=i+sum;
			 
			sum+=i;
		}
		System.out.println(sum);
		
	
		
		
	}

}
