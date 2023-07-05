package org.hopu.djp.libDemo.jucTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;



public class Test3 {
    class AtomicDemo implements Runnable{

        //        private volatile int serialNumber = 0;
        private AtomicInteger serialNumber = new AtomicInteger(0);

        @Override
        public void run() {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(getSerialNumber());
        }

        public int getSerialNumber(){
//            return serialNumber++;
            return serialNumber.getAndIncrement(); // 原子执行自增1操作
        }
    }

    public void method1() {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(ad).start();
        }
    }

    public static void main(String[] args) {
        Test3 t3 = new Test3();
        t3.method1();
    }
}
