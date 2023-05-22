package com.hopu.classobject.test;

public class MyUtils {
	 // 定义round方法,参数为(double d) , 返回值int
    public static int round(double d) {
        // round方法中,d+0.5后,转换为int类型,并返回.
        int n = (int) (d  + 0.5);
        return n;
    }
}
