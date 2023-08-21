package com.blb.dao.impl;

import com.blb.dao.UserFileDao;
import com.blb.entity.UserFile;
import com.blb.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserFileDaoImpl implements UserFileDao {

	@Override
	public void save(UserFile userFile) throws SQLException {
		Connection connection = DBUtils.getConnection();
		DBUtils.execute(connection, "insert into t_files(file_name, submit_file_name, user_id, is_dir, path_name) values(?,?,?,?,?)", 
				userFile.getFileName(), userFile.getSubmitFileName(), userFile.getUserId(), userFile.getIsDir(), userFile.getPathName());
		DBUtils.close(connection);
	}

	@Override
	public List<UserFile> getFiles(int userId, String pathName) throws SQLException {
		Connection connection = DBUtils.getConnection();
		ResultSet resultSet = DBUtils.executeQuery(connection, "select * from t_files where path_name = ? and user_id = ? order by is_dir", pathName, userId);
		List<UserFile> list = UserFile.resultToListBean(resultSet);
		DBUtils.close(connection);
		return list;
	}

	@Override
	public UserFile getById(int id) throws SQLException {
		Connection connection = DBUtils.getConnection();
		ResultSet resultSet = DBUtils.executeQuery(connection, "select * from t_files where id = ?", id);
		UserFile userFile = UserFile.resultToBean(resultSet);
		DBUtils.close(connection);
		return userFile;
	}

	@Override
	public void del(int id) throws SQLException {
		Connection connection = DBUtils.getConnection();
		DBUtils.execute(connection, "delete from t_files where id = ?", id);
		DBUtils.close(connection);
	}

}
