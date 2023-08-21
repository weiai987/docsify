package com.blb.ioc_demo.demo2;

import java.lang.reflect.InvocationTargetException;

public class TestFactory {

    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        try {
            Computer computer = factory.createComputer(Computer.class);
            computer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
