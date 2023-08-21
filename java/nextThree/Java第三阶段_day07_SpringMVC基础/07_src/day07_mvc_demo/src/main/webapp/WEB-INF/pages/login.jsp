<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/29
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <span style="color:red">${msg}</span>
    <form action="/user/login" method="post">
        <input name="user[0]" placeholder="请输入用户名"><br>
        <input name="user[1]" placeholder="请输入密码"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
