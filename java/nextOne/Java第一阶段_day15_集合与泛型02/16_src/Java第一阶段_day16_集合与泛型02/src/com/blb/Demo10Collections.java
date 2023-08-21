package com.blb;

import java.util.ArrayList;
import java.util.Collections;

public class Demo10Collections {

     @Test
    public  void testBinarySearch() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        System.out.println(Collections.binarySearch(list, 4));
    }

    @Test
    public  void testReplaceAll() {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
        Collections.replaceAll(list,"刘备","马超");
        System.out.println(list);
    }

    @Test
    public  void testSwap() {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
//      往集合中的元素进行互换
        Collections.swap(list,0,2);
        System.out.println(list);
    }

    @Test
    public  void testSort() {
        ArrayList<Integer> list = new ArrayList<Integer>();

//      往集合中添加元素
        Collections.addAll(list,3,9,6,4,1,5);
        System.out.println(list);

//      用默认的比较器对集合中的元素排序
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(list);
    }

    @Test
    public  void testMinAndMax() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,3,9,6,4,1,5);
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
    }

    @Test
    public  void testReverse() {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
//      往集合中所有元素反转
        Collections.reverse(list);
        System.out.println(list);
    }


    @Test
    public  void testShuffle() {
        ArrayList<String> list = new ArrayList<String>();
//      往集合中添加元素
        Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
        System.out.println(list);

//     随机打乱这个集合中的元素
        Collections.shuffle(list);
        System.out.println(list);
    }

    @Test
    public  void testAddAll() {
        ArrayList<String> list = new ArrayList<String>();
//      往集合中添加元素
        Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
        System.out.println(list);
    }

}
