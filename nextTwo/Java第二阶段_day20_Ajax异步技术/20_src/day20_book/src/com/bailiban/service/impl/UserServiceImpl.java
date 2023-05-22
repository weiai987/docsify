package com.bailiban.service.impl;

import com.bailiban.dao.UserDao;
import com.bailiban.dao.impl.UserDaoImpl;
import com.bailiban.domain.User;
import com.bailiban.service.UserService;

public class UserServiceImpl implements UserService {
	
	//“¿¿µdao
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User loginUser) {
		return  userDao.login(loginUser);
	}

}
