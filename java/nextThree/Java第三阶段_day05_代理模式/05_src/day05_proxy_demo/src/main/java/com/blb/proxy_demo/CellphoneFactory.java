package com.blb.proxy_demo;

/**
 * 手机工厂
 */
public class CellphoneFactory implements CellphoneSales {

    public void sell(String phone) {
        System.out.println("卖了一部" + phone);
    }
}
