package com.blb;

public class Demo06InterfaceEnhance {

    public static void main(String[] args) {
        Swimmable.swimming();
    }
}

interface Swimmable{

    public static void swimming(){
        System.out.println("游泳");
    }
}
