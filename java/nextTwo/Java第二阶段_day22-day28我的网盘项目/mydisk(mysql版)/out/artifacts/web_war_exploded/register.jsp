<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
	padding: 0;
	margin: 0;
	width: 100%;
	font-size: 14px;
}

input[type="text"]:focus, input[type="password"]:focus, input[type="email"]:focus{
	border: solid 1px blue;
}

.bg_img {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0px;
	background-image: url("/static/img/reg_bg_min.jpg");
	background-size: cover;
	display: flex;
}

form {
	color: #7d7d7d;
	text-align: center;
	width: 300px;
	height: 600px;
	background-color: white;
	padding: 20px;
	position: absolute;
	right: 200px; 
	top: 20%;
}

.blb_input {
	outline: none;
	height: 35px;
	width: 100%;
	border: solid 1px #bfbfbf;
	border-radius: 5px;
	text-indent: 3px;
}

.blb_form_item {
	margin-top: 40px;
}

input[type="button"] {
	background-color: #5082FF;
	border: 0px;
	color: white;
	border-radius: 25px;
	height: 50px;
}

a {
	color: #5082FF;
	text-decoration: none;
	bottom: -20px;
	position: relative;
}

h3 {
	font-size: 20px;
    margin: 0;
}

.logo {
	top: 20px;
	position: absolute;
	left: 20px;
}

input[type="checkbox"] {
	outline: none;
}

input:hover {
	cursor: pointer;
}

.blb_form_inline {
	display: flex;
}

.blb_msg{
    display: block;
    text-align: left;
    color: red;
    margin-bottom: 10px;
}

</style>
</head>
<body>
	<div class="bg_img">
		<img class="logo" alt="" src="/static/img/logo.png">
		<form>
			<div style="text-align: left;">
				<h3>我的网盘-注册</h3>
				<a style="display: block; top: 0px;" href="login.jsp">已有账号？登录</a>
			</div>
			<div class="blb_form_item">
				<input class="blb_input" type="text" placeholder="用户名" name="username">
			</div>
			<div class="blb_form_item">
				<input class="blb_input" type="password" placeholder="密码" name="password">
			</div>
			<div class="blb_form_item">
				<input class="blb_input" type="email" placeholder="邮箱" name="email" id="email">
			</div>
			<div class="blb_form_item blb_form_inline">
				<input class="blb_input" placeholder="验证码" name="checkCode" type="text">
				<input type="button" class="blb_input" id="getCheckCode" value="获取验证码"
					style="width: 105px; margin-left: 5px; height: 38px;">
			</div>
			<div class="blb_form_item">
				<span class="blb_msg"></span>
				<input type="button" id="register_bt" class="blb_input" value="注册">
			</div>
		</form>
	</div>
	<script type="text/javascript" src="/static/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#getCheckCode').click(function(){
				$('.blb_msg').text("");
				var email = $('#email').val();

				$.ajax({
					url: '/getCheckCode'
					,type: 'post'	
					,data: {
						email: email
					}
					,dataType: 'json'
					,success: function(e){
						if (e.rs) {
							$('input[name="checkCode"]').focus();
							$("#getCheckCode").prop('disabled', true);
							var num = 59;
							$('#getCheckCode').val("60秒后再试");
							var fun = setInterval(function(){
								if(num!=0){
									$('#getCheckCode').val(num+"秒后再试");
								}else {
									$('#getCheckCode').val('获取验证码');
									$("#getCheckCode").prop('disabled', false);
									clearInterval(fun);
								}
								num--;
							}, 1000);
						}else {
							$('.blb_msg').text(e.msg);
						}
					}
				})
			})

			$('#register_bt').click(function(){
				$('.blb_msg').text("");
				var data = $('form').serialize();
				
				$.ajax({
					url: '/register'
					,type: 'post'
					,data: data
					,dataType: 'json'
					,success: function(e){
						if (e.rs) {
							window.location.href="login.jsp";
						}else{
							$('.blb_msg').text(e.msg);
						}
					}
				})
			})
		})
	</script>
</body>
</html>