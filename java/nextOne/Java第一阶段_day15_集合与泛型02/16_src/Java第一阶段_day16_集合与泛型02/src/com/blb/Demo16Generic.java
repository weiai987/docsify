package com.blb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo16Generic {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<String> list2 = new ArrayList<String>();
        List<Number> list3 = new ArrayList<Number>();
        List<Object> list4 = new ArrayList<Object>();

        show1(list1);
//        show1(list2);//报错
        show1(list3);
//        show1(list4);//报错

//        show2(list1);//报错
//        show2(list2);//报错
        show2(list3);
        show2(list4);


    }

    public static void show1(List<? extends Number> list){
    }

    public static void show2(List<? super Number> list){
    }



}
