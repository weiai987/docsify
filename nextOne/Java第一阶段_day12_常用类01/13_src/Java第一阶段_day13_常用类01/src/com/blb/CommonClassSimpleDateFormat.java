package com.blb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonClassSimpleDateFormat {
/*
//将Date对象转换成自定义的格式输出。
    public static void main(String[] args) throws ParseException {
        //	定义当前时间点对应的Date对象
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        //将日期Date格式化输出
        String dateString = format.format(date);
        System.out.println(dateString);//2020-12-28 14:57:18
    }
 */

//将字符串格式的日期转成Date类型
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        //字符串类型的日期
        String d = "20-12-28 14:55:05";
        // 字符串类型的日期转成Date对象
        Date date = format.parse(d);
        System.out.println(date);//Sat Dec 28 14:55:05 CST 20
    }
}
