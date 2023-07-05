package org.hopu.djp.libDemo.jucTest;

import java.util.Random;
import java.util.concurrent.*;

public class Test15 {
    class taskDemo implements Runnable {
        private int taskNum;
        public taskDemo(int taskNum) {
            System.out.println(Thread.currentThread().getName() + " : taskNum=" + taskNum + " init.");
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : taskNum=" + taskNum + " begin.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : taskNum=" + taskNum + " end.");
        }
    }

    // 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    public void go1() throws ExecutionException, InterruptedException {
        int poolSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        for (int i = 0; i < poolSize*3; i++) {
            taskDemo task = new taskDemo(i);
            pool.submit(task);
        }
        pool.shutdown();
    }

    // 可安排在给定的延迟后运行或定期执行的命令。
    public void go2() {
        int poolSize = 5;
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(poolSize);
        for (int i = 0; i < poolSize*3; i++) {
            taskDemo task = new taskDemo(i);
            // 任务将在延迟2秒后启动
            pool.schedule(task, 2, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }

    // 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    public void go3() {
        int poolSize = 8;
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int j=0; j<3; j++) {
            for (int i = 0; i < poolSize; i++) {
                taskDemo task = new taskDemo(i);
                //
                pool.submit(task);
            }
            try {
                System.out.println("主线程休眠");
                Thread.sleep(10 * 1000);
                System.out.println("主线程唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    // 单任务线程池可以确保任务按照提交的顺序被执行
    public void go4() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        int index = 1;
        for(int j=0; j<3; j++) {
            for (int i = 0; i < 2; i++) {
                taskDemo task = new taskDemo(index++);
                pool.submit(task);
            }
        }
        pool.shutdown();
    }

    public static void main(String[] args) throws Exception {
        Test15 t15 = new Test15();
        t15.go4();
    }
}
