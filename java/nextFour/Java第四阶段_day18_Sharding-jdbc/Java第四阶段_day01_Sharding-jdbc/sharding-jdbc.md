 

#                  Sharding-JDBC分库分表

# **1.** 概述

## **1.1.** 分库分表是什么

小明是一家初创电商平台的开发人员，他负责卖家模块的功能开发，其中涉及了店铺、商品的相关业务，设计如下 数据库：

 

  ![img](img\wps3.png)



通过以下SQL能够获取到商品相关的店铺信息、地理区域信息：

~~~sql
SELECT p.*,r.[地理区域名称],s.[店铺名称],s.[信誉] FROM [商品信息] p
LEFT JOIN [地理区域] r ON p.[产地] = r.[地理区域编码] LEFT JOIN [店铺信息] s ON p.id = s.[所属店铺]
WHERE p.id = ?
~~~

形成类似以下列表展示：



 

![img](img\wps5.png) 

 

 

随着公司业务快速发展，数据库中的数据量猛增，访问性能也变慢了，优化迫在眉睫。分析一下问题出现在哪儿 呢？ 关系型数据库本身比较容易成为系统瓶颈，单机存储容量、连接数、处理能力都有限。当单表的数据量达到1000W或100G以后，由于查询维度较多，即使添加从库、优化索引，做很多操作时性能仍下降严重。

方案1：

通过提升服务器硬件能力来提高数据处理能力，比如增加存储容量   、CPU等，这种方案成本很高，并且如果瓶颈在

MySQL本身那么提高硬件也是有很的。

方案2：

把数据分散在不同的数据库中，使得单一数据库的数据量变小来缓解单一数据库的性能问题，从而达到提升数据库 性能的目的，如下图：将电商数据库拆分为若干独立的数据库，并且对于大表也拆分为若干小表，通过这种数据库 拆分的方法来解决数据库的性能问题。



 

![img](img\wps6.png) 

 

分库分表就是为了解决由于数据量过大而导致数据库性能降低的问题，将原来独立的数据库拆分成若干数据库组成

，将数据大表拆分成若干数据表组成，使得单一数据库、单一数据表的数据量变小，从而达到提升数据库性能的目 的。

 

## **1.2.** 分库分表的方式

分库分表包括分库和分表两个部分，在生产中通常包括：垂直分库、水平分库、垂直分表、水平分表四种方式。

### **1.2.1.** 垂直分表

下边通过一个商品查询的案例讲解垂直分表：

通常在商品列表中是不显示商品详情信息的，如下图：



 

![img](img\wps7.png) 

 

用户在浏览商品列表时，只有对某商品感兴趣时才会查看该商品的详细描述。因此，商品信息中商品描述字段访问 频次较低，且该字段存储占用空间较大，访问单个数据IO时间较长；商品信息中商品名称、商品图片、商品价格等 其他字段数据访问频次较高。

由于这两种数据的特性不一样，因此他考虑将商品信息表拆分如下：

将访问频次低的商品描述信息单独存放在一张表中，访问频次较高的商品基本信息单独放在一张表中。

  ![img](img\wps8.png)

 

商品列表可采用以下sql：

~~~sql
SELECT p.*,r.[地理区域名称],s.[店铺名称],s.[信誉] FROM [商品信息] p
LEFT JOIN [地理区域] r ON p.[产地] = r.[地理区域编码] LEFT JOIN [店铺信息] s ON p.id = s.[所属店铺]
WHERE...ORDER BY...LIMIT...
~~~

 

需要获取商品描述时，再通过以下sql获取：

~~~sql
SELECT *
FROM [商品描述] WHERE [商品ID] = ?
~~~



小明进行的这一步优化，就叫垂直分表。

垂直分表定义：将一个表按照字段分成多表，每个表存储其中一部分字段。

 

它带来的提升是：

1. 为了避免IO争抢并减少锁表的几率，查看详情的用户与商品信息浏览互不影响

2. 充分发挥热门数据的操作效率，商品信息的操作的高效率不会被商品描述的低效率所拖累。

一般来说，某业务实体中的各个数据项的访问频次是不一样的，部分数据项可能是占用存储空间比较大的BLOB或  是TEXT。例如上例中的商品描述。所以，当表数据量很大时，可以将表按字段切开，将热门字段、冷门字段分开放 置在不同库中，这些库可以放在不同的存储设备上，避免IO争抢。垂直切分带来的性能提升主要集中在热门数据的 操作效率上，而且磁盘争用情况减少。

通常我们按以下原则进行垂直拆分:

1. 把不常用的字段单独放在一张表;

2. 把text，blob等大字段拆分出来放在附表中;

3. 经常组合查询的列放在一张表中;

 

### **1.2.2.** 垂直分库

通过垂直分表性能得到了一定程度的提升，但是还没有达到要求，并且磁盘空间也快不够了，因为数据还是始终限 制在一台服务器，库内垂直分表只解决了单一表数据量过大的问题，但没有将表分布到不同的服务器上，因此每个 表还是竞争同一个物理机的CPU、内存、网络IO、磁盘。

经过思考，他把原有的SELLER_DB(卖家库)，分为了PRODUCT_DB(商品库)和STORE_DB(店铺库)，并把这两个库分 散到不同服务器，如下图：



 

![img](img\wps11.png) 

 

由于商品信息与商品描述业务耦合度较高，因此一起被存放在PRODUCT_DB(商品库)；而店铺信息相对独立，因此 单独被存放在STORE_DB(店铺库)。

小明进行的这一步优化，就叫垂直分库。

垂直分库是指按照业务将表进行分类，分布到不同的数据库上面，每个库可以放在不同的服务器上，它的核心理念 是专库专用。

它带来的提升是：

![img](img\wps12.png)解决业务层面的耦合，业务清晰

![img](img\wps13.png)能对不同业务的数据进行分级管理、维护、监控、扩展等

![img](img\wps14.png)高并发场景下，垂直分库一定程度的提升IO、数据库连接数、降低单机硬件资源的瓶颈

垂直分库通过将表按业务分类，然后分布在不同数据库，并且可以将这些数据库部署在不同服务器上，从而达到多 个服务器共同分摊压力的效果，但是依然没有解决单表数据量过大的问题。

 

### **1.2.3.** 水平分库

经过垂直分库后，数据库性能问题得到一定程度的解决，但是随着业务量的增长，PRODUCT_DB(商品库)单库存储 数据已经超出预估。粗略估计，目前有8w店铺，每个店铺平均150个不同规格的商品，再算上增长，那商品数量得 往1500w+上预估，并且PRODUCT_DB(商品库)属于访问非常频繁的资源，单台服务器已经无法支撑。此时该如何 优化？

再次分库？但是从业务角度分析，目前情况已经无法再次垂直分库。

尝试水平分库，将店铺ID为单数的和店铺ID为双数的商品信息分别放在两个库中。



 

![img](img\wps15.png) 



也就是说，要操作某条数据，先分析这条数据所属的店铺ID。如果店铺ID为双数，将此操作映射至 RRODUCT_DB1(商品库1)；如果店铺ID为单数，将操作映射至RRODUCT_DB2(商品库2)。此操作要访问数据库名称的表达式为RRODUCT_DB[店铺ID%2 + 1] 。

小明进行的这一步优化，就叫水平分库。

水平分库是把同一个表的数据按一定规则拆到不同的数据库中，每个库可以放在不同的服务器上。

 

它带来的提升是：

![img](img\wps17.png)解决了单库大数据，高并发的性能瓶颈。提高了系统的稳定性及可用性。

 

当一个应用难以再细粒度的垂直切分，或切分后数据量行数巨大，存在单库读写、存储性能瓶颈，这时候就需要进 行水平分库了，经过水平切分的优化，往往能解决单库存储量及性能瓶颈。但由于同一个表被分配在不同的数据   库，需要额外进行数据操作的路由工作，因此大大提升了系统复杂度。

 

 

### **1.2.4.** 水平分表

按照水平分库的思路对他把PRODUCT_DB_X(商品库)内的表也可以进行水平拆分，其目的也是为解决单表数据量大 的问题，如下图：



 

![img](img\wps18.png) 

 

与水平分库的思路类似，不过这次操作的目标是表，商品信息及商品描述被分成了两套表。如果商品ID为双数，将 此操作映射至商品信息1表；如果商品ID为单数，将操作映射至商品信息2表。此操作要访问表名称的表达式为商品 信息[商品ID%2 + 1] 。

小明进行的这一步优化，就叫水平分表。

水平分表是在同一个数据库内，把同一个表的数据按一定规则拆到多个表中。它带来的提升是：

![img](img\wps19.png)![img](img\wps20.png)优化单一表数据量过大而产生的性能问题避免IO争抢并减少锁表的几率

库内的水平分表，解决了单一表数据量过大的问题，分出来的小表中只包含一部分数据，从而使得单个表的数据量 变小，提高检索性能。

### 1.2.5 小结

本章介绍了分库分表的各种方式，它们分别是垂直分表、垂直分库、水平分库和水平分表：

垂直分表：可以把一个宽表的字段按访问频次、是否是大字段的原则拆分为多个表，这样既能使业务清晰，还能提 升部分性能。拆分后，尽量从业务角度避免联查，否则性能方面将得不偿失。

垂直分库：可以把多个表按业务耦合松紧归类，分别存放在不同的库，这些库可以分布在不同服务器，从而使访问 压力被多服务器负载，大大提升性能，同时能提高整体架构的业务清晰度，不同的业务库可根据自身情况定制优化 方案。但是它需要解决跨库带来的所有复杂问题。

水平分库：可以把一个表的数据(按数据行)分到多个不同的库，每个库只有这个表的部分数据，这些库可以分布在 不同服务器，从而使访问压力被多服务器负载，大大提升性能。它不仅需要解决跨库带来的所有复杂问题，还要解 决数据路由的问题(数据路由问题后边介绍)。

水平分表：可以把一个表的数据(按数据行)分到多个同一个数据库的多张表中，每个表只有这个表的部分数据，这 样做能小幅提升性能，它仅仅作为水平分库的一个补充优化。

一般来说，在系统设计阶段就应该根据业务耦合松紧来确定垂直分库，垂直分表方案，在数据量及访问压力不是特 别大的情况，首先考虑缓存、读写分离、索引技术等方案。若数据量极大，且持续增长，再考虑水平分库水平分表 方案。

 

## **1.3.** 分库分表带来的问题

分库分表能有效的缓解了单机和单库带来的性能瓶颈和压力，突破网络IO、硬件资源、连接数的瓶颈，同时也带来 了一些问题。

### **1.3.1.** 事务一致性问题

由于分库分表把数据分布在不同库甚至不同服务器，不可避免会带来分布式事务问题。

### **1.3.2.** 跨节点关联查询

在没有分库前，我们检索商品时可以通过以下SQL对店铺信息进行关联查询：

~~~sql
SELECT p.*,r.[地理区域名称],s.[店铺名称],s.[信誉] FROM [商品信息] p
LEFT JOIN [地理区域] r ON p.[产地] = r.[地理区域编码] LEFT JOIN [店铺信息] s ON p.id = s.[所属店铺]
WHERE...ORDER BY...LIMIT...
~~~

但垂直分库后[商品信息]和[店铺信息]不在一个数据库，甚至不在一台服务器，无法进行关联查询。

可将原关联查询分为两次查询，第一次查询的结果集中找出关联数据id，然后根据id发起第二次请求得到关联数 据，最后将获得到的数据进行拼装。

### **1.3.3.** 跨节点分页、排序函数

跨节点多库进行查询时，limit分页、order by排序等问题，就变得比较复杂了。需要先在不同的分片节点中将数据进行排序并返回，然后将不同分片返回的结果集进行汇总和再次排序。

如，进行水平分库后的商品库，按ID倒序排序分页，取第一页：

![img](img\wps22.jpg) 

 

以上流程是取第一页的数据，性能影响不大，但由于商品信息的分布在各数据库的数据可能是随机的，如果是取第 N页，需要将所有节点前N页数据都取出来合并，再进行整体的排序，操作效率可想而知。所以请求页数越大，系 统的性能也会越差。

在使用Max、Min、Sum、Count之类的函数进行计算的时候，与排序分页同理，也需要先在每个分片上执行相应 的函数，然后将各个分片的结果集进行汇总和再次计算，最终将结果返回。

 

### **1.3.4.** 主键避重

在分库分表环境中，由于表中数据同时存在不同数据库中，主键值平时使用的自增长将无用武之地，某个分区数据 库生成的ID无法保证全局唯一。因此需要单独设计全局主键，以避免跨库主键重复问题。

 

![img](img\wps23.jpg) 

### **1.3.5.** 公共表

实际的应用场景中，参数表、数据字典表等都是数据量较小，变动少，而且属于高频联合查询的依赖表。例子中地 理区域表也属于此类型。

可以将这类表在每个数据库都保存一份，所有对公共表的更新操作都同时发送到所有分库执行。

由于分库分表之后，数据被分散在不同的数据库、服务器。因此，对数据的操作也就无法通过常规方式完成，并且 它还带来了一系列的问题。好在，这些问题不是所有都需要我们在应用层面上解决，市面上有很多中间件可供我们 选择，其中Sharding-JDBC使用流行度较高，我们来了解一下它。

 

## **1.4** Sharding-JDBC介绍

### **1.4.1** Sharding-JDBC介绍

Sharding-JDBC是当当网研发的开源分布式数据库中间件，从 3.0 开始Sharding-JDBC被包含在 Sharding-Sphere

中，之后该项目进入进入Apache孵化器，4.0版本之后的版本为Apache版本。

ShardingSphere是一套开源的分布式数据库中间件解决方案组成的生态圈，它由Sharding-JDBC、Sharding- Proxy和Sharding-Sidecar（计划中）这3款相互独立的产品组成。 他们均提供标准化的数据分片、分布式事务和数据库治理功能，可适用于如Java同构、异构语言、容器、云原生等各种多样化的应用场景。

官方地址：https://shardingsphere.apache.org/document/current/cn/overview/

咱们目前只需关注Sharding-JDBC，它定位为轻量级Java框架，在Java的JDBC层提供的额外服务。 它使用客户端直连数据库，以jar包形式提供服务，无需额外部署和依赖，可理解为增强版的JDBC驱动，完全兼容JDBC和各种ORM框架。

Sharding-JDBC的核心功能为数据分片和读写分离，通过Sharding-JDBC，应用可以透明的使用jdbc访问已经分库 分表、读写分离的多个数据源，而不用关心数据源的数量以及数据如何分布。

​        适用于任何基于Java的ORM框架，如： Hibernate, Mybatis, Spring JDBC Template或直接使用JDBC。 

​        基于任何第三方的数据库连接池，如：DBCP, C3P0, BoneCP, Druid, HikariCP等。

​        支持任意实现JDBC规范的数据库。目前支持MySQL，Oracle，SQLServer和PostgreSQL。

  ![img](img\wps26.jpg)



上图展示了Sharding-Jdbc的工作方式，使用Sharding-Jdbc前需要人工对数据库进行分库分表，在应用程序中加入Sharding-Jdbc的Jar包，应用程序通过Sharding-Jdbc操作分库分表后的数据库和数据表，由于Sharding-Jdbc是对Jdbc驱动的增强，使用Sharding-Jdbc就像使用Jdbc驱动一样，在应用程序中是无需指定具体要操作的分库和分表 的。

### **1.4.2** 与jdbc性能对比

1. 性能损耗测试：服务器资源充足、并发数相同，比较JDBC和Sharding-JDBC性能损耗，Sharding-JDBC相对

JDBC损耗不超过7%。

![image-20210306175403035](img\image-20210306175403035.png)

![img](img\wps28.png) 



2. 性能对比测试：服务器资源使用到极限，相同的场景JDBC与Sharding-JDBC的吞吐量相当。

3. 性能对比测试：服务器资源使用到极限，Sharding-JDBC采用分库分表后，Sharding-JDBC吞吐量较JDBC不分表有接近2倍的提升。

![img](img\wps29.png)

 

# **2.** Sharding-JDBC快速入门

![img](img\wps30.png)

## **2.1** 需求说明

本章节使用Sharding-JDBC完成对订单表的水平分表，通过快速入门程序的开发，快速体验Sharding-JDBC的使用方法。

人工创建两张表，t_order_1和t_order_2，这两张表是订单表拆分后的表，通过Sharding-Jdbc向订单表插入数据， 按照一定的分片规则，主键为偶数的进入t_order_1，另一部分数据进入t_order_2，通过Sharding-Jdbc 查询数

据，根据 SQL语句的内容从t_order_1或t_order_2查询数据。

## **2.2.** 环境搭建

### **2.2.1** 环境说明

操作系统：Win10

数据库：MySQL-5.7.25 JDK：64位 jdk1.8.0_201

应用框架：spring-boot-2.1.3.RELEASE，Mybatis3.5.0 Sharding-JDBC：sharding-jdbc-spring-boot-starter-4.0.0-RC1

### **2.2.2** 创建数据库

创建订单库order_db

~~~sql
CREATE DATABASE `order_db` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
~~~

在order_db中创建t_order_1、t_order_2表

~~~sql
DROP TABLE IF EXISTS `t_order_1`; 
CREATE TABLE `t_order_1` (
`order_id` bigint(20) NOT NULL COMMENT '订单id',
`price` decimal(10, 2) NOT NULL COMMENT '订单价格',
`user_id` bigint(20) NOT NULL COMMENT '下单用户id',
`status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态',
PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `t_order_2`; 
CREATE TABLE `t_order_2` (
`order_id` bigint(20) NOT NULL COMMENT '订单id',
`price` decimal(10, 2) NOT NULL COMMENT '订单价格',
`user_id` bigint(20) NOT NULL COMMENT '下单用户id',
`status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态',
PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
~~~

### 2.2.3.引入maven依赖

引入 sharding-jdbc和SpringBoot整合的Jar包：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.bigdata.dbsharding</groupId>
    <artifactId>shardingdemo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.3.RELEASE</version>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.0</version>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.16</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>

        <dependency>
            <groupId>org.apache.shardingsphere</groupId>
            <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
            <version>4.0.0-RC1</version>
        </dependency>
    </dependencies>


    <build>
        <finalName>${project.name}</finalName>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
                <includes>
                    <include>**/*</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

            <plugin>
                <artifactId>maven-resources-plugin</artifactId>
                <configuration>
                    <encoding>utf-8</encoding>
                    <useDefaultDelimiters>true</useDefaultDelimiters>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

具体spring boot相关依赖及配置请参考资料中sharding-jdbc-simple工程，本指引只说明与Sharding- JDBC相关的内容。

 

## **2.3** 编写程序

### **2.3.1** 分片规则配置

分片规则配置是sharding-jdbc进行对分库分表操作的重要依据，配置内容包括：数据源、主键生成策略、分片策 略等。

定义application.yml，内容如下：

```
server:
  port: 56081
  servlet:
    context-path: /sharding-jdbc-simple-demo
spring:
  application:
    name: sharding-jdbc-simple-demo
  http:
    encoding:
      enabled: true
      charset: utf-8
      force: true
  main:
    allow-bean-definition-overriding: true
  shardingsphere:
    datasource:
      names: m1
      m1:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/order_db?useUnicode=true
        username: root
        password: mysql
    sharding:
      tables:
        t_order:
          actualDataNodes: m1.t_order_$->{1..2}
          tableStrategy:
            inline:
              shardingColumn: order_id
              algorithmExpression: t_order_$->{order_id % 2 + 1}
          keyGenerator:
            type: SNOWFLAKE
            column: order_id
    props:
      sql:
        show: true
mybatis:
  configuration:
    map-underscore-to-camel-case: true
logging:
  level:
    root: info
    org.springframework.web: info
    com.bigdata.dbsharding: debug
    druid.sql: debug
```

1. 首先定义数据源m1，并对m1进行实际的参数配置。

2. 指定t_order表的数据分布情况，他分布在m1.t_order_1，m1.t_order_2

3. 指定t_order表的主键生成策略为SNOWFLAKE，SNOWFLAKE是一种分布式自增算法，保证id全局唯一

4. 定义t_order分片策略，order_id为偶数的数据落在t_order_1，为奇数的落在t_order_2，分表策略的表达式为t_order_$->{order_id % 2 + 1}

### **2.3.2.** 数据操作

~~~java
@Mapper 
@Component
public interface OrderDao {

    /**
    *新增订单
    *@param price 订单价格
    *@param userId 用户id
    *@param status 订单状态
    *@return
    */
    @Insert("insert into t_order(price,user_id,status) value(#{price},#{userId},#{status})") int insertOrder(@Param("price") BigDecimal price, @Param("userId")Long userId,
    @Param("status")String status);

    /**
    *根据id列表查询多个订单
    *@param orderIds 订单id列表
    *@return
    */ @Select({"<script>" +
    "select " + " * " +
    " from t_order t" +
    " where t.order_id in " +
    "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" + " #{id} " +
    "</foreach>"+ "</script>"})
    List<Map> selectOrderByIds(@Param("orderIds")List<Long> orderIds);

}
~~~



**2.3.3.** 测试

编写单元测试：

```java
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcSimpleDemoBootstrap.class}) 
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsertOrder() {
        for (int i = 0; i < 10; i++) {
            orderDao.insertOrder(new BigDecimal((i + 1) * 5), 1L, "WAIT_PAY");
        }
    }

    @Test
    public void testSelectOrderByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(373771636085620736L);
        ids.add(373771635804602369L);
        List<Map> maps = orderDao.selectOrderByIds(ids);
        System.out.println(maps);
    }
}
```



执行testInsertOrder：

![img](img\wps43.jpg)

 

通过日志可以发现order_id为奇数的被插入到t_order_2表，为偶数的被插入到t_order_1表，达到预期目标。执行testSelectOrderbyIds：

![img](img\wps44.jpg) 

通过日志可以发现，根据传入order_id的奇偶不同，sharding-jdbc分别去不同的表检索数据，达到预期目标。

 

## **2.4.** 流程分析

通过日志分析，Sharding-JDBC在拿到用户要执行的sql之后干了哪些事儿：

（1） 解析sql，获取片键值，在本例中是order_id

（2） Sharding-JDBC通过规则配置 t_order_$->{order_id % 2 + 1}，知道了当order_id为偶数时，应该往t_order_1表插数据，为奇数时，往t_order_2插数据。

（3） 于是Sharding-JDBC根据order_id的值改写sql语句，改写后的SQL语句是真实所要执行的SQL语句。

（4） 执行改写后的真实sql语句

（5） 将所有真正执行sql的结果进行汇总合并，返回。



## **2.5.** 其他集成方式

Sharding-JDBC不仅可以与spring boot良好集成，它还支持其他配置方式，共支持以下四种集成方式。

在application.properties中配置

```properties
server.port=56081

spring.application.name = sharding‐jdbc‐simple‐demo
server.servlet.context‐path = /sharding‐jdbc‐simple‐demo 
spring.http.encoding.enabled = true 
spring.http.encoding.charset = UTF‐8 
spring.http.encoding.force = true

spring.main.allow‐bean‐definition‐overriding = true

mybatis.configuration.map‐underscore‐to‐camel‐case = true # 以下是分片规则配置
# 定义数据源
spring.shardingsphere.datasource.names = m1

spring.shardingsphere.datasource.m1.type = com.alibaba.druid.pool.DruidDataSource 
spring.shardingsphere.datasource.m1.driver‐class‐name = com.mysql.jdbc.Driver 
spring.shardingsphere.datasource.m1.url = jdbc:mysql://localhost:3306/order_db?useUnicode=true 
spring.shardingsphere.datasource.m1.username = root 
spring.shardingsphere.datasource.m1.password = root

# 指定t_order表的数据分布情况，配置数据节点
spring.shardingsphere.sharding.tables.t_order.actual‐data‐nodes = m1.t_order_$‐>{1..2}

# 指定t_order表的主键生成策略为SNOWFLAKE 
spring.shardingsphere.sharding.tables.t_order.key‐generator.column=order_id 
spring.shardingsphere.sharding.tables.t_order.key‐generator.type=SNOWFLAKE


# 指定t_order表的分片策略，分片策略包括分片键和分片算法
spring.shardingsphere.sharding.tables.t_order.table‐strategy.inline.sharding‐column = order_id 
spring.shardingsphere.sharding.tables.t_order.table‐strategy.inline.algorithm‐expression = t_order_$‐>{order_id % 2 + 1}

# 打开sql输出日志
spring.shardingsphere.props.sql.show = true
logging.level.root = info 
logging.level.org.springframework.web = info
logging.level.com.bigdata.dbsharding = debug 
logging.level.druid.sql = debug
```

#### Java 配置

添加配置类：

 ~~~java
@Configuration
public class ShardingJdbcConfig {

    // 定义数据源
    Map<String, DataSource> createDataSourceMap() { 
        DruidDataSource dataSource1 = new DruidDataSource(); 		           dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/order_db?useUnicode=true");            dataSource1.setUsername("root");
        dataSource1.setPassword("root");
        Map<String, DataSource> result = new HashMap<>(); result.put("m1", dataSource1);
        return result;
    }
// 定义主键生成策略
    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() { KeyGeneratorConfiguration result = new
    KeyGeneratorConfiguration("SNOWFLAKE","order_id"); return result;
	}

    // 定义t_order表的分片策略
    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order","m1.t_order_$‐>
        {1..2}");
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_$‐>{order_id % 2 + 1}"));
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());

        return result;
    }
    // 定义sharding‐Jdbc数据源
    @Bean
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration(); shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        //spring.shardingsphere.props.sql.show = true 
        Properties properties = new Properties(); 
        properties.put("sql.show","true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(),
        shardingRuleConfig,properties);
    }
}
 ~~~



由于采用了配置类所以需要屏蔽原来application.properties文件中spring.shardingsphere开头的配置信息。还需要在SpringBoot启动类中屏蔽使用spring.shardingsphere配置项的类：

```java
@SpringBootApplication(exclude = {SpringBootConfiguration.class}) public class ShardingJdbcSimpleDemoBootstrap {	}
```

Spring Boot properties配置

此方式同快速入门程序。

```properties
# 定义数据源
spring.shardingsphere.datasource.names = m1
spring.shardingsphere.datasource.m1.type = com.alibaba.druid.pool.DruidDataSource
spring.shardingsphere.datasource.m1.driver‐class‐name = com.mysql.jdbc.Driver
spring.shardingsphere.datasource.m1.url = jdbc:mysql://localhost:3306/order_db?useUnicode=true
spring.shardingsphere.datasource.m1.username = root 
spring.shardingsphere.datasource.m1.password = root


# 指定t_order表的主键生成策略为SNOWFLAKE 
spring.shardingsphere.sharding.tables.t_order.key‐generator.column=order_id
spring.shardingsphere.sharding.tables.t_order.key‐generator.type=SNOWFLAKE

# 指定t_order表的数据分布情况
spring.shardingsphere.sharding.tables.t_order.actual‐data‐nodes = m1.t_order_$‐>{1..2}

# 指定t_order表的分表策略
spring.shardingsphere.sharding.tables.t_order.table‐strategy.inline.sharding‐column = order_id 
spring.shardingsphere.sharding.tables.t_order.table‐strategy.inline.algorithm‐expression = t_order_$‐>{order_id % 2 + 1}
```



#### Spring命名空间配置

此方式使用xml方式配置，不推荐使用。

```xml
<?xml version="1.0" encoding="UTF‐8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema‐instance" xmlns:p="http://www.springframework.org/schema/p" xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
xmlns:sharding="http://shardingsphere.apache.org/schema/shardingsphere/sharding"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring‐beans.xsd http://shardingsphere.apache.org/schema/shardingsphere/sharding
http://shardingsphere.apache.org/schema/shardingsphere/sharding/sharding.xsd
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring‐context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring‐tx.xsd">
    <context:annotation‐config />

    <!‐‐定义多个数据源‐‐>
    <bean id="m1" class="com.alibaba.druid.pool.DruidDataSource" destroy‐method="close">
        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/order_db_1?useUnicode=true" />
        <property name="username" value="root" />
        <property name="password" value="root" />
    </bean>

    <!‐‐定义分库策略‐‐>
    <sharding:inline‐strategy id="tableShardingStrategy" sharding‐column="order_id" algorithm‐ expression="t_order_$‐>{order_id % 2 + 1}" />

    <!‐‐定义主键生成策略‐‐>
    <sharding:key‐generator id="orderKeyGenerator" type="SNOWFLAKE" column="order_id" />

    <!‐‐定义sharding‐Jdbc数据源‐‐>
    <sharding:data‐source id="shardingDataSource">
        <sharding:sharding‐rule data‐source‐names="m1">
        <sharding:table‐rules>
        <sharding:table‐rule logic‐table="t_order" table‐strategy‐ ref="tableShardingStrategy" key‐generator‐ref="orderKeyGenerator" />
        </sharding:table‐rules>
        </sharding:sharding‐rule>
    </sharding:data‐source>
</beans>
```



# **3.** 水平分表

前面已经介绍过，水平分表是在同一个数据库内，把同一个表的数据按一定规则拆到多个表中。在快速入门里，我 们已经对水平分库进行实现，这里不再重复介绍。

# **4.** 水平分库

前面已经介绍过，水平分库是把同一个表的数据按一定规则拆到不同的数据库中，每个库可以放在不同的服务器 上。接下来看一下如何使用Sharding-JDBC实现水平分库，咱们继续对快速入门中的例子进行完善。

(1) 将原有order_db库拆分为order_db_1、order_db_2

![img](img\wps54.jpg)

![img](img\wps55.jpg)

 

(2) 分片规则修改

由于数据库拆分了两个，这里需要配置两个数据源。

分库需要配置分库的策略，和分表策略的意义类似，通过分库策略实现数据操作针对分库的数据库进行操作。

```properties
    datasource:
      names: m1,m2
      m1:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/order_db1?useUnicode=true&useSSL=false&serverTimezone=UTC
        username: root
        password: root
      m2:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/order_db2?useUnicode=true&useSSL=false&serverTimezone=UTC
        username: root
        password: root
    sharding:
      tables:
        t_order:
          actualDataNodes: m$->{1..2}.t_order_$->{1..2}
          databaseStrategy:
            inline:
              shardingColumn: user_id
              algorithmExpression: m$->{user_id % 2 + 1}
          tableStrategy:
            inline:
              shardingColumn: order_id
              algorithmExpression: t_order_$->{order_id % 2 + 1}
          keyGenerator:
            type: SNOWFLAKE
            column: order_id
```

Sharding-JDBC支持以下几种分片策略： 

不管理分库还是分表，策略基本一样。

- standard：标准分片策略，对应StandardShardingStrategy。提供对SQL语句中的=, IN和BETWEEN AND的分片操作支持。StandardShardingStrategy只支持单分片键，提供PreciseShardingAlgorithm和RangeShardingAlgorithm两个分片算法。PreciseShardingAlgorithm是必选的，用于处理=和IN的分片。RangeShardingAlgorithm是可选的，用于处理BETWEEN AND分片，如果不配置RangeShardingAlgorithm，SQL中的BETWEEN AND将按照全库路由处理。
- complex：符合分片策略，对应ComplexShardingStrategy。复合分片策略。提供对SQL语句中的=, IN和BETWEEN   AND的分片操作支持。ComplexShardingStrategy支持多分片键，由于多分片键之间的关系复杂，因此并未进行过多的封装，而是直接将分片键值组合以及分片操作符透传至分片算法，完全由应用开发 者实现，提供最大的灵活度。
- inline：行表达式分片策略，对应InlineShardingStrategy。使用Groovy的表达式，提供对SQL语句中的=和 IN的分片操作支持，只支持单分片键。对于简单的分片算法，可以通过简单的配置使用，从而避免繁琐的Java

​       代码开发，如:t_user_$->{u_id % 8}表示t_user表根据u_id模8，而分成8张表，表名称为t_user_0到t_user_7。

- hint：Hint分片策略，对应HintShardingStrategy。通过Hint而非SQL解析的方式分片的策略。对于分片字段 非SQL决定，而由其他外置条件决定的场景，可使用SQL Hint灵活的注入分片字段。例：内部系统，按照员工登录主键分库，而数据库中并无此字段。SQL Hint支持通过Java API和SQL注释(待实现)两种方式使用。
- none：不分片策略，对应NoneShardingStrategy。不分片的策略。
  目前例子中都使用inline分片策略，若对其他分片策略细节若感兴趣，请查阅官方文档：

https://shardingsphere.apache.org/

(3) 插入测试

修改testInsertOrder方法，插入数据中包含不同的user_id

~~~java
@Test
public void testInsertOrder(){ 
    for (int i = 0 ; i<10; i++){
		orderDao.insertOrder(new BigDecimal((i+1)*5),1L,"WAIT_PAY");
	}
	for (int i = 0 ; i<10; i++){
		orderDao.insertOrder(new BigDecimal((i+1)*10),2L,"WAIT_PAY");
	}
}
~~~



执行testInsertOrder:

![img](img\wps69.png) 



通过日志可以看出，根据user_id的奇偶不同，数据分别落在了不同数据源，达到目标。

 

(4) 查询测试

调用快速入门的查询接口进行测试：

```java
List<Map> selectOrderbyIds(@Param("orderIds")List<Long> orderIds);
```



通过日志发现，sharding-jdbc将sql路由到m1和m2：

![image-20210306192502046](img\image-20210306192502046.png)

 



问题分析：

由于查询语句中并没有使用分片键user_id，所以sharding-jdbc将广播路由到每个数据结点。下边我们在sql中添加分片键进行查询。

在OrderDao中定义接口：

```java
@Select({"<script>",
" select",
" * ",
" from t_order t ", "where t.order_id in",
"<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>", "#{id}",
"</foreach>",
" and t.user_id = #{userId} ", "</script>"
})
List<Map> selectOrderbyUserAndIds(@Param("userId") Integer userId,@Param("orderIds")List<Long> orderIds);
```



编写测试方法：

```java
@Test
public void testSelectOrderbyUserAndIds(){ 
    List<Long> orderIds = new ArrayList<>(); 
    orderIds.add(373422416644276224L); orderIds.add(373422415830581248L);
	//查询条件中包括分库的键user_id
	int user_id = 1;
	List<Map> orders = orderDao.selectOrderbyUserAndIds(user_id,orderIds); 
    JSONArray 	jsonOrders = new JSONArray(orders); 
    System.out.println(jsonOrders);
}
```



执行testSelectOrderbyUserAndIds:

  ![img](img\wps76.jpg)

 



查询条件user_id为1，根据分片策略m$->{user_id % 2 + 1}计算得出m2，此sharding-jdbc将sql路由到m2，见上图日志。

 

# **5.** 垂直分库

前面已经介绍过，垂直分库是指按照业务将表进行分类，分布到不同的数据库上面，每个库可以放在不同的服务器 上，它的核心理念是专库专用。接下来看一下如何使用Sharding-JDBC实现垂直分库。

(1) 创建数据库

创建数据库user_db

```sql
CREATE DATABASE `user_db` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
```



在user_db中创建t_user表

```sql
DROP TABLE IF EXISTS `t_user`; 
CREATE TABLE `t_user` (
`user_id` bigint(20) NOT NULL COMMENT '用户id',
`fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
`user_type` char(1) DEFAULT NULL COMMENT '用户类型',
PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

 

(2) 在Sharding-JDBC规则中修改

```properties
    datasource:
      names: m0,m1,m2
      m0:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/user_db?useUnicode=true&useSSL=false&serverTimezone=UTC
        username: root
        password: root
      m1:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/order_db1?useUnicode=true&useSSL=false&serverTimezone=UTC
        username: root
        password: root
      m2:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/order_db2?useUnicode=true&useSSL=false&serverTimezone=UTC
        username: root
        password: root
    sharding:
      tables:
        t_user:
          actualDataNodes: m$->{0}.t_user
          tableStrategy:
            inline:
              shardingColumn: user_id
              algorithmExpression: t_user
        t_order:
          actualDataNodes: m$->{1..2}.t_order_$->{1..2}
          databaseStrategy:
            inline:
              shardingColumn: user_id
              algorithmExpression: m$->{user_id % 2 + 1}
          tableStrategy:
            inline:
              shardingColumn: order_id
              algorithmExpression: t_order_$->{order_id % 2 + 1}
          keyGenerator:
            type: SNOWFLAKE
            column: order_id
```



(3) 数据操作 

新增UserDao:

```java
@Mapper @Component
public interface UserDao {

/**
*新增用户
*@param userId 用户id
*@param fullname 用户姓名
*@return
*/
@Insert("insert into t_user(user_id, fullname) value(#{userId},#{fullname})") int insertUser(@Param("userId")Long userId,@Param("fullname")String fullname);

/**
*根据id列表查询多个用户
*@param userIds 用户id列表
*@return
*/ 
@Select({"<script>",
" select",
" * ",
" from t_user t ",
" where t.user_id in",
"<foreach collection='userIds' item='id' open='(' separator=',' close=')'>", "#{id}",
"</foreach>", "</script>"
})
List<Map> selectUserbyIds(@Param("userIds")List<Long> userIds);

}
```



(4) 测试

新增单元测试方法：

```java
@Test
public void testInsertUser(){ 
    for (int i = 0 ; i<10; i++){
		Long id = i + 1L; 
        userDao.insertUser(id,"姓名"+ id );
	}

}
@Test
public void testSelectUserbyIds(){ 
    List<Long> userIds = new ArrayList<>(); 
    userIds.add(1L);
	userIds.add(2L);
	List<Map> users = userDao.selectUserbyIds(userIds); 
    System.out.println(users);
}
```



执行testInsertUser:

  ![img](img\wps89.png)

 

通过日志可以看出t_user表的数据被落在了m0数据源，达到目标。执行testSelectUserbyIds:

![img](img\wps90.jpg) 

通过日志可以看出t_user表的查询操作被落在了m0数据源，达到目标。

  

# **6.** 公共表

公共表属于系统中数据量较小，变动少，而且属于高频联合查询的依赖表。参数表、数据字典表等属于此类型。可 以将这类表在每个数据库都保存一份，所有更新操作都同时发送到所有分库执行。接下来看一下如何使用Sharding-JDBC实现公共表。

(1) 创建数据库

分别在user_db、order_db_1、order_db_2中创建t_dict表：

```sql
CREATE TABLE `t_dict` (
`dict_id` bigint(20) NOT NULL COMMENT '字典id',
`type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型',
`code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典编码',
`value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典值',
PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```



(2) 在Sharding-JDBC规则中修改

```properties
# 指定t_dict为公共表
spring.shardingsphere.sharding.broadcast‐tables=t_dict
```



(3) 数据操作

新增DictDao：

```java
@Mapper 
@Component
public interface DictDao {

    /**
    *新增字典
    *@param type 字典类型
    *@param code 字典编码
    *@param value 字典值
    *@return
    */
    @Insert("insert into t_dict(dict_id,type,code,value) value(#{dictId},#{type},#{code},#{value})")
    int insertDict(@Param("dictId") Long dictId, @Param("type") String type, @Param("code")String code, @Param("value")String value);

    /**
    *删除字典
    *@param dictId 字典id
    *@return
    */
	@Delete("delete from t_dict where dict_id = #{dictId}") 
    int deleteDict(@Param("dictId") Long dictId);

}
```



(4) 字典操作测试

新增单元测试方法：

```java
@Test
public void testInsertDict(){ 
    dictDao.insertDict(1L,"user_type","0","管理员"); 			
    dictDao.insertDict(2L,"user_type","1","操作员");
}
@Test
public void testDeleteDict(){ 
    dictDao.deleteDict(1L); 
    dictDao.deleteDict(2L);
}
```



执行testInsertDict：

  ![img](img\wps100.jpg)

 

通过日志可以看出，对t_dict的表的操作被广播至所有数据源。 测试删除字典，观察是否把所有数据源中该 公共表的记录删除。

 

(5) 字典关联查询测试

字典表已在各各分库存在，各业务表即可和字典表关联查询。

定义用户关联查询dao：

在UserDao中定义：

```java
/**
*根据id列表查询多个用户，关联查询字典表
*@param userIds 用户id列表
*@return
*/ 
@Select({"<script>",
" select",
" * ",
" from t_user t ,t_dict b",
" where t.user_type = b.code and t.user_id in",
"<foreach collection='userIds' item='id' open='(' separator=',' close=')'>", "#{id}",
"</foreach>", "</script>"
})
List<Map> selectUserInfobyIds(@Param("userIds")List<Long> userIds);
```



定义测试方法：

```java
@Test
public void testSelectUserInfobyIds(){ 
    List<Long> userIds = new ArrayList<>(); 
    userIds.add(1L);
	userIds.add(2L);
	List<Map> users = userDao.selectUserInfobyIds(userIds); 
    JSONArray jsonUsers = new JSONArray(users); 
    System.out.println(jsonUsers);

}
```



执行测试方法，查看日志，成功关联查询字典表：

 ![img](img\wps105.jpg)



# **7.** 读写分离

![img](img\wps106.png)

## **7.1** 理解读写分离

面对日益增加的系统访问量，数据库的吞吐量面临着巨大瓶颈。  对于同一时刻有大量并发读操作和较少写操作类型的应用系统来说，将数据库拆分为主库和从库，主库负责处理事务性的增删改操作，从库负责处理查询操作，能 够有效的避免由数据更新导致的行锁，使得整个系统的查询性能得到极大的改善。

  ![img](img\wps107.png)

通过一主多从的配置方式，可以将查询请求均匀的分散到多个数据副本，能够进一步的提升系统的处理能力。 使用多主多从的方式，不但能够提升系统的吞吐量，还能够提升系统的可用性，可以达到在任何一个数据库宕机，甚至 磁盘物理损坏的情况下仍然不影响系统的正常运行。

  ![img](img\wps108.png)

读写分离的数据节点中的数据内容是一致的，而水平分片的每个数据节点的数据内容却并不相同。将水平分片和读 写分离联合使用，能够更加有效的提升系统的性能。

Sharding-JDBC读写分离则是根据SQL语义的分析，将读操作和写操作分别路由至主库与从库。它提供透明化读写分离，让使用方尽量像使用一个数据库一样使用主从数据库集群。

  ![img](img\wps109.png)



Sharding-JDBC提供一主多从的读写分离配置，可独立使用，也可配合分库分表使用，同一线程且同一数据库连接 内，如有写入操作，以后的读操作均从主库读取，用于保证数据一致性。Sharding-JDBC不提供主从数据库的数据 同步功能，需要采用其他机制支持。

![img](img\wps110.png)



接下来，咱们对上面例子中user_db进行读写分离实现。为了实现Sharding-JDBC的读写分离，首先，要进行

mysql的主从同步配置。

## **7.2** mysql主从同步(windows)

一，新增mysql实例

复制原有mysql如：D:\mysql-5.7.25(作为主库) -> D:\mysql-5.7.25-s1(作为从库)，并修改以下从库的my.ini：

```ini
[mysqld]
#设置3307端口port = 3307
# 设置mysql的安装目录
basedir=D:\mysql‐5.7.25‐s1
# 设置mysql数据库的数据的存放目录
datadir=D:\mysql‐5.7.25‐s1\data
```

然后将从库安装为windows服务，注意配置文件位置：

```
D:\mysql‐5.7.25‐s1\bin>mysqld install mysqls1 ‐‐defaults‐file="D:\mysql‐5.7.25‐s1\my.ini"
```

由于从库是从主库复制过来的，因此里面的数据完全一致，可使用原来的账号、密码登录。

 

二，修改主、从库的配置文件(my.ini)，新增内容如下： 

主库：

```ini
[mysqld] #开启日志
log-bin = mysql‐bin
#设置服务id，主从不能一致
server-id = 1
#设置需要同步的数据库
binlog-do-db=user_db #屏蔽系统库同步
binlog-ignore-db=mysql 
binlog-ignore-db=information_schema 
binlog-ignore-db=performance_schema
```

从库：

```ini
[mysqld] #开启日志
log-bin = mysql‐bin
#设置服务id，主从不能一致
server-id = 2
#设置需要同步的数据库
replicate_wild_do_table=user_db.% #屏蔽系统库同步
replicate_wild_ignore_table=mysql.% 
replicate_wild_ignore_table=information_schema.% 
replicate_wild_ignore_table=performance_schema.%
```

重启主库和从库：

```
net start [主库服务名]
net start [从库服务名mysqls1]
```

请注意，主从MySQL下的数据(data)目录下有个文件auto.cnf，文件中定义了uuid，要保证主从数据库实例的

uuid不一样，建议直接删除掉，重启服务后将会重新生成。

 

三，授权主从复制专用账号

```
#切换至主库bin目录，登录主库mysql -h localhost -uroot -p #授权主备复制专用账号
GRANT REPLICATION SLAVE ON *.* TO 'db_sync'@'%' IDENTIFIED BY 'db_sync';   #构建同步账户
#刷新权限
FLUSH PRIVILEGES;
#确认位点 记录下文件名以及位点
show master status;
```



![img](img\wps119.jpg) 



四，设置从库向主库同步数据、并检查链路

```sql
#切换至从库bin目录，登录从库
mysql -h localhost -P3307 -uroot -p


#注意 如果之前此备库已有主库指向 需要先执行以下命令清空
STOP SLAVE FOR CHANNEL '';
reset slave all;


#先停止同步
STOP SLAVE;
#修改从库指向到主库，使用上一步记录的文件名以及位点
CHANGE MASTER TO
master_host = 'localhost', 
master_user = 'root', 
master_password = 'root', 
master_log_file = 'mysql‐bin.000004', 
master_log_pos = 1038;
#启动同步
START SLAVE;
#查看从库状态Slave_IO_Runing和Slave_SQL_Runing都为Yes说明同步成功，如果不为Yes，请检查error_log，然后 排查相关异常。
show slave status\G
```

 

最后测试在主库修改数据库，看从库是否能够同步成功。

## **7.3** 实现sharding-jdbc读写分离

 

(1) 在Sharding-JDBC规则中修改

```properties
# 增加数据源s0，使用上面主从同步配置的从库。
spring.shardingsphere.datasource.names = m0,m1,m2,s0
...
spring.shardingsphere.datasource.s0.type = com.alibaba.druid.pool.DruidDataSource 
spring.shardingsphere.datasource.s0.driver‐class‐name = com.mysql.jdbc.Driver 
spring.shardingsphere.datasource.s0.url = jdbc:mysql://localhost:3307/user_db?useUnicode=true 
spring.shardingsphere.datasource.s0.username = root 
spring.shardingsphere.datasource.s0.password = root

....

# 主库从库逻辑数据源定义 ds0为user_db 
spring.shardingsphere.sharding.master‐slave‐rules.ds0.master‐data‐source‐name=m0 
spring.shardingsphere.sharding.master‐slave‐rules.ds0.slave‐data‐source‐names=s0

# t_user分表策略，固定分配至ds0的t_user真实表
spring.shardingsphere.sharding.tables.t_user.actual‐data‐nodes = ds0.t_user
....
```



(2) 测试

执行testInsertUser单元测试：

  ![img](img\wps122.jpg)



通过日志可以看出，所有写操作落入m0数据源。执行testSelectUserbyIds单元测试：

![img](img\wps123.jpg) 

 

通过日志可以看出，所有写操作落入s0数据源，达到目标。

 

 

 

 

