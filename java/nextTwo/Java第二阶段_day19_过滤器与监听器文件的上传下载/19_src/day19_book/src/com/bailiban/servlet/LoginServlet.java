package com.bailiban.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.bailiban.domain.User;
import com.bailiban.service.UserService;
import com.bailiban.service.impl.UserServiceImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		//使用BeanUtils优化参数的封装
		//获取所有请求参数
		Map<String, String[]> map = request.getParameterMap();
		//将参数数据封装进实体类
		User loginUser = new User();
		try {
			BeanUtils.populate(loginUser, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//实例化UserService对象
		UserService userService = new UserServiceImpl();
		//调用登录方法  得到从数据库中查询的用户对象
		User user = userService.login(loginUser);
		//判断用户是否登录成功
		if(user!=null) {
			 //添加记住用户名功能
			 //获取复选框的值
			String remember = request.getParameter("remember");
			//如果勾选了
			if(remember!=null){
				
				//创建Cookie保存用户名
				Cookie cookie  = new Cookie("username",user.getUsername());
				//设置保存时间
				cookie.setMaxAge(60*60*24*30);//30天
				//发送cookie到浏览器
				response.addCookie(cookie);
				
			}else {
				//如果没有勾选
				//获取cookie 
				Cookie[] cookies = request.getCookies();
				if(cookies!=null) {
					
					for (Cookie c : cookies) {
						
						//找到name为username的cookie
						 if("username".equals(c.getName())) {
							 
							 //删除该cookie
							 c.setMaxAge(0);
							 //发送到浏览器
							 response.addCookie(c);
							 break;
						 }
						
					}
					
				}
				
			}
			
			//用户登录成功， 跟踪用户登录状态 将用户对象保存到session中
			 HttpSession session = request.getSession();
			 session.setAttribute("u", user);
			//重定向到 图书列表页面
			response.sendRedirect(request.getContextPath()+"/book/list");
			
		}else {
			//出现错误 向request域中放错误信息
			request.setAttribute("msg", "用户登录失败!!!");
			//转发到login.jsp 显示错误提示
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//无论是get还是post请求 都执行doGet方法   避免写重复的代码
		doGet(request, response);
	}

}
