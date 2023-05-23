package com.blb.ioc_demo.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 电脑
 */
public class Computer {

    @MyValue("戴尔")
    private String brand;

    @MyComponent(IntelCpu.class)
    private Cpu cpu;

    @MyComponent(SumsungMemory.class)
    private Memory memory;

    public Computer(String brand, Cpu cpu, Memory memory) {
        this.brand = brand;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Computer() {
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void start(){
        System.out.println(brand+"电脑启动了！");
        cpu.run();
        memory.read();
        memory.write();
    }
}
