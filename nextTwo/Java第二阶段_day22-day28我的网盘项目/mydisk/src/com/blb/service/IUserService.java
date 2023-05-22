package com.blb.service;

import java.sql.SQLException;

import com.blb.entity.User;

public interface IUserService {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	User getUserByName(String username) throws SQLException;
	
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException 
	 */
	void add(User user) throws SQLException;
	
	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	User getUserByEmail(String email) throws SQLException;
}
