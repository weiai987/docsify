package com.blb.ioc_demo.demo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class IntelCpu implements Cpu {
    public void run() {
        System.out.println("英特尔CPU在运行。。。");
    }
}
