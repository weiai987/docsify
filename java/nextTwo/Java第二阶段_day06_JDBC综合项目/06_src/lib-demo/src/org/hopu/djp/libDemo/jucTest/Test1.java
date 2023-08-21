package org.hopu.djp.libDemo.jucTest;

public class Test1 {
    class ThreadDemo implements Runnable {
        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("thread_"+ Thread.currentThread().getId() +" go run().");
//            Long tid = Thread.currentThread().getId();
            while (true) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("子线程.flag=" + flag);
            }
        }
    }

    public void test1() {
        //ThreadDemo线程先开始的
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        td.setFlag(true);
        System.out.println("主进程.flag=" + td.isFlag());
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.test1();
    }
}
