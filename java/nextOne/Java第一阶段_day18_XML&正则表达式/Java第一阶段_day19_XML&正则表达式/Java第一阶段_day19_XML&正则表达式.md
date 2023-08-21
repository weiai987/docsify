# 学习目标

```
1、了解XML的发展跟历史
2、了解XML跟HTML的区别
3、熟练XML的语法规则
3、了解XML的约束
4、熟练XML的解析
5、熟练正则的解析
```



# 第1章 XML

## 1.1 概述

XML（EXtensible Markup Language）可扩展的标记语言。主要用于数据交换。在HTML发展过程中，由于游览器厂商的恶性竞争，都在兼容不规范的写法，以用来吸引开发者。这与W3C的初衷相违背。于是W3C制定了XML标准，想以此替代HTML进行数据展示。但此并不能吸引开发者，XML最终以失败告终。XML接着又向数据交互方向寻求生存之路，并在此取得一定的成功。现主要功能用于配置文件跟网络中进行数据交互。



## 1.2 XML与HTML的区别

- XML标签都是自定义的，HTML标签都是预定义的
- XML的语法严格，HTML语法松散
- XML存储数据的，HTML展示数据的



## 1.3 语法规则

- XML文件的后缀必须都是xml
- XML第一行必须写文档声明
- XML中有且仅有一个根标签
- 属性值必须使用引号，单引号、双引号都可以
- 标签必须正确关闭，要么成对标签，要么自闭合
- XML区分大小写



## 1.4 XML组成

#### 1.4.1 文档声明

- 格式：`<?xml 属性列表 ?>`

- 属性列表

  |    属性    |                            含义                             |
  | :--------: | :---------------------------------------------------------: |
  |  version   |                      版本号，必须属性                       |
  |  encoding  | 编码方式，告知解析引擎当前文档使用的字符集，默认ISO-8859-1  |
  | standalone | 是否独立，取值yes表示不依赖其它文件，取值no表示依赖其它文件 |

- 栗子

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  ```



#### 1.4.2 指令(了解)

xml中还可以定义指令（CSS），毕竟发明xml的初衷还是做数据展示的。了解即可。

- demo.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <?xml-stylesheet  type="text/css" href="test.css"  ?>
  <users>
  	<user>
  		<name>张三</name>
  		<age>18</age>
  		<sex>男</sex>
  	</user>
  
  	<user>
  		<name>李四</name>
  		<age>28</age>
  		<sex>女</sex>
  	</user>
  
  </users>
  ```

- test.css

  ```css
  @CHARSET "UTF-8";
  name{
  	color:red;
  }
  ```


#### 1.4.3 标签

xml中还可以自定义标签，有如下规则：

- 名称可以包含字母，数字以及其它字符
- 不能以数字或者标点符号开头
- 名称不能以xml或者XML、Xml等等开始
- 名称不能包含空格



#### 1.4.4 属性

标签内还可以定义属性，主要以K-V对的形式，属性值必须使用引号，单引号、双引号都行。id属性值唯一。



#### 1.4.5 文本

- 标签对中还可以定义文本内容。文本中如果用到需要转义的字符则需要转义，比如：`&lt; (<)`\` 、`&amp;(&) `、` &gt;(>)  `。

- CDATA区中的文本会原样输出，特殊字符不需要转义。`<![CDATA[    ]]>`

  ```xml
  	<code>
  		<![CDATA[
  				if(a>1 && a<3){
  					
  				}
  		]]>
  	</code>
  ```


#### 1.4.6 注释

xml中的注释同HTML，`<!--      -->`



## 1.5 约束

XML中主要是做数据交互的，那么我们可以通过规则对这些数据进行约束。



#### 1.5.1 分类

XML的约束主要分为dtd跟schema两种。dtd是一种简单的约束技术，已经过时。schema是一种复杂的约束技术，功能更加强大。



#### 1.5.2 DTD的使用

##### 外部DTD

将DTD的约束规则定义在外部的dtd文件中。根据外部的dtd文件的位置又有本地DTD跟网络DTD之分。

- 本地DTD`<!DOCTYPE 根标签名  SYSTEM "dtd文件的位置" >`

  - student.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"    ?>
  <!DOCTYPE students SYSTEM "student.dtd">  <!-- 外部引入dtd    -->
  <students>
  	<student number="1">
  		<name>six</name>
  		<age>16</age>
  		<sex>girl</sex>
  	</student>
  	
  	<student number="2">
  		<name>seven</name>
  		<age>23</age>
  		<sex>boy</sex>
  	</student>
   
  </students>
  ```

  - student.dtd

  ```dtd
  <!-- 定义可以有标签students，可以有student子标签，*表示数量为0-N，  +表示1-N -->
  <!ELEMENT students (student+) >
  <!-- 定义有标签student，可以有name，age，sex子标签，需要满足顺序 -->
  <!ELEMENT student (name,age,sex) >
  <!-- 定义可以有标签name，类型为字符串-->
  <!ELEMENT name (#PCDATA) >
  <!-- 定义可以有标签age，类型为字符串-->
  <!ELEMENT age (#PCDATA) >
  <!-- 定义可以有标签sex，类型为字符串-->
  <!ELEMENT sex (#PCDATA) >
  <!-- 定义student标签可以有属性number，必填项-->
  <!ATTLIST student number ID #REQUIRED >
  ```

- 网络DTD `<!DOCTYPE 根标签名  PUBLIC "dtd文件名"  "dtd文件的位置URL" >`

  ```xml
  <!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
  ```


##### 内部DTD

DTD的约束还可以直接定义在xml文件中。`<!DOCTYPE students [     ]>`

```xml
<?xml version="1.0" encoding="UTF-8" ?>

<!-- 内部dtd -->
<!DOCTYPE students [
<!ELEMENT students (student+) >
<!ELEMENT student (name,age,sex) >
<!ELEMENT name (#PCDATA) >
<!ELEMENT age (#PCDATA) >
<!ELEMENT sex (#PCDATA) >
<!ATTLIST student number ID #REQUIRED >
]>

<students>
	<student number="1">
		<name>six</name>
		<age>16</age>
		<sex>girl</sex>
	</student>
	
	<student number="2">
		<name>seven</name>
		<age>23</age>
		<sex>boy</sex>
	</student> 

</students>
```



#### 1.5.3 schema

由于DTD不能对数据内容进行约束，我们可以使用另一种功能更加强大的技术：schema。



##### schema的导入

我们先看一个简单的使用schema的规则（student.xml）

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <a:students xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns:a="http://www.blb.com/xml"
			xsi:schemaLocation="http://www.blb.com/xml student.xsd"

>
	<a:student number="blb_0001">
		<a:name>six</a:name>
		<a:age>111</a:age>
		<a:sex>boy</a:sex>
	</a:student>
	
</a:students>
```

- schema文件的后缀是xsd。
- schema的导入信息都是写在根标签中的。
- 在根标签中需要引入xsi的前缀`xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`
- 通过`xsi:schemaLocation`指定要使用的schema文件（`student.xsd`），并且给这个文件取一个别名`http://www.blb.com/xml`
- 通过`xmlns:命名空间`给这个别名命名一个命名空间的前缀，定义了前缀以后标签需要加上前缀
- 可以不设置命名空间，则标签默认来自此xsd文件，如果有多个schema文件，只能有1个默认。



##### schema的定义

student.xsd

```xml
<?xml version="1.0" ?>
<xsd:schema xmlns="http://www.blb.com/xml" 
xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	targetNamespace="http://www.blb.com/xml" elementFormDefault="qualified">
<!--  定义标签students  类型是自定义类型studentsType -->
	<xsd:element name="students" type="studentsType" />
	<xsd:complexType name="studentsType">
		<xsd:sequence>
		<!-- 标签student，类型是自定义类型studentType  最少出现次数是1，最多次数不限 -->
			<xsd:element name="student" type="studentType" minOccurs="1"
				maxOccurs="unbounded" />
		</xsd:sequence>
	</xsd:complexType>

<!-- 定义自定义类型studentType -->
	<xsd:complexType name="studentType">
		<xsd:sequence>
		<!-- name标签是字符串类型  -->
			<xsd:element name="name" type="xsd:string" />
				<!-- age标签是自定义类型ageType  -->
			<xsd:element name="age" type="ageType" />
				<!-- sex标签是自定义类型sexType  -->
			<xsd:element name="sex" type="sexType" />
		</xsd:sequence>
		<!-- 属性number，类型是自定义类型numberType，且为必须的 -->
		<xsd:attribute name="number" type="numberType" use="required" />
	</xsd:complexType>

	<!-- sexType自定义类型 -->
	<xsd:simpleType name="sexType">
		<xsd:restriction base="xsd:string">
		<!-- 枚举：值只能是boy或者girl   -->
			<xsd:enumeration value="boy" />
			<xsd:enumeration value="girl" />
		</xsd:restriction>
	</xsd:simpleType>
	<!-- 自定义类型ageType  范围从0-300之间 -->
	<xsd:simpleType name="ageType">
		<xsd:restriction base="xsd:integer">
			<xsd:minInclusive value="0" />
			<xsd:maxInclusive value="300" />
		</xsd:restriction>
	</xsd:simpleType>
	<!-- 自定义numberType类型，必须以blb_开头，后面跟4位数字 -->
	<xsd:simpleType name="numberType">
		<xsd:restriction base="xsd:string">
			<xsd:pattern value="blb_\d{4}" />
		</xsd:restriction>
	</xsd:simpleType>
</xsd:schema>  
```

对于schema的语法不需要掌握，了解如何使用即可。



##### 参考

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<context:component-scan base-package="com.blb.ssm.control"/>
	<mvc:default-servlet-handler/>
	<mvc:annotation-driven/>
	
	<bean id="ResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/"/>
		<property name="suffix" value=".jsp"/>
	</bean>
		
	</beans>
```



## 1.6 XML解析

​	定义好的xml文件我们通常需要使用程序来操作，这就要求我们能够解析XML，主要的解析方式有DOM、SAX。DOM主要基于文档对象模型，操作方便，相对更占空间。SAX基于事件驱动。我们通常使用框架dom4j来解析。

DOM解析：易用性强，使用DOM时，将把所有的XML文档信息都存于内存中，并且遍历简单，支持XPath，增强了易用性。效率低，解析速度慢，内存占用量过高，对于大文件来说几乎不可能使用。

SAX解析：SAX是一个用于处理XML事件驱动的“推”模型，虽然它不是W3C标准，但它却是一个得到了广泛认可的API。SAX模型最大的优点是内存消耗小。



#### 1.6.1 DOM4J

​	dom4j是一个Java的XML API，是jdom的升级品，用来读写XML文件的。dom4j是一个十分优秀的Java API，具有性能优异、功能强大和极其易使用的特点，它的性能超过sun公司官方的dom技术，同时它也是一个开放源代码的软件。如今可以看到越来越多的Java软件都在使用dom4j来读写XML，特别值得一提的是连Sun的JAXM也在用dom4j。这已经是必须使用的jar包。



#### 1.6.2 文档对象的获取

假设需解析的文档为student.xml，内容如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<students>
  <student number="blb_0001">
    <name>six</name>
    <age>28</age>
    <sex>boy</sex>
  </student>
  <student number="blb_0002">
    <name>seven</name>
    <age>29</age>
    <sex>girl</sex>
  </student>
</students>
```



- SAX方式

  ```java
  InputStream in = Demo.class.getClassLoader().getResourceAsStream("student.xml");	
  SAXReader reader = new SAXReader();
  Document document = reader.read(in);
  ```

- DOM方式

  ```java
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder db = dbf.newDocumentBuilder();
  InputStream in = Demo3.class.getClassLoader().getResourceAsStream("student.xml");
  org.w3c.dom.Document w3cdoc=db.parse(in);
  DOMReader domReader=new DOMReader();
  //将org.w3c.dom.Document转成org.dom4j.Document
  org.dom4j.Document document=domReader.read(w3cdoc);
  ```


#### 1.6.3 常用方法

- 根元素的获取

  ```java
  Element root = document.getRootElement();
  ```

- 获取标签下的所有子标签的相关信息

  ```java
  Iterator<Element> it =  root.elementIterator();
  while(it.hasNext()){
      Element e = it.next();
    //   e.getName 获取元素的标签名
      System.out.print(e.getName() + "\t");
      // e.attributeValue("number")  获取标签指定属性的值
      System.out.print(e.attributeValue("number") + "\t");
      // 获取子标签下的子标签
      Element c1 = e.element("age");
      // c1.getText() 获取标签内的文本内容。
      System.out.println(c1.getText());
      			
  }
  ```


#### 1.6.4 xpath解析

​	当我们使用dom的api解析时比较麻烦，尤其是嵌套层数比较多的时候。我们可以使用xpath表达式的方式来解析。使用这个功能要求dom4j的版本在2.0以上。

- ```java
  // 查找number属性值为blb_0002的students标签下的student子标签
  Node n = document.selectSingleNode("//students/student[@number='blb_0002']");
  System.out.println(n.getName());
  
  
  // selectSingleNode  获取某一个节点，如果有多个返回找到的第1个
  Node selectSingleNode = n.selectSingleNode("name");
  String name = selectSingleNode.getText();
  System.out.println(name);
  
  
  // 遍历，获取students标签下的所有student标签,路径中的"//"表示忽略层级，不使用则必须从根开始
  List<Node> nodes = document.selectNodes("//students/student");
  ListIterator<Node> listIterator = nodes.listIterator(); 
  // 通过迭代器遍历
  while(listIterator.hasNext()){
      Node n = listIterator.next();
      // n.valueOf("@number")获取Node的number属性的值
      String number =  n.valueOf("@number");
      System.out.println(number);
      //相对路径用 name   
      Node selectSingleNode = n.selectSingleNode("name");
      // 获取节点的文本内容
      String name = selectSingleNode.getText();
      System.out.println(name);
  }
  
  
  
  // 还可以通过Node的匹配的条件来过滤
  List<Node> nodes = document.selectNodes("//students/student");
  Iterator<Node> iterator = nodes.iterator();
  while(iterator.hasNext()){
      Node n = iterator.next();
      //			根据条件过滤 number属性值不为blb_0001
      if(n.matches("@number!='blb_0001'")){
          System.out.println(n.getName());
      }
  }
  
  
  
  
  ```



#### 1.6.5 文档的创建

上面我们学习了如何使用程序来解析XML，那么如何使用程序来创建、修改XML文档呢？要创建文档需要在程序中先创建好XML对象，在通过流写入到硬盘上的XML文件中。

- ```java
  // 内存中创建XML的Document对象。
  Document document = DocumentHelper.createDocument();
  // 文档对象中添加根元素，标签为students
  Element root = document.addElement("students");
  // 跟标签中继续添加标签student，并给此添加属性number，值为blb_0001
  Element student1 = root.addElement("student").addAttribute("number", "blb_0001");
  // 给student标签添加name标签，文本内容为six
  student1.addElement("name").addText("six");
  // 给student标签添加age标签，文本内容为18
  student1.addElement("age").addText("18");
  // 给student标签添加sex标签，文本内容为boy
  student1.addElement("sex").addText("boy");
  
  // 作用同上。
  Element student2 = root.addElement("student").addAttribute("number", "blb_0002");
  student2.addElement("name").addText("seven");
  student2.addElement("age").addText("29");
  student2.addElement("sex").addText("girl");
  
  // 创建输出格式
  OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
  
  // 创建要输出的文件，通过流写出
  FileOutputStream fs = new FileOutputStream("src/student.xml");
  OutputStreamWriter osw = new OutputStreamWriter(fs,"utf-8");
  XMLWriter xmlWriter = new XMLWriter(fs,prettyPrint);
  xmlWriter.write(document);
  fw.flush();
  fw.close();

  ```
  
- 如何对XML文档修改呢？

  先通过解析读取到程序中，在内存中修改内容，再通过流写出到指定文件中即可。快亲自动手试试吧。



# 第2章 正则表达式

## 2.1 概述

​		正则表达式，又称规则表达式。（英语：Regular Expression，常简写为regex）。正则表达式通常被用来检索、替换那些符合某个模式(规则)的文本。支持正则表达式的有：PHP、Java、Python、JavaScript等。有了正则表达式写代码更加简洁，通常两三行代码就可以达到目的。



## 2.2 规则

```
1. 任意一个字符表示匹配任意对应的字符，如a匹配a，7匹配7，-匹配-。
2. []代表匹配中括号中其中任一个字符，如[abc]匹配a或b或c。
3. -在中括号里面和外面代表含义不同，如在外时，就匹配-，如果在中括号内[a-b]表示匹配26个小写字母中的任一个；[a-zA-Z]匹配大小写共52个字母中任一个；[0-9]匹配十个数字中任一个。
4. ^在中括号里面和外面含义不同，如在外时，就表示开头，如^7[0-9]表示匹配开头是7的，且第二位是任一数字的字符串；如果在中括号里面，表示除了这个字符之外的任意字符(包括数字，特殊字符)，如[^abc]表示匹配出去abc之外的其他任一字符。
5. .表示匹配任意的字符。
6. \d表示数字。[0-9]
7. \D表示非数字。
8. \w表示字母、数字、下划线，[a-zA-Z0-9_]。
9. \W表示不是由字母、数字、下划线组成。
10.	[\u4e00-\u9fa5]匹配汉字
11. ?表示出现0次或1次。
12. +表示出现1次或多次。
13. *表示出现0次、1次或多次。
14. {n}表示出现n次。
15. {n,m}表示出现n~m次。
16. {n,}表示出现n次或n次以上。>=n
```

## 2.3 使用

​		了解基本的正则表达式的规则后，再结合`java.util.regex.Pattern`跟`java.util.regex.Matcher`就可以校验字符串了。

**代码演示**

要求：测试字符串`aaaaaaaabbb`是否符合`a*b`的正则。

> 方式1

```java
String s = "aaaaaaaabbb" ; 
//定义正则表达式（规则）
Pattern p = Pattern.compile("a*b");
Matcher matcher = p.matcher(s);
System.out.println(matcher.matches());// true ：测试的字符串符合定义的规则
```



> 方式2

```java
System.out.println(Pattern.matches("a*b", "aaaaaaaabbb"));// true ：测试的字符串符合定义的规则
```



> 方式3

```java
String s = "aaaaaaaabbb" ; 
s.matches("a*b");
```

tips：

​	检查字符串是否符合定义的规则，可以使用`Matcher`类的`matches`跟`find`方法判断，它们区别

- `matches`是拿整个测试字符串去验证。
- `find`是去判断子串是否有匹配。





**代码演示**

要求：测试正则相关的API，学习其它相关规则

```java
 public static void main(String[] args) {
        System.out.println(Pattern.matches("a*b", "aaaaabb"));
		System.out.println(Pattern.matches("[ab]", "ab"));
		System.out.println(Pattern.matches("[a-zA-H]", "Z"));
		System.out.println(Pattern.matches("[^abc]", "d"));
		System.out.println(Pattern.matches("[^abc]", "d"));
		System.out.println(Pattern.matches("[a-k&&c-z]", "z"));
		System.out.println(Pattern.matches("a[a-z]c", "abc"));
		System.out.println(Pattern.matches("\\d", "10"));
		System.out.println(Pattern.matches("\\D", "a"));
		System.out.println(Pattern.matches("\\s", "\t"));
		System.out.println(Pattern.matches("\\S", "a"));
		System.out.println(Pattern.matches("\\w", "a"));//[a-zA-Z_0-9]
		System.out.println(Pattern.matches("\\W", "a"));
		System.out.println(Pattern.matches("^a\\d{4}f$", "a1234f"));
		System.out.println(Pattern.matches("ab?c", "abbc"));
		System.out.println(Pattern.matches("ab*c", "abbbbbbbc"));
		System.out.println(Pattern.matches("a\\d+c", "a12312312312c"));
		System.out.println(Pattern.matches("a\\d{3}c", "a123c"));
		System.out.println(Pattern.matches("a\\d{3,}c", "a12312312312c"));
        System.out.println(Pattern.matches("a\\d{3,5}c", "a123456c"));
    }
```



## 2.4 分组

​     有时候我们不仅仅判断字符串是否符合规则，还要获取这些匹配的字段数据。比如字符串`2021-01-06`符合日期的正则（`\d{4}-\d{2}-\d{2}`），但我们需要获取这个测试串的年份数据、月份数据跟日期数据，这个时候就需要使用分组功能了。

​	分组功能就是将需要获取的字段用括号括起来，使用`Matcher`的`group`方法就能获取对应的分组数据了。

**代码演示**

```java
   public static void main(String[] args) {
        String s = "2021-01-06";
		Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
		Matcher matcher = p.matcher(s);
//		使用find方法来匹配
		if(matcher.find()){
// 		matcher.group() 返回的是整个串的数据
			System.out.println(matcher.group());//2021-01-06
			// 分组：通过索引来获取第几组，索引为从左往右数第几个 (  
			System.out.println(matcher.group(0));//2021-01-06
			System.out.println(matcher.group(1));//2021
			System.out.println(matcher.group(2));//01
			System.out.println(matcher.group(3));//06
		}
    }
}
```



​		这里分组是通过索引来获取第几组，索引为从左往右数第几个 `(`  ，从0开始。还可以给每个分组取个别名，通过名称来获取对应字段的数据。

**代码演示**

```java
public static void main(String[] args) {
        String s = "2021-01-06";
		Pattern p = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
		Matcher matcher = p.matcher(s);
//		使用find方法来匹配
		if(matcher.find()){
// 		matcher.group() 返回的是整个串的数据
			System.out.println(matcher.group());//2021-01-06
			// 分组：通过分组别名获取对应字段数据值
			System.out.println(matcher.group("year"));//2021
			System.out.println(matcher.group("month"));//01
			System.out.println(matcher.group("day"));//06
		} 
    }
}
```

