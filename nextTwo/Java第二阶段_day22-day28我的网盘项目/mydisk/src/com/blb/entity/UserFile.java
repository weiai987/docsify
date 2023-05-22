package com.blb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFile {

	private int id;
	private int userId;					//用户id
	private String fileName;			//用户名
	private String submitFileName;		//上传的文件名
	private int isDir;					//0目录，1文件
	private String pathName;				//当前目录
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSubmitFileName() {
		return submitFileName;
	}
	public void setSubmitFileName(String submitFileName) {
		this.submitFileName = submitFileName;
	}
	public int getIsDir() {
		return isDir;
	}
	public void setIsDir(int isDir) {
		this.isDir = isDir;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	@Override
	public String toString() {
		return "UserFile [id=" + id + ", userId=" + userId + ", fileName=" + fileName + ", submitFileName="
				+ submitFileName + ", isDir=" + isDir + ", pathName=" + pathName + "]";
	}
	/**
	 * 将结果集封装成对象
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public static UserFile resultToBean(ResultSet resultSet) throws SQLException {
		UserFile userFile = null;
		while (resultSet.next()) {
			userFile = new UserFile();
			userFile.setId(resultSet.getInt("id"));
			userFile.setUserId(resultSet.getInt("user_id"));
			userFile.setFileName(resultSet.getString("file_name"));
			userFile.setSubmitFileName(resultSet.getString("submit_file_name"));
			userFile.setIsDir(resultSet.getInt("is_dir"));
			userFile.setPathName(resultSet.getString("path_name"));
		}
		return userFile;
	}
	
	/**
	 * 将结果集成到集合中
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public static List<UserFile> resultToListBean(ResultSet resultSet) throws SQLException {
		List<UserFile> list = new ArrayList<>();
		while (resultSet.next()) {
			UserFile userFile = new UserFile();
			userFile.setId(resultSet.getInt("id"));
			userFile.setUserId(resultSet.getInt("user_id"));
			userFile.setFileName(resultSet.getString("file_name"));
			userFile.setSubmitFileName(resultSet.getString("submit_file_name"));
			userFile.setIsDir(resultSet.getInt("is_dir"));
			userFile.setPathName(resultSet.getString("path_name"));
			list.add(userFile);
		}
		return list;
	}
}
