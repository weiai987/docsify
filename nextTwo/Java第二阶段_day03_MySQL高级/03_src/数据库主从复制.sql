-- �޸���������master:
   #vi /etc/my.cnf
       [mysqld]
       log-bin=mysql-bin   //[����]���ö�������־
       server-id=222      //[����]������ΨһID��Ĭ����1��һ��ȡIP���һ��

-- �޸Ĵӷ�����slave:
   #vi /etc/my.cnf
       [mysqld]
       log-bin=mysql-bin   //[���Ǳ���]���ö�������־
       server-id=226      //[����]������ΨһID��Ĭ����1��һ��ȡIP���һ��

-- �����������ϼ����˺�2020/12/23
GRANT REPLICATION SLAVE ON *.* to 'mysync'@'%' identified by 'q123456'; 
-- һ�㲻��root�ʺţ�&ldquo;%&rdquo;��ʾ���пͻ��˶�������
-- ֻҪ�ʺţ�������ȷ���˴����þ���ͻ���IP���棬��192.168.145.226����ǿ��ȫ��

-- ��¼����������mysql����ѯmaster��״̬
   mysql>show master status;