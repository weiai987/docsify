package org.hopu.djp.libDemo.jucTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test8 {
    class Ticket implements Runnable{
        private Integer tick = 100;
        private Lock lock = new ReentrantLock();

        @Override
        public void run() {
            while(true){
            lock.lock(); //上锁
                synchronized(tick) {
                    try {
                        boolean b = false;
                        if (tick > 0) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                            }
                            System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
                        } else {
                            break;
                        }
                    } finally {
                lock.unlock(); //释放锁
                    }
                }
            }
        }
    }

    public void go() {
        Ticket ticket = new Ticket();
        for(int i=0; i<10; i++) {
            new Thread(ticket, i+"号窗口").start();
        }
    }

    public static void main(String[] args) {
        Test8 t8 = new Test8();
        t8.go();
    }
}


