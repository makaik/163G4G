create database db_user;

use db_user;

create table tb_user(	
	uname varchar(50) not null,
	pswd varchar(50),
	edu varchar(50),
	sex varchar(10)
)

select * from tb_user
