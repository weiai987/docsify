<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="java.util.List" errorPage="500.jsp"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page指令</title>
</head>
<body>
   	<%
   	   //page指令 使用import 导入相关包
   	   List  list = new ArrayList();
   	   int  i = 3/0;
   	%>
</body>
</html>