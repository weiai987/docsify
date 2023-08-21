package com.blb.bookms.interceptor;

import com.blb.bookms.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

//    private String[] whiteList = {".js",".css",".jpg",".png"};

    /**
     * 前置处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //查询session是否保存用户
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            //没有登录，重定向到login页面
            response.sendRedirect("/pages/login");
            //返回false，拦截
            return false;
        }
        //返回true，放行
        return true;
    }
}
