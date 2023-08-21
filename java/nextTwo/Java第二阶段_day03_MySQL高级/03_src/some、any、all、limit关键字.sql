-- 创建一个职位表
CREATE TABLE salary_table(
  id SMALLINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  position VARCHAR(40) NOT NULL,
  salary INT);
insert salary_table(position,salary) values('JAVA',8000),('Java',8400),('Java',9000),('Python',6500),('Python',10000),('Python',8900);
select *  from salary_table;

-- 查找出高于 Python  职位任一职位工资的其它职位
SELECT * FROM salary_table
  WHERE salary > ANY( SELECT salary FROM salary_table WHERE position = 'Python')
    and position not like '%Python%';

-- 查找出高于 Python  职位任何职位工资的其它职位SELECT * FROM salary_table
  WHERE salary > all( SELECT salary FROM salary_table WHERE position = 'Python')
    and position not like '%Python%';

-- 查找出等于Python  职位任何职位工资的其它职位
SELECT * FROM salary_table
  WHERE salary = any( SELECT salary FROM salary_table WHERE position = 'Python')
    and position not like '%Python%';

-- limit，一个参数的情况。
select * from emp limit 3;
select * from emp order by emp_id desc limit 3;
select * from emp order by hiredate limit 3;
-- 两个参数的情况下，第1个参数为结果集中需返回的起始记录位置（从1开始，到第n条记录后开始算）
-- 第2个参数是从开始返回的记录起，需返回的条数。
select * from emp limit 3,2;
select * from emp order by emp_id desc limit 3,2;
select * from emp order by hiredate limit 3;
	