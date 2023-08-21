package com.hopu.array;

import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) {
		// 定义一个定长数组
		int[] array = new int[3];
		// 1、元素赋值
		array[0]=1;
		array[1]=2;
		array[2]=3;
		
		// 2、元素修改
		array[0]=11;
		
		// 3、元素获取
		int a=array[0];
		
		// 打印数组，Arrays先了解即可
		System.out.println(Arrays.toString(array));
	}
}
