package com.bailiban.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * Servlet��������
 * ����һ����ʵ��Servlet�ӿ�
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

	//�ṩ����ķ���
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//�����̨���һ�仰
		System.out.println("Hello Servlet");
		//�õ��������
		PrintWriter out = res.getWriter();
		//������������Ϣ
		out.write("Hello Servlet");
	}
	
	

}
