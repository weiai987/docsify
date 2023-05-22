
<%@page import="com.bailiban.domain.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书列表</title>
		<!--导入框架样式文件-->
		<link rel="stylesheet" href="/day02_book/css/bootstrap.min.css" />
		<script type="text/javascript" src="/day02_book/js/jquery1.12.4.min.js"></script>
		<script type="text/javascript" src="/day02_book/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<a href="/day02_book/book-add.jsp" target="main" class="btn btn-primary pull-right" >添加书籍</a>
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
					    <%
						  //从request域中取出 书籍的集合
						  List<Book>  list = (List<Book>)request.getAttribute("list");
					    
					      for(Book b  : list){
					     
						%>
						<tr>
							<td><%=b.getId() %></td>
							<td><%=b.getName() %></td>
							<td ><img   src="/day02_book/img/<%=b.getImage() %>" width="50" /></td>
							<td><%=b.getPrice() %></td>
							<td><%=b.getAuthor() %></td>
							<td><%=b.getPublishDate()%></td>
							<td>
								<a class="btn btn-default btn-sm" href="">修改</a>&nbsp;
								<a class="btn btn-default btn-sm" href="/day02_book/book/delete?id=<%=b.getId()%>">删除</a>
							</td>
						</tr>
						<%
					      }
						%>
					
			</table>
		</div>
	</div>
</body>
</html>