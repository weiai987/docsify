package org.hopu.djp.libDemo.jucTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
        * CopyOnWriteArrayList/CopyOnWriteArraySet : “写入并复制”
        * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
        */
public class Test4 {

    class HelloThread implements Runnable{
        //	private List<String> list = Collections.synchronizedList(new ArrayList<String>());
        private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        //    private List<String> list = new ArrayList<String>();
        public HelloThread() {
            list.add("AA");
            list.add("BB");
            list.add("CC");
        }

        @Override
        public void run() {
            Iterator<String> it = list.iterator();

            while(it.hasNext()){
                System.out.println(Thread.currentThread().getName() +":" + it.next());
                list.add("AA");
            }
        }
    }

    public void go() {
        HelloThread ht = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(ht).start();
        }
    }

    public static void main(String[] args) {
        Test4 t4 = new Test4();
        t4.go();
    }
}


