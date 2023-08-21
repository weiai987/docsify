<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书添加</title>
		<!--导入框架样式文件-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.12.4.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	  <script>
        //在页面加载完成后
        $(function () {
           //给name绑定blur事件
           $("#name").blur(function () {
               //获取name文本输入框的值
               var name = $(this).val();
               //发送ajax请求
               $.get("checkBook",{"name":name},function (data) {

                   var span = $("#s_name");
                   if(data.isExsit){
                       //用图书名存在
                       span.css("color","red");
                       span.html(data.msg);
                   }else{
                       //图书名不存在
                       span.css("color","green");
                       span.html(data.msg);
                   }
               });

           }); 
        });

    </script>
	</head>
	<body>
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">图书添加</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/book/add">
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">图书名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name"   placeholder="请输入图书名称" required >
							    <span id="s_name"></span>
							</div>
						</div>
							<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">图书价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="price" placeholder="请输入图书价格" required >
							</div>
						</div>
							<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">图书作者</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="author" placeholder="请输入图书作者" required >
							</div>
						</div>
							<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">出版日期</label>
							<div class="col-sm-10">
								<input type="date"  class="form-control" name="publishDate" placeholder="请输入出版日期" required>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">图书图片</label>
							<div class="col-sm-10">
								<input type="file" class="form-control" name="image" placeholder="请输入图书图片" required>
							</div>
						</div>
					
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">添加</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>