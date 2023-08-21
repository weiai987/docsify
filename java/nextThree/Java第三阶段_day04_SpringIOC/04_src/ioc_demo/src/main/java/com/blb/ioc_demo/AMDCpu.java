package com.blb.ioc_demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("amd")
@Component
public class AMDCpu implements Cpu {
    public void run() {
        System.out.println("AMD的CPU在运行。。。");
    }
}
