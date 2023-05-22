package com.blb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Demo06Iterator {

    public static void main(String[] args) {
     
//        准备集合跟元素
        List<String> list = new ArrayList<>();
        list.add("关羽");
        list.add("张飞");
        list.add("刘备");
        list.add("赵云");
        list.add("诸葛亮");

//        获取集合对应的迭代器
        Iterator<String> iterator = list.iterator();
//      获取迭代器之后修改了集合结构，会异常
//        list.add("黄忠");

//        每次判断是否有下一个元素，如果有返回true，否则返回false
        while (iterator.hasNext()){
            String hero = iterator.next();
            System.out.println(hero);
//            遍历过程中修改了集合的结构，会异常
//            list.remove(hero);
        }

    }
}
