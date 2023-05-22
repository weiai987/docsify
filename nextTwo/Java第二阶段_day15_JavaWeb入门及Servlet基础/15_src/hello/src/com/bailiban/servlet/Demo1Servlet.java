package com.bailiban.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * Servlet快速入门
 * 定义一个类实现Servlet接口
 */
public class Demo1Servlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	//提供服务的方法
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//向控制台输出一句话
		System.out.println("Hello Servlet");
		//得到输出对象
		PrintWriter out = res.getWriter();
		//向浏览器输出信息
		out.write("Hello Servlet");
	}
	
	

}
