package com.bailiban.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest req = (HttpServletRequest) request;

        //获取资源请求路径
        String uri = req.getRequestURI();
        //2.判断是否包含登录相关资源路径,要注意排除掉 css/js/图片 等资源
        if(uri.contains("/login.jsp") || uri.contains("/login") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")|| uri.contains("/img/") ){
            //包含，用户就是想登录。放行
            chain.doFilter(request, response);
        }else{
            //不包含，需要验证用户是否登录
            //3.从获取session中获取user
            Object user = req.getSession().getAttribute("u");
            if(user != null){
                //登录了。放行
            	  chain.doFilter(request, response);
            }else{
                //如果没有登录 向request域中存放提示信息
                request.setAttribute("msg","亲！请先登录再操作!!!");
                //转发到login.jsp页面提示用户登录
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
      
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
