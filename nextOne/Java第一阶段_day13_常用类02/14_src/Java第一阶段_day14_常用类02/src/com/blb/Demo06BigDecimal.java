package com.blb;

import org.junit.Test;

import java.math.BigDecimal;

public class Demo06BigDecimal {

    @Test
    public void testBigDecimal01(){
        BigDecimal bd1 = new BigDecimal("0.123456789");
    }

    @Test
    public void testBigDecimal02(){
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        // 对2个小数进行相加运算
        System.out.println(bd1.add(bd2));
    }

    @Test
    public void testBigDecimal03(){
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        //          对2个小数进行相减运算
        System.out.println(bd2.subtract(bd1));
    }

    @Test
    public void testBigDecimal04(){
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        //          对2个小数进行相乘运算
        System.out.println(bd2.multiply(bd1));
    }

    @Test
    public void testBigDecimal05(){
        BigDecimal bd1 = new BigDecimal("0.33");
        BigDecimal bd2 = new BigDecimal("0.11");
        // 对2个小数进行相除运算，如果除不尽则报错
        System.out.println(bd1.divide(bd2));
        //  对2个小数进行相除运算，如果除不尽则保留3位小数位,末尾采取四舍五入的方式
        System.out.println(bd2.divide(bd1,3,BigDecimal.ROUND_HALF_UP));
    }
}
