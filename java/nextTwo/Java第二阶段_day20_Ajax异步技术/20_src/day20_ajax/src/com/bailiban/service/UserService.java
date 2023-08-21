package com.bailiban.service;

import com.bailiban.domain.User;

public interface UserService {

	/**
	  根据用户名查询用户
	 */
	User findUserByUserName(String username);

}
