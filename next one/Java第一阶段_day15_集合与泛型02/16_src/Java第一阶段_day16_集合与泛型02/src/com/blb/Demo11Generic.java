package com.blb;

import java.util.ArrayList;
import java.util.List;

public class Demo11Generic {

    public static void main(String[] args) {
//        指定了泛型，决定了这个集合中的元素只能放入String类型
        List<String> list = new ArrayList<>();
        list.add("唐僧");
        list.add("孙悟空");
        list.add("猪八戒");
        list.add("沙僧");
//        list.add(1);// 编译错误，因为不是String类型
    }
}
