package com.blb;

import java.util.Calendar;
import java.util.Date;

public class CommonClassCalendar4 {

   /* // 将日历类对象转成Date对象
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date); // Tue Jan 16 16:03:09 CST 2018
    }*/

    // 将Date对象转成日历类对象
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        System.out.println(cal);
    }
}
