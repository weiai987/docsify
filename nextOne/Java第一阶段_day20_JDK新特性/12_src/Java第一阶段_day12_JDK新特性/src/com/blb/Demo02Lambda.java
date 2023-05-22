package com.blb;

public class Demo02Lambda {

    public static void main(String[] args) {
        Drinkable drinkable = ()->{
            System.out.println("大口的喝...");
        };

        drinkable.drink();
    }
}

interface Drinkable{
    void drink();
}
