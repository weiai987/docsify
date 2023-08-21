-- 数据准备
create table goods(
  gid int,
  name varchar(20),
  num smallint
);
create table ord(
  oid int,
  gid int,
  much smallint
);
insert into goods values(1,'cat',40);
insert into goods values(2,'dog',63);
insert into goods values(3,'pig',87);


-- 简单触发器1
delimiter $
create trigger t1 
  after insert
  on ord
  for each row
  begin
    update goods set num=num-2 where gid = 1;
end$

-- 数据准备
create table stu (
  stu_id int PRIMARY key auto_increment,
  stu_code int,
  stu_name varchar(20)
);
create  table sc (
  sc_id int primary key auto_increment,
  stu_code int,
  stu_score decimal(8,2)
);

-- 简单触发器2
create  table sc_h (
  sc_id int primary key auto_increment,
	stu_code int,
  before_update_code int,
	after_update_code int,
  before_update_score decimal(8,2),
	after_update_score decimal(8,2)
);

delimiter $
create trigger t2
  after insert
	on stu for each row
	begin
	  insert into sc(stu_code,stu_score) values(new.stu_code, 80.0);
end$

delimiter $
create trigger t2a
  after update
	on sc for each row
	begin
	  insert into sc_h(stu_code, before_update_code, after_update_code,
		before_update_score,  after_update_score)
		values(new.stu_code, old.stu_code, new.stu_code,
		old.stu_score, new.stu_score);
end$

-- 带传值的触发器
delimiter $
create trigger t3
  after insert
  on ord
  for each row
  begin
    -- new 代表 ord 表中新增的数据
    update goods set num = num - new.much where gid = new.gid;
end$

-- 带判断的触发器
delimiter $
create trigger t4
  before insert
  on ord
  for each row
  begin
    -- 取出 goods 表中对应 id 的库存
    -- new 代表 orders 表中新增的数据
    select num from goods where gid = new.gid into @num;    
    -- 用即将插入的 orders 表中的库存和 goods 表中的库存进行比较
    -- 如果库存不够，中断操作
    if @num < new.num then
        -- 中断操作：暴力解决，主动出错
        insert into xxx values(xxx);
    end if;
end$


delimiter $
create trigger t5
  before insert
  on ord
  for each row
  begin
    declare restNum int;
    select num into restNum from goods where gid = new.gid;
    if new.much > restNum then
      set new.much = restNum;
    end if;
    update goods set num=num-new.much where gid=new.gid;
end$

-- 查看触发器
show triggers;
select * from information_schema.TRIGGERS;
select * from information_schema.TRIGGERS where trigger_schema='test' and event_object_table='ord';


-- 查看创建触发器的语句
show create trigger 触发器名称;

-- 删除触发器
drop trigger 触发器名称;



