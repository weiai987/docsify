package com.bailiban.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * �̳� GenericServlet ��ʽ ����Servlet
 */
@WebServlet("/demo1")
public class Demo1Servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

         System.out.println("�̳� GenericServlet ��ʽ ����Servlet");
		
	}

}
