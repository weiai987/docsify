package com.bailiban.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.bailiban.domain.User;
import com.bailiban.service.UserService;
import com.bailiban.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		//使用request对象解决 post 提交中文乱码
		request.setCharacterEncoding("utf-8");
//		//使用request对象  接收表单提交的数据
//		//getParameter(String name)  name为表单空件的name属性值
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		//接收到的数据封装进用户对象
//		User loginUser  = new User(username, password);
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
			//如果登录成功 重定向到 SuccessServlet
			//request.getContextPath() 获取虚拟目录
			response.sendRedirect(request.getContextPath()+"/success");
			
		}else {
			//出现错误 向request域中放错误信息
			request.setAttribute("msg", "用户名为："+loginUser.getUsername()+" 密码为:"+loginUser.getPassword()+" 的用户登录失败");
			//转发到ErrorServlet 显示错误提示
			request.getRequestDispatcher("/error").forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//无论是get还是post请求 都执行doGet方法   避免写重复的代码
		doGet(request, response);
	}

}
