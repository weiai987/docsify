package com.bailiban.service;

import com.bailiban.domain.User;

public interface UserService {

	/**
	 * ��¼����
	 * @param loginUser ֻ���û���������
	 * @return user�����û�ȫ������,û�в�ѯ��������null
	 */
	User login(User loginUser);
}
