<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.bailiban.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取对象属性值</title>
</head>
<body>
  <%
     //创建用户对象
     User  user = new User();
  	 user.setName("旺财");
  	 user.setAge(18);
  	 user.setBirthday(new Date());
  	 //将对象放入 request域对象
  	 request.setAttribute("u", user);
  	 
  	  List<Object> list = new ArrayList<>();
      list.add("aaa");
      list.add("bbb");
      list.add(user);
      request.setAttribute("list",list);
      
      Map map = new HashMap();
      map.put("sname","如花");
      map.put("sex","妖");
      map.put("user",user);

      request.setAttribute("map",map);
  %>
  <%--
     使用el 表达式 获取  域中对象
   --%>
   ${u} <br/>
   <%--获取对象属性值  --%>
   ${u.name}<br/>
   ${u.age}<br/>
   ${u.birthday}<br/>
   ${u.birthday.time}<br/>
   
    <h3>el获取List值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list[10]}<br>
    ${list[2].name}<br>
    ${empty list}
    <h3>el获取Map值</h3>
    ${map.sname}<br>
    ${map["sex"]}<br>
    ${map.user.name}

</body>
</html>