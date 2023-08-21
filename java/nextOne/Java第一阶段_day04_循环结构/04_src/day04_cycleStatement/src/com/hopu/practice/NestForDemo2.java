package com.hopu.practice;

public class NestForDemo2 {
	public static void main(String[] args) {
	    //外层循环控制行
	   a: for (int i = 1; i <= 9; i++) {
	    	// 内层循环控制列
	        for (int j = 1; j <= i; j++) {
	        	if(j>=5) {
	        		break a;
	        	}
	            //不换行\t表示制表符
	            System.out.print(i + "*" + j + "="+i*j+"\t");
	        }
	        // 需要一次换行
	        System.out.println();
	    }
	}
}
