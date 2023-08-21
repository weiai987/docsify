package com.blb.proxy_demo;

/**
 * 手机商店
 */
public class CellphoneShop implements CellphoneSales{

    //手机工厂对象
    private CellphoneSales factory = null;

    //通过构造方法传入被代理者
    public CellphoneShop(CellphoneSales factory) {
        this.factory = factory;
    }

    public void sell(String phone) {
        //扩展功能
        System.out.println("打广告！！！新手机，黑科技！！");
        //调用原来的被代理者方法
        this.factory.sell(phone);
        //扩展功能
        System.out.println("做售后！！！");
    }
}
