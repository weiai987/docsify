package com.bailiban.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")
public class Demo2Filter implements Filter {

	//ÿһ������������Դʱ����ִ�С�ִ�ж��
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ִ�з���ǰ�Ĵ���~~~");
		// ����
		chain.doFilter(request, response);

		System.out.println("ִ�з��к�Ĵ���~~~");

	}

	// �ڷ����������󣬻ᴴ��Filter����Ȼ�����init������ִֻ��һ�Ρ����ڼ�����Դ
	public void init(FilterConfig fConfig) throws ServletException {
       System.out.println("�ҳ�����~~~~~~~~~~~~~");
	}

	// �ڷ������رպ�Filter�������١�����������������رգ����ִ��destroy������ִֻ��һ�Ρ������ͷ���Դ
	public void destroy() {
		System.out.println("�ҹ���~~~~~~~~~~~~~");
	}

}
