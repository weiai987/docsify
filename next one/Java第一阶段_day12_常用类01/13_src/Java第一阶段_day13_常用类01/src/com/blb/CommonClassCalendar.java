package com.blb;

import java.util.Calendar;

public class CommonClassCalendar {

    public static void main(String[] args) {
//        创建当前时间对应的日历类
        Calendar cal = Calendar.getInstance();
//        获取日历类中的年份
        System.out.println(cal.get(Calendar.YEAR));//2020
//        获取日历类中的月份
        System.out.println(cal.get(Calendar.MONTH));//11
//        获取日历类中的几号
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//28
//        获取日历类中的小时，12小时制
        System.out.println(cal.get(Calendar.HOUR));//3
//        获取日历类中的小时，24小时制
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));// 15
        //         获取日历类中的分
        System.out.println(cal.get(Calendar.MINUTE));//31
        //         获取日历类中的秒
        System.out.println(cal.get(Calendar.SECOND));// 36
//         获取日历类中的星期
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));//2
    }


}
