package com.blb;

class GenericMethod  {

    public <E>  void show(E e){
        System.out.println(e);
    }

}

public class Demo13Generic {

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
//        泛型方法的类型确定为字符串
        gm.show("blb");
//        泛型方法的类型确定为Integer
        gm.show(99);
    }
}
