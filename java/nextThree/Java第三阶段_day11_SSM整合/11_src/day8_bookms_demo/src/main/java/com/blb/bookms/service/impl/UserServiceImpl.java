package com.blb.bookms.service.impl;

import com.blb.bookms.dao.IUserDAO;
import com.blb.bookms.entity.User;
import com.blb.bookms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User login(String username, String password) {
        return userDAO.login(username,password);
    }
}
