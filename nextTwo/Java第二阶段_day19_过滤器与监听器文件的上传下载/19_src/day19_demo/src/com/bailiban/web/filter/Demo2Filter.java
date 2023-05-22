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

	//每一次请求被拦截资源时，会执行。执行多次
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("执行放行前的代码~~~");
		// 放行
		chain.doFilter(request, response);

		System.out.println("执行放行后的代码~~~");

	}

	// 在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
	public void init(FilterConfig fConfig) throws ServletException {
       System.out.println("我出生了~~~~~~~~~~~~~");
	}

	// 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
	public void destroy() {
		System.out.println("我挂了~~~~~~~~~~~~~");
	}

}
