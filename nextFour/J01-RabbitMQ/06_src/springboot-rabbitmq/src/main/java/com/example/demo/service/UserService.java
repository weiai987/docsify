package com.example.demo.service;

import com.example.demo.pojo.User;

/**
 * 用户业务类
 * @author :master
 * @date :20200609
 */
public interface UserService {
    /**
     * 查询用户详情
     * @param id 主键
     * @return 返回用户对象
     */
    User findUserById (String id);
}
