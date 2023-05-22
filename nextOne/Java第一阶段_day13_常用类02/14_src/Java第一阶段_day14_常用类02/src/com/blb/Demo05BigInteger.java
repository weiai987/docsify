package com.blb;

import org.junit.Test;

import java.math.BigInteger;

public class Demo05BigInteger {

    @Test
    public void testBigInteger01(){
        BigInteger bi = new BigInteger("9999999999999999999999999999999999999");
        System.out.println(bi);
    }

    @Test
    public void testBigInteger02(){
        BigInteger b1 = new BigInteger("99999999999999999999999999999999999999999");
        BigInteger b2 = new BigInteger("99999999999999999999999999999999999999999");
        // 将2个BigInteger进行相加运算
        System.out.println(b1.add(b2));
    }

    @Test
    public void testBigInteger03(){
        BigInteger b1 = new BigInteger("999999999999999999999999999999999999999999999");
        BigInteger b2 = new BigInteger("111111111111111111111111111111111111111111111");
        // 将2个BigInteger进行相减运算
        System.out.println(b1.subtract(b2));
    }

    @Test
    public void testBigInteger04(){
        BigInteger b1 = new BigInteger("999999999999999999999999999999999999999999999");
        BigInteger b2 = new BigInteger("111111111111111111111111111111111111111111111");
        // 将2个BigInteger进行相乘运算
        System.out.println(b1.multiply(b2));
    }

    @Test
    public void testBigInteger05(){
        BigInteger b1 = new BigInteger("999999999999999999999999999999999999999999999");
        BigInteger b2 = new BigInteger("111111111111111111111111111111111111111111111");
        // 将2个BigInteger进行相乘运算
        System.out.println(b1.divide(b2)); // 9
    }
}
