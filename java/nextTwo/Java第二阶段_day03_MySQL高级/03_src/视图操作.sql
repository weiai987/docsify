-- 创建单表视图

create view v_stu1 as select * from student;
select * from v_stu1;
create view v_stu2 as select sid, sname from student;
select * from v_stu2;
create view v_stu3(学生编号, 学生姓名) as select sid, sname from student;
select * from v_stu3;

-- 创建多表关联视图
create view v_tc1 as
select tname, cname from teacher, course where tid=teacher_id;
create view v_tc2(教师名称，担任课程) as
select tname, cname from teacher, course where tid=teacher_id;


-- 查看视图
select * from view_name;

-- 更新视图
create or replace view view_name as select语句;

-- 删除视图
DROP VIEW [IF EXISTS] view_name [, view_name] ...
