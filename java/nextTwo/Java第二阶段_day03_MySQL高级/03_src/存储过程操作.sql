-- 数据准备:
create table ptest_01(
  pid int primary key auto_increment,
	pname varchar(20)
);

-- 创建存储过程
delimiter $
create procedure p_01()
begin
  insert into ptest_01(pname) value('bbb');
end$
delimiter ;
-- 创建完成后，我们调用一下此存储过程，查看效果。
call p_01();

-- 带有入参的存储过程示例
delimiter $
create procedure p_02(in name varchar(20))
begin
  insert into ptest_01(pname) value(name);
  select name as name1;
  set name='hahaha';
  select name as name2;
end$
delimiter ;
-- 创建完成后，我们调用一下此存储过程，查看效果。
set @name='www';
call p_02(@name);
select @name;
select * from ptest_01;


-- 带有出参的存储过程示例
delimiter $
create procedure p_03(out name varchar(20))
begin
  insert into ptest_01(pname) value(name);
  select name as name1;
  set name='hahaha';
  select name as name2;
end$
delimiter ;
-- 创建完成后，我们调用一下此存储过程，查看效果。
set @name='rrr';
call p_03(@name);
select @name;
select * from ptest_01;


-- 带有出入参的存储过程示例
delimiter $
create procedure p_04(inout name varchar(20))
begin
  insert into ptest_01(pname) value(name);
  select name as name1;
  set name='hahaha';
  select name as name2;
end$
delimiter ;
-- 创建完成后，我们调用一下此存储过程，查看效果。
set @name='rrr';
call p_04(@name);
select @name;
select * from ptest_01;


-- 查看存储过程
show procedure status where db='test';
select * from information_schema.routines
where routine_schema='test' and routine_type='PROCEDURE';
-- 查看创建存储过程的语句
show create procedure p_06;


-- 删除存储过程
drop procedure p_05; 
drop procedure if exists p_06; 


-- 存储过程体语法
-- 变量的声明、引用、赋值
mysql> set @aaa = 'aaa';
Query OK, 0 rows affected (0.00 sec)
-- 局部变量使用 declare 关键字声明，使用 set 关键字赋值
DECLARE variable_name [,variable_name...] datatype [DEFAULT value];


delimiter $
create procedure p_05()
begin
	declare abc int default 5;
	set abc = 8;
	select abc;
end$
delimiter ;
select abc;

-- 除了使用 set 赋值，还可以通过 select 语句赋值；
select pname from ptest_01 limit 1 into @n1;
select pname into @n2 from ptest_01 limit 1;
select @n1, @n2;

delimiter $
create procedure p_06()
begin
	declare n3, n4 varchar(20) default '000';
	select pname from ptest_01 limit 1 into n3;
    select pname into n4 from ptest_01 limit 1;
    select n3, n4;
end$
delimiter ;
call p_06();
-- 注意：使用 select 语句赋值时，返回结果集必须是单行单值。


-- 程序控制结构 - 分支结构
-- if-then-else 语句
delimiter $
create procedure p_07(in n1 int)
begin
	if(n1 >= 0) then
	   insert into ptest_01(pname) value('n1 >= 0');
	else
	   insert into ptest_01(pname) value('n1 < 0');
	end if;
end$
delimiter ;
call p_07();

-- case语句
delimiter $
create procedure p_08(in n1 int)
begin
	case(n1)
	  when(1) then
	    insert into ptest_01(pname) value('n1 = 1');
	    insert into ptest_01(pname) value('1111');
	    insert into ptest_01(pname) value('11111');
	  when(2) then
	    insert into ptest_01(pname) value('n1 = 2');
	    insert into ptest_01(pname) value('2222');
	    insert into ptest_01(pname) value('22222');
	  when(3) then
	    insert into ptest_01(pname) value('n1 = 3');
	    insert into ptest_01(pname) value('3333');
	    insert into ptest_01(pname) value('33333');
	  else
	    insert into ptest_01(pname) value('n1 = other');
	end case;
end$
delimiter ;
call p_08();


-- 程序控制结构 - 循环结构
-- while...end while 循环
delimiter $
create procedure p_11(in n1 int)
begin
	declare n2 int;
	set n2 = 0;
	while(n2 < n1 ) do
	  insert into ptest_01(pname) value(concat('n2 = ',n2));
	  set n2 = n2 + 1;
	end while;
	insert into ptest_01(pname) value('while is over.');
end$
delimiter ;
call p_11(3);


-- repeat···· end repea 循环
delimiter $
create procedure p_12(in n1 int)
begin
	declare n3 int;
	set n3 = 0;
	repeat
	  insert into ptest_01(pname) value(concat('n3 = ',n3));
	  set n3 = n3 + 1;
	  until(n3 > n1)
	end repeat;
	insert into ptest_01(pname) value('repeat is over.');
end$
delimiter ;
call p_12(3);


-- loop ·····endloop 循环
delimiter $
create procedure p_13(in n1 int)
begin
	declare n4 int;
	set n4 = 0;
	loop_lable: loop
	  insert into ptest_01(pname) value(concat('n4 = ',n4));
	  set n4 = n4 + 1;
	  if(n4 > n1) then leave loop_lable;
	  end if;
	end loop;
	insert into ptest_01(pname) value('loop is over.');
end$
delimiter ;
call p_13(3);

