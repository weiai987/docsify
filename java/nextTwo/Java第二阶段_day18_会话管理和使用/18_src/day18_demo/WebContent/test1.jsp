<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>域对象生命周期1</title>
</head>
<body>
     <%
         //分别向四大域对象中放数据
         pageContext.setAttribute("page", "pageContext数据");
         request.setAttribute("rq", "request数据");
         session.setAttribute("se", "session数据");
         application.setAttribute("app", "application");
     %>
     <!-- 从四大域对象中取数据 -->
     <%=pageContext.getAttribute("page") %><br/>
     <%=request.getAttribute("rq") %><br/>
     <%=session.getAttribute("se") %><br/>
     <%=application.getAttribute("app") %>
     <jsp:forward page="test2.jsp"></jsp:forward>
</body>
</html>