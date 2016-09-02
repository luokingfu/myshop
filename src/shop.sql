/*删除商城数据库,如果存在*/
drop database if exists shop;
/*创建数据库,并设置编码*/
create database shop default character set utf8;

use shop;
/*删除管理员表*/
drop table if exists account;
/*删除商品类别表*/
drop table if exists category;

/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
   /* 管理员编号,自动增长 */
   a_id                  int not null auto_increment,
   /* 管理员登录名  */
   login               varchar(20),
   /* 管理员姓名  */
   name                varchar(20),
   /* 管理员密码 */
   pass                varchar(20),
   /* 设置编号为主键 */
   primary key (a_id)
);

/*=============================*/
/* Table: 商品类别表结构 		   */
/*=============================*/
create table category
(
   /* 类别编号,自动增长 */
   c_id                  int not null auto_increment,
   /* 类别名称 */
   type                varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   hot                 bool default false,
   /* 外键,此类别由哪位管理员管理 */
   aid                  int,
   /* 设置类别编号为主键 */
   primary key (c_id)
);

/*=============================*/
/* Table: 商品表结构	 		   */
/*=============================*/
create table product
(
   /* 商品编号,自动增长 */
   p_id                  int not null auto_increment,
   /* 商品名称 */
   name                varchar(20),
   /* 商品价格 */
   price               decimal(8,2),
   /* 商品图片 */
   pic                 varchar(200),
   /* 商品简单介绍 */
   remark              varchar(500),
   /* 商品详细介绍 */
   xremark             varchar(500),
   /* 商品生产日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
   commend             bool,
   /* 是否为有效商品,有效商品才有可能显示在商城首页 */
   open                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   /* 设置商品编号为主键 */
   primary key (p_id)
);

ALTER TABLE product AUTO_INCREMENT = 201288888;

/*============================*/
/* Table: 游客表结构 		  */
/*============================*/
create table user
(
   /* 用户编号,自动增长 */
   u_id                  int not null auto_increment,
   /* 用户登录名 */
   login               varchar(20),
   /* 用户登录密码 */
   pass                varchar(20),
   /* 用户性别 */
   sex                 varchar(20),
   /* 用户电话 */
   phone               varchar(20),
   /* 用户Email */
   email               varchar(20),
   /* 设置用户编号为主键 */
   primary key (u_id)
);

/*=============================*/
/* Table: 订单状态表结构 		   */
/*=============================*/
create table status
(
   /* 状态编号,自动增长 */
   s_id                  int not null auto_increment,
   /* 订单状态 */
   status               varchar(10),
   /* 设置订单编号为主键 */
   primary key (s_id)
);

/*=============================*/
/* Table: 订单表结构用来存储项目购物信息  */
/*=============================*/
create table forder
(
   /* 订单编号,自动增长 */
   f_id                int not null auto_increment,
   /* 收件人名字 */
   f_name              varchar(20),
   /* 收件人电话 */
   phone               varchar(20),
   /* 配送信息 */
   detail              varchar(20),
   /* 下单日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* 订单总金额 */
   total               decimal(8,2),
   /* 收件人邮编 */
   post                varchar(20),
    /* 收件人地址 */
   address             varchar(200),
   /* 订单状态 */
   sid                 int default 1,
   /* 会员编号 */
   uid                 int,
   /* 设置订单编号为主键 */
   primary key (f_id)
);

/* 修改自动增长的初始值 */
ALTER TABLE forder AUTO_INCREMENT = 2000021801;

/*=============================*/
/* Table: 购物项表结构 		   */
/*=============================*/

create table sorder
(
   /* 购物项编号,自动增长 */
   s_id                int not null auto_increment,
   /* 被购买商品的名称 */
   s_name                varchar(20),
   /* 购买时商品的价格 */
   s_price               decimal(8,2),
   /* 购买的数量 */
   number              int not null,
   /* 所属商品编号 */
   pid                  int,
   /* 此订单项,所属的订单编号 */
   fid                  int,
   /* 设置购物项编号为主键 */
   primary key (s_id)
);

create table role
(
	r_id int not null auto_increment,
	r_name  varchar(20),
	detail varchar(200),
	primary key(r_id)
);

create table account_role
(
	aid int,
	rid int,
	primary key(aid,rid)
);

/* 权限表, 例如 "添加商品", "查询类别".... */
create table permission(
	p_id int not null auto_increment,
	name varchar(20), 
	primary key(p_id)
);
/* 存储url地址,与权限名称,是多对一的关系 */
create table url(
	u_id int not null auto_increment,
	address varchar(20),
	pid int, 
	primary key(u_id)
);

create table permission_role
(
	pid int,
	rid int,
	primary key(pid,rid)
);

/*插入测试用例*/
INSERT INTO account(login,name,pass) values ('admin','管理员','admin');
INSERT INTO account(login,name,pass) values ('user','客服A','user');

INSERT INTO category (type,hot,aid) VALUES ('男士休闲',true,1);
INSERT INTO category (type,hot,aid) VALUES ('女士休闲',true,1);
INSERT INTO category (type,hot,aid) VALUES ('儿童休闲',true,2);
INSERT INTO category (type,hot,aid) VALUES ('老人休闲',true,2);


/* 商品测试用例 */
INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('圣得西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('罗蒙西服',0.01,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('衫衫西服',3999.40,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('金利来西服',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('韩版女装',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('雪地靴',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('欧版女装',3999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('女款手套',4999.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('佳能单反机',3998.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('金士顿优盘',299.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('日立硬盘',599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('大水牛机箱',399.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('电脑桌',150.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('老板椅',199.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('空调',3599.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('电视',699.00,'test.jpg','这里是简单介绍','这里是详细介绍',true,true,4);

/*插入状态测试用例*/
INSERT INTO status (status) VALUES ('未支付');
INSERT INTO status (status) VALUES ('已支付');
INSERT INTO status (status) VALUES ('配送中');
INSERT INTO status (status) VALUES ('订单完成');

INSERT INTO user (login,pass,sex,phone,email) VALUES ('user01','user01','男','18312345678','10000@qq.com');
/*插入购物车测试用例*/
INSERT INTO forder (f_name,phone,detail,date,total,address,post,uid) VALUES ('bb','123','备注',default,200.3,'广州天河区','1000',1);

/*插入购物车项测试用例*/
INSERT INTO sorder (s_name,s_price,number,pid,fid) VALUES ('空调',200,1,15,2013021801);
INSERT INTO sorder (s_name,s_price,number,pid,fid) VALUES ('电视',0.3,1,16,2013021801);

insert into role(r_name,detail)values('ROLE_ADMIN','可以拥有系统的所有权限');
insert into role(r_name,detail)values('ROLE_USER','仅仅拥有操作商品的权限');

insert into account_role(aid,rid)values(1,1);
insert into account_role(aid,rid)values(2,2);

insert into url(address,pid)values('/user/save.jsp',1);
insert into url(address,pid)values('/user/save2.jsp',1);
insert into url(address,pid)values('/admin/delete.jsp',2);

insert into permission(name)values('添加商品');
insert into permission(name)values('删除商品');


insert into permission_role(pid,rid)values(1,1);
insert into permission_role(pid,rid)values(2,1);
insert into permission_role(pid,rid)values(1,2);

SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM user;
SELECT * FROM status;


SELECT * FROM account;
SELECT * FROM account_role;
SELECT * FROM role;
select * from url;
select * from permission;
select * from permission_role;

 select * from url u join permission p on u.pid=p.p_id join permission_role pr on p.p_id=pr.pid
	  	  join role r on pr.rid=r.r_id