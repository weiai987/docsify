package com.hopu.array;

import java.util.Arrays;

public class Dddd {
	public static void main(String[] args) {
		// 定义2个同样类型的数组
		int[] arr= {1,2};
		int[] arr2= {3,4,5}; 
		// 定义一个新数组，并指定长度
		int[] newArr=new int[arr.length+arr2.length];
		for (int i = 0; i < newArr.length; i++) {
			if(i<arr.length) {
				newArr[i]=arr[i];
			}else {
				newArr[i]=arr2[i-arr.length];
			}
		}	
		// 打印
	    System.out.println(Arrays.toString(newArr));
	}
}
