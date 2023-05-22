package com.blb;

import org.junit.Test;

import java.util.Arrays;

public class Demo02String {

    @Test
    public void testString01() {
        String word ="hello , welcome to bailiban! ";
        System.out.println(word.substring(8)); //welcome to bailiban!
        System.out.println(word.substring(8,15)); //welcome
    }

    @Test
    public void testString02() {
        String word ="  hello  ";
        //去掉两端的空白字符
        System.out.println(word.trim()); //hello
    }

    @Test
    public void testString03() {
        String word ="hello , welcome to bailiban! ";
        //hello子字符串替换为byebye
        System.out.println(word.replace("hello","byebye")); //byebye , welcome to bailiban!
    }

    @Test
    public void testString04() {
        String word ="hello , welcome to bailiban! ";
        //返回索引位置为4的内容
        System.out.println(word.charAt(4)); //o
    }

    @Test
    public void testString05() {
        String word ="welcome to bailiban! ";
        //以空格字符将字符串分割为数组
        String[] attr = word.split(" ");
        System.out.println(Arrays.toString(attr)); //[welcome, to, bailiban!]
    }

}
