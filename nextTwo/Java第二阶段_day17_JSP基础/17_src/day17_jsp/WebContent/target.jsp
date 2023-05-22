<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>目标页面</title>
</head>
<body>
  我是目标页面!!! 
  <!--获取带过来的参数  -->
  <%=request.getParameter("username") %>
</body>
</html>