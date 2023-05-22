<%@page import="com.bailiban.domain.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 使用taglib 指令导入JSTL标签库 -->
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书列表</title>
		<!--导入框架样式文件-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.12.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
	         <!-- 从session取出用户信息 显示欢迎信息 -->
	         <h1>欢迎您:${u.username}</h1>
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<a href="${pageContext.request.contextPath}/book-add.jsp" target="main" class="btn btn-primary pull-right" >添加书籍</a>
				</div>
						
			<table class="table table-bordered table-hover">
						<tr class="success">
							<th>编号</th>
							<th>书名</th>
							<th>图片</th>
							<th>价格</th>
							<th>作者</th>
							<th>出版日期</th>
							<th>操作</th>
						</tr>
						<!-- 使用foreach标签 遍历 -->
						<c:forEach items="${list}" var="book">
							<tr>
							<td>${book.id}</td>
							<td>${book.name}</td>
							<td ><img   src="${pageContext.request.contextPath}/img/${book.image}" width="50" /></td>
							<td>${book.price}</td>
							<td>${book.author}</td>
							<td>${book.publishDate}</td>
							<td>
								<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/book/updateUI?id=${book.id}">修改</a>&nbsp;
								<a class="btn btn-default btn-sm" onclick="return confirm('确定删除吗？')" href="${pageContext.request.contextPath}/book/delete?id=${book.id}">删除</a>&nbsp;
								<a class="btn btn-success btn-sm" onclick="return confirm('确定下载吗？')" href="${pageContext.request.contextPath}/book/picDownload?filename=${book.image}">图书封面下载</a>
							</td>
						</tr>
						</c:forEach>
					   			
			</table>
		</div>
	</div>
</body>
</html>