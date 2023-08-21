package com.blb.seven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("user_name");
		String userId = req.getParameter("user_id");
		for(int i=0;i<UserData.userList.size();i++){
			Integer id = UserData.userList.get(i).getId() ;
			if(id.equals(Integer.parseInt(userId))){
				UserData.userList.get(i).setName(userName);; 
				break;
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
