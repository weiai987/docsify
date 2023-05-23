<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>

<form  class="layui-form" lay-filter="layui-form"> 
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-inline">
      <input type="text" name="user_name" value="${updateUser.name}" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <input type="hidden" name="user_id" value="${updateUser.id }">
   
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div> 
</form>
<script src="layui/layui.js"></script>
<script>
layui.use('form', function(){
  var form = layui.form;
  var layer = layui.layer;
  var $ = layui.$ ;
 
   // 监听表单提交事件
  form.on('submit(*)',function(data){
	  // post方式提交表单
	  $.post('UserUpdateServlet',data.field,function(data){
		  // 提交后刷新父页面的表格，demo为父表格的id
		  parent.layui.table.reload('demo');
		  // 通过父页面关闭当前页面
		  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		  parent.layer.close(index);
	  });
	  

  });
  
});
</script>


</body>
</html>