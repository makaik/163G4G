--�������ݿ�
create database db_sbm;
--ʹ�����ݿ�
use db_sbm;
--�������ݱ�
--�˻���

create table tb_user(
	userId int primary key identity(1001,1) not null,	--�û�ID
	userName varchar(20) not null,	--�û�����
	userPassword varchar(20) not null,	--�û�����
	userSex varchar(1) not null,	--�û��Ա�
	userAge int check(userAge>0 and userAge <120),	--�û�����
	telephone varchar(15) not null,	--�û��绰
	address varchar(50) not null,	--�û���ַ
	pic varchar(100) not null,	--�û�ͷ��
	type int not null	--�û�����
)



--��Ӧ�̱�

create table tb_provider(
	providerId int primary key identity(1001,1) not null,	--��Ӧ��ID
	providerName nvarchar(20) not null,		--��Ӧ������
	providerDetail nvarchar(20),	--��Ӧ������
	contact nvarchar(20) not null,	--��ϵ��
	telephone nvarchar(15) not null,	--��Ӧ�̵绰
	facsimile nvarchar(15) not null,	--��Ӧ�̴���
	address nvarchar(50) not null	--��Ӧ�̵�ַ
)

--��Ʒ��

create table tb_goods(
	goodsId int primary key identity(1001,1) not null,	--��ƷID
	goodsName nvarchar(30) not null,	--��Ʒ����
	goodsNum int check(goodsNum>0) not null,	--��Ʒ���
	goodsPrice float check(goodsPrice>0) not null, --��Ʒ�۸�
	goodsUnit nvarchar(4),	--��Ʒ��λ
	goodsIntro nvarchar(50) not null	--��Ʒ����
)

--�˵���

create table tb_account(
	accountId int primary key identity(1001,1) not null,	--�˵�ID
	providerId int not null,	--��Ӧ��ID
	totalPrice float not null,	--�����ܶ�
	isPayed int check(isPayed in(0,1)),	--�Ƿ񸶿�
	accountDate date not null,	--�˵�ʱ��
	goodsId int not null,	--��ƷID
	businessNum int not null	--��������
)
---------------------------------------------------
go
--��������
insert into tb_user values
('admin','123456','m',27,'18236238825','���','/photof.jpg',0),
('denga1','123123','m',27,'18539537138','���','/photof.jpg',0),
('tom','123123','m',27,'18539537138','���','/photof.jpg',0)

insert into tb_provider values
('��ӷھ��ܾ���','ȫ��������','����','18903956868','0395666888','��ӻ�վ��')

insert into tb_goods values
('111',100,998.00,'��','�ھ�����')
insert into tb_goods values
('222',100,998.00,'��','�ھ��ӻ���')
insert into tb_goods values
('333',100,998.00,'��','�ھ���Ҷ��')
insert into tb_goods values
('444',100,998.00,'��','�ھ�����')

insert into tb_account values
(1001,99800,1,GETDATE(),1001,100)

--���ݲ�ѯ
select * from tb_user
select * from tb_provider
select * from tb_goods
select * from tb_account
go

