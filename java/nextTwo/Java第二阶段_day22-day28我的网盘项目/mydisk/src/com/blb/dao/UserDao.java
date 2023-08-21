package com.blb.dao;

import java.sql.SQLException;

import com.blb.entity.User;

public interface UserDao {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	User getUserByName(String username) throws SQLException;
	
	/**
	 * 保存
	 * @param user
	 * @throws SQLException 
	 */
	void save(User user) throws SQLException;
	
	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	User getUserByEmail(String email) throws SQLException;
}
