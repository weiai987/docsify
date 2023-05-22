package com.blb;

import java.util.HashMap;

public class Demo07HashMap {

    public static void main(String[] args) {
//        三国时期，刘备派关羽守樊城，张飞守新野，赵子龙守徐州，他自己坐镇荆州。
        //创建 map对象
        HashMap<String, String> map = new HashMap<String, String>();

        //添加元素到集合
        map.put("关羽", "樊城");
        map.put("张飞", "新野");
        map.put("赵子龙", "徐州");
        map.put("刘备", "荆州");
        System.out.println(map);

//        删除赵子龙
        System.out.println(map.remove("赵子龙"));
        System.out.println(map);

        // 想要查看刘备守哪座城？
        System.out.println(map.get("刘备"));
    }
}
