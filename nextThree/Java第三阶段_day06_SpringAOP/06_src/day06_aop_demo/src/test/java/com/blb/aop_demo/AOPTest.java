package com.blb.aop_demo;

import com.blb.aop_demo.entity.User;
import com.blb.aop_demo.service.GoodsService;
import com.blb.aop_demo.service.UserService;
import com.blb.aop_demo.util.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");

    @Test
    public void testUserServiceAOP(){
        UserService userService = context.getBean(UserService.class);
        userService.queryUser();
        userService.queryUserById(1);
        userService.createUser(new User(1,"test","123"));
        userService.updateUser(new User(1,"test","123"));
        userService.deleteUserById(1);
    }

    @Test
    public void testGoodsServiceAOP(){
        GoodsService goodsService = context.getBean(GoodsService.class);
        goodsService.queryGoods();
        goodsService.queryGoodsById(1,"xx");
        goodsService.createGoods();
        goodsService.updateGoods();
        goodsService.deleteGoodsById(1);
    }

    private AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AopConfig.class);

    @Test
    public void testServiceAOP(){
//        UserService userService = context2.getBean(UserService.class);
//        userService.queryUser();
//        userService.queryUserById(1);
//        //userService.createUser(new User(1,"test","123"));
//        userService.updateUser(new User(1,"test","123"));
//        userService.deleteUserById(1);
        GoodsService goodsService = context2.getBean(GoodsService.class);
        System.out.println(goodsService.getClass());
        goodsService.queryGoods();
        goodsService.queryGoodsById(1,"xx");
        goodsService.createGoods();
        goodsService.updateGoods();
        goodsService.deleteGoodsById(1);
    }

}
