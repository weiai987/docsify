package com.blb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo09Stream {

    public static void main(String[] args) {
//      创建集合并添加元素
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
//       通过流过滤姓名以“黄”开头的元素，然后遍历
        list.stream().filter((s)->{
           return s.startsWith("黄");
        }).forEach((s)->{
            System.out.println(s);
        });

    }
}
