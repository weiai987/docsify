package com.hopu.parctice;

public class FractionalSequenceTest {
    public static void main(String[] args) {
        System.out.println("数列的和为:" + getValue(20));
    }
	// 获取第i项的值    2/1，3/2，5/3，8/5，13/8
	public static double getValue(int n) {
	    double a=2; //分子
	    double b = 1;//分母
	    double sum = 0; //值
	    double temp = 0;//临时变量
	    for(int i = 0; i < n; i++) {
	         sum += a/b; 
	         temp = a;
	         a += b;
	         b = temp;
	    }
	    return sum;
	}
}
