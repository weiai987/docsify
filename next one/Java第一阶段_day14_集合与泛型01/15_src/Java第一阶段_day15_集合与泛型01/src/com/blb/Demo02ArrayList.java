package com.blb;

import java.util.ArrayList;
import java.util.List;

public class Demo02ArrayList {

    public static void main(String[] args) {
//        创建集合容器
        List<String> list = new ArrayList<>();
        list.add("关羽");// 添加元素关羽，索引为0
        list.add("张飞");// 添加元素张飞，索引为1
        list.add("刘备");// 添加元素刘备，索引为2
        list.add("赵云");// 添加元素赵云，索引为3
        list.add("诸葛亮");// 添加元素诸葛亮，索引为4

//        遍历方式1
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

//        遍历方式2
        for (String name : list){
            System.out.println(name);
        }

    }
}
