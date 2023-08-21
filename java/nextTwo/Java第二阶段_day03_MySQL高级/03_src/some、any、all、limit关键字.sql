-- ����һ��ְλ��
CREATE TABLE salary_table(
  id SMALLINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  position VARCHAR(40) NOT NULL,
  salary INT);
insert salary_table(position,salary) values('JAVA',8000),('Java',8400),('Java',9000),('Python',6500),('Python',10000),('Python',8900);
select *  from salary_table;

-- ���ҳ����� Python  ְλ��һְλ���ʵ�����ְλ
SELECT * FROM salary_table
  WHERE salary > ANY( SELECT salary FROM salary_table WHERE position = 'Python')
    and position not like '%Python%';

-- ���ҳ����� Python  ְλ�κ�ְλ���ʵ�����ְλSELECT * FROM salary_table
  WHERE salary > all( SELECT salary FROM salary_table WHERE position = 'Python')
    and position not like '%Python%';

-- ���ҳ�����Python  ְλ�κ�ְλ���ʵ�����ְλ
SELECT * FROM salary_table
  WHERE salary = any( SELECT salary FROM salary_table WHERE position = 'Python')
    and position not like '%Python%';

-- limit��һ�������������
select * from emp limit 3;
select * from emp order by emp_id desc limit 3;
select * from emp order by hiredate limit 3;
-- ��������������£���1������Ϊ��������践�ص���ʼ��¼λ�ã���1��ʼ������n����¼��ʼ�㣩
-- ��2�������Ǵӿ�ʼ���صļ�¼���践�ص�������
select * from emp limit 3,2;
select * from emp order by emp_id desc limit 3,2;
select * from emp order by hiredate limit 3;
	