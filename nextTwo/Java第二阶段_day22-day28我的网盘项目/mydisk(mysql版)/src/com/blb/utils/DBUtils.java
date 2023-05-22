package com.blb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 连接池工具类
 * @author huahao
 *
 */
public class DBUtils {
	
	private static HikariDataSource hikariDataSource;

	static {
		HikariConfig conf = new HikariConfig();
		conf.setUsername(PropertiesUtils.getValue("jdbc.name"));
		conf.setPassword(PropertiesUtils.getValue("jdbc.password"));
		conf.setJdbcUrl(PropertiesUtils.getValue("jdbc.url"));
		conf.setDriverClassName(PropertiesUtils.getValue("jdbc.driver"));
		hikariDataSource = new HikariDataSource(conf);
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return hikariDataSource.getConnection();
	}
	
	/**
	 * 执行语句
	 * @param connection
	 * @param sql
	 * @param paramObject
	 * @throws SQLException 
	 */
	public static void execute(Connection connection, String sql, Object... paramObject) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		for (int i = 0; i < paramObject.length; i++) {
			prepareStatement.setObject(i+1, paramObject[i]);
		}
		prepareStatement.execute();
	}
	
	/**
	 * 执行查询语句
	 * @param connection
	 * @param sql
	 * @param paramObject
	 * @return 
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(Connection connection, String sql, Object... paramObject) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		for (int i = 0; i < paramObject.length; i++) {
			prepareStatement.setObject(i+1, paramObject[i]);
		}
		return prepareStatement.executeQuery();
	}
	
	/**
	 * 关闭连接池
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) throws SQLException {
		connection.close();
	}
}
