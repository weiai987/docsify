-- ���ݿ�����ʾ��
  begin;
  update student set sname='����' where id=;
  rollback;
  commit;

-- ֱ���� SET ���ı� MySQL ���Զ��ύģʽ:
-- SET AUTOCOMMIT=0 ��ֹ�Զ��ύ
-- SET AUTOCOMMIT=1 �����Զ��ύ

  show session variables like 'autocommit';  --�鿴�Զ��ύ״̬
  set session autocommit = 0;  --�ر��Զ��ύ
  set session autocommit = off;  --�ر��Զ��ύ
  update student set sname='����';
  rollback;
  commit;

-- �������Ǵ���һ������Ϊ���Ա�
drop table if exists test_trac;
create table if not exists test_trac (
    t_id varchar(16) primary key,
    t_name varchar(32)
);

-- ���ǿ������Ự��һ���ÿͻ���(�ỰA)��һ����������(�ỰB)���ỰA��������
insert into test_trac values('aaa', 'bbb');  --�ڻỰA��ִ��
-- �ڻỰB�϶�ȡ���ᷢ���޷���ȡδ�ύ�����ݣ��ỰAִ��commit�󣬻ỰB����������ȡ��

-- ���ỰB��������뼶����Ϊ����δ�ύ��
sessionB: set session transaction isolation level read uncommitted;
sessionB: start transaction;
sessionB: select * from test_trac;
-- ��ʾ�ỰA����֮ǰ��ֵ
sessionA: start transaction;
sessionA: insert into test_trac values('ccc0', 'aaa');
-- ��sessionAδ�ύ������£��ỰB�ɶ�ȡ���ỰA��δ�ύ��insert�����������ѯ�����޸ģ������ض�������ѯ�����������ö�����


-- ���ỰB��������뼶����Ϊ�������ύ��
sessionB: set session transaction isolation level read committed;
sessionB: start transaction;  --��������
sessionB: select * from test_trac where t_name='aaa';
-- �ỰAҲ��������
sessionA: start transaction;
sessionA: insert into test_trac values('ccc1', 'aaa');
-- ��sessionAδ�ύ������£�sessionB������������¼������sessionA���ύ
sessionA: commit;
sessionB: select * from test_trac where t_name='aaa';
-- �ؼ��ǻỰB���Լ�������δ����ύ�����У���ȡ���˻ỰA�ύ�����ݡ�

-- ���ڰѻỰB�ĸ��������Ϊ�����ظ�����
sessionB: set session transaction isolation level repeatable read;
sessionB: start transaction;  --��������
sessionB: select * from test_trac where t_name='bbb';
-- ���ظ���������
sessionA: start transaction;  --��������
sessionA: insert into test_trac values('ddd0', 'bbb');
sessionA: commit;
-- ��Ȼ�ỰA���ύ���񣬻ỰB��ѯ���ò����µ�ֵ�����ǻỰBҲ�ύ��
sessionB: commit;
sessionB: select * from test_trac where t_name='bbb';
-- �ö�������
sessionA: start transaction; 
sessionB: start transaction;
sessionA: select * from test_trac where t_name='bbb';
sessionB: select * from test_trac where t_name='bbb';
-- �ỰA��B��������󣬶�ȡ�Ľ�������ỰA���ֿ��Բ���ĳ��ֵ�����벢�ύ���ỰBҲҪ����ͬ����ֵ���������������ͻ��Ҳ�������ݿ���ڲ�ѯ֮�������˶�Ӧ�����ݡ����ǻỰB�������в�֪������ı䡣
sessionA: insert into test_trac values('ddd1', 'bbb');
sessionA: commit;
sessionB: insert into test_trac values('ddd1', 'bbb');
sessionB: ERROR 1062 (23000): Duplicate entry 'ddd1' for key 'PRIMARY'
-- ����ỰA����һ������ֵ��δ�ύ���ỰB����ͬ��������ֵ���ڻỰAδ�ύ������±�������ָ���ỰA�ύ��ع���

-- ���ڰѻỰB�ĸ��������Ϊ�����л���
sessionB: set session transaction isolation level serializable;
sessionB: start transaction;  --��������
-- �ڴ˸���ȼ��£�һ����ĳ�����������insert��update��delete�������������ݣ����������Ự��select�����ᱻ���������Ǹ��µĻỰ���ύ��
-- ��������Ự�����¹��ˣ���һ���Ựselect���������ڶ����Ự����selectֱ�ӱ���
ERROR 1213 (40001): Deadlock found when trying to get lock; try restarting transaction