package com.bailiban.dao;

import com.bailiban.domain.User;

public interface UserDao {

	/**
	  �����û�����ѯ�û�
	 */
	User findUserByUserName(String username);

}