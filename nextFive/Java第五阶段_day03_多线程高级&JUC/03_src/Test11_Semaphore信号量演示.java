package org.hopu.djp.libDemo.jucTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test11 {
    static Semaphore semaphore = new Semaphore(2);

    public class semaphoreDemo implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                semaphore.acquire();
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",获取许可!");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(System.currentTimeMillis() + "," + thread.getName() + ",释放许可!");
            }
        }
    }

    public void go() {
        for (int i = 0; i < 10; i++) {
            new Thread(new semaphoreDemo()).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test11 t11 = new Test11();
        t11.go();
    }
}
