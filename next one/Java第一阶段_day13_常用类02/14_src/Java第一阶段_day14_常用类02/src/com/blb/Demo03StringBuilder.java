package com.blb;

import org.junit.Test;

public class Demo03StringBuilder {

    @Test
    public void testStringBuilder01() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);// 空白
        StringBuilder sb2 = new StringBuilder("bailiban");
        System.out.println(sb2);// bailiban
    }

    @Test
    public void testStringBuilder02() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("hello ").append(" welcome ").append(" to ").append(" bailiban ");
        System.out.println(sb);// hello  welcome  to  bailiban
    }

    @Test
    public void testStringBuilder03() {
        StringBuilder sb = new StringBuilder("bailiban");
        System.out.println(sb.reverse());// nabiliab
    }
}
