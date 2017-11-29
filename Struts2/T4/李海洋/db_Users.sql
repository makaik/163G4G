create database db_Users;
use db_Users;
go
--用户表（tb_user）
create table tb_user(
userId int primary key identity(1001,1),--用户Id号
userName nvarchar(20) not null,--用户名称
userPassword nvarchar(20) not null,--用户密码
userSex char(2) check(userSex in('男','女')) default '男',--用户性别
userAge	int	not null check(userAge>0 and userAge<120),--用户年龄
phone nvarchar(20) not null,--用户电话
QQ nvarchar(20) not null,--用户QQ
address	nvarchar(50) not null--用户地址
)
select * from tb_user