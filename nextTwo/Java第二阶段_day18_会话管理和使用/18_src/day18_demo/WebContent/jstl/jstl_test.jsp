<%@page import="com.bailiban.domain.User"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>test</title>
</head>
<body>

<%

    List list = new ArrayList();   
    list.add(new User("如花",18,new Date()));
    list.add(new User("小强",28,new Date()));
    list.add(new User("旺财",18,new Date()));
    request.setAttribute("list",list);

%>
<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="green">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 == 0}">
            <tr  bgcolor="yellow">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
            </tr>
        </c:if>


    </c:forEach>

</table>

</body>
</html>
