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
    <form action="/saveStudent" method="post">
        <input name="student" placeholder="请输入学生信息"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
