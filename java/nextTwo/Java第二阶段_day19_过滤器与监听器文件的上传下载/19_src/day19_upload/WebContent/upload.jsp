<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
         <input type="text"  name="username" /><br/>
         <input type="file" name="pic" /> <br/>
         <input type="submit" value="上传" />
         
    </form>
</body>
</html>