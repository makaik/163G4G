create database db_user

use db_user

create table tb_user(
uid int primary key identity(1,1),
uname varchar(20) not null,
upwd varchar(50) not null,
sex int not null,
eduction varchar(10) not null 

)
select * from tb_user 
insert into tb_user values('tom','123456',1,'´ó×¨')


