package org.hopu.djp.libDemo.jucTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class Test5 {

    private int threadNum = 100;
    private CountDownLatch startGate;
    private CountDownLatch endGate;

    public void go() {
        startGate = new CountDownLatch(1);
        endGate = new CountDownLatch(threadNum);

        long start = System.currentTimeMillis();
        //所有阻塞的任务同时开始
        startGate.countDown();

        HelloTable ht = new HelloTable();
        for(int i=0; i<threadNum; i++) {
            new Thread(ht).start();
        }

        try {
            //主线程阻塞,等待其他所有 worker 线程完成后再执行
            endGate.await();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总用时: " + (end - start) + "ms");
    }

    public static void main(String[] args) {
        Test5 t = new Test5();
        t.go();
    }

    class HelloTable implements Runnable {
//        private HashMap<String, Object> table = new HashMap<String, Object>();
    private Hashtable<String, Object> table = new Hashtable<String, Object>();
//    private ConcurrentHashMap<String, Object> table = new ConcurrentHashMap<String, Object>();

        @Override
        public void run() {
//            System.out.println("线程"+Thread.currentThread().getName()+"开始运行。");
            try {
                long l1 = System.currentTimeMillis();
                startGate.await();
                Thread.sleep(10);
                for(int i=0; i<100000; i++) {
                    double x = new Random().nextDouble();
//            System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(x) + ":");
                    table.put(String.valueOf(x), x);
                }
                long l2 = System.currentTimeMillis();
                System.out.println("线程"+Thread.currentThread().getName()+"运行时间：" + (l2 - l1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                endGate.countDown();
            }
        }
    }
}


