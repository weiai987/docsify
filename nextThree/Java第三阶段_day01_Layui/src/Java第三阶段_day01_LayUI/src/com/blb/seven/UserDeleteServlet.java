package com.blb.seven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userId = req.getParameter("user_id");
		
		for(int i=0;i<UserData.userList.size();i++){
			Integer id = UserData.userList.get(i).getId() ;
			if(id.equals(Integer.parseInt(userId))){
				UserData.userList.remove(i);
				break;
			}
		}
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().write("{\"flag\":true}"); 
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
}
