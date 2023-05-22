package com.blb;

import org.junit.Test;

public class Demo04Integer {

    @Test
    public void testInteger01(){
        //将基本类型的1自动装箱为包装类Integer
        Integer i = 1 ;
        System.out.println(i);//1
    }

    @Test
    public void testInteger02(){
        //定义包装类对象i
        Integer i = new Integer(1) ;
        //将包装类拆箱成基本类型int
        int i2 = i ;
        System.out.println(i2);// 1
    }

    @Test
    public void testInteger03(){
        // 将字符串类型转成对应的基本类型
        int i = Integer.parseInt("99");
        System.out.println(i);
    }

    @Test
    public void testInteger04(){
        Integer it = new Integer(100);
        // 将包装类转成基本类型
        int i = it.intValue();
        System.out.println(i);
    }

    @Test
    public void testInteger05(){
//          获取36的2进制的表示形式
        System.out.println( Integer.toBinaryString(36));
//          获取36的8进制的表示形式
        System.out.println( Integer.toOctalString(36));
//          获取36的16进制的表示形式
        System.out.println( Integer.toHexString(36));
    }
}
