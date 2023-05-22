<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- 使用taglib 指令导入JSTL标签库 -->
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员登录</title>
		<!--导入框架样式文件-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.12.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<h2>管理员登录</h2>
			<form method="post" action="${pageContext.request.contextPath}/login">
				<div class="form-group">
					<label class="control-label">用户名</label>
					<input type="text" class="form-control" value="${cookie.username.value}" placeholder="请输入用户名" name="username" required />
				</div>
				<div class="form-group">
					<label class="control-label">密码</label>
					<input type="password" class="form-control" placeholder="请输入密码" name="password" required />
				</div>
				  <div class="checkbox">
				    <label>
				      <input type="checkbox"  ${cookie.username.value!=null?"checked='checked'":''}  value="remember" name="remember"> 记住用户名
				    </label>
				  </div>
				<button type="submit" class="btn btn-success btn-block">登录</button>
				<button type="submit" class="btn btn-danger btn-block">取消</button>
			</form>
			<!-- 使用小脚本 从request域中 取出  错误信息-->
			<c:if test="${msg!=null}">
				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					${msg}
			    </div>
			</c:if>
		
		</div>
	</body>

</html>