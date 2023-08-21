package org.hopu.djp.libDemo.jucTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test7 {

    /**
     * 一、创建执行线程的方式三：实现Callable接口。相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
     * 二、执行Callable方式，需要FutureTask实现类的支持，用于接受运算结果。FutureTask是Future接口的实现类
     */
    class ThreadDemo implements Callable<Integer> {
        private int sum = 0;

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "线程开始");
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + "线程结束");
            return sum;
        }
    }

    public void go() {
        ThreadDemo td = new ThreadDemo();
        List<FutureTask<Integer>> list1 = new ArrayList<FutureTask<Integer>>();
        List<Thread> list2 = new ArrayList<Thread>();

        for(int i=0; i<10; i++) {
            // 1.执行Callable方式，需要FutureTask实现类的支持，用于接受运算结果
            FutureTask<Integer> result = new FutureTask<>(td);
            Thread t1 = new Thread(result);
            t1.start();
            list1.add(result);
            list2.add(t1);
        }

        for(int i=0; i<list1.size(); i++) {
            // 2.接收线程运算后的结果
            try {
                Integer sum = list1.get(i).get(); // FutureTask可用于闭锁
                System.out.println(list2.get(i).getName() + ".result=" + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test7 t7 = new Test7();
        t7.go();
    }
}


