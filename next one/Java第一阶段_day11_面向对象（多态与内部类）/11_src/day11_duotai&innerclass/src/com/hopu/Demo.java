package com.hopu;
public class Demo {
    public static void main(String[] args){
        AbstractClass abstractClass = new Pork();
        abstractClass.execute();

        System.out.println("-------------------");

        abstractClass = new Elephant();
        abstractClass.execute();
    }
}