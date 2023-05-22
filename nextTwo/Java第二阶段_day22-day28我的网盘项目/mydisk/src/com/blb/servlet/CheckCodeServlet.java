package com.blb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blb.entity.User;
import com.blb.service.IUserService;
import com.blb.service.impl.UserServiceImpl;
import com.blb.utils.EmailUtils;
import com.blb.utils.Response;

@WebServlet("/getCheckCode")
public class CheckCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			if (email.isEmpty()) {
				resp.getWriter().write(Response.error("邮箱不能为空"));
				return;
			}
			User user = userService.getUserByEmail(email);
			if (user!=null) {
				resp.getWriter().write(Response.error("邮箱已存在，不允许重复注册"));
				return;
			}
			
			int code = (int) ((Math.random()*9+1)*100000);
			req.getSession().setAttribute("checkCode", code+"");
			EmailUtils.send("【我的网盘】验证码", code+"", email);
			resp.getWriter().write(Response.success());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
