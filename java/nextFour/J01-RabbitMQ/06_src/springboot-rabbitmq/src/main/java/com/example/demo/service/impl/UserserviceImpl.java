package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 * @author :master
 * @date :20200609
 */
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String id) {
        return userMapper.selectByPrimaryKey(Long.valueOf(id));
    }
}
