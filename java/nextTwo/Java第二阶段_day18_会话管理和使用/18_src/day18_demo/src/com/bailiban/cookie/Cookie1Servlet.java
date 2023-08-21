package com.bailiban.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie1Servlet
 */
@WebServlet("/cookie1")
public class Cookie1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//创建Cookie
		Cookie c1  = new Cookie("name", "wangcai");
		//设置Cookie的生命周期 30秒
		c1.setMaxAge(30);
		//再创建Cookie
		Cookie c2  = new Cookie("age", "18");
		//再创建Cookie
		Cookie c3 = new Cookie("sex", "中性");
		//发送Cookie 到客户端
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
