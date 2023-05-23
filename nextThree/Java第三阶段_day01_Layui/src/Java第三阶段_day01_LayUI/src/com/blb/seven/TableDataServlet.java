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
	

	
//	���췽���д���100���û�����
	public TableDataServlet() {
		for(int i=1;i<=100;i++){
			User u = new User("seven"+i,"123456",i);
			UserData.userList.add(u);
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
//		��ȡǰ�˴�����Ҫ��ҳ�Ÿ�ÿҳ��ʾ����
		String pageNum = req.getParameter("page");
		String limit = req.getParameter("limit");
		System.out.println(pageNum+"================="+limit);
		
//		��ȡ��ҳ�����ļ���
		List<User> pageList = getPageList(Integer.parseInt(pageNum),Integer.parseInt(limit));
		
		resp.setContentType("text/json;charset=utf-8");
		
//		�����ݷ�װ��ǰ����Ҫ�ĸ�ʽ
		JSONObject data = new JSONObject();
		data.put("code", 0);
		data.put("msg", "no data."); 
		data.put("count", UserData.userList.size());
		JSONArray array= JSONArray.parseArray(JSON.toJSONString(pageList));
		data.put("data", array);
		
		resp.getWriter().write(data.toString());
	}
	
//	��ȡ��ҳ�����ļ���
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
