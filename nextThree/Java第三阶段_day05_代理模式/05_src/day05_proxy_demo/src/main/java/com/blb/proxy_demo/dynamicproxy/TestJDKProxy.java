package com.blb.proxy_demo.dynamicproxy;

import com.blb.proxy_demo.CellphoneFactory;
import com.blb.proxy_demo.CellphoneSales;
import com.blb.proxy_demo.ComputerFactory;
import com.blb.proxy_demo.ComputerSales;

public class TestJDKProxy {

    public static void main(String[] args) {
        CellphoneSales factory1 = new CellphoneFactory();
        ComputerSales factory2 = new ComputerFactory();
        JDKFactoryProxy proxy = new JDKFactoryProxy();
        CellphoneSales cellphoneProxy = (CellphoneSales) proxy.createProxy(factory1);
        cellphoneProxy.sell("小米11");
        ComputerSales computerProxy = (ComputerSales) proxy.createProxy(factory2);
        computerProxy.sell("华为电脑");
    }
}
