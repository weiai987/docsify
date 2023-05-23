package com.blb.proxy_demo;

public class TestCellphone {

    public static void main(String[] args) {
        //创建手机工厂
        CellphoneSales factory = new CellphoneFactory();
        factory.sell("华为P40手机");
        //创建商店
        CellphoneSales shop = new CellphoneShop(factory);
        //调用方法
        shop.sell("华为P40手机");
    }
}
