package com.hopu.array;

import java.util.Arrays;
import java.util.List;

public class ArraysTestDemo {
	public static void main(String[] args) {
		// 定义一个元素顺序杂乱的数组
		int[] arr = { 4, 1, 3, 6, 2, 5};	
		// 直接打印
		System.out.println(arr);
		// 1、将数组以字符串形式打印
		System.out.println(Arrays.toString(arr));

		// 2、数组排序
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		// 3、数组二分查找
		int index =Arrays.binarySearch(arr, 1);
		System.out.println("元素1在有序数组arr中的索引位置为："+index);
		
		// 4、数组元素替换
		Arrays.fill(arr, 0, 2, 0);
		System.out.println(Arrays.toString(arr));
		
		// 5、数组的复制
		int[] copyArray =Arrays.copyOfRange(arr, 0, 3);
		System.out.println(Arrays.toString(copyArray));
	}
}
