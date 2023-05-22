package org.hopu.djp.libDemo.service.impl;

import org.hopu.djp.libDemo.dao.IUserDao;
import org.hopu.djp.libDemo.dao.impl.UserDaoImpl;
import org.hopu.djp.libDemo.entity.User;
import org.hopu.djp.libDemo.service.IUsreService;

import java.util.List;

public class UserServiceImpl implements IUsreService {
    private static final IUserDao userDao = new UserDaoImpl();

    @Override
    public int addUser(User user, int optId) {
        return userDao.addOne(user, optId);
    }

    @Override
    public User loginUser(User user) {
        List<User> list = userDao.findList(user);
        if(list != null && list.size() == 1) {
//            如果找到登录用户
            return list.get(0);
        }
        return null;
    }
}
