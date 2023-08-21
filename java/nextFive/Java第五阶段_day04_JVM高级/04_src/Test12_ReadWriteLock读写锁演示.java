package org.hopu.djp.libDemo.jucTest;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test12 {
    class ReadWriteLockDemo implements Runnable {
        private int number = 0;

        public ReadWriteLockDemo(int number) {
            this.number = number;
        }

        private ReadWriteLock lock = new ReentrantReadWriteLock();
        public void get() {
            lock.readLock().lock();//加锁
            try {
                System.out.println(Thread.currentThread().getName() + " : " + number);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();//解锁
            }
        }

        public void set(int number) {
            lock.writeLock().lock();//加锁
            try {
                System.out.println(Thread.currentThread().getName());
                this.number = number;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();//解锁
            }
        }

        @Override
        public void run() {
            this.get();
//            this.set((int)(Math.random() * 101));
        }
    }

    public void go() {
        ReadWriteLockDemo rw = new ReadWriteLockDemo(12);
        for (int i = 0; i < 100; i++) {
            new Thread(rw).start();
        }
    }


    public static void main(String[] args) {
        Test12 t12 = new Test12();
        t12.go();
    }
}


