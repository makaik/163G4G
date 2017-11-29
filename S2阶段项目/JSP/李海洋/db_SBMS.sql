create database db_SBMS;
use db_SBMS;
go
--用户表（tb_user）
create table tb_user(
userId int primary key identity(1001,1),--用户Id号
userName nvarchar(20) not null,--用户名称
userPassword nvarchar(20) not null,--用户密码
userSex	char(1)	not null,--用户性别
userAge	int	not null check(userAge>0 and userAge<120),--用户年龄
telephone nvarchar(20) not null,--用户电话
address	nvarchar(50) not null,--用户地址
pic	nvarchar(100) not null,--头像地址
type int not null--用户类型
)
--供应商表（tb_provider）
create table tb_provider(
providerId int primary Key identity(1,1),--供应商Id号
providerName nvarchar(20) not null,--供应商名称
providerDetail nvarchar(30),--供应商描述
contact	nvarchar(20) not null,--联系人
telephone nvarchar (15)	not null,--供应商电话
facsimile nvarchar (15)	not null,--供应商传真
address	nvarchar(40) not null--供应商地址
)
--商品表（tb_goods)
create table tb_goods(
goodsId	int	primary Key identity(1,1),--商品Id号
goodsName nvarchar(30) not null,--商品名称
goodsNum int not null check(goodsNum>0),--商品数量
goodsPrice float not null check(goodsPrice>0),--商品价格
goodsUnit nvarchar(4),--商品单位
goodsIntro nvarchar(50)	not null--商品描述
)
--账单表（tb_account）
create table tb_account(
accountId int primary Key identity(1,1),--账单Id号
totalPrice float check(totalPrice>0),--交易总金额
isPayed	int,--是否付款
accountDate	date not null,--账单时间
businessNum	int	check(businessNum >0),--交易数量
goodsId	int Not null,--商品Id号
providerId int Not null--供应商Id号
)
select * from tb_user;
select * from tb_provider;
select * from tb_goods;
select * from tb_account;
--修改
alter table tb_user alter column userAge int not null ;
insert into tb_user values('Sea','2588','m',18,'13687877788','河南邓州','/photo',0);
insert into tb_user values('Jack','2588','m',21,'13687866688','北京','/photo',1);

insert into tb_account values();

select top 4 * from tb_provider where providerId not in(select top 0 providerId from tb_provider)
select top 4 * from tb_user  where userId not in (select top 0 userId from tb_user ) 