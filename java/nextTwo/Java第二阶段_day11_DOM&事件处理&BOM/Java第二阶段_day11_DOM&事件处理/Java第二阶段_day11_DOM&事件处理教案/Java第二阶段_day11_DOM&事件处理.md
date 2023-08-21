### Java第二阶段_day11_DOM&事件处理

#### 简介

```js
DOM (Document Object Model) 文档对象模型
定义了访问和操作HTML文档的标准
```

#### 获取/查询

| document.getElementById()             | 通过id属性获取元素。注：IE8以下不区分id大小写                |
| :------------------------------------ | ------------------------------------------------------------ |
| **document.getElementsByClassName()** | **通过class属性获取元素。注：IE8及IE8以下不兼容**            |
| **document.getElementsByTagName()**   | **通过元素获取元素。注：无兼容性问题**                       |
| **document.getElementsByName()**      | **通过name属性获取元素。注：部分标签才有用**                 |
| **document.querySelector()**          | **通过css选择器选择第一个元素。注：IE7及IE7以下不兼容，工作中基本不用，实时性问题** |
| **document.querySelectorAll()**       | **通过css选择器选择一组元素。注：IE7及IE7以下不兼容，工作中基本不用，实时性问题** |

#### 节点

##### 节点的属性

###### 1.nodeName

​	介绍：节点的名称，如果为元素节点，则输出具体的元素名

​	注意：只能读，不能修改

###### 2.nodeValue

​	介绍：节点的内容，只能获取文本节点和注释节点的内容

​	注意：文本节点和注释节点，可读，可修改

###### 3.nodeType

​	介绍：节点的类型

​	注意：只能读，不可修改

​	节点类型速查表

| 节点类型         | 返回值 |
| ---------------- | ------ |
| 元素节点         | 1      |
| 属性节点         | 2      |
| 文本节点         | 3      |
| 注释节点         | 8      |
| document         | 9      |
| DocumentFragment | 11     |

###### 4.attibutes

​	介绍：查看元素节点的属性集合

###### 5.parentNode

​	介绍：查看父节点

​	注意：document属于节点，可以查看到document

###### 6.childNodes

​	介绍：查看子节点们

###### 7.firstChild

​	介绍：查看第一个子节点

###### 8.lastChild

​	介绍：查看最后一个子节点

###### 9.nextSibling

​	介绍：查看下一个兄弟节点

###### 10.previousSibling

​	介绍：查看上一个兄弟节点

##### 节点的方法

###### 1.hasChildNodes()

​	介绍：判断是否含有子节点

##### 元素节点的特有属性

###### 1.parentElement        

​	介绍：获取父元素节点

###### 2.children

​	介绍：获取所有的子元素节点

​	注意：IE9及IE9以下不兼容

###### 3.firstElementChild 

​	介绍：获取第一个元素节点

​	注意：IE不兼容

###### 4.lastElementChild     

​	介绍：获取最后一个元素节点

​	注意：IE不兼容

###### 5.nextElementSibling    

​	介绍：获取下一个元素节点

###### 6.previousElementSibling  

​	介绍：获取上一个元素节点

###### 7.childElementCount  

​	介绍：获取子节点个数

###### 8.innerHTML*

​	介绍：获取或者设置元素节点里面的代码片段

###### 9.innerText*

​	介绍：获取或者设置元素节点里面的内容

​	注意：老版本火狐不兼容

###### 10.textContent

​	介绍：获取或者设置元素节点里面的内容

​	注意：老版本IE不兼容

##### 元素节点的特有方法

###### 1.setAttribute("name","value")

​	介绍：设置元素节点的属性

###### 2.getAttribute("name")

​	介绍：获取元素节点的属性

#### 节点的创建

##### 1.document.createElement()

​	介绍：创建元素节点

##### 2.document.createTextNode()

​	介绍：创建文本节点

##### 3.document.createComment()

​	介绍：创建注释节点

##### 4.document.createDocumentFragment()

​	介绍：创建文档节点碎片

#### 节点的插入

##### 1.parent.appendChild(node)    

​	介绍：将node插入至parent中

​	注意：如果node已经存在于html文档中，即为剪贴操作

##### 2.parent.insertBefore(a, b)

​	介绍：插入a在b之前

#### 节点的删除

##### 1.parent.removeChild(node)

​	介绍：父级删除，返回已经删掉的元素

##### 2.child.remove()

​	介绍：删除元素自身

#### 节点的替换

##### 1.parent.replaceChild(new, origin)

​	介绍：拿new去替换origin



**代码演示**

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			#ball{
				position: absolute;
			}
		</style>
	</head>
	
	<body>
		
		<img src="img/ball.png" id="ball" width="120" height="120"/>
		
		<script>
			var ball = document.getElementById("ball");
			// 获取足球的最大X位置
			var maxX = window.innerWidth - ball.offsetWidth ;
			// 获取足球的最大Y位置
			var maxY = window.innerHeight - ball.offsetHeight ;
			// 设置定时器
			setInterval(move, 10);
			
			function move(){
				// 每次移动分为X轴移动跟Y轴的移动.
				moveX();
				moveY();
			}
			
			// X轴上的每次偏移量
			var xv = 5;
			// 当前X轴的边距
			var xs = 0;
			function moveX(){
				// 每次移动先计算新的左边界
				xs = xs + xv;
				// 当右边超出边界则将偏移量取反,效果则为反弹
				if(xs >= maxX){
					xs = maxX;
					xv = -xv;
				}else if(xs < 0){// 当左边超出边界则将偏移量取反
					xs = 0;
					xv = -xv;
				}
				// 将新的位置更新到图片的样式上
				ball.style.left = xs + "px";
			}
			
			// Y轴上的每次偏移量
			var yv = 10;
			// 当前Y轴的边距
			var ys = 0;		
			function moveY(){
				// 每次移动先计算新的上边界
				ys = ys + yv;
				// 当下边超出边界则将偏移量取反,效果则为反弹
				if(ys >= maxY){
					ys = maxY;
					yv = -yv;
				}else if(ys < 0){// 当上边超出边界则将偏移量取反
					ys = 0;
					yv = -yv;
				}
				// 将新的位置更新到图片的样式上
				ball.style.top = ys + "px";
			}			
		</script>		
	</body>
</html>

```





### 事件处理

#### 简介

​	事件就是文档或浏览器窗口中发生的一些特定的交互瞬间

#### 事件绑定

##### 1.DOM元素绑定

​	语法：

```js
<tag on+事件类型="处理函数()">点我</tag>
```

​	示例：

```js
<div onclick="clickone()">点我</div>
```

##### 2.DOM对象绑定 

​	语法：

```
document.getElementById("btn").on+事件类型 = 函数引用
```

​	示例：

```
document.getElementById("btn").onclick = function（）{ alert("hello"); }
```

##### 3.DOM对象监听函数-addEventListener

​	语法：

```
document.getElementById("btn").addEventListener("事件类型",函数引用[,boolean])
参数说明：第三个参数为可选参数，默认值为false，表示冒泡。设置成true则为捕获。
```

​	示例：

```js
document.getElementById("btn").addEventListener("click",function（）{ alert("hello"); },false);
```

​	注意：IE8及IE8以下不兼容

##### 4.DOM对象监听函数-attchEvent 

​	语法：

```
document.getElementById("btn").attchEvent("on+事件类型",函数引用)
```

​	注意：该方法主要是为了解决addEventListener的老版本IE不兼容问题。不会单独拿出来使用

#### 事件解绑

##### 1.removeEventListener

​	语法示例：

```
demo.addEventListener("click",fun,false);
demo.removeEventListener("click",fun,false);
function fun（）{ alert("hello"); }
```

​	注意：以上方式适用于函数引用，如果函数为匿名函数，则需要用arguments.callee处理，并且要写在addEventListener内部

```
demo.addEventListener("click",function（）{ 
	alert("hello");
	demo.removeEventListener("click",arguments.callee,false);
},false);
```

#### 事件类型

小技巧：只有一个“DOMContentLoaded”事件，其余的事件全部为小写。

##### 1.鼠标事件

| 事件名称    | 说明     |
| ----------- | -------- |
| click       | 单击     |
| dbclick     | 双击     |
| contextmenu | 右击     |
| mousemove   | 鼠标移动 |
| mouseover   | 鼠标移入 |
| mouseout    | 鼠标移出 |
| mouseenter  | 鼠标移入 |
| mouseleave  | 鼠标移出 |
| wheel       | 滚轮     |

##### 2.键盘事件

| 事件名称 | 说明           |
| -------- | -------------- |
| keydown  | 按键按下       |
| keyup    | 按键松开       |
| keypress | 按键按下并松开 |

##### 3.表单事件

| 事件名称 | 说明                         |
| -------- | ---------------------------- |
| change   | 表单元素发生改变时并失去焦点 |
| input    | 表单元素发生改变时           |
| blur     | 表单元素失去焦点时           |
| focus    | 表单元素获取焦点时           |
| reset    | 表单重置                     |
| select   | 选择文本时                   |
| submit   | 表单提交时                   |

#### 事件对象

说明：

​	1.event对象代表事件的状态，类似于照相机，在事件触发的一瞬间所产生。事件通常与函数结合使用，函数不会在事件发生前被执行！

​	2.event对象表示方式为函数的形参，实际开发中可以用语义化单词所替代!

例如：

```
document.getElementById("btn").onclick = function（event）{ console.log(event); }
```

属性：

| 属性名称   | 说明                                           |
| ---------- | ---------------------------------------------- |
| clientX    | 点击位置距离当前body可视区域的x坐标            |
| clientY    | 点击位置距离当前body可视区域的y坐标            |
| screenX    | 点击位置距离当前电脑屏幕的x坐标                |
| screenY    | 点击位置距离当前电脑屏幕的y坐标                |
| pageX      | 对于整个页面来说，包括了被卷去的body部分的宽度 |
| pageY      | 对于整个页面来说，包括了被卷去的body部分的高度 |
| offsetX    | 相对于带有定位的父盒子的x坐标                  |
| offsetY    | 相对于带有定位的父盒子的y坐标                  |
| srcElement | 事件源对象                                     |
| target     | 事件源对象                                     |
| key        | 在按下按键时返回按键的标识符                   |
| keyCode    | 事件触发的键的值的字符代码                     |

**代码演示**

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
			#input{
				outline: none;
				width: 200px;
				height: 40px;
				border: 1px 5F9EA0 solid;
				padding-left: 20px;
				font-size: 20px;
			}
			
			#eye{
				width: 25px;
				position: absolute;
				left: 190px;
				top:15px;
				cursor: pointer;
				display: none;
				
			}
			
		</style>
	</head>
	<body>
		
		<div style="position: relative;">
			<input id="input" type="password" />
			<img id="eye" src="img/eye.png" />
		</div>
		
		
		<script>
			
			var eye = document.getElementById("eye");
			var input = document.getElementById("input");
			
			input.oninput = function(){
				if(this.value){
					eye.style.display = "block";
				}else{
					eye.style.display = "none";
				}
				console.log(this.value);
			}
			
			
			eye.onmousedown = function(){
				input.type = "text";
			}
			
			eye.onmouseup = function(){
				input.type = "password";
				input.focus();
			}
		</script>
	</body>
</html>

```

