# 学习目标

- 理解Oracle相关概念
- 掌握Oracle服务器的安装
- 掌握Orace客户端的安装
- 掌握监听器及本地网络服务名配置
- 掌握Oracle实例的操作
- 掌握Oracle表空间的操作
- 掌握Oracle用户的操作
- 掌握Oracle表的操作

# 1. Oracle数据库相关概念

## 1.1 Oracle数据库简介

​		Oracle Database，又名Oracle RDBMS，或简称Oracle。是甲骨文公司的一款关系数据库管理系统。它是在数据库领域一直处于领先地位的产品。可以说Oracle数据库系统是目前世界上流行的关系数据库管理系统，是目前最流行的C/S或B/S体系结构的数据库之一，它具有系统可移植性好、使用方便、功能强，适用于各类大、中、小、微机环境。它是一种高效率、可靠性好的 适应高吞吐量的数据库解决方案。oracle目前是世界上使用最为广泛的数据库管理系统，作为一个通用的数据库系统，它具有完整的数据管理功能；作为一个关系型数据库，它是一个完备关系的产品；作为分布式数据库它实现了分布式处理功能。

​		**Oracle与Mysql的区别**

​		Oracle收费，价格很贵，单机性能高；mysql 免费，开源，单机性能比Oracle差

​		一般大公司用Oracle，小公司或要求不高的用Mysql

​		互联网公司用Mysql，因为在互联网项目中，一定会集群，Oracle单体性能再强也显无力；再则Oracle收费贵，不开源，所以直接用Mysql反而更省心。

## 1.2 Oracle数据库：database

​		oracle数据库是数据的物理存储。包括数据文件ORA或者DBF，控制文件，联机文件，日志文件，参数文件。oracle数据库的概念和其他数据库概念有些不一样，比如mysql，mysql数据库创建数据库的过程是--创建库--创建表，而oracle创建数据库的过程是--创建一个表空间--创建一个用户--由用户去创建表。所以oracle数据库和其他数据库是有不同之处的。可以这样理解，oracle是只有一个数据库，是一个大的数据库，由用户来管理的。 

​		注意与Mysql中的数据库区分开来。

## 1.3 Oracle实例

​		一个oracle的实例由一系列的后台进程和内存结构组成。

​		**其实就是用来访问和使用数据库的一块进程，它只存在于内存中。就像Java中new出来的实例对象一样。**  

​		我们访问Oracle都是访问一个实例，但这个实例如果关联了数据库文件，就是可以访问的，如果没有，就会得到实例不可用的错误。  

​		实例名指的是用于响应某个数据库操作的数据库管理系统的名称。她同时也叫SID。实例名是由参数instance_name决定的。 

​		查询当前数据库实例名： 

```sql
select instance_name from v$instance;
```

​		数据库实例名(instance_name)用于对外部连接。在操作系统中要取得与数据库的联系，必须使用数据库实例名。比如我们作开发，要连接数据库，就得连接数据库实例名： 

```
jdbc:oracle:thin:@localhost:1521:orcl（orcl就为数据库实例名）
```

​		一个数据库可以有多个实例，在作数据库服务集群的时候可以用到。 

## 1.4 表空间

​		Oracle数据库是通过表空间来存储物理表的，**一个数据库实例可以有N个表空间，一个表空间下可以有N张表**。 

​		有了数据库，就可以创建表空间。 

​		**表空间(tablespace)是数据库的逻辑划分，每个数据库至少有一个表空间（称作SYSTEM表空间）**。为了便于管理和提高运行效率，可以使用一些附加表空间来划分用户和应用程序。例如：USER表空间供一般用户使用，RBS表空间供回滚段使用。一个表空间只能属于一个数据库。 

## 1.5 用户

​		Oracle数据库建好后，要想在数据库里建表，必须先为数据库建立用户，并为用户指定表空间。

​		用户是在实例下建立的。不同实例中可以建相同名字的用户。表的数据，是由用户放入某一个表空间的，而这个表空间会随机把这些表数据放到一个或多个数据文件DBF中。

​		oracle是由用户和表空间对数据进行管理和存储的。但是表数据不是由表空间去查询的，而是由用户去查询的。因为不同用户可以在同一个表空间建立相同名字的表。

## 1.6 表

 有了数据库，表空间和用户，就可以用自定义的用户在自己的表空间创建表了。 

# 2. Oracle安装

## 2.1 Oracle安装

将Oracle11g的两个安装文件下载到本地后，分别解压到同一个目录，例如database，如下图所示

![1611842545417](01_Oracle_day01.assets/1611842545417.png) 

进入到database目录，双击setup.exe进行安装。

![1611842581568](01_Oracle_day01.assets/1611842581568.png) 

取消勾选，不接收安全更新，点击下一步。

![1611842684840](01_Oracle_day01.assets/1611842684840.png) 

  此时会提示未指定电子邮件地址，点击是。

![1611842798145](01_Oracle_day01.assets/1611842798145.png)

 选择创建和配置数据库

![1611842831626](01_Oracle_day01.assets/1611842831626.png) 

选择桌面类

![1611842859578](01_Oracle_day01.assets/1611842859578.png)

修改字符集为UTF8，输入两次管理员密码，此处直接输入密码为123

![1611842947929](01_Oracle_day01.assets/1611842947929.png)

因为密码不符合建议，所以会弹出警告提示，点击是，忽略警告。

![1611843000026](01_Oracle_day01.assets/1611843000026.png)

等待检查完成。

![1611843066554](01_Oracle_day01.assets/1611843066554.png)

如果出现PATH异常，点击右上角全部忽略，点击下一步继续

![1611844199027](01_Oracle_day01.assets/1611844199027.png)

点击完成。

![1611844235074](01_Oracle_day01.assets/1611844235074.png) 

出现下面窗口时，表示安装即将完成，点击确定。

![1611845143490](01_Oracle_day01.assets/1611845143490.png) 

至此，Oracle安装完毕，点击关闭即可。

![1611845178939](01_Oracle_day01.assets/1611845178939.png)

## 2.2 测试Oracle

打开开始菜单，找到Oracle目录，打开SQL Plus

![1611846706154](01_Oracle_day01.assets/1611846706154.png) 

在弹出的窗口中输入用户名和密码：system/123

默认管理员账号是system，密码是安装时设置的密码。

如果出现下图，表示连接成功，说明Oracle安装成功

![1611846766555](01_Oracle_day01.assets/1611846766555.png) 

## 2.3 客户端工具PL/SQL安装

运行已经下载好的plsqldev1302x64.msi

![1611846160395](01_Oracle_day01.assets/1611846160395.png) 

点击next

![1611846205019](01_Oracle_day01.assets/1611846205019.png) 

选择i accept the terms in the license agreement，点击next

![1611846230778](01_Oracle_day01.assets/1611846230778.png) 

默认，点击next

![1611846348938](01_Oracle_day01.assets/1611846348938.png) 

默认，点击next

![1611846368842](01_Oracle_day01.assets/1611846368842.png) 

点击install

![1611846380282](01_Oracle_day01.assets/1611846380282.png) 

等待安装完毕即可

![1611846438218](01_Oracle_day01.assets/1611846438218.png) 



## 2.4 测试PL/SQL

运行PL/SQL

![1612071763166](01_Oracle_day01.assets/1612071763166.png) 

输入用户名，密码，Database选择ORCL，点击OK进行登录。

![1612071791886](01_Oracle_day01.assets/1612071791886.png) 

登录成功后，会进到首页，首页中间上方会显示当前登录的用户和数据库实例：system@orcl，就表示登录成功。如果账号密码错误三次，也会进入首页，但中间正上方不会有账号和数据库实例名称。

![1612071867049](01_Oracle_day01.assets/1612071867049.png)  

# 3. 配置监听器及本地网络服务名

## 3.1 本机连接

默认情况下，Oracle允许本机连接，而不允许远程连接，这里我们可以使用下面这种方式来登录Oracle。

`Database的写法是：ip:port/数据库实例`

![1612072065980](01_Oracle_day01.assets/1612072065980.png) 

可以看到是可以登录的。

![1612072200643](01_Oracle_day01.assets/1612072200643.png)  

## 3.2 远程连接

但是如果使用局域网ip来访问的话，就无法登录，下面显示局域网登录方式。

打开cmd，键入ipconfig可以查看本机ip。

```powershell
ipconfig
```

![1612072297724](01_Oracle_day01.assets/1612072297724.png) 

在PL/SQL中输入用户名和密码，Database输入：192.168.0.102:1521/oracl，注意分号要用英文的。

```plsql
192.168.0.102:1521/oracl
```

![1612072410233](01_Oracle_day01.assets/1612072410233.png) 

于是，你会得到下面提示，因为默认情况下Oracle并未开始远程访问，或者说没有监听程序在监听这个ip和端口。如果要开启远程访问，我们就要配置Oracle的监听器了。

![1612072516551](01_Oracle_day01.assets/1612072516551.png) 

## 3.3 配置监听器

打开开始菜单，找到Oracle目录，在配置和移植工具中找到Net manager，运行。

![1612072625527](01_Oracle_day01.assets/1612072625527.png) 

打开后显示下面界面

![1612072692064](01_Oracle_day01.assets/1612072692064.png) 

打开服务命名，找到数据库实例orcl，将连接类型从“专用服务器”改为“共享服务器”。

![1612072930656](01_Oracle_day01.assets/1612072930656.png) 

同时，点击下方的绿色加号，添加一个地址

```
协议：TCP/IP
主机名：192.168.0.102
端口号：1521
```

![1612073010908](01_Oracle_day01.assets/1612073010908.png) 

点击左侧的监听程序，点击下方的添加地址，输入下面网络地址：

```
协议：TCP/IP
主机名：192.168.0.102
端口号：1521
```

![1612073122271](01_Oracle_day01.assets/1612073122271.png) 

点击文件，选择保存网络配置。

![1612073210070](01_Oracle_day01.assets/1612073210070.png) 

打开系统服务，找到监听服务，重启（修改了监听配置后一定要重启监听服务才会生效）

![1612073246442](01_Oracle_day01.assets/1612073246442.png) 

继续测试远程连接

![1612073324720](01_Oracle_day01.assets/1612073324720.png) 

可以看到已经可以成功登录了。（局域网内其他人就可以通过192.168.0.102这个地址来访问你的Oracle了）

![1612073344845](01_Oracle_day01.assets/1612073344845.png) 

## 3.4 注意事项

如果重启监听服务器登录出现下方这个提示，不用慌张，等个半分钟左右即可，主要是监听程序还没完成重启完成。

![1612073427567](01_Oracle_day01.assets/1612073427567.png) 

## 3.5 本地网络服务名配置

打开开始菜单，找到Oracle目录，在配置和移植工具中找到Net Configuration Assistant，运行。

![1612073568994](01_Oracle_day01.assets/1612073568994.png) 

出现下方界面后，选择本地网络服务名配置，点击下一步。

![1612073641529](01_Oracle_day01.assets/1612073641529.png) 

可以看到有添加、重新配置、删除、重命名、测试等功能。

假设要重命名，选择重命名。

![1612073665761](01_Oracle_day01.assets/1612073665761.png) 

选择要修改的网络服务名，这里我们选择ORCL，下一步。

![1612073752450](01_Oracle_day01.assets/1612073752450.png) 

将名称修改为：ORCL1。

![1612073785546](01_Oracle_day01.assets/1612073785546.png) 

提示已修改

![1612073820602](01_Oracle_day01.assets/1612073820602.png) 

下一步

![1612073839193](01_Oracle_day01.assets/1612073839193.png) 

点击完成。

![1612073856035](01_Oracle_day01.assets/1612073856035.png) 

重启PL/SQL，在Database处下拉，可以看到已经从ORCL改成了ORCL1

![1612073912624](01_Oracle_day01.assets/1612073912624.png) 

# 4. Oracle核心

## 4.1 Oracle数据库实例

​		Oracle中的实例就是一个进程和服务，类似Mysql中的新建数据库，因为Oracle这边数据库只有一个，而实例确可以有多个，所有的操作都是以实例的方式来操作。所以可以理解为Oracle中新建数据库实例就是Mysql的新建数据库。

### 4.1.1 新建Oracle实例

在开始菜单中，找到Oracle目录，找到配置和移植工具，找到Database Configuration Assistant，运行。

![1612074581311](01_Oracle_day01.assets/1612074581311.png) 
下一步

![1612074667531](01_Oracle_day01.assets/1612074667531.png) 

选择创建数据库

![1612074685647](01_Oracle_day01.assets/1612074685647.png) 

选择一般用途

![1612074713890](01_Oracle_day01.assets/1612074713890.png) 

输入数据库名称：test

![1612074739092](01_Oracle_day01.assets/1612074739092.png) 

下一步

![1612074760602](01_Oracle_day01.assets/1612074760602.png) 

为了方便，这里选择所有账号使用同一管理口令（生产环境不建议这么操作）

![1612074777581](01_Oracle_day01.assets/1612074777581.png) 

提示字符太少警告，点击是，不予理会。

![1612074828135](01_Oracle_day01.assets/1612074828135.png) 

下一步

![1612074854798](01_Oracle_day01.assets/1612074854798.png) 

下一步

![1612074871625](01_Oracle_day01.assets/1612074871625.png) 

下一步

![1612074894681](01_Oracle_day01.assets/1612074894681.png) 

选择字符集，改为UTF8

![1612074943801](01_Oracle_day01.assets/1612074943801.png) 

下一步

![1612074973359](01_Oracle_day01.assets/1612074973359.png) 

完成。

![1612074987360](01_Oracle_day01.assets/1612074987360.png) 

确定

![1612075006980](01_Oracle_day01.assets/1612075006980.png) 

此时，Oracle已经开始新建数据库了，等待完成即可。

![1612075031324](01_Oracle_day01.assets/1612075031324.png) 

安装完成后，打开系统服务，可以看到多出了一个test服务，表明实例创建成功。

![1612075628444](01_Oracle_day01.assets/1612075628444.png) 

重启PL/SQL可以看到已经有TEST选项了

![1612075676972](01_Oracle_day01.assets/1612075676972.png)  

### 4.1.2 练习

使用Database Configuration Assistant对数据库实例进行修改和删除，并测试使用PL/SQL连接

## 4.2 表空间

​		前面已经提到，表空间是用来存储表的，是逻辑与物理并存的概念。**一个Oracle数据库可以有多个数据库实例，一个数据库实例下可以有多个表空间，而一个表空间下也可以多个表空间文件**

打开PL/SQL，找到Tablespaces，可以看到原有的表空间。

![1612076592255](01_Oracle_day01.assets/1612076592255.png) 

**表空间分为普通表空间和临时表空间**

### 4.2.1 普通表空间（简称表空间）

普通表空间（后面称为表空间），用于存储数据库表数据。

#### 4.2.1.1 新建表空间

在PL/SQL中，点击左上角的新建窗口，打开一个SQL window

![1612076783028](01_Oracle_day01.assets/1612076783028.png) 

输入表空间创建语句

![1612076943190](01_Oracle_day01.assets/1612076943190.png) 

```sql
-- 新建表空间
-- 语法：create tablespace 表空间名称 datafile '表空间文件存放路径' size 文件大小 autoextend on Next 每次自动扩容大小 Maxsize 最大空间;
create tablespace tablespace01 datafile 'D:\app\hh\oradata\orcl\tablespace01' size 20M Autoextend on Next 5M Maxsize 50M;
```

点击上方的绿色三角形运行该语句

![1612076999395](01_Oracle_day01.assets/1612076999395.png) 

在下方可以看到执行的时间信息

![1612077062045](01_Oracle_day01.assets/1612077062045.png) 

执行成功后，打开表空间文件所在目录，可以看到表空间文件已经被创建出来了，大小是20M。

![1612077204500](01_Oracle_day01.assets/1612077204500.png) 

#### 4.2.1.2 添加表空间文件

一个表空间可以有多个表空间文件，所以可以给表空间添加文件，使用下面命令

```sql
-- 添加表空间文件
-- 语法：Alter tablespace 表空间名称 Add datafile '表空间文件存放路径' Size 文件大小 autoextend on Next 每次自动扩容大小 Maxsize 最大空间;
Alter tablespace tablespace01 Add datafile 'D:\app\hh\oradata\orcl\tablespace01_1' Size 20M Autoextend on Next 5M Maxsize 50M;
```

![1612077336514](01_Oracle_day01.assets/1612077336514.png) 

打开文件目录，可以看到添加的文件已经创建出来了，大小20M

![1612077465826](01_Oracle_day01.assets/1612077465826.png)

#### 4.2.1.3 修改表空间文件大小

```sql
-- 更改数据文件大小：
-- 语法：Alter database datafile '表空间文件存放路径' Resize 大小
Alter database datafile 'D:\app\hh\oradata\orcl\tablespace01' Resize 50M
```

#### 4.2.1.4 查看表空间

```sql
-- 查看表空间
select * from user_tablespaces;
```

![1612077751890](01_Oracle_day01.assets/1612077751890.png) 

#### 4.2.1.5 删除表空间

```
-- 删除表空间（删除内容和文件）
-- 语法：Drop tablespace 表空间名称 
-- Including contents and datafile 表示删除内容和文件，不加这段代码表示只删除表空间，内容和文件还在
Drop tablespace tablespace01 Including contents and datafiles;
```

可以看到tablespace01表空间已经不存在了

![1612077856655](01_Oracle_day01.assets/1612077856655.png) 

### 4.2.2 临时表空间

临时表空间，用于存储临时数据，比如排序、分组、临时表等数据就可能存放在临时表空间中。

#### 4.2.2.1 创建临时表空间

```sql
-- 创建临时表空间
Create temporary tablespace tablespace_01_temp Tempfile 'D:\app\hh\oradata\orcl\tablespace_01_temp.dbf' Size 5M Autoextend on Next 3M Maxsize 10M;
```

![1612078634712](01_Oracle_day01.assets/1612078634712.png) 

#### 4.2.2.2 添加临时表空间文件

```sql
-- 添加临时表空间文件
Alter tablespace tablespace_01_temp Add tempfile 'D:\app\hh\oradata\orcl\tablespace_01_temp_1.dbf' Size 5M;
```

![1612078769423](01_Oracle_day01.assets/1612078769423.png) 

#### 4.2.2.3 修改临时表空间大小

```sql
-- 修改临时表空间大小
Alter database Tempfile 'D:\app\hh\oradata\orcl\tablespace_01_temp.dbf' Resize 4M;
```

![1612078950154](01_Oracle_day01.assets/1612078950154.png) 

#### 4.2.2.4 查看临时表空间

同查看表空间一样

#### 4.2.2.5 删除临时表空间

同删除表空间一样

## 4.3 用户

​		Oracle中的表只能由用户来操作，而不同用户可以在同一表空间下创建相同名称的表。可以理解为，表空间下有用户，用户下再有表。

### 4.3.1 新建用户

打开PL/SQL，找到Users文件夹，右击New...

![1612079173014](01_Oracle_day01.assets/1612079173014.png) 

输入用户名、密码，选择刚才的表空间和临时表空间，然后点击Apply，创建该用户。

![1612079418101](01_Oracle_day01.assets/1612079418101.png) 

此时创建出来的用户是没有权限的，我们可以通过Role privileges标签页给该用户添加权限

![1612079650058](01_Oracle_day01.assets/1612079650058.png) 

- connect : 基本操作表的权限，比如增删改查、视图创建等 
- resource： 创建一些函数，比如簇、索引，创建表、列等 
- dba : 相当于管理员权限，拥有系统所有权限  

### 4.3.2 用户的其它操作

![1612079860383](01_Oracle_day01.assets/1612079860383.png) 

### 4.3.3 命令方式操作用户

```sql
-- 创建用户
CREATE USER test1 IDENTIFIED BY 123 DEFAULT TABLESPACE tablespace01 TEMPORARY TABLESPACE tablespace_01_temp;

-- 查看所有用户
select * from dba_users;

-- 修改密码
alter user test1 IDENTIFIED by 123456

-- 删除用户
drop user test1;

-- 授权
grant dba to HUHAO;
```

## 4.4 表

表是Oracle用来存储数据的真正单位，类似Excel中的表格。

**注意，表是跟用户关联的，所以创建表要想好当前是哪个用户**

**切换huahao账号进行登录**

### 4.4.1 新建表

语法

```sql
CREATE TABLE 表名(
  字段名 数据类型 [[CONSTRAINT 约束名] 约束][DEFAULT 默认值],
  字段名 数据类型 [[CONSTRAINT 约束名] 约束][DEFAULT 默认值],
  ...
  字段名 数据类型 [[CONSTRAINT 约束名] 约束][DEFAULT 默认值]
)
```

案例

```sql
create table t_emp(
  id number(6) primary key,
  username varchar(255) not null,
  password varchar(255) not null
)
```

![1612081054545](01_Oracle_day01.assets/1612081054545.png) 

### 4.4.2 修改表

```sql
-- 修改表名
rename t_emp to s_emp;
-- 修改字段属性
alter table s_emp modify(username varchar(50));
-- 修改字段名
alter table s_emp rename column username to user_name;
-- 添加字段
alter table s_emp add (age number(11));
-- 修改字段
alter table s_emp modify (age number(4));
-- 删除字段
alter table s_emp drop column age;
```

### 4.4.3 查询表

```sql
-- 查询HUAHAO下的表
select * from all_tables where owner='HUAHAO';
```

### 4.4.4 删除表

```sql
-- 删除表
drop table s_emp;
```