package com.blb.ioc_demo;

public class TestComputer {

    public static void test1() {
        Computer computer = new Computer();
        Cpu cpu = new IntelCpu();
        Memory memory = new SumsungMemory();
        computer.setCpu(cpu);
        computer.setMemory(memory);
        computer.start();
    }

    public static void test2() {
        Computer computer = new Computer();
        Cpu cpu = new IntelCpu();
        Memory memory = new SumsungMemory();
        computer.setCpu(cpu);
        computer.setMemory(memory);
        computer.start();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
