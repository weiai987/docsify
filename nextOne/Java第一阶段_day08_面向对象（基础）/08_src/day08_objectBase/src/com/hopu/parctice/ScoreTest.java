package com.hopu.parctice;

import java.util.Scanner;

public class ScoreTest {
	public static void main(String[] args) {
		 //定义一个数组，用动态初始化完成数组元素的初始化，长度为6
	    int[] arr = new int[6];
	
	    //键盘录入评委分数
	    Scanner sc =new Scanner(System.in);	
	    // 收评委分数的操作，用循环改进
	    for(int i=0; i<arr.length; i++) {
	        System.out.println("请输入第" + (i + 1) + "个评委的打分：");
	        arr[i] = sc.nextInt();
	    }
	    
	    // 获取最大值
	   int max =getMax(arr);
	    // 获取最小值
	   int min =getMin(arr);
	   
	   // 获取平均分
	   int avg =getAvg(arr,max,min);
	   
	   //输出平均分
       System.out.println("选手的最终得分是：" + avg);
	}
	// 定义获取最大值方法
	public static int getMax(int[] arr) {
        int max = arr[0];
        for(int x=1; x<arr.length; x++) {
            if(arr[x] > max) {
                max = arr[x];
            }
        }
        return max;
	}
	// 定义获取最小值方法
    public static int getMin(int[] arr) {
        int min = arr[0];
        for(int x=1; x<arr.length; x++) {
            if(arr[x] < min) {
                min = arr[x];
            }
        }
        return min;
    }
    // 定义求平均分方法
    public static int getAvg(int[] arr,int max,int min) {
        int total = 0;
        for(int i=0; i<arr.length; i++) {
           total+=arr[i];
        }
        int avg=(total-max-min)/(arr.length-2);
        return avg;
    }
}
