package com.blb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 获取ID
	 * @return
	 */
	public static String getID() {
		int num = (int) (Math.random()*1000);
		return format.format(new Date()) + num; 
	}
	
}
