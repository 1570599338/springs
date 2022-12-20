/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2022-12-20 15:33:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '123', '2');
INSERT INTO `account` VALUES ('2', '122', '3');
INSERT INTO `account` VALUES ('3', '111', '666');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', 'tom', '1', '美国');
INSERT INTO `city` VALUES ('2', 'Jim', '1', '英国');
INSERT INTO `city` VALUES ('3', 'LiLei', '1', '中国');
INSERT INTO `city` VALUES ('4', 'Han Meimei', '1', '中国');
INSERT INTO `city` VALUES ('5', 'name:2046803994', '1', 'country:453720241');
INSERT INTO `city` VALUES ('6', 'name:-422835335', '1', 'country:156350227');
INSERT INTO `city` VALUES ('7', 'name:-869893224', '1', 'country:-1568604365');
INSERT INTO `city` VALUES ('8', 'namehx:-2004023150', '1', 'countryhx:-895096429');
INSERT INTO `city` VALUES ('9', 'namehx:-542191449', '1', 'countryhx:1140617784');
INSERT INTO `city` VALUES ('10', 'name:1126012220', '1', 'country:-2145262661');
INSERT INTO `city` VALUES ('11', 'namehx:2019662342', '1', 'countryhx:1818905252');
INSERT INTO `city` VALUES ('12', 'name:46234187', '1', 'country:-1636202016');
INSERT INTO `city` VALUES ('13', 'namehx:1309087278', '1', 'countryhx:-1797660472');
INSERT INTO `city` VALUES ('14', 'namehx:1648752998', '1', 'countryhx:602257129');
INSERT INTO `city` VALUES ('15', 'namehx:1717005622', '1', 'countryhx:-252857147');
INSERT INTO `city` VALUES ('16', 'namehx:1759077514', '1', 'countryhx:-728350863');
INSERT INTO `city` VALUES ('17', 'namehx:-339728873', '1', 'countryhx:1886451711');
INSERT INTO `city` VALUES ('18', 'namehx:-1440510069', '1', 'countryhx:847472001');
INSERT INTO `city` VALUES ('19', 'namehx:16291830', '1', 'countryhx:1475103712');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主链ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1pbaumidou.com');
INSERT INTO `user` VALUES ('7', 'Jack', '20', 'test2pbaomidou.com');
INSERT INTO `user` VALUES ('8', 'Tom', '28', 'test 3ghaomidou.com');
INSERT INTO `user` VALUES ('9', 'Sandy', '21', 'test4gbaomidou.com');
INSERT INTO `user` VALUES ('10', 'Billie', '24', 'test5gbaomidou.com');
INSERT INTO `user` VALUES ('11', 'Jone', '18', 'test1pbaumidou.com');
INSERT INTO `user` VALUES ('12', 'Jack', '20', 'test2pbaomidou.com');
INSERT INTO `user` VALUES ('13', 'Tom', '28', 'test 3ghaomidou.com');
INSERT INTO `user` VALUES ('14', 'Sandy', '21', 'test4gbaomidou.com');
INSERT INTO `user` VALUES ('15', 'Billie', '24', 'test5gbaomidou.com');
INSERT INTO `user` VALUES ('16', 'Jone', '18', 'test1pbaumidou.com');
INSERT INTO `user` VALUES ('17', 'Jack', '20', 'test2pbaomidou.com');
INSERT INTO `user` VALUES ('18', 'Tom', '28', 'test 3ghaomidou.com');
INSERT INTO `user` VALUES ('19', 'Sandy', '21', 'test4gbaomidou.com');
INSERT INTO `user` VALUES ('20', 'Billie', '24', 'test5gbaomidou.com');
INSERT INTO `user` VALUES ('21', 'Jone', '18', 'test1pbaumidou.com');
INSERT INTO `user` VALUES ('22', 'Jack', '20', 'test2pbaomidou.com');
INSERT INTO `user` VALUES ('23', 'Tom', '28', 'test 3ghaomidou.com');
INSERT INTO `user` VALUES ('24', 'Sandy', '21', 'test4gbaomidou.com');
INSERT INTO `user` VALUES ('25', 'Billie', '24', 'test5gbaomidou.com');
INSERT INTO `user` VALUES ('26', 'Jone', '18', 'test1pbaumidou.com');
INSERT INTO `user` VALUES ('27', 'Jack', '20', 'test2pbaomidou.com');
INSERT INTO `user` VALUES ('28', 'Tom', '28', 'test 3ghaomidou.com');
