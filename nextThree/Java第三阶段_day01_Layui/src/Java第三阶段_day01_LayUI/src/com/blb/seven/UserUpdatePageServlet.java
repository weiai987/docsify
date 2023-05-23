package com.blb.seven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserUpdatePageServlet")
public class UserUpdatePageServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		for(int i=0;i<UserData.userList.size();i++){
			Integer id = UserData.userList.get(i).getId() ;
			if(id.equals(Integer.parseInt(userId))){
				req.setAttribute("updateUser", UserData.userList.get(i)); 
				break;
			}
		}
		
		req.getRequestDispatcher("user_update.jsp").forward(req, resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
}
