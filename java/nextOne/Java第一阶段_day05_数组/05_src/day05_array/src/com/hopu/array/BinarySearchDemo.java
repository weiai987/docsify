package com.hopu.array;

import java.util.Arrays;

public class BinarySearchDemo {
	public static void main(String[] args) {
		// 定义一个元素顺序有序的数组
		int[] arr = { 1, 2, 3, 4, 5, 6};
		// 定义一个要查找的元素
		int a=61;
		
		// 初始化查找的起始位置、终止位置和中间位置
		int begin=0;
		int end=arr.length;
		int mid=(begin+end)/2;
		// 确保不会出现重复查找，越界
		while(begin <=end) {
			if(a> arr[mid]) {
				begin=mid+1;
				mid=(begin+end)/2;
			}else if(a< arr[mid]) {
				end=mid-1;
				mid=(begin+end)/2;
			}else {
				System.out.println("元素位置为："+mid);
				break;
			}
			// 如果起始角标已经超过终止角标还没找到，那就是数组没有这个原生
			if(end<=begin) {
				System.out.println("没有该元素");
				break;
			}
		}
	}
}
