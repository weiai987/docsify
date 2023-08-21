<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>转发动作</title>
</head>
<body>
   <!-- 使用转发动作  转发请求 target.jsp页面 -->
   <jsp:forward page="target.jsp">
       <jsp:param value="wangwai" name="username"/>
   </jsp:forward>
</body>
</html>