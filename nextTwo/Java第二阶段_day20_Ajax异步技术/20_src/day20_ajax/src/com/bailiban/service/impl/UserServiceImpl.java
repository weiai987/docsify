package com.bailiban.service.impl;

import com.bailiban.dao.UserDao;
import com.bailiban.dao.impl.UserDaoImpl;
import com.bailiban.domain.User;
import com.bailiban.service.UserService;

public class UserServiceImpl implements UserService {
	
	//����dao
	private UserDao userDao = new UserDaoImpl();
	/**
	  �����û�����ѯ�û�
	 */
	@Override
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}


}
