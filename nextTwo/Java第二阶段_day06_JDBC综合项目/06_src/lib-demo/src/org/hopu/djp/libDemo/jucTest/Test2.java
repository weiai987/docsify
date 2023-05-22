package org.hopu.djp.libDemo.jucTest;

public class Test2 extends Thread {
//    boolean flag = false;
    volatile boolean flag = false;
    int i = 0;

    public void run() {
        while (!flag) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        Test2 vt = new Test2();
        vt.start();
        Thread.sleep(1000);
        vt.flag = true;
        while(true) {
            System.out.println("stop:" + vt.i);
            Thread.sleep(1000);
        }
    }
}

