create table if not exists user
(
	id int unsigned auto_increment comment '用户编号'
		primary key,
	username varchar(20) not null comment '用户名',
	password char(32) not null comment '密码',
	email varchar(50) not null comment '邮箱',
	age tinyint unsigned default 18 not null comment '年龄',
	sex enum('man', 'woman', 'baomi') default 'baomi' not null comment '性别',
	tel char(11) not null comment '电话',
	addr varchar(50) default 'beijing' not null comment '地址',
	card char(18) not null comment '身份证号',
	married tinyint(1) default 0 not null comment '0代表未结婚，1代表已结婚',
	salary float(8,2) default 0.00 not null comment '薪水',
	constraint card
		unique (card),
	constraint email
		unique (email),
	constraint tel
		unique (tel)
);

create index id
	on user (id, username, age);