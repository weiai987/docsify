package com.hopu.practice;

public class NestForDemo {
	public static void main(String[] args) {
	    //打印2020年至2023年月份
	    //年份是外循环，3年；月份是内循环，12月
	    for (int i = 2020; i <= 2023; i++) {
	        for (int j = 1; j <= 12; j++) {
	            //不换行打印星号
	            System.out.print(i + "年" + j + "月 ");
	        }
	        //内循环打印12个月后，需要一次换行
	        System.out.println();
	    }
	}
}
