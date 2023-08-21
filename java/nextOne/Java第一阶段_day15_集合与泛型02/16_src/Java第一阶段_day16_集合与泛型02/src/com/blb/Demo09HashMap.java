package com.blb;

import java.util.*;

public class Demo09HashMap {

    public static void main(String[] args) {
        //创建 map对象
        HashMap<String, String> map = new HashMap<String, String>();

        //添加元素到集合
        map.put("关羽", "樊城");
        map.put("张飞", "新野");
        map.put("赵子龙", "徐州");
        map.put("刘备", "荆州");


//方式1
        Set<String> keys = map.keySet();
        for (String name : keys) {
            System.out.println(name + " " + map.get(name));
        }

        Collection<String> values = map.values();
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }

//        方式2
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("----------");
//        方式3 推荐
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }


        }
}
