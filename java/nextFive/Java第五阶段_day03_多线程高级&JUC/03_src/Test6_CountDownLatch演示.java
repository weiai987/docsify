package org.hopu.djp.libDemo.jucTest;

import java.util.concurrent.CountDownLatch;

public class Test6 {
    class latchDemo implements Runnable {
        private CountDownLatch latch;
        private int x = 0;
        public latchDemo(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                long start = System.currentTimeMillis();
                for(int i=0; i<10; i++) {
                    x += 2;
                }
                String name = Thread.currentThread().getName();
                System.out.println(name + ":x=" + x);
                long end = System.currentTimeMillis();
                System.out.println(name + "耗费时间为：" + (end - start) + "ms");
            } finally {
                latch.countDown();  // 必须的操作，表示结束
            }

        }
    }

    public void go() {
        int latchSize = 10;
        CountDownLatch latch = new CountDownLatch(latchSize); // 5表示有5个线程
        latchDemo l = new latchDemo(latch);
        long start = System.currentTimeMillis();

        for(int i=0; i<5; i++) {
            new Thread(l).start();
        }
        try {
            latch.await(); // 主进程等待，直到计算达到latchSize数量的子进程执行latch.countDown
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("总耗费时间为：" + (end - start) + "ms");
    }

    public static void main(String[] args) {
        Test6 t = new Test6();
        t.go();
    }
}
