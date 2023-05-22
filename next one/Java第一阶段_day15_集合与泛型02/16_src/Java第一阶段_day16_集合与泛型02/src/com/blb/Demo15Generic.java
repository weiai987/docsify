package com.blb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo15Generic {

    public static void main(String[] args) {
//        定义泛型为String
        List<String> list1 = new ArrayList<String>();
        show(list1);
//        定义泛型为Integer
        List<Integer> list2 = new ArrayList<Integer>();
        show(list2);


    }

    public static void show(List<?> list){
//        list.add(); //不能调用add方法
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }


}
