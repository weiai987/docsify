-- 在已存在的表上追加普通索引

ALTER table tc_9 ADD INDEX i_tc_9b(bbb);
ALTER table tc_9 ADD INDEX i_tc_9b(bbb, ccc);

-- 创建表的时候直接指定

create table tc_9(
  aaa int primary key,
  bbb varchar(20),
  ccc datetime,
  index i_tc_9a (bbb)
);
create table tc_9(
  aaa int primary key,
  bbb varchar(20),
  ccc datetime,
  index i_tc_9a (bbb, ccc)
);

-- 查看表上的索引
show index from tc_9;

-- 删除索引
drop index i_tc_9a on tc_9;


-- 唯一索引
CREATE UNIQUE INDEX i_tc_9b ON tc_9(bbb); 
-- 创建表的时候直接指定
create table tc_9(
  aaa int primary key,
  bbb varchar(20),
  ccc datetime,
  unique i_tc_9a (bbb)
);

-- 创建主键索引
drop table if exists tc_10;
create table tc_10(
  aaa int primary key,
  bbb varchar(20),
  ccc datetime
);
create table tc_10(
  aaa int,
  bbb varchar(20),
  ccc datetime,
  primary key(aaa)
);
create table tc_10(
  aaa int,
  bbb varchar(20),
  ccc datetime
);
alter table tc_10 add primary key(aaa);



​	