-- 数据准备
drop table if exists dept;
create table dept (
  dept_id int primary key auto_increment,
	dept_name varchar(20)
);

drop table if exists empl;
create table empl (
  empl_id int primary key auto_increment,
	empl_name varchar(20),
	dept_id int
);

insert into dept(dept_name) values('开发部'), ('测试部'), ('实施运维部');
insert into empl(empl_name, dept_id) values('赵大',1), ('钱二',2), ('张三',3), ('李四', 1);


-- select型子查询，查出每个部门的员工数有多少
SELECT d.dept_name, ( 
    SELECT COUNT(*)
    FROM empl e
    WHERE e.dept_id = d.dept_id
 ) empl_num
 FROM dept d;

select dept_name, (select 1) as a1, (select 2) as a2 from dept;
select dept_name, (select 1,2) as a1, (select 2) as a2 from dept;
-- 第2句sql是错的，Operand should contain 1 column(s)

-- where型子查询，列出开发部的员工列表
select empl_id, empl_name from empl
where dept_id = (select dept_id from dept where dept_name like '%开发部%');
-- where型子查询，列出开发部与测试部的员工列表
select empl_id, empl_name from empl
where dept_id in (select dept_id from dept
  where dept_name like '%开发部%' or dept_name like '%测试部%');
-- where型子查询，列出不是开发部与测试部的员工列表
select empl_id, empl_name from empl
where dept_id not in (select dept_id from dept
  where dept_name like '%开发部%' or dept_name like '%测试部%');

-- from型子查询，列出开发部和测试部的姓李的员工列表
select empl_id, empl_name
from (select empl_id, empl_name from empl, dept
      where empl.dept_id = dept.dept_id
        and dept_name in('开发部','测试部') ) ta
where ta.empl_name like '李%';

-- exists型子查询，查询存在实际员工的部门名称
SELECT dept_name
FROM dept d
WHERE EXISTS(
    SELECT *
    FROM empl e
    WHERE d.dept_id=e.dept_id
);

​	



