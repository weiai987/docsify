package com.blb.seven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@WebServlet("/TableDataServlet")
public class TableDataServlet extends HttpServlet {
	

	
//	构造方法中创建100条用户数据
	public TableDataServlet() {
		for(int i=1;i<=100;i++){
			User u = new User("seven"+i,"123456",i);
			UserData.userList.add(u);
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
//		获取前端传递需要的页号跟每页显示数量
		String pageNum = req.getParameter("page");
		String limit = req.getParameter("limit");
		System.out.println(pageNum+"================="+limit);
		
//		获取当页数量的集合
		List<User> pageList = getPageList(Integer.parseInt(pageNum),Integer.parseInt(limit));
		
		resp.setContentType("text/json;charset=utf-8");
		
//		将数据封装成前端需要的格式
		JSONObject data = new JSONObject();
		data.put("code", 0);
		data.put("msg", "no data."); 
		data.put("count", UserData.userList.size());
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(pageList));
		data.put("data", array);
		
		resp.getWriter().write(data.toString());
	}
	
//	获取当页数量的集合
	public List<User> getPageList(int pageNo ,int pageLimit){
		List<User> list = new ArrayList<>();
		int maxSize = UserData.userList.size()> pageNo*pageLimit? pageNo*pageLimit:UserData.userList.size() ;
		for(int i=(pageNo-1)*pageLimit;i<maxSize;i++){
			list.add(UserData.userList.get(i));
		}
		return list ;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
