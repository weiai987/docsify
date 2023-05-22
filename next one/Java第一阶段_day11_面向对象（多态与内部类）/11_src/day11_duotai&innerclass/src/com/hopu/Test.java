package com.hopu;
public class Test { 
    public static void main(String[] args) { 
        // 多态形式，创建对象 
        Animal a1 = new Cat(); 
        // 调用的是 Cat 的 eat 
        a1.eat(); 
        System.out.println(a1.a);
        // 多态形式，创建对象 
        Animal a2 = new Dog(); 
        // 调用的是 Dog 的 eat 
        a2.eat(); 
    }
}