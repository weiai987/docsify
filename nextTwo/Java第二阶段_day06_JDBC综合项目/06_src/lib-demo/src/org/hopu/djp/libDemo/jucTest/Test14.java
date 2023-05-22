package org.hopu.djp.libDemo.jucTest;

public class Test14 {
    class threadTask implements Runnable {

        private int i = 0;
        @Override
        public void run() {
            while (i <= 10) {
                System.out.println(Thread.currentThread().getName() + " : " + i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void go() {
        threadTask tt = new threadTask();
    }
}
