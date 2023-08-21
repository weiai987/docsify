package com.blb.service.impl;

import java.sql.SQLException;

import com.blb.dao.UserDao;
import com.blb.dao.impl.UserDaoImpl;
import com.blb.entity.User;
import com.blb.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private UserDao userdao = new UserDaoImpl();

	@Override
	public User getUserByName(String username) throws SQLException {
		return userdao.getUserByName(username);
	}

	@Override
	public void add(User user) throws SQLException {
		userdao.save(user);
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		return userdao.getUserByEmail(email);
	}

}
