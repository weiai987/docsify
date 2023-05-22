package com.blb;

import java.util.Calendar;

public class CommonClassCalendar2 {

    public static void main(String[] args) {
//        创建当前时间对应的日历类
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR,2012);
        cal.set(Calendar.MONTH,11);
        cal.set(Calendar.DAY_OF_MONTH,12);
        System.out.println(cal.get(Calendar.YEAR)+"年 "+(cal.get(Calendar.MONTH)+1)+"月 "+cal.get(Calendar.DAY_OF_MONTH)+"日");
        // 2012年 12月 12日

    }
}
