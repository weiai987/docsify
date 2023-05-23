package com.blb.ioc_demo;

public class SumsungMemory implements Memory {
    public void read() {
        System.out.println("三星内存读取数据");
    }

    public void write() {
        System.out.println("三星内存写入数据");
    }
}
