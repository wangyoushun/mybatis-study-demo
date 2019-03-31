
drop table if exists mybatis_demo_classroom;
CREATE TABLE `mybatis_demo_classroom` (
	`id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`name` VARCHAR (50) DEFAULT NULL COMMENT '名称',
	`address` VARCHAR (50) DEFAULT NULL COMMENT '地址',
	`is_deleted` CHAR (1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y-是 N-否',
	`creator` VARCHAR (50) NOT NULL DEFAULT 'system' COMMENT '创建人',
	`modifier` VARCHAR (50) NOT NULL DEFAULT 'system' COMMENT '修改人',
	`gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
	`gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '教室表';

drop table if exists mybatis_demo_student;
CREATE TABLE `mybatis_demo_student` (
	`id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`class_id` BIGINT (20) not null COMMENT '教室id',
	`number` VARCHAR (50) DEFAULT NULL COMMENT '学号',
	`name` VARCHAR (50) DEFAULT NULL COMMENT '姓名',
	`age` int (4) DEFAULT 0 COMMENT '年龄',
  `sex` char(1) DEFAULT '' COMMENT '性别 m 男 w 女' ,
	`is_deleted` CHAR (1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y-是 N-否',
	`creator` VARCHAR (50) NOT NULL DEFAULT 'system' COMMENT '创建人',
	`modifier` VARCHAR (50) NOT NULL DEFAULT 'system' COMMENT '修改人',
	`gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
	`gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB  DEFAULT CHARSET = utf8 COMMENT = '学生表';

CREATE TABLE `mybatis_demo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `u_id` varchar(64) NOT NULL COMMENT 'uid',
  `opt_type` char(2) DEFAULT '01' COMMENT '操作类型 01 浏览 02 新增 03 更新 04 删除',
  `extra_info` varchar(50) DEFAULT NULL,
  `is_deleted` char(1) NOT NULL DEFAULT 'N' COMMENT '是否删除 Y-是 N-否',
  `creator` varchar(50) NOT NULL DEFAULT 'system' COMMENT '创建人',
  `modifier` varchar(50) NOT NULL DEFAULT 'system' COMMENT '修改人',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作记录表';



INSERT INTO `study`.`mybatis_demo_classroom` (`id`, `name`, `address`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('1', '上海一中', '上海青浦区', 'N', 'wys', 'wys', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_classroom` (`id`, `name`, `address`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('2', '上海2中', '上海青浦区', 'N', 'wys', 'wys', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_classroom` (`id`, `name`, `address`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('3', '上海3中', '上海青浦区', 'N', 'wys', 'wys', '2019-03-10 19:25:13', '2019-03-10 19:25:13');

INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('21', '1', 'c5628ce1-7c77-4576-8ebc-2f9f61f7cf9b', 'stu0', '0', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('22', '1', '2583411c-a195-4115-b4bc-e43c60285c8e', 'stu1', '2', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('23', '1', '015a1eef-566d-453f-bafa-4e1aeb210e0b', 'stu2', '4', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('24', '1', '0a89d23b-ad2c-4054-833f-7657842a31e4', 'stu3', '6', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('25', '1', '37bb1ce6-263e-4b0a-8534-7aa501afbc92', 'stu4', '8', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('26', '1', '383ecfbf-94d7-4374-bcc2-c6ea31ea21e6', 'stu5', '10', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('27', '1', 'c535b518-4e8b-448b-855f-9863b857c184', 'stu6', '12', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('28', '1', 'd8b6f8f8-afd8-4e7c-951d-1b69a03bf72f', 'stu7', '14', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('29', '1', '16d4f688-12f6-40c5-b579-fbd8fc6ee987', 'stu8', '16', 'M', 'N', 'system', 'system', '2019-03-10 19:23:52', '2019-03-10 19:23:52');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('41', '2', 'ade0dd4f-0fb0-449b-8499-8bcd62116a8d', 'stu0', '0', 'M', 'N', 'system', 'system', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('42', '2', '60a32046-e5a7-46fc-b5df-cce29865fd54', 'stu1', '2', 'M', 'N', 'system', 'system', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('43', '2', '084cad27-d889-4d34-9af4-a46da8f6a4d7', 'stu2', '4', 'M', 'N', 'system', 'system', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('44', '2', '97f38ca4-3aae-4e99-a0fb-37b4c61a2167', 'stu3', '6', 'M', 'N', 'system', 'system', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('45', '2', '18959be0-1664-4224-a8e0-c549435a404d', 'stu4', '8', 'M', 'N', 'system', 'system', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('46', '2', 'a35d0567-1000-4dd1-a05b-c4c49e799cd1', 'stu5', '10', 'M', 'N', 'system', 'system', '2019-03-10 19:25:00', '2019-03-10 19:25:00');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('47', '3', 'b7174573-65c0-45e8-9594-626e27ede607', 'stu0', '0', 'M', 'N', 'system', 'system', '2019-03-10 19:25:13', '2019-03-10 19:25:13');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('48', '3', '161e9302-fd1a-4cfb-b4ef-689f23eee3b2', 'stu1', '2', 'M', 'N', 'system', 'system', '2019-03-10 19:25:13', '2019-03-10 19:25:13');
INSERT INTO `study`.`mybatis_demo_student` (`id`, `class_id`, `number`, `name`, `age`, `sex`, `is_deleted`, `creator`, `modifier`, `gmt_created`, `gmt_modified`) VALUES ('49', '2', 'a3608980-9a41-416b-a409-1f0b8d040080', 'stu2', '4', 'M', 'N', 'system', 'system', '2019-03-10 19:25:13', '2019-03-10 19:25:13');


