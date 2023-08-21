package com.blb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo08Regular {

    public static void main(String[] args) {
        String s = "2021-01-06";
		Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
		Matcher matcher = p.matcher(s);
//		使用find方法来匹配
		if(matcher.find()){
// 		matcher.group() 返回的是整个串的数据
			System.out.println(matcher.group());//2021-01-06
			// 分组：通过索引来获取第几组，索引为从左往右数第几个 (
			System.out.println(matcher.group(0));//2021-01-06
			System.out.println(matcher.group(1));//2021
			System.out.println(matcher.group(2));//01
			System.out.println(matcher.group(3));//06
		}
    }
}
