package com.bailiban.web.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * 
 * @author my
 * 定义一个ServletContextListener 监听器 
 * 监听ServletContext的创建和销毁
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    
	 /*
     * 监听 ServletContext对象的创建
     * ServletContext对象是在服务器启动后自动创建
     * 该方法在服务器启动后自动调用
     * 
     */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		 System.out.println("ServletContext对象被创建了。。。");
		 //加载类路径 classpath下的配置文件
		 //得到servletContext对象
		 ServletContext servletContext = sce.getServletContext();
		 //获取配置参数
		 String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
		 //获取真实路径
		 String realPath = servletContext.getRealPath(contextConfigLocation);
		 System.out.println(realPath);
		 //将文件加载进内存
		 try {
			FileInputStream fis = new FileInputStream(realPath);
			System.out.println(fis) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    /*
     * 在服务器关闭后，ServletContext对象被销毁。
     * 当服务器正常关闭后该方法被调用
     * 
     */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("ServletContext对象被销毁了。。。");
		
	}
 
	
}
