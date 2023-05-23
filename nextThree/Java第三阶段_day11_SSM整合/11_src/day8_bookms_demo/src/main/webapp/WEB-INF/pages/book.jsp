<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/21
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body>
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-md3">
                <div id="tree"></div>
            </div>
            <div class="layui-col-md9">
                <button type="button" class="layui-btn">
                    <a href="javascript:window.parent.load('/bookType/toBookSave',false)">
                        <i class="layui-icon">&#xe608;</i> 添加
                    </a>
                </button>
                <table class="layui-table" lay-size="sm">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>书名</th>
                        <th>价格</th>
                        <th>类型</th>
                        <th>作者</th>
                        <th>出版社</th>
                        <th>出版日期</th>
                        <th>状态</th>
                        <th>图片</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.bookName}</td>
                            <td>${book.price}</td>
                            <td>${book.typeId}</td>
                            <td>${book.author}</td>
                            <td>${book.publishOrg}</td>
                            <td>${book.publishTime}</td>
                            <td>${book.state}</td>
                            <td>
                                <img src="/images/${book.bookImage}">
                            </td>
                            <td>
                                <div class="layui-btn-group">
                                    <button type="button" class="layui-btn layui-btn-primary layui-btn-sm">
                                        <%--跳转到查询书籍的控制器方法--%>
                                        <a href="javascript:window.parent.load('/book/findBook?id=${book.id}')">
                                            <i class="layui-icon">&#xe642;</i>
                                        </a>
                                    </button>
                                    <button type="button" class="layui-btn layui-btn-primary layui-btn-sm">
                                        <i class="layui-icon">&#xe640;</i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div id="page"></div>
            </div>
        </div>
    </div>

<%--    <script>--%>
<%--        layui.use('laypage', function(){--%>
<%--            var laypage = layui.laypage;--%>
<%--            //执行一个laypage实例--%>
<%--            laypage.render({--%>
<%--                elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号--%>
<%--                count: ${page.count},   //数据总数，从服务端得到--%>
<%--                limit: ${page.limit},--%>
<%--                curr:${page.current},--%>
<%--                jump: function(obj, first){--%>
<%--                    //obj包含了当前分页的所有参数，比如：--%>
<%--                    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。--%>
<%--                    console.log(obj.limit); //得到每页显示的条数--%>
<%--                    //首次不执行--%>
<%--                    if(!first){--%>
<%--                        var typeId = localStorage.getItem("typeId");--%>
<%--                        if(typeId == null || typeId == undefined){--%>
<%--                            typeId = 0;--%>
<%--                        }--%>
<%--                        var url = "/book/findPage?curr="+obj.curr+"&typeId="+typeId;--%>
<%--                        window.parent.load(url,true);--%>
<%--                        // $("#content").load("/book.do?m=findPage&current="+obj.curr+"&typeId="+typeId);--%>
<%--                    }--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>

<%--        //ajax请求后台获得书籍类型--%>
<%--        $.get("http://localhost:8080/bookType/findBookTypes",--%>
<%--            function(res){--%>
<%--                console.log("res:"+res);--%>
<%--                layui.use('tree', function(){--%>
<%--                    var tree = layui.tree;--%>
<%--                    //渲染--%>
<%--                    var inst1 = tree.render({--%>
<%--                        elem: '#tree'  //绑定元素--%>
<%--                        ,data: [{--%>
<%--                            title: '所有书籍', //一级菜单--%>
<%--                            id:0,--%>
<%--                            spread:true,--%>
<%--                            children: res //将json转换为数组--%>
<%--                        }],--%>
<%--                        click: function(obj){--%>
<%--                            //保存类型iD--%>
<%--                            localStorage.setItem("typeId",obj.data.id);--%>
<%--                            var url = "/book/findPage?curr=1&typeId="+obj.data.id;--%>
<%--                            //按类型分页--%>
<%--                            window.parent.load(url,true);--%>
<%--                            //$("#content").load("/book.do?m=findPage&typeId="+obj.data.id);--%>
<%--                        }--%>
<%--                    });--%>
<%--                });--%>
<%--            }--%>
<%--        );--%>
<%--    </script>--%>
</body>
</html>
