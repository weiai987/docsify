package com.blb;

public class Demo05InterfaceEnhance {

    public static void main(String[] args) {
        Bird bird = new Chicken();
        bird.fly();
    }
}

interface Bird{

    default void fly(){
        System.out.println("展翅高飞");
    }

}

class Chicken implements Bird{

    @Override
    public void fly() {
        System.out.println("想飞却飞不高……");
    }
}