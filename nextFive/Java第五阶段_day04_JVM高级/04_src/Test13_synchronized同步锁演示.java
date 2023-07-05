package org.hopu.djp.libDemo.jucTest;

public class Test13 implements Runnable {
    public static synchronized void method1() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ".method1 begin.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ".method1 end.");
    }

    public static synchronized void method2() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ".method2 begin.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ".method2 end.");
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int i = Integer.valueOf(name.substring(name.length() - 1));
        if (i % 2 == 0) {
            method1();
        } else {
            method2();
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Test13 t13 = new Test13();
            new Thread(t13).start();
        }
    }
}


