package com.blb.ioc_demo.demo2;

import org.springframework.stereotype.Component;

public class KingstonMemory implements Memory {
    public void read() {
        System.out.println("金士顿内存读取数据");
    }

    public void write() {
        System.out.println("金士顿内存写入数据");
    }
}
