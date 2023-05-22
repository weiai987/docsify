package com.blb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo04HashSet {

    public static void main(String[] args) {
//        创建集合容器
        Set<String> set = new HashSet<>();
        set.add("关羽");
        set.add("张飞");
        set.add("刘备");
        set.add("赵云");
        set.add("诸葛亮");

        System.out.println(set);// 打印集合信息

        System.out.println(set.size());// 查看集合中一共有多少个元素

        System.out.println(set.contains("赵云")); // 判断赵云是否存在集合中

        set.remove("诸葛亮");// 删除诸葛亮


        set.clear();// 清空集合
        System.out.println(set.isEmpty());// boolean  isEmpty()  判断是否为空

    }
}
