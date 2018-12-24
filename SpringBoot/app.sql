create table if not exists  users(
  id uuid not null,
  name char(16) not null ,
  pwd char(16) not null,
  constraint users_pkey primary key (id)
);
insert into users(id, name, pwd) VALUES (1,'axa-001','123456');
insert into users(id, name, pwd) VALUES (2,'axa-002','123456');
insert into users(id, name, pwd) VALUES (3,'axa-003','123456');
insert into users(id, name, pwd) VALUES (4,'axa-004','123456');

create table if not exists role(
  id smallint not null,
  role varchar(16)
);
insert into role(id, role) VALUES (1,'ROLE_ADMIN');
insert into role(id, role) VALUES (2,'ROLE_USER');

create table if not exists user_role(
  user_id smallint not null ,
  role_id smallint not null ,
  constraint user_role_pkey primary key (user_id),
  constraint user_role_pkey primary key (role_id)
);
insert into user_role(user_id, role_id) VALUES (1,1);
insert into user_role(user_id, role_id) VALUES (2,1);
insert into user_role(user_id, role_id) VALUES (2,2);

create table if not exists equip(
  id varchar(32) not null ,
  num smallint not null ,
  equipGroup varchar(16) not null ,
  name varchar(32) not null ,
  type varchar(16),
  address varchar(128)
);
insert into equip(id, num, equipGroup, name, type, address) VALUES ('A001-HJC-001',001,'燃烧试验区','1号高温仓','环境仓','试验配套区域（东区）');
insert into equip(id, num, equipGroup, name, type, address) VALUES ('A001-HJC-002',002,'燃烧试验区','2号高温仓','环境仓','试验配套区域（西区）');
insert into equip(id, num, equipGroup, name, type, address) VALUES ('A001-HJC-003',003,'耐久试验区','3号高温仓','环境仓','试验配套区域（南区）');
insert into equip(id, num, equipGroup, name, type, address) VALUES ('A001-HJC-004',004,'耐久试验区','4号高温仓','环境仓','试验配套区域（北区）');
insert into equip(id, num, equipGroup, name, type, address) VALUES ('A001-HJC-005',005,'低温试验区','1号低温仓','环境仓','试验配套区域（东区）');
insert into equip(id, num, equipGroup, name, type, address) VALUES ('A001-HJC-006',006,'低温试验区','2号低温仓','环境仓','试验配套区域（东区）');