package com.bailiban.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		   //解决输出乱码
	      response.setContentType("text/html;charset=utf-8");
	      //从 request域中 取出 错误信息
	      String msg = (String) request.getAttribute("msg");
		  //向浏览器输出错误信息
		  response.getWriter().write(msg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
