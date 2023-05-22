package com.hopu.array;

import java.util.Arrays;

public class ArraySortDemo1 {
	public static void main(String[] args) {
		// 定义一个元素顺序杂乱的数组
		int[] arr = { 4, 1, 3, 6, 2, 5};
		// 外层循环表示比较轮数
		for (int i = 1; i <= arr.length-1; i++) {
			// 内层循环对比相邻两个数
			for (int j = 0; j < arr.length-i; j++) {
				// 定义一个临时变量
				int tempMax=0;
				// 进行元素位置交换
				if(arr[j]>arr[j+1]) {
					tempMax=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tempMax;
				}
			}
		}
		// 打印
		System.out.println(Arrays.toString(arr));
	}
}
