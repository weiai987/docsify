package com.blb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo03LinkedList {

    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        //添加元素
        link.addFirst("关羽");
        link.addFirst("张飞");
        link.addFirst("刘备");

        for (String s : link) {
            System.out.println(s);
        }



        System.out.println("======================");


//        System.out.println(link);
//
//        System.out.println(link.getFirst()); // 获取第1个元素
//        System.out.println(link.getLast()); // 获取最后1个元素
//
//        System.out.println(link.removeFirst());// 删除第1个元素
//        System.out.println(link.removeLast());// 删除最后1个元素
//
//        while (!link.isEmpty()) { //判断集合是否为空
//            System.out.println(link.pop()); //弹出集合中的栈顶元素
//        }
//
//        System.out.println(link);
    }
}
