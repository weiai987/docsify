package com.blb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo09Regular {

    public static void main(String[] args) {
        String s = "2021-01-06";
		Pattern p = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
		Matcher matcher = p.matcher(s);
//		使用find方法来匹配
		if(matcher.find()){
// 		matcher.group() 返回的是整个串的数据
			System.out.println(matcher.group());//2021-01-06
			// 分组：通过分组别名获取对应字段数据值
			System.out.println(matcher.group("year"));//2021
			System.out.println(matcher.group("month"));//01
			System.out.println(matcher.group("day"));//06
		}
    }
}
