package com.bailiban.dao;

import com.bailiban.domain.User;

public interface UserDao {

	/**
	  根据用户名查询用户
	 */
	User findUserByUserName(String username);

}