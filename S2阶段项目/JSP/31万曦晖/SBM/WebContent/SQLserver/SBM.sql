--创建数据库
create database db_SBM;
--使用数据库
use db_SBM;
--创建数据表
--账户表

create table tb_user(
	userId int primary key not null,	--用户ID
	userName varchar(20) not null,	--用户名称
	userPassword varchar(20) not null,	--用户密码
	userSex varchar(1) not null,	--用户性别
	userAge int check(userAge>0 and userAge <120),	--用户年龄
	telephone varchar(15) not null,	--用户电话
	address varchar(50) not null,	--用户地址
	pic varchar(100) not null,	--用户头像
	type int not null	--用户类型
)



--供应商表

create table tb_provider(
	providerId int primary key not null,	--供应商ID
	providerName nvarchar(20) not null,		--供应商姓名
	providerDetail nvarchar(20),	--供应商描述
	contact nvarchar(20) not null,	--联系人
	telephone nvarchar(15) not null,	--供应商电话
	facsimile nvarchar(15) not null,	--供应商传真
	address nvarchar(50) not null	--供应商地址
)

--商品表

create table tb_goods(
	goodsId int primary key not null,	--商品ID
	goodsName nvarchar(30) not null,	--商品名称
	goodsNum int check(goodsNum>0) not null,	--商品库存
	goodsPrice float check(goodsPrice>0) not null, --商品价格
	goodsUnit nvarchar(4),	--商品单位
	goodsIntro nvarchar(50) not null	--商品详情
)

--账单表

create table tb_account(
	accountId int primary key not null,	--账单ID
	providerId int not null,	--供应商ID
	totalPrice float not null,	--交易总额
	isPayed int check(isPayed in(0,1)),	--是否付款
	accountDate date not null,	--账单时间
	goodsId int not null,	--商品ID
	businessNum int not null	--交易数量
)
go
--插入数据
insert into tb_user values
(1001,'Killer','123456','m',27,'18236238825','檀香山','/photo/lwf.jpg',0)

insert into tb_provider values
(1001,'中国三鹿奶粉有限公司','全国经销商','Boos','110001','123000','火车站北')

insert into tb_goods values
(1,'111',100,998.00,'罐','奶粉X')
insert into tb_goods values
(2,'222',100,998.00,'罐','奶粉K')
insert into tb_goods values
(3,'333',100,998.00,'罐','奶粉J')
insert into tb_goods values
(4,'444',100,998.00,'罐','奶粉Pro')

insert into tb_account values
(10001,1001,99800,1,GETDATE(),1,100)

--数据查询
select * from tb_user
select * from tb_provider
select * from tb_goods
select * from tb_account
go

