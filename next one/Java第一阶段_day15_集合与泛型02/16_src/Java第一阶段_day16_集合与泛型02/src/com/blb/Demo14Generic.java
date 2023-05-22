package com.blb;

interface GenericInterface<E>{
    public abstract void set(E e);
    public abstract E get();
}

//此时泛型接口中的泛型确定为String
class GenericImpl implements GenericInterface<String>{
    private String data ;

    @Override
    public void set(String s) {
        this.data = s ;
    }

    @Override
    public String get() {
        return data;
    }
}

public class Demo14Generic {

    public static void main(String[] args) {
        GenericInterface gi = new GenericImpl() ;
        gi.set("blb");
        System.out.println(gi.get());
    }
}
