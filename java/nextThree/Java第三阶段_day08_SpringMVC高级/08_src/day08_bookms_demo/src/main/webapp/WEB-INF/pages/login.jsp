<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath() + "/";
    %>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        .login{
            width:500px;
            margin:10px auto;
        }
    </style>
</head>
<body>
    <form class="layui-form login" action="<%=basePath%>user/login" method="post">
        <span style="color:red">${msg}</span>
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-block">
                <input type="text" name="username" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="submit" class="layui-btn" lay-submit lay-filter="formDemo" value="登录"/>
            </div>
        </div>
    </form>
</body>
</html>
