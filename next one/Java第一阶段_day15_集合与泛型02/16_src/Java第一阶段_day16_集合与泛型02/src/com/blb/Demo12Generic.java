package com.blb;

import java.util.ArrayList;

// 仿照ArrayList自定义泛型类
class MyGeneric<E> {
    private  E e ;

    public void set(E e){
        this.e = e ;
    }

    public E get(){
        return e ;
    }

}


public class Demo12Generic {

    public static void main(String[] args) {
        // 泛型类确定为String
        MyGeneric<String> g1 = new MyGeneric<String>();
        g1.set("blb");
        System.out.println(g1.get());
        // 泛型类确定为Integer
        MyGeneric<Integer> g2 = new MyGeneric<Integer>();
        g2.set(9);
        System.out.println(g2.get());

    }
}
