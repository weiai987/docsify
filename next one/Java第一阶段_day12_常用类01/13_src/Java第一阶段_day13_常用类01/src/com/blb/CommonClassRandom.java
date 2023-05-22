package com.blb;

import java.util.Random;

public class CommonClassRandom {

    public static void main(String[] args) {
//        创建一个随机对象
        Random random = new Random() ;
//        生成一个随机的int整数
        System.out.println(random.nextInt());
//        随机生成一个[0,10)范围内的随机数
        System.out.println(random.nextInt(10));
//        随机生成一个float类型的值
        System.out.println(random.nextFloat());
//        随机生成一个double类型的值
        System.out.println(random.nextDouble());
//        随机生成一个long类型的值
        System.out.println(random.nextLong());
//        随机生成一个boolean类型的值
        System.out.println(random.nextBoolean());
    }
}
