package org.hopu.djp.libDemo.service;

import org.hopu.djp.libDemo.entity.User;

public interface IUsreService {
//    注册用户
    int addUser(User user, int optId);
    //    用户登录
    User loginUser(User user);
}
