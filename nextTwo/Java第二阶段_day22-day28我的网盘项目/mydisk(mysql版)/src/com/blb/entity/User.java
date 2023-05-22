package com.blb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String headImg;
	
	public User() {}
	
	public User(String username, String password, String email, String headImg) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.headImg = headImg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", headImg=" + headImg + "]";
	}
	
	/**
	 * 将结果集封装成对象
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public static User resultToBean(ResultSet resultSet) throws SQLException {
		User user = null;
		while (resultSet.next()) {
			user = new User();
			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setHeadImg(resultSet.getString("head_img"));
			user.setEmail(resultSet.getString("email"));
		}
		return user;
	}
	
}
