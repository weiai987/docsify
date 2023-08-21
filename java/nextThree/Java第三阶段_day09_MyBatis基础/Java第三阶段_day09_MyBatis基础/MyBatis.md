# 学习目标

```
1、MyBatis简介
2、MyBatis的基本使用
3、MyBatis的查询
```

# 1、MyBatis简介

## 1.1 简介

MyBatis是目前主流的ORM框架

MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。

## 1.2 什么是ORM

对象关系映射（Object Relational Mapping，简称ORM）是通过使用描述对象和数据库之间映射的元数据，将面向对象语言程序中的对象自动持久化到关系数据库中。本质上就是将数据从一种形式转换到另外一种形式。

## 1.3 MyBatis和Hibernate的区别

Hibernate	

​	1) 是全自动框架，不用写SQL，全部自动生成

​	2) 不利于SQL的优化

​	3) 入门相对复杂

MyBatis		

​	1) 半自动框架，需要写SQL，由框架完成映射

​	2) 方便SQL的优化

​	3) 入门相对容易


# 2、MyBatis的基本使用

1）导入依赖

```
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.25</version>
    </dependency>


    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.5</version>
    </dependency>
```
2）添加配置文件mybatis-config.xml

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--多种环境：开发、测试、生产-->
    <environments default="development">
        <environment id="development">
            <!--事务管理-->
            <transactionManager type="JDBC"/>
            <!--数据源 POOLED代表连接池-->
            <dataSource type="POOLED">
                <!--JDBC的配置-->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/bookms_db?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC&amp;useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <!--配置映射文件的位置-->
    <mappers>
        <mapper resource="mappers/BookMapper.xml"></mapper>
    </mappers>
</configuration>
```

3）定义mapper接口

只定义一个insert方法

```
/**
 * 书籍表的映射接口
 */
public interface BookMapper {

    void insert(Book book);
}
```

4） 映射文件

在resources的mappers目录下添加映射文件BookMapper.xml

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--命名空间指定接口类型-->
<mapper namespace="com.blb.mybatis_demo.dao.BookMapper">
    <!--insert配置插入操作 id是接口中方法的名称 parameterType是参数类型-->
    <insert id="insert" parameterType="com.blb.mybatis_demo.entity.Book">
        insert into tb_book(book_name, price, type_id, author, publish_org, publish_time, state,book_image)
        values(#{bookName},#{price},#{typeId},#{author},#{publishOrg},#{publishTime},#{state},#{bookImage});
    </insert>
</mapper>
```

讲解配置：

- mapper           用于配置Mapper接口，实现其中增删改查方法的配置

- namespace    指定接口的类型的完整限定名

- insert              配置插入相关的方法，类似的还有：update（更新）、delete（删除）、select（查询）

- id                     方法名称

- parameterType   方法的参数类型

- #{xx}              占位符，用于在SQL中插入参数值，xx是参数的名称，如果参数类型是Java对象，xx则是对象的属性名称

  ​						

5) 单元测试

```
public class TestBookMapper {

    @Test
    public void testInsert(){
        //创建SQLSessionFactoryBuilder对象，用于创建SQLSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory
        try {
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //SqlSessionFactory用于创建SqlSession会话
            try(SqlSession session = factory.openSession()){
                //通过session获得Mapper对象
                BookMapper mapper = session.getMapper(BookMapper.class);
                //执行操作
                mapper.insert(new Book(0L,"test-11",88,1,"xx","xx","2011-1-1",0,"xx.jpg"));
                //提交修改
                session.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



# 3、MyBatis的查询

1） 给接口加方法

```
    List<Book> findAll();

    Book findById(int id);
```

2） 返回值的配置

需要给select标签配置返回值的类型resultType

```
    <!--select配置查询方法，resultType配置返回类型-->
    <select id="findAll" resultType="com.blb.mybatis_demo.entity.Book">
        select * from tb_book
    </select>

    <select id="findById" resultType="com.blb.mybatis_demo.entity.Book">
        select * from tb_book where id = #{id}
    </select>
```

3） 测试

```
    @Test
    public void testSelectAll(){
        //创建SQLSessionFactoryBuilder对象，用于创建SQLSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory
        try {
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //SqlSessionFactory用于创建SqlSession会话
            try(SqlSession session = factory.openSession()){
                //通过session获得Mapper对象
                BookMapper mapper = session.getMapper(BookMapper.class);
                //执行操作
                List<Book> books = mapper.findAll();
                books.forEach(book -> System.out.println(book));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

问题：查询出的名称为多个单词的字段出现null值

原因：数据库的字段单词以下划线分隔，Java的属性以驼峰命名，导致部分名称不一致无法实现映射

```
tb_book表的字段：
id、book_name、price、type_id、author、publish_org、publish_time、state、book_image

Book类的属性：
id、bookName、price、typeId、author、publishOrg、publishTime、state、bookImage
```

两种解决方法：

1） 添加resultMap，实现数据库字段和属性的映射，把resultType改为resultMap

```
    <!--实现Book到tb_book映射-->
    <resultMap id="bookMap" type="com.blb.mybatis_demo.entity.Book">
        <!--配置主键 property是java属性名 column是表字段名-->
        <id property="id" column="id"></id>
        <!--普通字段-->
        <result property="bookName" column="book_name"></result>
        <result property="price" column="price"></result>
        <result property="typeId" column="type_id"></result>
        <result property="author" column="author"></result>
        <result property="publishOrg" column="publish_org"></result>
        <result property="publishTime" column="publish_time"></result>
        <result property="state" column="state"></result>
        <result property="bookImage" column="book_image"></result>
    </resultMap>
```

2） 在mybatis配置文件里，配置下划线转换为驼峰命名风格

```
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
```

对比resultMap和resultType:

- 返回值的属性名称与数据库字段一致时，使用resultType
  	resultType用于定义返回值的类型，值就是Java类的完整限定名。
  
- 返回值的属性名称与数据库字段不一致时，使用resultMap
    resultMap用于数据库字段和属性的映射
    resultMap的属性有：id（标识id）和type（Java类的完整限定名）
    
    resultMap子节点有：id（主键）和result（普通字段）
    
    id和result的属性有：
    
    - property  属性名
    - column    字段名
    - javaType  属性类型（可以省略，自动读取）
    - sqlType    字段类型（可以省略，自动读取）

# 4、日志分析

## 4.1.引入日志依赖包（pom.xml）

会自动引入log4j以及slf4j-api

```
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.5</version>
</dependency>
```

## 4.2.添加log4j.properties

```
    log4j.rootLogger=DEBUG,A1
    log4j.logger.org.apache=DEBUG
    log4j.appender.A1=org.apache.log4j.ConsoleAppender
    log4j.appender.A1.layout=org.apache.log4j.PatternLayout
    log4j.appender.A1.layout.ConversionPattern=%-d{yyyy-MM-dd HH:mm:ss,SSS} [%t] [%c]-[%p] %m%n
```

再次运行程序会打印日志：

```
2018-06-30 19:53:37,554 [main] [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-[DEBUG] Opening JDBC Connection
2018-06-30 19:53:37,818 [main] [org.apache.ibatis.datasource.pooled.PooledDataSource]-[DEBUG] Created connection 2094411587.
2018-06-30 19:53:37,818 [main] [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-[DEBUG] Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@7cd62f43]
2018-06-30 19:53:37,863 [main] [MyMapper.selectUser]-[DEBUG] ==>  Preparing: select * from tb_user where id = ? 
2018-06-30 19:53:37,931 [main] [MyMapper.selectUser]-[DEBUG] ==> Parameters: 1(Integer)
2018-06-30 19:53:37,953 [main] [MyMapper.selectUser]-[DEBUG] <==      Total: 1
User{id='1', userName='zpc', password='123456', name='鹏程', age=25, sex=1, birthday='1990-09-02', created='2018-06-30 18:20:18.0', updated='2018-06-30 18:20:18.0'}
2018-06-30 19:53:37,954 [main] [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-[DEBUG] Resetting autocommit to true on JDBC Connection [com.mysql.jdbc.JDBC4Connection@7cd62f43]
2018-06-30 19:53:37,954 [main] [org.apache.ibatis.transaction.jdbc.JdbcTransaction]-[DEBUG] Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@7cd62f43]
2018-06-30 19:53:37,955 [main] [org.apache.ibatis.datasource.pooled.PooledDataSource]-[DEBUG] Returned connection 2094411587 to pool.
```

## 5.3.MyBatis使用步骤总结

- 1)配置mybatis-config.xml 全局的配置文件 (1、数据源，2、外部的mapper)
- 2)创建SqlSessionFactory
- 3)通过SqlSessionFactory创建SqlSession对象
- 4)通过SqlSession操作数据库 CRUD
- 5)调用session.commit()提交事务
- 6)调用session.close()关闭会话