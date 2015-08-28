/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_xgtc
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : xgtc

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-08-28 21:03:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` varchar(32) NOT NULL,
  `manager` varchar(50) DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分部';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '仓山分部');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` varchar(32) NOT NULL,
  `jobno` varchar(10) NOT NULL COMMENT '工号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `department_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('11', '22', '33', '333', '1');

-- ----------------------------
-- Table structure for `express`
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `id` varchar(32) NOT NULL,
  `no` varchar(30) DEFAULT NULL COMMENT '单号',
  `to_place` varchar(100) DEFAULT NULL COMMENT '目的地',
  `from_place` varchar(100) DEFAULT NULL COMMENT '始发地',
  `expense` decimal(10,4) DEFAULT NULL COMMENT '费用',
  `employee_id` varchar(32) DEFAULT NULL COMMENT '员工',
  `expresstype_id` varchar(32) DEFAULT NULL COMMENT '快递种类',
  `expresspeople_id` varchar(32) DEFAULT NULL COMMENT '发送人收件人信息',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `exp_ep_fk` (`expresstype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of express
-- ----------------------------
INSERT INTO `express` VALUES ('1111', '1111N', 'fz', 'xm', '40.0000', '11', '22', '33', '322232');

-- ----------------------------
-- Table structure for `expresspeople`
-- ----------------------------
DROP TABLE IF EXISTS `expresspeople`;
CREATE TABLE `expresspeople` (
  `id` varchar(32) NOT NULL,
  `sender_company` varchar(200) DEFAULT NULL COMMENT '发送人公司',
  `sender_name` varchar(100) DEFAULT NULL COMMENT '发件人',
  `sender_phone` varchar(30) DEFAULT NULL COMMENT '发件人电话',
  `sender_address` varchar(200) DEFAULT NULL COMMENT '发件人地址',
  `consignee_company` varchar(200) DEFAULT NULL COMMENT '收件人公司',
  `consignee_name` varchar(100) DEFAULT NULL COMMENT '收件人',
  `consignee_phone` varchar(30) DEFAULT NULL COMMENT '收件人电话',
  `consignee_address` varchar(200) DEFAULT NULL COMMENT '收件人地址',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expresspeople
-- ----------------------------
INSERT INTO `expresspeople` VALUES ('33', 'fzyd', 'xmyd', '23', '23', '42', '4', '2234', '2342');

-- ----------------------------
-- Table structure for `expressprocess`
-- ----------------------------
DROP TABLE IF EXISTS `expressprocess`;
CREATE TABLE `expressprocess` (
  `id` varchar(32) NOT NULL,
  `express_id` varchar(32) DEFAULT NULL COMMENT '单号id',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `datetime` varchar(17) DEFAULT NULL COMMENT '日期',
  `signstate` varchar(10) DEFAULT NULL COMMENT '签字状态',
  `abnormal_info` varchar(200) DEFAULT NULL COMMENT '异常原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expressprocess
-- ----------------------------
INSERT INTO `expressprocess` VALUES ('1', '1111', '1', '2121', '12', '11');

-- ----------------------------
-- Table structure for `expresstype`
-- ----------------------------
DROP TABLE IF EXISTS `expresstype`;
CREATE TABLE `expresstype` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `typename` varchar(30) DEFAULT NULL COMMENT '快件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expresstype
-- ----------------------------
INSERT INTO `expresstype` VALUES ('22', '2222');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '22', '33');
