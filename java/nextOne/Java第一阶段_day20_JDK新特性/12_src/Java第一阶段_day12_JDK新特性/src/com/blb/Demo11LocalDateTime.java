package com.blb;

import org.junit.Test;
import sun.rmi.server.LoaderHandler;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Demo11LocalDateTime {

    @Test
    public void dateTime01(){
//      获取当前对应的日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate date = LocalDate.of(2020, 12, 13);
        System.out.println(date);
//      获取年份
        System.out.println(now.getYear());
//       获取月份，英文
        System.out.println(now.getMonth());
//       获取月份值
        System.out.println(now.getMonthValue());
//        获取当月中的第几天，也就是几号
        System.out.println(now.getDayOfMonth());
//        获取当周中的第几天，也就是星期
        System.out.println(now.getDayOfWeek());
//        获取年中的第几天
        System.out.println(now.getDayOfYear());

//        修改年份为2019
        System.out.println(now.withYear(2019));
//        修改月份为2
        System.out.println(now.withMonth(2));
//        修改日期为3号
        System.out.println(now.withDayOfMonth(3));

    }

    @Test
    public void dateTime02(){
        LocalTime time = LocalTime.of(11,12,13);
        System.out.println(time);
//      获取当前时间
        LocalTime now = LocalTime.now();
//       获取小时
        System.out.println(now.getHour());
//       获取分
        System.out.println(now.getMinute());
//       获取秒
        System.out.println(now.getSecond());
//       获取纳秒
        System.out.println(now.getNano());
//      修改小时为12
        System.out.println(now.withHour(12));
//       修改分钟为22
        System.out.println(now.withMinute(22));
//        修改秒为33
        System.out.println(now.withSecond(33));
    }

    @Test
    public void dateTime03(){
        LocalDateTime time = LocalDateTime.of(2020,12,11,10,11,12);
        System.out.println(time);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //      获取年份
        System.out.println(now.getYear());
//       获取月份，英文
        System.out.println(now.getMonth());
//       获取月份值
        System.out.println(now.getMonthValue());
//        获取当月中的第几天，也就是几号
        System.out.println(now.getDayOfMonth());
//        获取当周中的第几天，也就是星期
        System.out.println(now.getDayOfWeek());
//        获取年中的第几天
        System.out.println(now.getDayOfYear());
//       获取小时
        System.out.println(now.getHour());
//       获取分
        System.out.println(now.getMinute());
//       获取秒
        System.out.println(now.getSecond());
//       获取纳秒
        System.out.println(now.getNano());
//        修改年份为2019
        System.out.println(now.withYear(2019));
//        修改月份为2
        System.out.println(now.withMonth(2));
//        修改日期为3号
        System.out.println(now.withDayOfMonth(3));
//      修改小时为12
        System.out.println(now.withHour(12));
//       修改分钟为22
        System.out.println(now.withMinute(22));
//        修改秒为33
        System.out.println(now.withSecond(33));
    }

    @Test
    public void dateTime04(){
//      日期转成格式化字符串
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        String formatNow = now.format(dtf);
        System.out.println(formatNow);

//       格式化字符串转成日期
        LocalDateTime parse = LocalDateTime.parse("2021年01月28日 04时14分43秒", dtf);
        System.out.println(parse);
    }

    @Test
    public void dateTime05(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime time = LocalTime.of(17,48,12);
        System.out.println(time);

        Duration duration = Duration.between(now,time);
//      时间差转成小时
        System.out.println(duration.toHours());
//      时间差转成分钟
        System.out.println(duration.toMinutes());
//      时间差转成秒
        System.out.println(duration.getSeconds());
//      时间差转成纳秒
        System.out.println(duration.toNanos());

    }

    @Test
    public void dateTime06(){
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2030,4,30);
        Period period = Period.between(now,date);
//      获取年份差
        System.out.println(period.getYears());
//      获取月份差
        System.out.println(period.getMonths());
//       获取日期差
        System.out.println(period.getDays());
    }

    @Test
    public void dateTime07(){
        LocalDateTime now = LocalDateTime.now();
//      设置下月1号的校正器
        TemporalAdjuster firstDayOfNextMonth = temporal -> {
            LocalDateTime time = (LocalDateTime) temporal;
            return time.plusMonths(1).withDayOfMonth(1);
        };
//      通过校正器调节now的值
        System.out.println(now.with(firstDayOfNextMonth));

//       TemporalAdjusters获取下一年的第1天的校正器
        System.out.println(now.with(TemporalAdjusters.firstDayOfNextYear()));

    }

}
