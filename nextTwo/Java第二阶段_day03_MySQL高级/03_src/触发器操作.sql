-- ����׼��
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


-- �򵥴�����1
delimiter $
create trigger t1 
  after insert
  on ord
  for each row
  begin
    update goods set num=num-2 where gid = 1;
end$

-- ����׼��
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

-- �򵥴�����2
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

-- ����ֵ�Ĵ�����
delimiter $
create trigger t3
  after insert
  on ord
  for each row
  begin
    -- new ���� ord ��������������
    update goods set num = num - new.much where gid = new.gid;
end$

-- ���жϵĴ�����
delimiter $
create trigger t4
  before insert
  on ord
  for each row
  begin
    -- ȡ�� goods ���ж�Ӧ id �Ŀ��
    -- new ���� orders ��������������
    select num from goods where gid = new.gid into @num;    
    -- �ü�������� orders ���еĿ��� goods ���еĿ����бȽ�
    -- �����治�����жϲ���
    if @num < new.num then
        -- �жϲ����������������������
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

-- �鿴������
show triggers;
select * from information_schema.TRIGGERS;
select * from information_schema.TRIGGERS where trigger_schema='test' and event_object_table='ord';


-- �鿴���������������
show create trigger ����������;

-- ɾ��������
drop trigger ����������;



