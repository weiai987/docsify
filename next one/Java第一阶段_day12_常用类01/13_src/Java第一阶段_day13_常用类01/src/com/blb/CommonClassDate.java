package com.blb;

import java.util.Date;

public class CommonClassDate {

    public static void main(String[] args) {
        //      创建当前时间对应的Date对象
        Date date = new Date();
//      使用Date中重写的toString的格式显示日期
        System.out.println(date); // Mon Dec 28 14:29:39 CST 2020
//      自从标准基准时间之间的毫秒数
        System.out.println(date.getTime());//  1609137137133


//		创建日期对象，把当前的毫秒值转成日期对象
        Date date2 = new Date(0);
        System.out.println(date2); // Thu Jan 01 08:00:00 CST 1970
    }
}
