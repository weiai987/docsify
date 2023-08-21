package com.blb.proxy_demo;

public class ComputerShop implements ComputerSales {

    private ComputerSales factory;

    public ComputerShop(ComputerSales factory) {
        this.factory = factory;
    }

    public void sell(String computer) {
        System.out.println("来买我们的电脑玩游戏吧！！");
        this.factory.sell(computer);
        System.out.println("你玩坏了找我！！");
    }
}
