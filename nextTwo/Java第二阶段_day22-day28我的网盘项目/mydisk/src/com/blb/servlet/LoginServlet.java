package com.blb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blb.entity.User;
import com.blb.service.IUserService;
import com.blb.service.impl.UserServiceImpl;
import com.blb.utils.Response;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
	
		try {
			User user = userService.getUserByName(username);
			if (user==null) {
				resp.getWriter().write(Response.error("用户名不存在"));
				return;
			}
			if (!user.getPassword().equals(password)) {
				resp.getWriter().write(Response.error("密码错误"));
				return;
			}
			if (remember!=null) {
				
			}
			req.getSession().setAttribute("user", user);
			resp.getWriter().write(Response.success());
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().write(Response.error("操作失败，请稍后再试"));
		}
	}
	
}
