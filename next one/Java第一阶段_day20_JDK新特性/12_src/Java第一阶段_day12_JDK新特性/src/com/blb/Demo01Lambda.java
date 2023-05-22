package com.blb;

public class Demo01Lambda {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("有一个线程即将执行。");
            }
        }).start();

//        lambda
        new Thread(()->System.out.println("有一个线程即将执行。")).start();

    }

}
