### Java第二阶段_day11_BOM

#### 说明

此章内容，包含大量的属性和方法，标注*为重点内容，没有标注为了解内容

#### 简介

BOM 是 browser object model 的缩写，简称浏览器对象模型。主要处理浏览器窗口和框架，描述了与浏览器进行交互的方法和接口，可以对浏览器窗口进行访问和操作，譬如可以弹出新的窗口，回退历史记录，获取 url

#### BOM 与 DOM的关系

1、javacsript 是通过访问 BOM 对象来访问、控制、修改浏览器 

2、BOM 的 window 包含了 document，因此通过 window 对象的 document 属性就可以访问、 检索、修改文档内容与结构。 

3、document 对象又是 DOM 模型的根节点。 因此，BOM 包含了 DOM，浏览器提供出来给予访问的是 BOM 对象，从 BOM 对象再访问到 DOM 对象，从而 js 可以操作浏览器以及浏览器读取到的文档

#### **BOM 中的核心对象**

| 名称      | 简介                                        |
| --------- | ------------------------------------------- |
| Window    | JavaScript 层级中的顶层对象，表示浏览器窗口 |
| document  | DOM                                         |
| Navigator | 包含客户端浏览器的信息                      |
| History   | 包含了浏览器窗口访问过的 URL                |
| Location  | 包含了当前 URL 的信息                       |
| Screen    | 包含客户端显示屏的信息                      |

##### Window 

###### 介绍

Window 对象表示一个浏览器窗口或一个框架。在客户端 JavaScript 中，Window 对象是全局对象，所有的表达式都在当前的环境中计算。也就是说，要引用当前窗口根本不需要特殊的语法，可以把那个窗口的属性作为全局变量来使用。例如，可以只写 document，而不必写 window.document。

###### 属性

| 属性名                                   | 简介                                                         |
| ---------------------------------------- | ------------------------------------------------------------ |
| history                                  | 对 History 对象的只读引用。请参数 History 对象。             |
| location                                 | 用于窗口或框架的 Location 对象。请参阅 Location 对象。       |
| Navigator                                | 对 Navigator 对象的只读引用。请参数 Navigator 对象。         |
| Screen                                   | 对 Screen 对象的只读引用。请参数 Screen 对象。               |
| document                                 | 对 Document 对象的只读引用。请参阅 Document 对象。           |
| window                                   | window 属性等价于 self 属性，它包含了对窗口自身的引用。      |
| innerheight*                             | 返回窗口的文档显示区的高度。                                 |
| innerwidth*                              | 返回窗口的文档显示区的宽度。                                 |
| pageXOffset*                             | 设置或返回当前页面相对于窗口显示区左上角的 X 位置。          |
| pageYOffset*                             | 设置或返回当前页面相对于窗口显示区左上角的 Y 位置。          |
| screenLeft，screenTop，screenX，screenY* | 只读整数。声明了窗口的左上角在屏幕上的的 x 坐标和 y 坐标。IE、Safari、Chrome 和 Opera 支持 screenLeft和 screenTop，而 Chrome、Firefox 和 Safari 支持 screenX 和 screenY。 |
| name*                                    | 设置或返回窗口的名称。注：没有设置为默认空串，有缓存问题，面试题重点 |
| length                                   | 设置或返回窗口中的框架数量。                                 |
| opener                                   | 返回对创建此窗口的窗口的引用。                               |
| outerheight                              | 返回窗口的外部高度。                                         |
| outerwidth                               | 返回窗口的外部宽度。                                         |
| parent                                   | 返回父窗口。                                                 |
| self                                     | 返回对当前窗口的引用。等价于 Window 属性。                   |
| status                                   | 设置窗口状态栏的文本。（仅 Opera 支持）                      |
| top                                      | 返回最顶层的先辈窗口。                                       |
| closed                                   | 返回窗口是否已被关闭。                                       |
| defaultStatus                            | 设置或返回窗口状态栏中的默认文本。（仅 Opera 支持）          |

###### 方法

| 方法名           | 介绍                                                         |
| ---------------- | ------------------------------------------------------------ |
| alert()*         | 显示带有一段消息和一个确认按钮的警告框。                     |
| confirm()*       | 显示带有一段消息以及确认按钮和取消按钮的对话框。             |
| prompt()*        | 显示可提示用户输入的对话框。                                 |
| setInterval()*   | 按照指定的周期（以毫秒计）来调用函数或计算表达式。           |
| setTimeout()*    | 在指定的毫秒数后调用函数或计算表达式。                       |
| clearInterval()* | 取消由 setInterval() 设置的 timeout。                        |
| clearTimeout()*  | 取消由 setTimeout() 方法设置的 timeout。                     |
| open()*          | 打开一个新的浏览器窗口或查找一个已命名的窗口。window.open(URL,name,features,replace) |
| close()*         | 关闭浏览器窗口。                                             |
| scrollBy()*      | 按照指定的像素值来滚动内容。                                 |
| scrollTo()*      | 把内容滚动到指定的坐标。                                     |
| blur()           | 把键盘焦点从顶层窗口移开。                                   |
| createPopup()    | 创建一个弹出窗口。只有 ie 支持（不包括 ie11）                |
| focus()          | 把键盘焦点给予一个窗口。                                     |
| moveBy()         | 可相对窗口的当前坐标把它移动指定的像素。                     |
| moveTo()         | 把窗口的左上角移动到一个指定的坐标。                         |
| print()          | 打印当前窗口的内容。                                         |
| resizeBy()       | 按照指定的像素调整窗口的大小。                               |
| resizeTo()       | 把窗口的大小调整到指定的宽度和高度。                         |

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>
	<body>
		
		<script>
			
			var i = 1 ;
			
//			alert(window.i);
			
//			var result = confirm("今天你吃早饭了吗？");
//			if(result){
//				alert("保持身材，不要长得像张炜林一样胖。");
//			}else{
//				alert("不吃早饭对身体不好，不要像赵恩阳一样。");
//			}
			
//			var result = prompt("你今天学习了吗？","没有");
//			alert(result);

			
			var i = 0 ;
//			function print(){
//				document.write(parseInt(Math.random()*10));
//				var timer = setTimeout(print,10);
//				
//				i++;
//				
//				if(i == 200){
//					clearTimeout(timer);
//				}
//			}
//			setTimeout(print,10);

			function print(){
				document.write(parseInt(Math.random()*10));
				i++;
				if(i == 200){
					clearInterval(timer);
					window.open("https://www.bailiban.com");
				}
			}
			var timer = setInterval(print,10);			
		</script>
		
	</body>
</html>

```





##### Navigator

###### 介绍

Navigator 对象包含的属性描述了正在使用的浏览器。可以使用这些属性进行平台专用的配置。虽然这个对象的名称显而易见的是 Netscape 的 Navigator 浏览器，但其他实现了 JavaScript 的浏览器也支持这个对象。

###### 属性

| 属性名          | 介绍                                                         |
| --------------- | ------------------------------------------------------------ |
| cookieEnabled*  | 返回指明浏览器中是否启用 cookie 的布尔值。                   |
| onLine          | 返回指明系统是否处于脱机模式的布尔值。                       |
| userAgent       | 返回由客户机发送服务器的 user-agent 头部的值。               |
| appCodeName     | 返回浏览器的代码名。以 Netscape 代码为基础的浏览器中，它的值是 "Mozilla"。为兼容Microsoft 也是 |
| appMinorVersion | 返回浏览器的次级版本。（IE4、Opera 支持）                    |
| appName         | 返回浏览器的名称。                                           |
| appVersion      | 返回浏览器的平台和版本信息。                                 |
| browserLanguage | 返回当前浏览器的语言。（IE 和 Opera 支持）                   |
| cpuClass        | 返回浏览器系统的 CPU 等级。（IE 支持）                       |
| platform        | 返回运行浏览器的操作系统平台。                               |
| systemLanguage  | 返回当前操作系统的默认语言。（IE 支持）                      |
| userLanguage    | 返回操作系统设定的自然语言。（IE 和 Opera 支持）             |
| plugins         | 返回包含客户端安装的所有插件的数组                           |

###### 方法

| 方法名         | 介绍                                         |
| -------------- | -------------------------------------------- |
| javaEnabled()  | 规定浏览器是否支持并启用了 Java。            |
| taintEnabled() | 规定浏览器是否启用数据污点 (data tainting)。 |

##### History

###### 介绍

History 对象包含用户（在浏览器窗口中）访问过的 URL

###### 属性

| 属性名  | 介绍                              |
| ------- | --------------------------------- |
| length* | 返回浏览器历史列表中的 URL 数量。 |

###### 方法

| 方法名     | 介绍                                |
| ---------- | ----------------------------------- |
| back()*    | 加载 history 列表中的前一个 URL。   |
| forward()* | 加载 history 列表中的下一个 URL。   |
| go()*      | 加载 history 列表中的某个具体页面。 |

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		第1章
		<button id="btn" onclick="aa()">go</button>
		<script>
			function aa(){
				history.forward();
			}
		</script>
	</body>
</html>

```

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		第2章
		<button id="btn" onclick="bb()">go</button>		
		<script>
			
			function bb(){
				history.back();
			}
		</script>
	</body>
</html>

```



##### Location

###### 介绍

Location 对象包含有关当前 URL 的信息。

###### 属性

| 属性名    | 介绍                                          |
| --------- | --------------------------------------------- |
| hash      | 设置或返回从井号 (#) 开始的 URL（锚）。       |
| host*     | 设置或返回主机名和当前 URL 的端口号。         |
| hostname* | 设置或返回当前 URL 的主机名。                 |
| href      | 设置或返回完整的 URL。                        |
| pathname  | 设置或返回当前 URL 的路径部分。               |
| port      | 设置或返回当前 URL 的端口号。                 |
| protocol  | 设置或返回当前 URL 的协议。                   |
| search    | 设置或返回从问号 (?) 开始的 URL（查询部分）。 |

###### 方法

| 方法名           | 介绍                                                         |
| ---------------- | ------------------------------------------------------------ |
| assign()*        | 加载新的文档。                                               |
| reload(‘force’)* | 重新加载当前文档。参数可选，不填或填 false 则取浏览器缓存的文档 |
| replace()*       | 用新的文档替换当前文档。                                     |

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		
		<button onclick="something()" style="margin-left: 400px;">你想干什么？</button>
		
		<script>
			
			function something(){
				location.reload();
//				location.href = "https://bailiban.com";
				
			}		
			
		</script>		
	</body>
</html>
```





##### Screen

###### 介绍

Screen 对象包含有关客户端显示屏幕的信息。每个 Window 对象的 screen 属性都引用一个 Screen 对象。Screen 对象中存放着有关显示浏览器屏幕的信息。JavaScript 程序将利用这些信息来优化它们的输出，以达到用户的显示要求。例如，一个程序可以根据显示器的尺寸选择使用大图像还是使用小图像，它还可以根据显示器的颜色深度选择使用 16 位色 还是使用 8 位色的图形。另外，JavaScript 程序还能根据有关屏幕尺寸的信息将新的浏览器 窗口定位在屏幕中间。

###### 属性

| 属性名               | 介绍                                                       |
| -------------------- | ---------------------------------------------------------- |
| availHeight          | 返回显示屏幕的高度 (除 Windows 任务栏之外)。               |
| availWidth           | 返回显示屏幕的宽度 (除 Windows 任务栏之外)。               |
| bufferDepth          | 设置或返回调色板的比特深度。（仅 IE 支持）                 |
| colorDepth           | 返回目标设备或缓冲器上的调色板的比特深度。                 |
| deviceXDPI           | 返回显示屏幕的每英寸水平点数。（仅 IE 支持）               |
| deviceYDPI           | 返回显示屏幕的每英寸垂直点数。（仅 IE 支持）               |
| fontSmoothingEnabled | 返回用户是否在显示控制面板中启用了字体平滑。（仅 IE 支持） |
| height               | 返回显示屏幕的高度。                                       |
| logicalXDPI          | 返回显示屏幕每英寸的水平方向的常规点数。（仅 IE 支持）     |
| logicalYDPI          | 返回显示屏幕每英寸的垂直方向的常规点数。（仅 IE 支持）     |
| pixelDepth           | 返回显示屏幕的颜色分辨率（比特每像素）。                   |
| updateInterval       | 设置或返回屏幕的刷新率。（仅 IE11 以下支持）               |
| width                | 返回显示器屏幕的宽度。                                     |

