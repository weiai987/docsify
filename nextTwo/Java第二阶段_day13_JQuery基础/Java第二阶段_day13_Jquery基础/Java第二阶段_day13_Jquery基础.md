## 一. 为什么要学jquery

使用javascript开发过程中，有许多的缺点：

1. 查找元素的方法单一，麻烦。
2. 遍历数组很麻烦，通常要嵌套一大堆的for循环。
3. 有兼容性问题。
4. 想要实现简单的动画效果，也很麻烦
5. 代码冗余。

## 二. jquery官方标语

```javascript
write less ， do more.
```

## 三. jquery到底是什么?

>    cdn：https://www.bootcdn.cn/jquery/
>   下载地址：http://www.jq22.com/jquery-info122
>   中文官网：https://www.jquery123.com/
>   原版官网：https://jquery.com/
>
> jQuery就是一个js库，使用jQuery的话，会比使用JavaScript更简单。

jQuery其实就是一个js文件，里面封装了一大堆的方法方便我们的开发，因此我们学习jQuery，其实就是学习jQuery这个js文件中封装的一大堆方法。



## 四. jquery实例方法和DOM操作

### 01.jQuery实例方法-DOM操作

|   方法    | 说明                                                         | 备注                                                         |
| :-------: | :----------------------------------------------------------- | :----------------------------------------------------------- |
|  .get()   | 取得其中一个匹配的元素, 参数表示取得第几个匹配的元素。 也是从0开始 | 获取到的是DOM对象   可以直接使用原生的js进行操作             |
|   .eq()   | 获取元素匹配中的第几个子元素, 参数为 index  一个整数，指示元素基于0的位置,这个元素的位置是从0算起。如果给的参数为负值  那么就从集合中的最后一个元素开始倒数。(1算起) |                                                              |
|  .find()  | 找出当前元素的指定后代元素   作用和后代选择器一样            |                                                              |
| .filter() | 根据指定条件进行筛选  返回值为布尔类型   为true则添加到返回的集合中 | filter的参数是一个回调函数, 回调函数有两个参数  分别为index和ele  这里的ele是遍历到当前项的DOM元素 |
|  .not()   | 跟filter完全相反                                             |                                                              |
|  .has()   | 保留包含特定后代的元素，去掉那些不含有指定后代的元素。       |                                                              |
|   .is()   | 根据选择器、DOM元素或 jQuery 对象来检测匹配元素集合，如果其中至少有一个元素符合这个给定的表达式就返回true。 |                                                              |
|  .add()   | 把与表达式匹配的元素添加到jQuery对象中。这个函数可以用于连接分别与两个表达式匹配的元素结果集。(集合操作) |                                                              |
|  .end()   | 将匹配的元素列表变为前一次的状态。 (回退操作)                |                                                              |

**代码演示**

```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.js"></script>
</head>
<body>
	<div class="wrapper">
		<ul>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
			<li>5</li>
		</ul>
	</div>
	<ul>
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
	</ul>
	<script>
		// 场景：给wrapper一个相对定位，给ul一个绝对定位，给li一个颜色
		// $(".wrapper").css({position : "relative"});
		// $(".wrapper ul").css({position : "absolute"});
		// $(".wrapper ul li").css({color : "red"});
		// 写起来比较麻烦，使用find来在指定条件下进行选择

		// find()
		$(".wrapper")
			.css({position : "relative"})
			.find("ul")
			.css({position : "absolute"})
			.find("li")
			.css({color : "red"})
		//代码其实没有减少多少，但是效率提升，不用每次从头进行查找

		//prevObject  中有一个属性，表示的是上一个对象
		console.log( $(".wrapper") )
		console.log( $(".wrapper").find("ul") )
		console.log( $(".wrapper").find("ul").find("li") )
		// 问题 true？false
		console.log( $(".wrapper").find("ul").find("li").prevObject == $(".wrapper").find("ul") )

	</script>
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<ul>
				<li>1</li>
				<li class="demo">2</li>
				<li>3</li>
				<li>4</li>
				<li class="demo">5</li>
			</ul>
		</div>
		<ul>
			<li>1</li>
			<li class="demo">2</li>
			<li>3</li>
			<li>4</li>
			<li class="demo">5</li>
		</ul>
		<script>
			// 把demo获取到进行操作
			// console.log( $(".wrapper ul").find(".demo") )
			// filter() 过滤   
 			// 两种参数：选择器，function

 			//第一种为选择器
			// $(".wrapper")
			// 	.find("ul")
			// 	.find("li")
			// 	.filter(".demo")
			// 	.css({color : "red"})

			//传入jquery选择器筛选
			// $(".wrapper ul")
			// 	.filter("li:odd")   //注意：只能在选择好的基础之上进行筛选
			// 	.css({color : "red"})

			// $(".wrapper ul")
			// 	.find("li")
			// 	.filter(":odd")  
			// 	.css({color : "red"})

			// 第二种为函数
			$(".wrapper ul li").filter(function(index,ele){
				console.log(ele)
				console.log(index)
				// return false  //返回boolean表示是否选中
				return index % 2 == 0;
			}).css({color : "red"})
			// not() 
			// 跟filter完全相反

		</script>
	</body>
</html>
```





### 02.取值赋值相关操作

|      方法      | 说明                                                         | 备注                                                         |
| :------------: | ------------------------------------------------------------ | ------------------------------------------------------------ |
|      .css      | 获取元素属性或者设置   可以设置或者获取单个属性, 也可以传入一个对象设置多个属性值 | css()取值相当于 getComputed , 赋值相当于dom.style.***        |
|    .attr()     | 设置或者获取元素的属性                                       | 主要依赖的是Element对象的getAttribute()和setAttribute()两个方法 |
|    .prop()     | 设置或者获取布尔类型属性值的的属性 一般情况下为表单元素的对应属性 | 主要依赖的则是JS中原生的对象属性获取和设置方式。             |
|    .html()     | 设置或者获取元素内容  不传参表示获取  传参表示设置,          | 当传入的参数中包含标签时  会被解析                           |
|    .text()     | 设置或者获取元素内容  不传参表示获取  传参表示设置,          | 当传入的参数中包含标签时  不会被解析    在页面上原样显示     |
|    .size()     | 获取当前jquery对象的的 长度(jquery对象是DOM元素的包装集, 也就是计算有多少DOM元素) |                                                              |
|  .addClass()   | 为匹配到的元素添加指定的类名。  只传一个参数 如果需要添加多个类  着多个类写在一个字符串里  每个类名之间使用空格隔开 |                                                              |
| .removeClass() | 从所有匹配的元素中删除全部或者指定的类。  传入参数表示删除指定的类   如果不传参 表示删除所有的参数 |                                                              |
|  .hasClass()   | 判断是否有一个类  返回值为布尔类型                           |                                                              |
| .toggleClass() | 对设置或移除被选元素的一个或多个类进行切换。检查每个元素中指定的类。如果不存在则添加类，如已设置则删除。 |                                                              |
|     .val()     | 获取表单元素的值   类似于原生js中value的属性                 |                                                              |

### 03.拓展：serialize()、serializeArray()

serialize 串联表单数据 

serializeArray 串联数据成数组



## 五. jquery对象的增删查改

### 1. jQuery对象查改删增相关方法

| 方法            | 说明                                                         | 备注                                                         |
| --------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| .next()         | 获取下一个兄弟元素                                           |                                                              |
| .prev()         | 获取上一个兄弟元素                                           |                                                              |
| .nextAll()      | 获取当前查找元素后面所有的兄弟元素                           | 当前元素下面的所有兄弟节点                                   |
| .prevAll()      | 获取当前查找元素前面所有的兄弟元素                           | 当前元素上面的所有兄弟节点                                   |
| .nextUntil()    | 查找当前元素之后所有的同辈元素，直到遇到匹配的那个元素为止。如果没有选择器匹配到，或者没有提供参数，那么跟在后面的所有同辈元素都会被选中。这就跟用没有提供参数的 .nextAll()效果一样。 | 掐头选中元素,传jquery对象或dom                               |
| .prevUntil()    | 查找当前元素之前所有的同辈元素，直到遇到匹配的那个元素为止。 | 去尾选中元素,传jquery对象或dom                               |
| .siblings()     | 找到与当前查找元素平级的所有的兄弟元素   不传参表示查找所有的兄弟元素 如果传入了对应的选择器  就表示查找对应选择器的兄弟元素 | 当前元素节点的所有兄弟节点                                   |
| .parent()       | 取得一个包含着所有匹配元素的唯一父元素的元素集合。如果传参  就表示 查找到指定要求的父元素 |                                                              |
| .parents()      | 取得一个包含着所有匹配元素的祖先元素的元素集合（不包含根元素）。可以通过一个可选的表达式进行筛选。 | 查找祖先元素 可以有参数 selector                             |
| .closest()      | 查找最近的祖先节点 可以有参数selector 能把自己选中           | .closest( selectors [, context ] )方法从 jQuery 1.7 开始，不再建议使用该方法，但是 jQuery 1.7 之前仍然可以使用。 |
| .offsetParent() | 返回第一个匹配元素用于定位的父节点。这返回父元素中第一个其position设为relative或者absolute的元素。此方法仅对可见元素有效。 |                                                              |
| .slice()        | 选取一个匹配的子集  和数组的API方法一样  参数也一样          |                                                              |

### 2. 追加元素相关的方法	

| 方法            | 说明                                                         | 备注                                                   |
| --------------- | ------------------------------------------------------------ | ------------------------------------------------------ |
| .insertAfter()  | 在当前元素作为兄弟元素插入到指定元素的后面 这是目标元素调用的方法, 而且参数可以是一个集合 | A.insertAfter(B)  A插入到 B的后面 (有剪切的功能)       |
| .after()        | 在当前元素作为兄弟元素插入到指定元素的后面, 这里是已有元素调用的方法, 参数为需要插入的新元素 | B.after(A)  A在 B的后面 (有剪切的功能)                 |
| .insertBefore() | 在当前元素作为兄弟元素插入到指定元素的前面, 这是目标元素调用的方法, 而且参数可以是一个集合 | A.insertBefore(B)  A插入到 B的前面 (有剪切的功能)      |
| .before()       | 在当前元素作为兄弟元素插入到指定元素的前面, 这里是已有元素调用的方法, 参数为需要插入的新元素 | B.before(A)  A在 B的前面 (有剪切的功能)                |
| .appendTo()     | 将元素作为最后一个子元素追到到父元素中 这是需要追加的子元素调用的方法, 参数为已存在的父元素 | C.appendTo(D): C添加到D的里面 (添加到最后一个子元素后) |
| .append()       | 将元素作为最后一个子元素追到到父元素中, 这是父元素调用的方法 , 参数为需要追加的子元素 | D.append(C): C里添加D(添加到最后一个子元素后)          |
| .prependTo()    | 将元素作为第一个子元素追到到父元素中                         | 这是需要追加的子元素调用的方法, 参数为已存在的父元素   |
| .prepend()      | 将元素作为第一个子元素追到到父元素中                         | 这是父元素调用的方法 , 参数为需要追加的子元素          |

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.js"></script>
	</head>
	<body>
		<ul id="city">
			<li id="bj">北京</li>
			<li id="tj">天津</li>
			<li id="nj">南京</li>
		</ul>
		<ul id="game">
			<li id="cs">反恐精英</li>
			<li id="xj">星际争霸</li>
			<li id="ms">魔兽世界</li>
		</ul>
		<script>
			// 这一系列的方法就是为了完成链式调用的方便
			// 所有的都是剪贴的操作

			// .insertAfter() 将前面的插入到后面成下个兄弟元素
			// $("#tj").insertAfter($("#xj"));

			// .after()  将后面的插入到前面下一个兄弟元素
			// $("#tj").after($("#xj"));

			// .insertBefore() 将前面的插入到后面成上一个兄弟元素
			// $("#tj").insertBefore($("#xj"));

			// .before() 将后面的插入到前面上一个兄弟元素
			// $("#tj").before($("#xj"));

			// .appendTo()  将前面的插入到后面的里面成为最后一个子节点
			// $("#tj").appendTo($("#xj"));

			// .append()  将后面的插入到前面的里面成为最后一个子节点
			// $("#tj").append($("#xj"));

			// .prependTo() 将前面的插入到后面的里面成为第一个子节点
			// $("#tj").prependTo($("#xj"));

			// .prepend() 将后面的插入到前面的里面成为第一个子节点
			// $("#tj").prepend($("#xj"));

		</script>
	</body>
</html>
```



### 3. 删除及clone操作

| 方法         | 说明                                                         | 备注                                                         |
| ------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| .remove()    | 移除元素本身及其子元素                                       | 元素自杀                                                     |
| .detach()    | 移除被选元素，包括所有的文本和子节点。然后它会保留数据和事件。 | 如果仅移出文本和子元素, 可以使用empty代替, 如果需要移除所有的东西包括事件, 那么可以使用remove代替 |
| .empty()     | 清空元素的子元素                                             | 元素本身还在                                                 |
| .wrap()      | 使用指定的 HTML 元素来包裹每个被选中的元素。该方法由被包括元素调用 | 他有两个参数, 参数一为包括元素, 可以为DOM元素, 也可以为Jquery对象, 参数二为可选参数, 为包裹元素的回调函数  循环包裹 参数 function |
| .wrapInner() | 将每一个匹配的元素的子内容用指定的内容或元素包裹起来         | 循环包裹 参数 function                                       |
| .wrapAll()   | 把所有匹配的元素用指定的内容或元素包裹起来。                 | 包裹选中的所有元素 会破坏结构                                |
| .unwrap()    | 移除指定元素的父元素。                                       | 不传参  表示删除指定元素的父元素, 解除包装 结构化标签不能删除 |
| .clone()     | 克隆节点 参数为true的时候 事件也能克隆                       | 参数为布尔类型,为 true  表示clone所有的子元素及其事件 , 为false, 表示仅克隆所有的子代及后代元素 |
| .data()      | 向元素添加数据  一个参数为获取对应属性的值                   | 参数一为需要添加的数据名 参数二为添加的值                    |



