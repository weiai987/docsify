package org.hopu.djp.libDemo.jucTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test9 {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    class CondationDemo implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("Thread is await");
                condition.await();
                System.out.println("Thread is going on");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void go() throws InterruptedException {
        CondationDemo c1 = new CondationDemo();
        Thread t1 = new Thread(c1);
        t1.start();
        Thread.sleep(2000);
        // 通知线程t1继续执行
        lock.lock();
        condition.signal();
        lock.unlock();
        System.out.println("go on.");
    }

    public static void main(String[] args) throws InterruptedException {
        Test9 t9 = new Test9();
        t9.go();
    }
}
