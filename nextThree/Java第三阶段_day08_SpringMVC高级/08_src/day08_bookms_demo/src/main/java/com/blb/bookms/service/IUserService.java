package com.blb.bookms.service;

import com.blb.bookms.entity.User;

public interface IUserService {

    User login(String username, String password);
}
