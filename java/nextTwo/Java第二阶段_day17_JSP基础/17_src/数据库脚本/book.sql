DROP TABLE  IF EXISTS t_user ;
DROP TABLE  IF EXISTS t_book ;
#用户表
CREATE TABLE t_user(
		
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(32) UNIQUE NOT NULL,
    PASSWORD VARCHAR(32) NOT NULL
);
INSERT INTO t_user VALUES (NULL ,'wangcai','888');
INSERT INTO t_user VALUES (NULL ,'ruhua','666');
INSERT INTO t_user VALUES (NULL ,'wangcai','888');
#图书表
CREATE TABLE t_book(
		
    id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(32) UNIQUE NOT NULL,
    price DOUBLE  NOT NULL,
    author VARCHAR(32)  NOT NULL,
    image  VARCHAR(32) DEFAULT NULL, --  图片
    publish_date  DATETIME  NOT NULL  
    
);

INSERT INTO t_book VALUES (NULL ,'葵花宝典',99.9,'东方不败','b1.png',NOW());
INSERT INTO t_book VALUES (NULL ,'九阴真经',9.9,'周芷若','b2.png',NOW());
INSERT INTO t_book VALUES (NULL ,'独孤九剑',888,'令狐冲' , 'b3.png',NOW());

