package com.blb.aop_demo.service;

import com.blb.aop_demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void queryUser(){
        System.out.println("查询用户");
    }

    public void queryUserById(int id){
        System.out.println("查询用户id"+id);
    }

    public void createUser(User user){
        System.out.println("添加用户：" + user);
        throw new RuntimeException("测试异常");
    }

    public void updateUser(User user){
        System.out.println("添加用户：" + user);
    }

    public void deleteUserById(int id){
        System.out.println("删除用户ID：" + id);
    }
}
