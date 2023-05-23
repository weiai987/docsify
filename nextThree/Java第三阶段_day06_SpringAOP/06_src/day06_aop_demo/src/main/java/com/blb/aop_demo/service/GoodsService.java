package com.blb.aop_demo.service;


import com.blb.aop_demo.util.AopTest;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @AopTest
    public void queryGoods(){
        System.out.println("查询商品");
    }

    @AopTest
    public void queryGoodsById(int id,String name){
        System.out.println("查询商品id"+id);
    }

    public int createGoods(){
        System.out.println("添加商品：");
        return 1;
    }

    public int updateGoods(){
        System.out.println("更新商品：");
        return 0;
    }

    public void deleteGoodsById(int id){
        System.out.println("删除商品ID：" + id);
    }
}
