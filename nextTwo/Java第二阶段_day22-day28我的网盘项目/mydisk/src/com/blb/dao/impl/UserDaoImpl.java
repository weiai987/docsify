package com.blb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blb.dao.UserDao;
import com.blb.entity.User;
import com.blb.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByName(String username) throws SQLException {
		Connection connection = DBUtils.getConnection();
		ResultSet resultSet = DBUtils.executeQuery(connection, "select * from t_user where username = ?", username);
		User user = User.resultToBean(resultSet);
		DBUtils.close(connection);
		return user;
	}

	@Override
	public void save(User user) throws SQLException {
		Connection connection = DBUtils.getConnection();
		DBUtils.execute(connection, "insert into t_user(username, password, email, head_img) values(?,?,?,?)", user.getUsername(), user.getPassword(), user.getEmail(), user.getHeadImg());
		DBUtils.close(connection);
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		Connection connection = DBUtils.getConnection();
		ResultSet resultSet = DBUtils.executeQuery(connection, "select * from t_user where email = ?", email);
		User user = User.resultToBean(resultSet);
		DBUtils.close(connection);
		return user;
	}

}
