package com.blb.dao;

import com.blb.entity.UserFile;

import java.sql.SQLException;
import java.util.List;

public interface UserFileDao {

	/**
	 * 保存上传的文件
	 * @param userFile
	 * @throws SQLException 
	 */
	void save(UserFile userFile) throws SQLException;
	
	/**
	 * 获取指定目录下的文件
	 * @param pathName
	 * @return
	 * @throws SQLException 
	 */
	List<UserFile> getFiles(int userId, String pathName) throws SQLException;

	/**
	 * 根据ID获取
	 * @param id
	 * @return
	 */
	UserFile getById(int id) throws SQLException;

	/**
	 * 根据id删除
	 * @param id
	 */
	void del(int id) throws SQLException;
}
