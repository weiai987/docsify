package com.bailiban.dao;

import com.bailiban.domain.User;

public interface UserDao {

	/**
	 * ��¼����
	 * @param loginUser ֻ���û���������
	 * @return user�����û�ȫ������,û�в�ѯ��������null
	 */
	User login(User loginUser);

}