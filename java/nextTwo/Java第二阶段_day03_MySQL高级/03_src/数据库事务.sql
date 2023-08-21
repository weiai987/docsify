-- 数据库事务示例
  begin;
  update student set sname='王军' where id=;
  rollback;
  commit;

-- 直接用 SET 来改变 MySQL 的自动提交模式:
-- SET AUTOCOMMIT=0 禁止自动提交
-- SET AUTOCOMMIT=1 开启自动提交

  show session variables like 'autocommit';  --查看自动提交状态
  set session autocommit = 0;  --关闭自动提交
  set session autocommit = off;  --关闭自动提交
  update student set sname='王军';
  rollback;
  commit;

-- 首先我们创建一个表作为测试表
drop table if exists test_trac;
create table if not exists test_trac (
    t_id varchar(16) primary key,
    t_name varchar(32)
);

-- 我们开两个会话，一个用客户端(会话A)，一个用命令行(会话B)，会话A开启事务
insert into test_trac values('aaa', 'bbb');  --在会话A上执行
-- 在会话B上读取，会发现无法读取未提交的数据，会话A执行commit后，会话B可以正常读取。

-- 将会话B的事务隔离级别设为“读未提交”
sessionB: set session transaction isolation level read uncommitted;
sessionB: start transaction;
sessionB: select * from test_trac;
-- 显示会话A插入之前的值
sessionA: start transaction;
sessionA: insert into test_trac values('ccc0', 'aaa');
-- 在sessionA未提交的情况下，会话B可读取：会话A的未提交的insert（脏读）；查询过后被修改（不可重读）；查询过被新增（幻读）。


-- 将会话B的事务隔离级别设为“读已提交”
sessionB: set session transaction isolation level read committed;
sessionB: start transaction;  --开启事务
sessionB: select * from test_trac where t_name='aaa';
-- 会话A也开启事务
sessionA: start transaction;
sessionA: insert into test_trac values('ccc1', 'aaa');
-- 在sessionA未提交的情况下，sessionB读不到这条记录，除非sessionA已提交
sessionA: commit;
sessionB: select * from test_trac where t_name='aaa';
-- 关键是会话B的自己的事务未办结提交过程中，读取到了会话A提交的数据。

-- 现在把会话B的隔离基本设为“可重复读”
sessionB: set session transaction isolation level repeatable read;
sessionB: start transaction;  --开启事务
sessionB: select * from test_trac where t_name='bbb';
-- 可重复读的例子
sessionA: start transaction;  --开启事务
sessionA: insert into test_trac values('ddd0', 'bbb');
sessionA: commit;
-- 虽然会话A已提交事务，会话B查询，得不到新的值，除非会话B也提交。
sessionB: commit;
sessionB: select * from test_trac where t_name='bbb';
-- 幻读的例子
sessionA: start transaction; 
sessionB: start transaction;
sessionA: select * from test_trac where t_name='bbb';
sessionB: select * from test_trac where t_name='bbb';
-- 会话A和B开启事务后，读取的结果集。会话A发现可以插入某个值，插入并提交。会话B也要插入同样的值，结果发现主键冲突，也就是数据库库在查询之后，新增了对应的数据。但是会话B的事务中不知道这个改变。
sessionA: insert into test_trac values('ddd1', 'bbb');
sessionA: commit;
sessionB: insert into test_trac values('ddd1', 'bbb');
sessionB: ERROR 1062 (23000): Duplicate entry 'ddd1' for key 'PRIMARY'
-- 如果会话A插入一个主键值，未提交。会话B插入同样的主键值，在会话A未提交的情况下被阻塞，指导会话A提交或回滚。

-- 现在把会话B的隔离基本设为“串行化”
sessionB: set session transaction isolation level serializable;
sessionB: start transaction;  --开启事务
-- 在此隔离等级下，一旦有某个事务进行了insert、update、delete操作更新类数据，所有其他会话的select操作会被阻塞，除非更新的会话被提交。
-- 如果两个会话都更新过了，第一个会话select被阻塞，第二个会话进行select直接报错
ERROR 1213 (40001): Deadlock found when trying to get lock; try restarting transaction