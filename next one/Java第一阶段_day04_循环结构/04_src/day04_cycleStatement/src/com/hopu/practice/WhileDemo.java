package com.hopu.practice;

public class WhileDemo {
	public static void main(String[] args) {
	    //求和的最终结果必须保存起来，需要定义一个变量，用于保存求和的结果，初始值为0
	    int sum = 0;
	    //从1开始到100结束的数据，使用循环结构完成
	    /*
	        sum += i; sum = sum + i;
	        第一次：sum = sum + i = 0 + 1 = 1;
	        第二次：sum = sum + i = 1 + 2 = 3;
	        第三次：sum = sum + i = 3 + 3 = 6;
	        第四次：sum = sum + i = 6 + 4 = 10;
	        第五次：sum = sum + i = 10 + 5 = 15;
	        。。。
	        */
	    for(int i=1; i<=100; i++) {
	        //将反复进行的事情写入循环结构内部
	        // 此处反复进行的事情是将数据 i 加到用于保存最终求和的变量 sum 中
	        sum += i;        
	    }
	    System.out.println(sum);
	}
}
