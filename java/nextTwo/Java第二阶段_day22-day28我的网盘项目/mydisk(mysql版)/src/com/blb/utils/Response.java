package com.blb.utils;

import com.alibaba.fastjson.JSON;

public class Response {

	private String msg = "操作成功";
	private boolean rs = true;
	private Object data;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isRs() {
		return rs;
	}

	public void setRs(boolean rs) {
		this.rs = rs;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 失败响应
	 * @param msg
	 * @return
	 */
	public static String error(String msg) {
		Response response = new Response();
		response.msg = msg;
		response.rs = false;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 失败响应
	 * @param data
	 * @return
	 */
	public static String error(Object data) {
		Response response = new Response();
		response.msg = "操作失败";
		response.rs = false;
		response.data = data;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 失败响应
	 * @param msg
	 * @param data
	 * @return
	 */
	public static String error(String msg, Object data) {
		Response response = new Response();
		response.msg = msg;
		response.rs = false;
		response.data = data;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 成功响应
	 * @param data
	 * @return
	 */
	public static String success(Object data) {
		Response response = new Response();
		response.data = data;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 成功响应
	 * @param msg
	 * @return
	 */
	public static String success(String msg) {
		Response response = new Response();
		response.msg = msg;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 成功响应
	 * @param msg
	 * @param data
	 * @return
	 */
	public static String success(String msg, Object data) {
		Response response = new Response();
		response.msg = msg;
		response.data = data;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 成功响应
	 * @return
	 */
	public static String success() {
		Response response = new Response();
		return JSON.toJSONString(response);
	}
}
