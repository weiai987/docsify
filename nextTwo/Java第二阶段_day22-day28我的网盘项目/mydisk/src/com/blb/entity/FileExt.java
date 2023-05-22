package com.blb.entity;

public class FileExt {

	private String fileName;	//文件名
	private boolean isDir;		//是否是目录
	private String icon;			//图标
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isDir() {
		return isDir;
	}
	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "FileExt [fileName=" + fileName + ", isDir=" + isDir + ", icon=" + icon + "]";
	}
	
	
}
