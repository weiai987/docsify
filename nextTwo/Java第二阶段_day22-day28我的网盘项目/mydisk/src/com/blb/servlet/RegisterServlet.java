package com.blb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blb.entity.User;
import com.blb.service.IUserService;
import com.blb.service.impl.UserServiceImpl;
import com.blb.utils.Response;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String checkCode = req.getParameter("checkCode");
	
		try {
			User user = userService.getUserByName(username);
			if (user!=null) {
				resp.getWriter().write(Response.error("用户名已存在，不允许重复注册"));
				return;
			}
			user = userService.getUserByEmail(email);
			if (user!=null) {
				resp.getWriter().write(Response.error("邮箱已存在，不允许重复注册"));
				return;
			}
			String code = (String) req.getSession().getAttribute("checkCode");
			if (!code.equals(checkCode)) {
				resp.getWriter().write(Response.error("验证码不正确"));
				return;
			}
			int n = new Random().nextInt(50);
			userService.add(new User(username, password, email, n + ".jpg"));
			resp.getWriter().write(Response.success());
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().write(Response.error("操作失败，请稍后再试"));
		}
	}
	
}
