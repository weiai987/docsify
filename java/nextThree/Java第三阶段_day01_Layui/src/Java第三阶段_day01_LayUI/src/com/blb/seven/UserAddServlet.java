package com.blb.seven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserAddServlet")
public class UserAddServlet  extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String userName = req.getParameter("user_name");
		User u = new User(userName,"123456",100);
		UserData.userList.add(u);
		
	}

}
