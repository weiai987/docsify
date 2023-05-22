package com.bailiban.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bailiban.dao.UserDao;
import com.bailiban.domain.User;
import com.bailiban.utils.JDBCUtils;

/**
 * �������ݿ���User�����
 */
public class UserDaoImpl implements UserDao {

    //����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public User findUserByUserName(String username) {
		//����Sql
		String sql ="select * from t_user where username = ? ";
		//ִ�в�ѯ
		User user;
		try {
			user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
			return user;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

    
}
