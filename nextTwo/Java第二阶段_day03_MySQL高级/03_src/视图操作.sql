-- ����������ͼ

create view v_stu1 as select * from student;
select * from v_stu1;
create view v_stu2 as select sid, sname from student;
select * from v_stu2;
create view v_stu3(ѧ�����, ѧ������) as select sid, sname from student;
select * from v_stu3;

-- ������������ͼ
create view v_tc1 as
select tname, cname from teacher, course where tid=teacher_id;
create view v_tc2(��ʦ���ƣ����ογ�) as
select tname, cname from teacher, course where tid=teacher_id;


-- �鿴��ͼ
select * from view_name;

-- ������ͼ
create or replace view view_name as select���;

-- ɾ����ͼ
DROP VIEW [IF EXISTS] view_name [, view_name] ...
