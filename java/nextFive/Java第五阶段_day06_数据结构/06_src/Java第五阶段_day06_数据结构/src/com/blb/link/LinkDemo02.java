package com.blb.link;

import java.util.LinkedList;

public class LinkDemo02 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
//        添加元素
        list.add("100");
        list.add("200");
        list.add("300");
        list.add("400");
        list.add("500");
//        位置2的地方插入
        list.add(2, "150");
        System.out.println(list);
//      获取索引3位置的元素
        System.out.println(list.get(3));
//      删除元素
        System.out.println(list.remove(2));
        System.out.println(list);

//       获取首节点
        System.out.println("链表的第一个元素是：" + list.getFirst());
//       获取尾节点
        System.out.println("链表的最后一个元素是：" + list.getLast());
    }
}
