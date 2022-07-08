# mysql基于docker搭建主从

## master服务实例配置

### 新建文件夹

```` shell
mkdir  /var/data/mysql/master/log
mkdir  /var/data/mysql/master/data 
mkdir  /var/data/mysql/master/conf 
mkdir  /var/data/mysql/master/mysql-files
````

### conf目录下新建my.cnf

```` shell
touch my.cnf
vim my.cnf

[mysqld]
server_id = 1
log-bin=mysql-bin
read-only=0
binlog-do-db=jan
replicate-ignore-db=mysql
replicate-ignore-db=sys
replicate-ignore-db=information_schema
replicate-ignore-db=performance_schema
````

### 创建master容器

```` shell
docker run -p 3307:3306 --name mysql-master \
-v /var/data/mysql/master/log:/var/log/mysql \
-v /var/data/mysql/master/data:/var/lib/mysql \
-v /var/data/mysql/master/conf:/etc/mysql \
-v /var/data/mysql/master/mysql-files:/var/lib/mysql-files \
-e MYSQL_ROOT_PASSWORD=root \
--privileged=true \
-d mysql/mysql-server

````

### 创建用户 

```` mysql
create user 'zhuling'@'%' identified by '123456';
grant all on *.* to zhuling@'%';
FLUSH PRIVILEGES;
````

> 授予用户 slave REPLICATION SLAVE权限和REPLICATION CLIENT权限，用于在主从库之间同步数据。

```` mysql
CREATE USER 'slave'@'%' IDENTIFIED BY '123456';
````

```` mysql
GRANT REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'slave'@'%';
````

```` mysql
FLUSH PRIVILEGES;
````

### master查看主机信息

```` mysql
show master status;
````



## slave服务实例配置

### 新建文件夹

```` shell
mkdir  /var/data/mysql/slave/log
mkdir  /var/data/mysql/slave/data 
mkdir  /var/data/mysql/slave/conf 
mkdir  /var/data/mysql/slave/mysql-files
````

### conf目录下新建my.cnf

```` shell
touch my.cnf
vim my.cnf

[mysqld]
server_id = 2
log-bin=mysql-bin
read-only=1
binlog-do-db=jan
replicate-ignore-db=mysql
replicate-ignore-db=sys
replicate-ignore-db=information_schema
replicate-ignore-db=performance_schema
````

### 创建slave容器

```` shell
docker run -p 3308:3306 --name mysql-slave \
-v /var/data/mysql/slave/log:/var/log/mysql \
-v /var/data/mysql/slave/data:/var/lib/mysql \
-v /var/data/mysql/slave/conf:/etc/mysql \
-v /var/data/mysql/slave/mysql-files:/var/lib/mysql-files \
-e MYSQL_ROOT_PASSWORD=root \
--privileged=true \
-d mysql/mysql-server

````

```` mysql
stop slave;
````

```` mysql
reset slave;
````

```` shell
mysql -u slave -p123456 -h 192.168.1.101 -P3307 --get-server-public-key
````

```` mysql
change master to master_host='192.168.50.152',
       master_user='slave', master_password='123456',
       master_port=3307, master_log_file='mysql-bin.000006',
       master_log_pos=12147, master_connect_retry=30;
````

```` mysql
start slave;
````

```` mysql
show slave status\G;
````
