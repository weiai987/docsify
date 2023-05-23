package com.blb.proxy_demo;

public class TestComputer {

    public static void main(String[] args) {
        ComputerSales shop = new ComputerShop(new ComputerFactory());
        shop.sell("外星人电脑");
    }
}
