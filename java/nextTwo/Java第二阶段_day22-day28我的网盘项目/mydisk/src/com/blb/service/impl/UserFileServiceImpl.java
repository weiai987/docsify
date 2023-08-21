package com.blb.service.impl;

import com.blb.dao.UserFileDao;
import com.blb.dao.impl.UserFileDaoImpl;
import com.blb.entity.UserFile;
import com.blb.service.IUserFileService;
import com.blb.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserFileServiceImpl implements IUserFileService {
	
	private UserFileDao userFileDao = new UserFileDaoImpl();

	@Override
	public void save(UserFile userFile) throws SQLException {
		userFileDao.save(userFile);
	}

	@Override
	public void saveList(List<UserFile> userFiles) throws SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			for (UserFile userFile : userFiles) {
				DBUtils.execute(connection, "insert into t_files(file_name, submit_file_name, user_id, is_dir, path_name) values(?,?,?,?,?)",
						userFile.getFileName(), userFile.getSubmitFileName(), userFile.getUserId(), userFile.getIsDir(), userFile.getPathName());
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBUtils.close(connection);
		}
	}

	@Override
	public List<UserFile> getFiles(int userId,String pathName) throws SQLException {
		return userFileDao.getFiles(userId, pathName);
	}

	@Override
	public UserFile getById(int id) throws SQLException {
		return userFileDao.getById(id);
	}


	@Override
	public void del(int id) throws SQLException {
		userFileDao.del(id);
	}

}
