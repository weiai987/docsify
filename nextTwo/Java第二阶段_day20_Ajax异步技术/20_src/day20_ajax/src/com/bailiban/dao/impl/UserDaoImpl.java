package com.bailiban.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bailiban.dao.UserDao;
import com.bailiban.domain.User;
import com.bailiban.utils.JDBCUtils;

/**
 * 操作数据库中User表的类
 */
public class UserDaoImpl implements UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public User findUserByUserName(String username) {
		//定义Sql
		String sql ="select * from t_user where username = ? ";
		//执行查询
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
