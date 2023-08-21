-- 修改主服务器master:
   #vi /etc/my.cnf
       [mysqld]
       log-bin=mysql-bin   //[必须]启用二进制日志
       server-id=222      //[必须]服务器唯一ID，默认是1，一般取IP最后一段

-- 修改从服务器slave:
   #vi /etc/my.cnf
       [mysqld]
       log-bin=mysql-bin   //[不是必须]启用二进制日志
       server-id=226      //[必须]服务器唯一ID，默认是1，一般取IP最后一段

-- 在主服务器上加入账号2020/12/23
GRANT REPLICATION SLAVE ON *.* to 'mysync'@'%' identified by 'q123456'; 
-- 一般不用root帐号，&ldquo;%&rdquo;表示所有客户端都可能连
-- 只要帐号，密码正确，此处可用具体客户端IP代替，如192.168.145.226，加强安全。

-- 登录主服务器的mysql，查询master的状态
   mysql>show master status;