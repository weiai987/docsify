package com.blb.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	
	private static Properties properties =  new Properties();
	
	static {
		try {
			getConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取properties文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Properties readProperties(String file) throws IOException {
		Properties properties = new Properties();
		properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(file));
		return properties;
	}
	
	/**
	 * 读取系统默认配置文件
	 * @return
	 * @throws IOException
	 */
	public static Properties getConfig() throws IOException {
		properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream("system.properties"));
		return properties;
	}
	
	/**
	 * 获取配置的值
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * 获取配置的值
	 * @param key
	 * @return
	 */
	public static Object getValue(Object key) {
		return properties.get(key);
	}

	/**
	 * 获取配置文件对象
	 * @return
	 */
	public static Properties getProperties() {
		return properties;
	}
	
}
