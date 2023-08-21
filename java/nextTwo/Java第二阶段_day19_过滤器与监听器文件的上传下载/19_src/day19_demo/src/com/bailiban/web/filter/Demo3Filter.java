package com.bailiban.web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 配置过滤器拦截方式
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class Demo3Filter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Demo3Filter~~~");
		// 放行
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
		
	}

}
