-- 数据准备
drop table 成绩;
drop table 学生;
drop table 科目;
CREATE TABLE IF NOT EXISTS 学生 (	id int PRIMARY KEY,
	name varchar(10),
);
CREATE TABLE IF NOT EXISTS 科目 (	id int PRIMARY KEY,
	name varchar(10)
);
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2),
	CONSTRAINT fk_c_s FOREIGN KEY(学生ID) REFERENCES 学生(id),
	CONSTRAINT fk_c_k FOREIGN KEY(科目ID) REFERENCES 科目(id)
);

show indexes from 成绩;

-- 在向从表中插入数据时：
insert into 成绩 values(1, null, null, 12.3);
insert into 成绩(id, 成绩) values (2, 12.3);
insert into 成绩 values(3, 2, 3, 12.3);
Cannot add or update a child row: a foreign key constraint fails (`test`.`成绩`, CONSTRAINT `fk_c_s` FOREIGN KEY (`学生ID`) REFERENCES `学生` (`id`))

insert into 学生 values(2, 'aaa');
insert into 科目 values(3, 'bbb');

-- 在向从表中更新数据时：
update 成绩 set 学生ID=3 where id=3;
 Cannot add or update a child row: a foreign key constraint fails (`test`.`成绩`, CONSTRAINT `fk_c_s` FOREIGN KEY (`学生ID`) REFERENCES `学生` (`id`))
 update 成绩 set 学生ID=null where id=3;
-- 如果外键字段更新后的值，在不为null时，必须在关联的主表字段中存在时，才能更新成功，否则报错。**
-- 在向主表中更新存在已关联从表的字段数据时：
update 学生 set id=3 where id=2;
delete from 学生 where id=2;
Cannot delete or update a parent row: a foreign key constraint fails (`test`.`成绩`, CONSTRAINT `fk_c_s` FOREIGN KEY (`学生ID`) REFERENCES `学生` (`id`))

-- 在主表删除存在已关联从表的字段数据时：
delete from 学生 where id=2;
Cannot delete or update a parent row: a foreign key constraint fails (`test`.`成绩`, CONSTRAINT `fk_c_s` FOREIGN KEY (`学生ID`) REFERENCES `学生` (`id`))

-- 在修改表时添加外键约束
drop table 成绩;
drop table 学生;
drop table 科目;
CREATE TABLE IF NOT EXISTS 学生 (	id int PRIMARY KEY,
	name varchar(10)
);
CREATE TABLE IF NOT EXISTS 科目 (	id int PRIMARY KEY,
	name varchar(10)
);
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2)
);
alter table 成绩 add constraint 成绩_学生ID_fk0  foreign key (学生ID) references 学生 (id);
alter table 成绩 add constraint 成绩_科目ID_fk0  foreign key (科目ID) references 科目 (id);


-- 不允许级联操作
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2),
	CONSTRAINT fk_c_s FOREIGN KEY(学生ID) REFERENCES 学生(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_c_k FOREIGN KEY(科目ID) REFERENCES 科目(id)
);
--或者如下
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2),
	CONSTRAINT fk_c_s FOREIGN KEY(学生ID) REFERENCES 学生(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_c_k FOREIGN KEY(科目ID) REFERENCES 科目(id)
);

-- 进行no action设置之后，与未设置级联操作一致（no action实际是默认模式），删除和更新会报错。

-- 级联更新
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2),
	CONSTRAINT fk_c_s FOREIGN KEY(学生ID) REFERENCES 学生(id) ON UPDATE CASCADE,
	CONSTRAINT fk_c_k FOREIGN KEY(科目ID) REFERENCES 科目(id)
);
-- 进行了on update cascade设置之后，update操作主表，将主表数据和从表中关联的数据字段都一并更新。

 update 学生 set id=3 where id=2;
 select * from 学生;
 select * from 成绩;

-- 级联删除
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2),
	CONSTRAINT fk_c_s FOREIGN KEY(学生ID) REFERENCES 学生(id) ON delete CASCADE,
	CONSTRAINT fk_c_k FOREIGN KEY(科目ID) REFERENCES 科目(id)
);
-- 进行了on delete cascade设置之后，delete操作主表，将主表数据和从表中关联的数据都一并删除。

 delete from 学生 where id=2;
 select * from 学生;
 select * from 成绩;
-- on update cascade 与 on delete cascade 可以连起来写。

-- 级联设置为null
CREATE TABLE IF NOT EXISTS 成绩 (	id int PRIMARY KEY,
	学生ID INT(10),
	科目ID INT(10),
	成绩 DECIMAL(10,2),
	CONSTRAINT fk_c_s FOREIGN KEY(学生ID) REFERENCES 学生(id) ON delete set null,
	CONSTRAINT fk_c_k FOREIGN KEY(科目ID) REFERENCES 科目(id)
);
-- 进行了on delete set null 或 on update set null 设置之后，delete 或 update 操作主表，将主表数据和从表中关联的数据字段都一并设为null。
 delete from 学生 where id=2;
 select * from 学生;
 select * from 成绩;
		
​		