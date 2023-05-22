<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>隐式对象</title>
</head>
<body>
   <%
      //获取虚拟目录
      String path = request.getContextPath();
   
      //输出
      out.write(path);
   %>
</body>
</html>