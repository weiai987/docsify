package com.hopu.array;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		// 定义一个指定容量的二维数组
		int[][] array = new int[2][3];
		// 1、赋值
		array[0][0]=0;
		array[0][1]=1;
		array[0][2]=2;
		array[1][0]=3;
		array[1][1]=4;
		
		// 2、修改
		array[0][0]=110;
		
		// 3、获取
		int a=array[0][0];

		// 打印数组
	    System.out.println(Arrays.deepToString(array));
	}
}
