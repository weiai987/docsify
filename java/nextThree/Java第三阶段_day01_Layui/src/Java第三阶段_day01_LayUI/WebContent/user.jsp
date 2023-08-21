<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div><button type="button" class="layui-btn" id="add_btn">新增</button></div>
	
	<table id="demo" lay-filter="demo" ></table>
	 
<script>
layui.use('table',function(){
  var table = layui.table;
  var $ = layui.$;
  //第一个实例
  table.render({
    elem: '#demo'  //指定原始 table 容器的选择器或 DOM，方法渲染方式必填 
    ,toolbar:true // 是否显示工具条
    ,url: 'TableDataServlet' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头，里面的name必须保证返回的json数组的bean的属性名为name，titile为页面表头显示的字段名
      {field: 'id', title: 'ID', width:'20%',sort:true}
      ,{field: 'name', title: '姓名', width: '20%',sort:true}
      ,{field: 'password', title: '密码', width:'20%'}
      ,{fixed: 'right',title : '操作',align:'center', toolbar: '#opt'}
    ]]
  });
  
  table.on('tool(demo)', function(obj){
	 var data = obj.data; //获得当前行数据
	 var layEvent = obj.event; //获得 lay-event 对应的值 
	 var userName = data.name;// 表单中的name字段
	 var userId = data.id;// 表单中的id字段
	 var $ = layui.$ ;
	 
	 if(layEvent === 'del_event'){
		 
		 layer.confirm("你确定真的要删除"+userName+"的数据吗?",{icon: 2},function(index){
			 // 异步请求去后台删除数据
			$.post("UserDeleteServlet",{"user_id":userId},function(data){
				// 删除成功给出提示
				if(data.flag){
					// 操作成功的提示
					layer.msg("删除成功！",{icon:1});
					// 关闭最新的层
					layer.close(layer.index);
					// 刷新id为demo的table数据
					layui.table.reload("demo");
				}
			});
		 });
		 
	 }else if(layEvent === 'update_event'){// 修改操作
		 // 打开修改页面
		 layer.open({
			  type:2,
			  title:"用户修改",
			  area: ['700px', '600px'],
			  maxmin:true,
			  shadeClose :false,
			  // 修改页面需要先访问Servlet获取修改的用户信息
			  content:'UserUpdatePageServlet?user_id='+userId
		  });
	 }
	 
	 
  });
  
  
  $('#add_btn').on('click',function(){
	  layer.open({
		  type:2,
		  title:"用户新增",
		  area: ['700px', '600px'],
		  maxmin:true,
		  shadeClose :false,
		  content:'user_add.jsp'
	  });
	  
  });
  
});
</script>

<script id="opt" type="text/html" >
		<a lay-event="update_event" href="javascript:;" ><button type="button" class="layui-btn  layui-btn-radius layui-btn-xs layui-btn-normal">修改</button></a>
		<a lay-event="del_event" href="javascript:;" ><button type="button" class="layui-btn  layui-btn-radius layui-btn-xs layui-btn-normal">删除</button></a>
</script>

</body>
</html>