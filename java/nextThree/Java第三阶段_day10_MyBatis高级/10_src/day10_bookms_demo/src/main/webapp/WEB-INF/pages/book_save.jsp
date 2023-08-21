<%--
  Created by IntelliJ IDEA.
  User: xray
  Date: 2020/6/29
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        form{
            width: 600px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
<form class="layui-form" action="/book/saveBook" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${book.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">书名</label>
        <div class="layui-input-block">
            <input type="text" name="bookName" value="${book.bookName}"  placeholder="请输入书名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input type="text" name="price" value="${book.price}" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block">
            <select name="typeId" lay-verify="required">
                <option value=""></option>
                <c:forEach var="type" items="${bookTypes}">
                    <option value="${type.id}" ${type.id eq book.typeId?'selected':''} >${type.title}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="author" value="${book.author}"  required  lay-verify="required" placeholder="请输入作者" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出版时间</label>
        <div class="layui-input-block">
            <input type="text" name="publishTime" value="${book.publishTime}"  id="publishTime"  placeholder="请输入出版时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出版社</label>
        <div class="layui-input-block">
            <input type="text" name="publishOrg"   value="${book.publishOrg}"  placeholder="请输入出版社" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="checkbox" name="state" value="1" ${book.state eq 1?'checked':''} lay-skin="switch" lay-text="已借|未借">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">书籍图片</label>
        <div class="layui-input-block">
            <input type="file" name="pic" >
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit" class="layui-btn" >提交</input>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script>
    layui.use('laydate',function(){
        var laydate = layui.laydate;
        laydate.render({elem:'#publishTime'});
    });
    layui.use('form', function(){
        var form = layui.form;
        console.log("ok");
        //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return true;
        // });
        form.render();
    });
</script>
</body>
</html>
