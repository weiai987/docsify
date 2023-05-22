<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<%
	//创建计数器 记录访问次数
	int count = 0;
    //标记是否有 名为 count的cookie存在
    boolean flag = false; //默认不存在
	//获取所有Cookie
	Cookie[] cookies = request.getCookies();
	//遍历Cookie数组
	if (cookies != null&&cookies.length > 0) {

		for (Cookie c : cookies) {
             //获取Cookie的名称
            String name = c.getName();
             //判定名称是否是 count
			if ("count".equals(name)) {
				//如果是count  获取count值   
				count = Integer.parseInt(c.getValue());
				//记录一次
				count++;
				//更新该cookie中保持的数据
				c.setValue(count+"");
				//设置生命周期
				c.setMaxAge(60*60);//保持一小时
				//保存到浏览器
				response.addCookie(c);
				//设置为存在
				flag=true;
			}

		}
	}
	
	//如果是第一次访问
	if(cookies == null||cookies.length ==0 || flag==false){
		//访问一次记录一次
		count++;
	    //创建cookie
		Cookie cookie = new Cookie("count", count + "");
		//将次数保存在cookie
		cookie.setMaxAge(60*60);//保持一小时
		response.addCookie(cookie);
	}
	
	%>
	<h1>当前访问次数:<%=count%></h1>
</body>
</html>