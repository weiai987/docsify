package com.blb;

import java.util.ArrayList;
import java.util.List;

public class Demo01ArrayList {

    public static void main(String[] args) {
//        创建集合容器
        List<String> list = new ArrayList<>();
        list.add("关羽");// 添加元素关羽，索引为0
        list.add("张飞");// 添加元素张飞，索引为1
        list.add("刘备");// 添加元素刘备，索引为2
        list.add("赵云");// 添加元素赵云，索引为3
        list.add("诸葛亮");// 添加元素诸葛亮，索引为4

        System.out.println(list);// 打印集合信息

        System.out.println(list.get(2));// 根据索引查找对应的元素

        System.out.println(list.size());// 查看集合中一共有多少个元素

        System.out.println(list.contains("赵云")); // 判断赵云是否存在集合中

        list.remove("诸葛亮");// 删除诸葛亮

        //Object[] toArray()转换成一个Object数组
        Object[] objects = list.toArray();
        // 遍历数组
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        list.clear();// 清空集合
        System.out.println(list.isEmpty());// boolean  isEmpty()  判断是否为空

    }
}
