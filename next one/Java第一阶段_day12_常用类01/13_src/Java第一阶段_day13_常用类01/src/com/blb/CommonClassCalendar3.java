package com.blb;

import java.util.Calendar;

public class CommonClassCalendar3 {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日"); // 2018年1月17日
//      2020年12月28日

        // 使用add方法，将日增加1
        cal.add(Calendar.DAY_OF_MONTH, 1);
        // 使用add方法，将年份减去9
        cal.add(Calendar.YEAR, -9);
        System.out.println(cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日"); // 2018年1月17日
//      2011年12月29日
    }

}
