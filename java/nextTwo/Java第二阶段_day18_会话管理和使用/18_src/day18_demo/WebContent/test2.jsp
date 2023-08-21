<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>域对象生命周期2</title>
</head>
<body>
   <!-- 从四大域对象中取数据 -->
     <%=pageContext.getAttribute("page") %><br/>
     <%=request.getAttribute("rq") %><br/>
     <%=session.getAttribute("se") %><br/>
     <%=application.getAttribute("app") %>
</body>
</html>