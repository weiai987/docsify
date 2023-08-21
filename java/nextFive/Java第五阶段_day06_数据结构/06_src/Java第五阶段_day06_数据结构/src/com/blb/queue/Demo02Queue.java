package com.blb.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Demo02Queue {

    public static void main(String[] args) {
//      创建队列
        Queue<String> queue = new LinkedList<String>();
//      使用add或者offer方法添加元素
        queue.add("刘备");
        queue.add("关羽");
        queue.add("张飞");
        queue.offer("赵云");
        queue.offer("黄忠");

//       删除队头元素
        System.out.println(queue.poll());
//        System.out.println(queue.remove());

//       获取队头元素
        System.out.println(queue.element());
        System.out.println(queue.peek());

    }
}
