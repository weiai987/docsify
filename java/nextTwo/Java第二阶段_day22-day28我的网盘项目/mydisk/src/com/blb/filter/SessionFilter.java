package com.blb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会话过滤器
 * @author huahao
 *
 */
@WebFilter(urlPatterns = "/*", initParams = {
	@WebInitParam(name = "whiteList", value = "/login.jsp;/register.jsp;/getCheckCode;/login;/logout;/register")
})
public class SessionFilter implements Filter {
	
	private FilterConfig config;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		//白名单放行
		String whiteListStr = config.getInitParameter("whiteList");
		String uri = request.getRequestURI();
		String[] whiteList = whiteListStr.split(";");
		for (String urlString : whiteList) {
			if (uri.equals(urlString)) {
				chain.doFilter(request, response);
				return;
			}
		}
		
		//静态资源、h2数据库控制台放行
		if (uri.startsWith("/static/") || uri.startsWith("/console/")) {
			chain.doFilter(request, response);
			return;
		}
		
		//已登录用户放行
		Object object = request.getSession().getAttribute("user");
		if (object!=null) {
			chain.doFilter(request, response);
			return;
		}
		
		//其它情况打回登录页面
		response.sendRedirect("login.jsp");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
