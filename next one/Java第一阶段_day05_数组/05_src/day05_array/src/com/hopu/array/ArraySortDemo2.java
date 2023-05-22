package com.hopu.array;

import java.util.Arrays;

public class ArraySortDemo2 {
	public static void main(String[] args) {
		// 定义一个元素顺序杂乱的数组
		int[] arr = { 4, 1, 3, 6, 2, 5};
		// 外层循环循环每一个元素，拿着与内存循环的每个元素对比
		for (int i = 0; i < arr.length; i++) {
			// 内层循环对比相邻两个数
			for (int j = i+1; j < arr.length; j++) {	
				// 定义一个临时变量	
				int temp=0;
				// 进行元素位置交换
				if(arr[i] > arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		// 打印
		System.out.println(Arrays.toString(arr));
	}
}
