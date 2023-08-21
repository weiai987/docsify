<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jsp</title>
</head>
<body>
  <!-- 代码小脚本   -->
  <% 
     int a = 3; //局部变量
  %>
  <!-- 输出小脚本 -->
  <%=a%>
  <%="hello jsp" %>
  <!-- 声明 小脚本   -->
  <%!
     int b = 8;//成员变量
   %>
   <%=b %>
   -----------------------
   <% int i = 0; %>
   <%!int j = 0;%>
   <%
       i++;
       j++;
   %>
   <%="i的值:"+i %>
   <%="J的值:"+j %>
  <br/>
  Hi JSP!!!
</body>
</html>