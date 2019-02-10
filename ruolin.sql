SET NAMES utf8;
DROP DATABASE IF EXISTS ruolin;
CREATE DATABASE ruolin;
USE ruolin;

CREATE TABLE user(
  id INT AUTO_INCREMENT,
  uname VARCHAR(16),
  upwd VARCHAR(16),
  roleid INT,
  PRIMARY KEY (id)
);
 INSERT INTO user VALUES(null,'user01','123456',2);
 INSERT INTO user VALUES(null,'user02','123456',2);
 INSERT INTO user VALUES(null,'admin','123456',1);

CREATE TABLE role(
  id INT,
  rolename VARCHAR(16)
);
INSERT INTO role VALUES(1,'admin');
INSERT INTO role VALUES(2,'user');

CREATE TABLE permission(
  id SMALLINT AUTO_INCREMENT,
  pername VARCHAR(16),
  roleid SMALLINT,
  PRIMARY KEY (id)
);
INSERT INTO permission VALUES(null,'sys:add',1);
INSERT INTO permission VALUES(null,'sys:edit',1);
INSERT INTO permission VALUES(null,'sys:delete',1);
INSERT INTO permission VALUES(null,'sys:search',1);

 
CREATE TABLE equipment(
  id SMALLINT AUTO_INCREMENT,
  egroup VARCHAR(16),
  num VARCHAR(16),
  ename VARCHAR(16),
  type VARCHAR(16),
  address VARCHAR(16),
  PRIMARY KEY (id)
  
);
INSERT INTO equipment VALUES(null,'燃烧试验区域','A001-RSC-001','1号高温仓','环境仓','试验配套区域（东区）');
INSERT INTO equipment VALUES(null,'燃烧试验区域','A001-RSC-002','2号高温仓','环境仓','试验配套区域（西区）');
INSERT INTO equipment VALUES(null,'耐久试验区域','A001-NJC-001','3号高温仓','环境仓','试验配套区域（西区）');
INSERT INTO equipment VALUES(null,'耐久试验区域','A001-NJC-002','1号低温仓','环境仓','试验配套区域（北区）');
INSERT INTO equipment VALUES(null,'低温试验区域','A001-DWC-001','2号低温仓','环境仓','试验配套区域（北区）');
INSERT INTO equipment VALUES(null,'低温试验区域','A001-DWC-002','3号低温仓','环境仓','试验配套区域（西区）');
INSERT INTO equipment VALUES(null,'压力试验区域','A001-YLC-001','1号重力仓','环境仓','试验配套区域（南区）');
INSERT INTO equipment VALUES(null,'压力试验区域','A001-YLC-001','1号重力仓','环境仓','试验配套区域（南区）');

CREATE TABLE equipUser(
  id INT AUTO_INCREMENT,
  user_id INT,
  equip_id INT,
  PRIMARY KEY (id)
);
INSERT INTO equipUser VALUES(null,1,1);
INSERT INTO equipUser VALUES(null,1,2);
INSERT INTO equipUser VALUES(null,1,3);
INSERT INTO equipUser VALUES(null,1,4);
INSERT INTO equipUser VALUES(null,1,5);
INSERT INTO equipUser VALUES(null,1,6);
INSERT INTO equipUser VALUES(null,1,6);
INSERT INTO equipUser VALUES(null,1,7);
INSERT INTO equipUser VALUES(null,2,1);
INSERT INTO equipUser VALUES(null,2,3);
INSERT INTO equipUser VALUES(null,2,4);
INSERT INTO equipUser VALUES(null,2,5);
INSERT INTO equipUser VALUES(null,2,7);
INSERT INTO equipUser VALUES(null,2,8);