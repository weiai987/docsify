package com.blb.proxy_demo;

public class ComputerFactory implements ComputerSales {

    public void sell(String computer) {
        System.out.println("工厂卖了一台"+computer);
    }
}
