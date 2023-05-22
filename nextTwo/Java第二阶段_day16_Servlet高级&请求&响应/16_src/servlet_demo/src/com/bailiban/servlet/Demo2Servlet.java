package com.bailiban.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承 HttpServlet方式创建servlet
 */
@WebServlet("/demo2")
public class Demo2Servlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	//如果请求方式为get执行该方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("get方式~~~~~");
	}
    //如果请求方式为post执行该方法
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post方式~~~~~");
	}

}
