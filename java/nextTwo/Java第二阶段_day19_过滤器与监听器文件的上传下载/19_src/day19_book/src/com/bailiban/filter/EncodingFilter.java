package com.bailiban.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class EncodingFilter implements Filter {

 
	
	public void destroy() {
	
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	     
		//在放行之前设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//放行 
		chain.doFilter(request, response);
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
