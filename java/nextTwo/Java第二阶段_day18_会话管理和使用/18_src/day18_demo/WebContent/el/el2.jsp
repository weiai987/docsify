<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>获取域中数据</title>
</head>
<body>
    <%
       //向域中放数据
       session.setAttribute("name", "如花");
       request.setAttribute("name", "旺财");
       session.setAttribute("age", 18);
    %>
    <!-- 使用EL 从指定域获取数据 -->
    ${requestScope.name} <br/>
    ${sessionScope.age} <br/>
    <!-- 自动通过键名取值  优先取小范围 -->
    ${name}
    
</body>
</html>