DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);


DROP TABLE IF EXISTS mybatis_demo_log;

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
) ;