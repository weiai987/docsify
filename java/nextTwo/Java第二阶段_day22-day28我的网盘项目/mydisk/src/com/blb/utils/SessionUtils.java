package com.blb.utils;

import com.blb.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 会话工具类
 * @author huahao
 *
 */
public class SessionUtils {

	/**
	 * 获取当前用户id
	 * @param request
	 * @return
	 */
	public static int getUserId(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user.getId();
	}
	
	/**
	 * 获取当前用户
	 * @param request
	 * @return
	 */
	public static User getUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	/**
	 * 获取用户上传目录
	 * @param req
	 * @return
	 */
	public static String getUploadPath(HttpServletRequest req) {
		return PropertiesUtils.getValue("system.uploadPath") + SessionUtils.getUser(req).getUsername() + "/";
	}
}
