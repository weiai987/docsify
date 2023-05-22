<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>运算符</title>
</head>
<body>
   <h1>算术运算符</h1>
   ${8+3 }<br/>
   ${8-3 }<br/>
   ${8/3 }<br/>
   ${8*3 }<br/>
   ${8%3 }
   <h1>比较运算符</h1>
   ${3>8}
   <h1>逻辑运算符</h1>
   ${3>1&&3>8}
   <h1>三元运算符</h1>
   ${3<8?true:false}
</body>
</html>