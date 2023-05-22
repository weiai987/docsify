## 一.网页介绍

### 1.网页概述

​	**网站**是指在因特网上根据一定的规则，使用HTML等制作的用于展示特定内容相关的网页集合

​	**网页**是网站中的一“页”，通常是HTML格式的文件，它要通过浏览器来阅读

​	**网页是构成网站的基本元素**，它通常由图片、链接、文字、声音、视频等元素组成。通常我们看到的网页、常见以.htm和.html后缀结尾的文件，因此将其俗称为HTML文件

### 						2.什么是HTML

​	**HTML**指的是**超文本标记语言**（Hyper Text Markup Language），它是用来描述网页的一种语言

​	HTML不是一种编程语言，而是一种标记语言（Markup Language）

​	标记语言是一套标记标签（Markup tag）

**超文本的含义：**

​	1.它可以加入图片、声音、动画、多媒体等内容（超越了文本限制）

​	2.它还可以从一个文件跳转到另一个，它与世界各地主机的文件链接（超级链接文本）

### 		    			3.网页的形成

​	网页是由网页元素构成的，这些元素都是利用html标签描述出来，然后通过浏览器解析用来显示给用户

### 						4.网页总结

​	网页是图片、链接、文字、声音、视频等元素组成，其实就是一个html文件（后缀名为.html）

​	网页生成制作：由前端人员书写HTML文件，然后浏览器打开就能看到网页

​	HTML：超文本标记语言，用来制作网页的一门语言，由标签组成的。比如：图片标签、链接标签、视频标签等...

## 			二.常用浏览器

### 									1.常用浏览器介绍

​	浏览器是网页显示、运行的平台。常用的浏览器有IE、火狐（Firefox）、谷歌（Chrome）、Safari和Opera等。平时称为五大浏览器

### 									2.浏览器内核

​	浏览器内核（渲染引擎）：负责读取网页内容，整理讯息、计算网页的显示方式并显示页面

| 浏览器       | 内核    | 备注                                            |
| ------------ | ------- | ----------------------------------------------- |
| IE           | Trident | IE、猎豹安全、360极速浏览器、百度浏览器         |
| firefox      | Gecko   | 火狐浏览器内核                                  |
| Safari       | Webkit  | 苹果浏览器内核                                  |
| chrome/opera | Blink   | chrome/Opera浏览器内核、Blink其实是WebKit的分支 |

​	目前国内一般的浏览器都会采用WebKit/Blink内核，如360、UC、QQ、搜狗等

## 			三.Web标准

​	**Web标准**是由W3C组织和其他标准化组织制定的一**系列标准的集合**，W3C（万维网联盟）是国际最著名的标准化组织

### 					1.为什么需要Web标准

​	浏览器不同，它们显示的页面或者排版就有些许差异

​	遵循Web标准除了可以让不同的开发人员写出的页面更加标准、更加统一之外，还有以下优点：

​		1.让web的发展前景更加广阔

​		2.内容能被更广泛的设备访问

​		3.更容易被搜索引擎搜索

​		4.降低网站流量费用

​		5.使网站更加便于维护

​		6.提高页面的浏览速度

### 					2.Web标准的构成

​	主要包括结构、表现和行为三个方面

| 标准 | 说明                                                         |
| ---- | ------------------------------------------------------------ |
| 结构 | 结构用于对**网页元素**进行整理和分类，现阶段主要学的是HTML   |
| 表现 | 表现用于设置网页元素的板式，颜色、大小等**外观样式**，主要是指CSS |
| 行为 | 行为是指网页模型的定义以及**交互**的编号、现阶段主要学的是JavaScript |

​	Web标准提出的最佳体验方案：结构、样式、行为相分离

​	简单理解：结构写到HTML文件中，表现写到CSS文件中，行为写到JavaScript文件中

​	**相比较而言，三者之中结构最重要**

## 四.HTML结构

```html
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="UTF-8">
    	<title>Document</title>
	</head>
	<body>
    
	</body>
</html>
```

语言：<html lang="EN"></html>   

head：页面文档头部

字符编码：<mete charset="UTF-8">	UTF-8就是万国码

​	**注意**：字符编码除了UTF-8之外 还有 GBK--- 国标扩展码、GB2312 --- 中文简体

​				当我们使用记事本保存时 默认编码为ANSI 运行就会发生乱码现象

body:页面主体           

编码格式：**文件一定要以.htm或者.html为后缀**



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

## 	五.HTML基础标签

### 1.语义化

​	每一个HTML元素都有具体的含义

### 			2.文本标签

| 标签名          | 特点                                |
| --------------- | ----------------------------------- |
| 标题标签h1~h6   | 文本会进行加粗 从h1到h6文本逐步缩小 |
| 分割线标签hr    | 产生一条分割线                      |
| 段落标签p       | 独占一行                            |
| 预格式化标签pre | 内容原样输出 包括空格和换行         |
| 上标标签sup     | 内容为上标                          |
| 下标标签sub     | 内容为下标                          |
| 加粗标签b       | 内容加粗                            |
| 倾斜标签i       | 内容倾斜                            |
| 下划线标签u     | 为内容添加下划线                    |
| 删除线s         | 为内容添加删除线                    |

**代码演示**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <pre>
        Lorem ipsum, dolor sit amet consectetur 
        adipisicing elit. Quae maxime necessitatibus optio totam! Nulla harum dolore id eveniet, 
        aut assumenda facilis soluta itaque labore,
        qui ratione rerum repellat, sit nobis.
    </pre>
    <!-- 注音 -->
    <ruby>
        托尼老师
        <rt>tuo ni lao shi</rt>
    </ruby>
    <!-- 上标  下标 -->
    马保国<sub>混元形意太极门</sub>
    马保国<sup>混元形意太极门</sup>

    <u>年轻人不讲武德<b>来，骗！&nbsp;&nbsp;&nbsp;&nbsp;来&lt;偷&amp;袭</b>，我&emsp;&emsp;&emsp;这&gt;一个<i>69</i>岁的<s>老同志</s></u>
</body>
</html><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <pre>
        Lorem ipsum, dolor sit amet consectetur 
        adipisicing elit. Quae maxime necessitatibus optio totam! Nulla harum dolore id eveniet, 
        aut assumenda facilis soluta itaque labore,
        qui ratione rerum repellat, sit nobis.
    </pre>
    <!-- 注音 -->
    <ruby>
        托尼老师
        <rt>tuo ni lao shi</rt>
    </ruby>
    <!-- 上标  下标 -->
    马保国<sub>混元形意太极门</sub>
    马保国<sup>混元形意太极门</sup>

    <u>年轻人不讲武德<b>来，骗！&nbsp;&nbsp;&nbsp;&nbsp;来&lt;偷&amp;袭</b>，我&emsp;&emsp;&emsp;这&gt;一个<i>69</i>岁的<s>老同志</s></u>
</body>
</html>
```





### 3.font标签（已废弃）

​	属性：

​		size  ：    1-7   从小到大     一旦超过 了7会出现和7一样大的效果

​		color ：   字体的颜色

​		face：    字体的样式

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 字体标签 
                1.改变大小  size   1-7  从小到大
                2.改变颜色  color
                3. 改变字体的样式  -->
    <font size="7" color="green" face="仿宋">蛋黄的长裙，蓬松的头发</font>
    <font size="5" color="green" face="楷体"><a href="#">蛋黄的长裙，蓬松的头发</a></font>
    <a href="#"><font size="3" color="green" face="仿宋">蛋黄的长裙，蓬松的头发</font></a>
</body>
</html>
```



### 		4.HTML实体

​	空格   '&nbsp'  '&emsp'&nbsp;

​	大于 小于   &lt    &gt

​	&       &amp

​	版权符号：&copy

### 		5.超链接

​	a（默认情况下是蓝色字体，并且有下划线，点击一次之后会变成紫色）

​		属性 ：

​			href    链接的地址

​			target     跳转方式   默认的情况下是  '_self'     如果换成了"__blank"就会新建一个页面进行跳转

​		1.普通链接    使用属性  href   进行跳转

​		2.锚链接 

​			①.给要跳转的位置添加一个  id

​			②.建立一个a标签

​			③.在 当前的a标签里面的href属性里面  通过 #id名进行跳转

​				**注意**：也可以使用name作为标记位置 但是在H5中已被废弃

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- a标签 -->
    <!-- 用法1.  当做普通链接 -->
    	<a href="#">123</a>
    <!-- 必须拥有的条件
            1.要进行跳转的地址 -->
    	<a href="http://www.baidu.com">百度一下</a>
    	<a href="锚点.html" target="_self">跳转</a>
    <!-- 锚链接 -->
    <a href="锚点.html">跳转到另外的一个网页</a>
    <img src="ima/下载.jpg" alt="">
</body>
</html>
```



### 		6.图片标签

​		img

​		属性：

​	  		src：图片的地址

​      		alt : 当图片加载不出来的时候显示的文字

​      		title :当鼠标移入时产生的文字

​      		width： 图片的宽度

​      		height：图片的高度

​	 		align:   并不是图片的水平位置 而是 图片两边文字的垂直位置

 		路径的写法

​      		1.绝对路径

​					本地绝对路径、服务绝对路径

​      		2.相对路径

​          		./表示当前资源所在的目录

​         		../ 返回上一级目录

​          		相对路径的 ./是可以省略的

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 图片标签 -->
        <!-- src   ：图片的地址
            alt : 当图片加载不出来的时候显示的文字
            title  :当鼠标移入时产生的文字
            width： 图片的宽度
            height：图片的高度-->
    <!-- 路径的写法
            1.绝对路径
            2.相对路径
                    ./表示当前资源所在的目录
                    ../  返回上一级目录
                    相对路径的 ./是可以省略的
         -->
         <p align="center">
         这是一只猫<img src="image/下载.jpg" alt="可爱的猫" title="猫" width="500" height="500" align="button">这是一只猫
         </p>
        
    </body>
</html>
```



### 7.无序列表 ul  

​		子标签：li

​		属性：type  进行什么样更改

​		取值：

​       		disc  默认的样式  实心圆点  

​      		square  实心的方块

​      		circle  空心的圆圈

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 列表标签 -->
        <!-- 无序列表 -->
    <!-- <ul>无序列表</ul> 
            u：  unordered 
            l：   list-->
    <!-- <li>选项</li> 
            l：  list
            i：  item-->
    <!-- XXX同学择偶标准
                1.有钱的
                2.漂亮
                3.最好是上了年纪的但是必须是有钱的
     -->
     <!--type   进行什么样更改
                disc    默认的样式    实心圆点   
                square   实心的方块
                circle    空心的圆圈-->
    <ul type="circle">
        <a href="#"><li>有钱的</li></a>
        <li>漂亮的</li>
        <li>最好是上了年纪的但是必须是有钱的</li>
    </ul>
</body>
</html>
```



### 8.有序列表 ol  

​		子标签：li

​		属性：type    (取值:a、A、i、I、默认值为1)

​			  	 start  开始值

​    		  	 reversed  倒序

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 有序列表 -->
    <!-- ordered list OL
         list   item  LI
        
         start    开始值
         reversed   倒序
        -->
    <!-- 把大象装进冰箱需要几步
        1.打开冰箱门
        2.把大象装进冰箱
        3.关闭冰箱门
        I  罗马字符
    
     -->
     <ol type="1"  start="4" reversed>
         <li>打开冰箱门</li>
         <li>把大象装进冰箱</li>
         <li>关闭冰箱门</li>
     </ol>
</body>
</html>
```



### 9.自定义列表 dl 

​		子标签：

​			dt：列表标题

​			dd ：列表项

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- 自定义标签 -->
    <!-- dl  d: definition
                l:list 
          dt:
            d:definition
            t:title
          dd:
            d:definition
            d:description
        -->
    <dl>
        <dt>HTML</dt>
        <dd>超文本标记语言</dd>
        <dt>浑元形意太极门</dt>
        <dd>马保国</dd>
        <dt>伞兵一号</dt>
        <dd>卢本伟</dd>
    </dl>
</body>
</html>
```



## 六.表格(table)

​        	按照一定顺序摆放数据，表格是由一些单元格组成

### 1.属性

​		 **table表格**

​      		  border边框

​            	cellspacing 	单元格和单元格之间的距离 

​            	cellpadding	单元格边框和内容之间的距离

​            	aligin 	表格水平的位置

​      	**tr 行** 

​        		align  调整一整行内容的水平位置

​        		valign  调整内容的垂直位置（top  middle  bottom)

​        		height  调整本行的高度

​       		 bgcolor  调整本行的颜色

​				**注意**  tr中width是不生效的

​     	**td  单元格**

​          		width、 height

​          	（只要有任何一个单元格发生改变的时候，他所在的那一行或者那一列宽度和高度都会发生变化）

​          		align 调整的自身内容的水平位置

​          		valign 调整自身内容的垂直位置

​         		 bgcolor 调整的是自身的颜色

### 2.表格的结构

​			caption 表格标题

​		  		1.必须跟随在table标签之后

​          		2.表格标题只能存在一个(人为约定)

​			th 表格的表头

​			thead 表格的页眉

​			tbody 表格的主体

​			tfoot 表格的页脚

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>   
     <table border="1" width="500" height="500" cellspacing="0" cellpadding="0" align="center" bgcolor="yellow">
        <tr align="center" valign="bottom" bgcolor="red">
            <td align="center" bgcolor="blue">IU</td>
            <td width="300px">刘德华</td>
            <td>周星驰</td>
        </tr>
        <tr align="center">
            <td>李云龙</td>
            <td valign="bottom">迪丽热巴</td>
            <td>古力娜扎</td>
        </tr>
        <tr>
            <td>马尔扎哈</td>
            <td>卡萨丁</td>
            <td>卡萨</td>
        </tr>
     </table>
</body>
</html>
```



### 3.表格的高级运用

​			 跨列合并 colspan

​					从指定单元格位置开始，横向向右合并，几个单元格（包含自己）被合并掉的单元格应从tr中删除

​					属性：   td的colspan属性

​					取值：   合并单元格的数量

​             跨行合并 rowspan

​					从指定单元格的位置处开始，纵向向下合并，几个单元格（包含自己）被合并掉的要删除

​					属性： td的rowspan属性

​					取值： 合并单元格的数量

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1" width="600" height="600" cellspacing="0" cellpading="0" align="center">
        <!-- 表格标题必须跟随在table标签之后
            表格标题只能存在一个 -->
            <caption><font size="5">这是一个九宫格</font></caption>
        <!-- 行合并和列合并
        
                跨列合并  colspan
                跨行合并  rowspan-->
       <tr>
           <td colspan="2">1</td>
           <!-- <td>2</td> -->
           <td rowspan="2">3</td>
       </tr>
       
       <tr>
           <td>4</td>
           <td>5</td>
           <!-- <td>6</td> -->
       </tr>
       
       <tr>
           <td colspan="3">7</td>
           <!-- <td>8</td>
           <td>9</td> -->
       </tr>
    </table>
</body>
</html>
```



## 七.表单form

​       	用于  显示、收集  用户信息 ，并且提交给服务器

### 1.组成

​			表单元素  : 将信息提交给服务器

​			表单控件  : 负责接收用户的数据

 		   表单提交： 点了提交按钮就会跳转到新的页面

​      	  属性：

​          		    action  设置提交表单的地址

​          		    method  设置表单的提交方式

​             		 	get  显示传输

​             		 	post  隐式传输

### 2.表单控件

​	input属性：

​        	type 类型

​				  text  普通文本输入框

​          		password  密码框

​          		file  文件上传

​		  		radio  单选

​		  		checkbox 多选

​		 	 	submit 提交

​		      	reset   重置

​		 	 	image  图片（默认是提交属性）

​				  button  按钮

​        	value 值

​        	name  名称

​			placeholder 文本占位符

​			checked 默认选中 

​			disabled 禁用

​			readonly 只读

​			**注意** ：checked只适用于单选按钮和复选框 ，checked和disabled设置时可以直接写属性名 也可以写成checked = "checked"、checked = "true"

### 3.关联标签

​        	label

​          		属性 ： for

​       	 第一种用法  

​          		给要关联的控件加上一个id

​          		通过for属性连接id

​        	第二种方法

​          		直接包裹input元素

### 4.文本域 textarea

​       	文本域的大小不取决于宽高，而是行数、列数

​        	cols  列数

​        	rows  行数

### 5.下拉菜单 select

​        	option：列表项

​       	 size  : 默认选项的数量 如果取值大于1的话 则成为一个滚动列表

​        	selected 默认选中

### 6.拓展标签

​			iframe：浮动框架 

​      			第一个作用  在一个屏幕中显示多个页面（小窗口的形式展现的）

​	  			第二个作用  可以在小窗口中显示不同的网页

​			marquee：跑马灯标签

​				属性：

​					behavior	设置文本在 marquee 元素内如何滚动

​					bgcolor	   通过颜色名称或十六进制值设置背景颜色

​					direction	设置 marquee 内文本滚动的方向

​							可选值：left，right，up，down（默认值为left）

​					height		 以像素或百分比值设置高度

​					hspace		设置水平边距

​					loop			 设置 marquee 滚动的次数，默认值为 −1，表示 marquee 将连续滚动

​					scrollamount	设置每次滚动时移动的长度（以像素为单位），默认值为 6

​					scrolldelay		设置每次滚动时的时间间隔（以毫秒为单位）默认值为 85

​					truespeed		默认情况下，会忽略小于60的scrolldelay值，如果存在truespeed，那些值不会被忽略

​					vspace			  以像素或百分比值设置垂直边距

​					width				以像素或百分比值设置宽度





```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   
    <form action="http://www.baidu.com" method="POST" >
 
        <label for="user">用户名：</label>
        <input type="text" id="user" placeholder="请输入5-10包含字母的用户名">
       <br>
       <label>
        密&emsp;码： <input type="password">
       </label>
       <br>
       性&emsp;别：男<input type="radio" name="sex" />女<input type="radio" name="sex">
       <br>
       爱&emsp;好：rap<input type="checkbox"/>   篮球<input type="checkbox"/>  吃<input type="checkbox"/>
       <br/>
       邮箱:<input type="email"/><br/>
       电话:<input type="tel"/><br/>
       <!-- 文本域 
              文本域的大小不取决于宽高
               而是     行数    列数
               cols   列数
               rows   行数
            -->
       个性签名：<textarea cols="20" rows="20"></textarea>
       <br>
       文件:<input type="file"/>
       <br>

       <select  size="4" multiple="multiple">
            <option value="">美国</option>  
            <option value="" selected>中国</option>
            <option value="">伊拉克</option>
            <option value="">苏联</option>
       </select>
       <input type="submit" value="注册">
       <input type="reset" value="重置">
       <input type="image" src="image/1.jpg" />
    </form>
</body>
</html>
```



