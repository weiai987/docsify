<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/29
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <input id="username" placeholder="请输入用户名"><br>
    <input id="password" placeholder="请输入密码"><br>
    <button>测试</button>
    <script  type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script>
        //点击测试
        $("button").click(function () {
            var json = {username:$("#username").val(),password:$("#password").val()};
            $.ajax({
                type: "post",
                dataType: "json",//数据为JSON格式
                url: "/ajax",
                contentType: "application/json;charset=UTF-8",//指定消息请求类型
                data: JSON.stringify(json),//将json对象转成json对象
                success: function (data) {
                    console.log(data);
                }
            });
        });
    </script>
</body>
</html>
