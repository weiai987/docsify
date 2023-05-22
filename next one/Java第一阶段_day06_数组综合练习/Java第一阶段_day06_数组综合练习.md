# Java第一阶段_day06_数组综合练习

## 百里半在线点餐系统

## 学习目标

~~~Java
1、掌握控制台项目开发流程
2、了解项目所需流程
3、熟悉项目需实现功能
4、会使用顺序、选择、循环、跳转语句编写程序
5、会使用数组
6、Arrays简化数组操作
~~~

## 一、简介

使用百里半在线订餐系统，可以在网上进行订餐。

回忆实际生活中的点餐过程：

1. 选定一家餐厅
2. 查看菜单
3. 点餐
4. 坐等外卖员送餐
5. 签收
6. 自愿对订单

![image-20210322112431315](Java%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5_day06_%E6%95%B0%E7%BB%84%E7%BB%BC%E5%90%88%E7%BB%83%E4%B9%A0.assets/%E6%95%88%E6%9E%9C%E5%9B%BE1.png)

![image-20210322112448335](Java%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5_day06_%E6%95%B0%E7%BB%84%E7%BB%BC%E5%90%88%E7%BB%83%E4%B9%A0.assets/%E6%95%88%E6%9E%9C%E5%9B%BE2.png)

![image-20210322112526895](Java%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5_day06_%E6%95%B0%E7%BB%84%E7%BB%BC%E5%90%88%E7%BB%83%E4%B9%A0.assets/%E6%95%88%E6%9E%9C%E5%9B%BE3.png)

![image-20210322112606558](Java%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5_day06_%E6%95%B0%E7%BB%84%E7%BB%BC%E5%90%88%E7%BB%83%E4%B9%A0.assets/%E6%95%88%E6%9E%9C%E5%9B%BE4.png)



## 二、技术列表

- Java基础
- 数组
- Arrays简化数组



## 三、功能列表

![image-20210322100143529](Java%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5_day06_%E6%95%B0%E7%BB%84%E7%BB%BC%E5%90%88%E7%BB%83%E4%B9%A0.assets/%E5%8A%9F%E8%83%BD%E5%88%97%E8%A1%A8.png)

## 四、项目实战

### 4.1 初始化项目的功能菜单项

需求：打印在线点餐系统的功能菜单

分析：使用数组保存项目功能菜单项，好处：不用记忆功能菜单序号，易于项目拓展，提高代码可读性

核心代码：

~~~Java
System.out.println("**************************欢迎使用吃货联盟在线点餐系统**************************");
	String[] menus = { "我要订餐", "查看餐袋", "签收订单", "删除订单", "我要点赞", "退出系统" };
	for (int i = 0; i < menus.length; i++) {
		System.out.print((i + 1) + ". " + menus[i] + "\t");
	}

~~~

### 4.2 实现我要订餐

###### 4.2.1、需求：创建在线订餐需要的菜品列表（包括菜品名称、单价、点赞个数）

~~~Java
//1-1 打印菜单
	String[] dishMenus={"酸辣土豆丝","小炒肉","手撕鸡","红烧肉","青菜烧豆腐","鱼香肉丝","干煸豆角","焖面"};
 	//菜品单价
	double[] prices={18,24,38,45,22,28,25,24};
  	//每个菜对应的点赞个数
	int[] goods=new int[dishMenus.length];
	System.out.println("编号\t菜品\t单价\t点赞个数");
	for (int i = 0; i < dishMenus.length; i++) {				          
  	    System.out.print((i+1)+"\t"+dishMenus[i]+"\t"+prices[i]+"\t"+goods[i]+"\n");
	}

~~~

###### 4.2.2、用户选择菜品、份数、送餐时间并输入个人信息（包括姓名、电话、送餐地址），确认无误之后提交订单，实现订单保存

~~~Java
 	/**
	 * 订单中的菜品信息
	 */
	private static String[] dishes=new String[10];
	/**
	 * 订单中的份数
	 */
	private static int[] disheCounts=new int[10];
	/**
	 * 订单中的送餐时间
	 */
	private static String[] times=new String[10];
	/**
	 * 订单中的联系人姓名
	 */
	private static String[] names=new String[10];
	/**
	 * 订餐中的联系方式
	 */
	private static String[] phones=new String[10];
	/**
	 * 订单中的送餐地址
	 */
	private static String[] addresses=new String[10];
	//订单的签收状态

~~~

~~~Java
   //1-3 输出用户选择的菜单信息
	System.out.println("您的点餐信息如下：");
	System.out.println("菜品\t数量");
	System.out.println(dishMenus[dishMenuId-1]+"\t"+count);
	System.out.println("联系人姓名："+userName+",联系方式："+phone);
	System.out.println("送餐时间："+time+"，送餐地址："+address);
	System.out.println("确认下单请输入ok，否则输入其他表示取消下单！");
	String answer = input.nextLine();//保存用户输入的下单信号
	if(answer.equalsIgnoreCase("ok")){//下单，保存订单
		//保存用户输入的所有信息
		dishes[orderId]=dishMenus[dishMenuId-1];
		disheCounts[orderId]=count;
		times[orderId]=time;
		names[orderId]=userName;
		phones[orderId]=phone;
		addresses[orderId]=address;
		System.out.println("订单生成成功！订单编号是"+(orderId+1)+"请保存好订单编号，签收时需要使用该编号！");
		orderId++;//修改标识订单符号的值
		return;
	}

~~~

### 4.3 实现查看餐袋

需求：遍历系统中已有的订单，并逐条显示输出（注：仅遍历订餐人信息不为空的记录）

~~~Java
	System.out.println("****************查看餐袋****************");
	System.out.println("编号\t订餐人\t餐品信息\t送餐日期\t送餐地址\t联系方式\t订单状态\t总金额（单位：元）");
	for (int i = 0; i <names.length; i++) {
		if(names[i]==null){
			continue;
		}			System.out.println((i+1)+"\t"+names[i]+"\t"+dishes[i]+"\t"+times[i]+"\t"+addresses[i]+"\t"+phones[i]+"\t"+(orderStatus[i]==0?"未完成":"已完成")+"\t"+orderTotalMoney[i]);
	}

~~~



### 4.4 签收订单

需求：根据订单编号，将对应的状态修改为“已完成”

验证：1.输入订单编号必须存在的  2.客户的姓名不能是Null 3.输入订单编号已经是签收，就不能重复签收

实现步骤：

1. 输入订单编号
2. 输入姓名
3. 拿订单编号去订单数组里面找对应的客户姓名和订单状态，只有订单状态是“未完成”并且客户姓名和输入姓名匹配的情况下，才能执行订单签收。否则签收失败，并提示用户信息。

~~~Java
	if (orderNo < 0 || orderNo > orderSize) {// 订单编号不存在
		System.out.println("您输入的订单编号有误，签收失败！");
	} else {
	System.out.println("请输入您的姓名：");
   	// 2、输入姓名
	String name = input.nextLine();
	// 3、拿订单编号去订单数组里面找对应的客户姓名和订单状态，
	String tempName = names[orderNo - 1];// 订单数组中保存的客户名称
	byte status = orderStatus[orderNo - 1];// 订单状态
	// 只有订单状态是“未完成”并且客户姓名和输入姓名匹配的情况下，才能执行订单签收。否则签收失败，并提示用户信息
	if(tempName!=null){
		if (tempName.equals(name) && status == 0) {
			orderStatus[orderNo - 1] = 1;// 1：已完成
			System.out.println("订单签收成功！请进入查看餐袋查看结果！");
		} else {
			System.out.println("对不起，您的信息有误，签收失败！");
		}
	}else{
		System.out.println("您输入的信息有误，订单编号与姓名不符，签收失败！");
	}
}

~~~

### 4.5 删除订单

需求：按照输入的订单号，判断其状态，删除“已完成”状态的订单

实现思路：

1. 输入订单编号
2. 找到订单，判断订单状态是否为“已完成”，如果是“已完成”，执行删除，否则提示用户订单未完成
3. 为找到订单，提示用户信息

~~~java
//1、输入订单编号
	System.out.println("请输入要删除的订单编号");
	int orderId=Integer.parseInt(input.nextLine());
	//2、找到订单，判断订单状态是否为“已完成”，如果是已完成，执行删除，否则提示用户
	if(orderId>0 && orderId<orderSize){
		//获取订单状态，判断是否未已完成
		byte status=orderStatus[orderId-1];
		if(status==1){//已完成
			//将当前订单位置置空，让后面的元素往前移一位
     		for (int i = orderId; i < names.length; i++) {
				//所有与订单相关的数组都要进行往前移一位的操作
		   	 	Dishes[i-1]=dishes[i];
				disheCounts[i-1]=disheCounts[i];
				orderTotalMoney[i-1]=orderTotalMoney[i];
				times[i-1]=times[i];
				names[i-1]=names[i];
				phones[i-1]=phones[i];
				addresses[i-1]=addresses[i];
				orderStatus[i-1]=orderStatus[i];
                
			}
			System.out.println("订单编号为："+orderId+"的订单删除成功。可以通过查看餐袋查看删除结果！");
		}else{
			System.out.println("订单尚未完成，不能删除！删除订单失败！");
		}
	}else{
		//3、未找到订单，提示用户信息
  		System.out.println("您输入的订单编号不存在！订单删除失败！");
	}

~~~



### 4.6 我要点赞

需求：显示菜品序号、菜品名、单价、点赞数

​			提示用户输入要点赞的菜品序号

实现思路：

1. 打印菜品列表
2. 选择要点赞的菜品编号
3. 判断菜品是否存在，存在就在当前菜品的点赞数+1
4. 菜品不存在，提示用户输入有误

~~~Java
	//1、打印菜品列表
	System.out.println("编号\t菜品\t单价（单位：元）\t点赞个数（单位：个）");
	for (int i = 0; i < dishMenus.length; i++) {
		System.out.print((i + 1) + "\t" + dishMenus[i] + "\t" + prices[i] + "\t" + goods[i] + "\n");	}
	// 2-1 点赞菜品编号
	System.out.println("请输入您要选择的菜品编号（比如小炒肉输入2即可）：");
	//2-2、选择要点赞的菜品编号
	int goodMenuId = Integer.parseInt(input.nextLine());		
	//3、判断菜品是否存在，存在就在当前菜品的点赞数+~~
	if(goodMenuId>0 && goodMenuId<dishMenus.length){
		goods[goodMenuId-1]+=1;
		System.out.println("点赞成功！当前菜品赞"+goods[goodMenuId-1]+"个");
	}else{
		//4、菜品不存在，提示用户输入有误！
		System.out.println("您选择的菜品不存在！点赞失败");}
~~~

### 4.7 退出系统

~~~Java
	//退出系统
	flag = true;
	break;
~~~

