package com.hopu.parctice;

public class BinarySearchTest {
	 public static void main(String[] args) {
		 // 定义一个有序数组 
		 int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 // 调用递归算法查找元素位置
		 int key=4;
		 int index= binSearch(arr, 0, arr.length-1, key);
		 // 输出结果
		 System.out.println(key+"数字在数组的角标位置是："+index);
	 }
	 // 定义递归二分算法
 	 public static int binSearch(int arr[], int start, int end, int key) {
 		 int mid = start + (end - start) / 2;
 		 // 找到对应元素
 		 if (arr[mid] == key) {
 			 return mid;
		 }
 		 if (key > arr[mid]) {
 			 // 递归调用二分查找
 			 return binSearch(arr, mid + 1, end, key);
		 } else if (key < arr[mid]) {
			 // 递归调用二分查找
			 return binSearch(arr, start, mid - 1, key);			
		 }
 		 // 没有找到，返回-1标志
 		 if (start >= end) {
 			 return -1;
 		 }
 		 return -1;
     }
}
