package com.blb;


import org.junit.Test;

enum Weeks {
    //七个星期常量
    MON,TUE,WES,THU,FRI,SAT,SUN
}

public class Demo09Enum02 {

    @Test
    public void testWeek(){
        //定义枚举变量并赋值
        Weeks week = Weeks.SAT;
        //使用switch判断枚举变量
        switch(week){
            case MON:
                System.out.println("星期一吃鱼香茄子");
                break;
            case TUE:
                System.out.println("星期二吃蛋炒饭");
                break;
            case WES:
                System.out.println("星期三吃小牛肉");
                break;
            case THU:
                System.out.println("星期四吃热干面");
                break;
            case FRI:
                System.out.println("星期五吃黄焖鸡");
                break;
            case SAT:
                System.out.println("星期六吃泡面");
                break;
            case SUN:
                System.out.println("星期天吃青椒肉丝");
                break;
        }
    }

}
