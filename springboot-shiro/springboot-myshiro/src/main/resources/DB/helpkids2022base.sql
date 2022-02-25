/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 127.0.0.1
 Source Database       : helpkids

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 02/24/2022 21:04:44 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_about`
-- ----------------------------
DROP TABLE IF EXISTS `t_about`;
CREATE TABLE `t_about` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `content` longtext COMMENT '内容',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='关于我们';

-- ----------------------------
--  Records of `t_about`
-- ----------------------------
BEGIN;
INSERT INTO `t_about` VALUES ('1', '联系我们', '<pre style=\"background-color: rgb(255, 255, 255);\"><div style=\"color: rgb(0, 0, 0); font-family: &quot;Courier New&quot;; font-size: 9pt; text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您有正能量需要投稿分享...</span></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\"><span style=\"font-size: 12px;\"><br></span></font></div><font color=\"#000000\" face=\"Courier New\"><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您身边有人需要帮忙...</span></div><div style=\"text-align: right;\"><span style=\"font-size: 12px;\"><br></span></div><span style=\"font-size: 9pt;\"><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您要寻找亲人...</span></div><br><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">请联系我们！</span></div><br><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\">我们的联系方式是xxxxxx</span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div></span></font></pre>', '0', '', '2022-02-21 13:47:27', 'admin', '2022-02-21 18:56:20', 'dddddd'), ('3', 'qwer', 'qwerwq', '0', '', '2022-02-21 12:36:31', '', '2022-02-21 12:36:39', 'qwerqwress水电费是梵蒂冈的');
COMMIT;

-- ----------------------------
--  Table structure for `t_apply`
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT '' COMMENT '姓名',
  `tel` varchar(11) DEFAULT '' COMMENT '电话',
  `adress` varchar(200) DEFAULT '' COMMENT '地址',
  `reason` longtext COMMENT '申请理由',
  `wish_id` int(5) DEFAULT NULL COMMENT '心愿id',
  `use_id` int(5) DEFAULT NULL COMMENT '用户id',
  `audit_status` int(2) DEFAULT '0' COMMENT '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望',
  `audit_id` int(5) DEFAULT NULL COMMENT '审核人员id',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='愿望申领单';

-- ----------------------------
--  Records of `t_apply`
-- ----------------------------
BEGIN;
INSERT INTO `t_apply` VALUES ('7', 'ddd', '15810704401', '布局不不不', 'asfsaa阿斯顿发撒地方', '3', '1', '0', null, '0', '', '2022-02-23 23:55:59', '', null, null), ('8', '在政治', '15810704401', '', '阿熟悉啊心', '5', '1', '0', null, '0', '', '2022-02-24 15:22:27', '', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `t_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
--  Records of `t_config`
-- ----------------------------
BEGIN;
INSERT INTO `t_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'), ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456'), ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');
COMMIT;

-- ----------------------------
--  Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
--  Records of `t_dept`
-- ----------------------------
BEGIN;
INSERT INTO `t_dept` VALUES ('100', '0', '0', '若依科技', '0', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('101', '100', '0,100', '深圳总公司', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('102', '100', '0,100', '长沙分公司', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('103', '101', '0,100,101', '研发部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('104', '101', '0,100,101', '市场部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('105', '101', '0,100,101', '测试部门', '3', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('106', '101', '0,100,101', '财务部门', '4', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('107', '101', '0,100,101', '运维部门', '5', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('108', '102', '0,100,102', '市场部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00'), ('109', '102', '0,100,102', '财务部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
COMMIT;

-- ----------------------------
--  Table structure for `t_dict_data`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict_data`;
CREATE TABLE `t_dict_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
--  Records of `t_dict_data`
-- ----------------------------
BEGIN;
INSERT INTO `t_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男'), ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女'), ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知'), ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单'), ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单'), ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态'), ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态'), ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组'), ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组'), ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是'), ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否'), ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知'), ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告'), ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态'), ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作'), ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作'), ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作'), ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作'), ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作'), ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作'), ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作'), ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作'), ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作'), ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态'), ('29', '1', '计算机类', '0', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:14:42', 'admin', '2020-02-05 10:37:05', ''), ('30', '1', '文职类', '1', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:15:05', 'admin', '2020-02-05 10:37:16', ''), ('31', '2', '销售类', '2', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:15:18', 'admin', '2020-02-05 10:37:27', ''), ('32', '0', '1000以下', '0', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:18', '', null, null), ('33', '1', '1000~3000', '1', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:34', '', null, null), ('34', '2', '3001~8000', '2', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:51', '', null, null), ('35', '3', '8001~12000', '3', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:17:07', '', null, null), ('36', '0', '未发布', '0', 'job_resume_status', null, null, 'Y', '0', 'admin', '2020-02-05 10:26:54', '', null, null), ('37', '1', '发布', '1', 'job_resume_status', null, null, 'Y', '0', 'admin', '2020-02-05 10:27:06', '', null, null), ('38', '0', '北京市', '0', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:31', '', null, null), ('39', '1', '上海市', '1', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:40', '', null, null), ('40', '2', '广州市', '2', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:51', '', null, null), ('41', '3', '深圳市', '3', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:14:03', '', null, null), ('42', '0', '未处理', '0', 'job_operate_status', null, null, 'Y', '0', 'admin', '2020-02-05 18:18:19', '', null, null), ('43', '1', '已处理', '1', 'job_operate_status', null, null, 'Y', '0', 'admin', '2020-02-05 18:18:32', '', null, null), ('44', '0', '同意', '0', 'job_operate_result', null, null, 'Y', '0', 'admin', '2020-02-05 18:19:13', '', null, null), ('45', '1', '拒绝', '1', 'job_operate_result', null, null, 'Y', '0', 'admin', '2020-02-05 18:19:20', '', null, null), ('46', '1', '30天(10元)', '10', 'job_vip_level', '', '', 'Y', '0', 'admin', '2020-02-07 13:27:38', 'admin', '2020-02-07 13:29:08', ''), ('47', '2', '90天(25元)', '25', 'job_vip_level', '', '', 'Y', '0', 'admin', '2020-02-07 13:27:58', 'admin', '2020-02-07 13:29:01', ''), ('48', '3', '180天(45元)', '45', 'job_vip_level', null, null, 'Y', '0', 'admin', '2020-02-07 13:28:51', '', null, null), ('49', '4', '360天(80元)', '80', 'job_vip_level', null, null, 'Y', '0', 'admin', '2020-02-07 13:29:34', '', null, null), ('50', '1', '20人以下', '1', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:12', '', null, null), ('51', '2', '20~50人', '2', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:30', '', null, null), ('52', '3', '50~100人', '3', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:46', '', null, null), ('53', '4', '100~500人', '4', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:10:00', '', null, null), ('54', '5', '500人以上', '5', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:10:14', '', null, null), ('55', '1', '金融/投资/证券', '1', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:11:35', '', null, null), ('56', '2', '计算机软件', '2', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:11:51', '', null, null), ('57', '3', '汽车及零配件', '3', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:12:26', '', null, null), ('58', '4', '房地产/汽车', '4', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:12:40', '', null, null), ('59', '5', '快速消费品(食品、饮料、化妆品) 批发/零售', '5', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 14:15:16', '', null, null), ('60', '1', 'lquan01tab', 'lquan01key', 'sys_user_sex1', '', 'primary', 'Y', '0', 'admin', '2022-02-11 17:02:09', 'admin', '2022-02-11 17:03:31', 'lquan01'), ('61', '2', 'lquan02tab', 'lquan02key', 'sys_user_sex1', '', 'default', 'Y', '0', 'admin', '2022-02-11 17:02:49', null, null, 'lquan02'), ('63', '4', 'lquan03tab1', 'lquan03key1', 'sys_user_sex1', '', 'success', 'Y', '0', 'admin', '2022-02-11 17:13:30', 'admin', '2022-02-11 17:13:53', 'lquan03tab1'), ('64', '1', '货币', '0', 'sys_user_wishType', '', '', 'Y', '0', 'admin', '2022-02-21 21:52:07', null, null, '货币援助'), ('65', '2', '人力物力', '1', 'sys_user_wishType', '', '', 'Y', '0', 'admin', '2022-02-21 21:52:43', null, null, '人力物力援助'), ('66', '1', '待审核', '0', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:54:39', 'admin', '2022-02-22 15:55:21', '0：待审核'), ('67', '2', '审核通过', '1', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:55:11', null, null, '1：审核通过'), ('68', '3', '审核失败', '2', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:55:53', null, null, '2：审核失败'), ('69', '4', '圆梦', '3', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:56:47', null, null, '3：圆梦');
COMMIT;

-- ----------------------------
--  Table structure for `t_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict_type`;
CREATE TABLE `t_dict_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
--  Records of `t_dict_type`
-- ----------------------------
BEGIN;
INSERT INTO `t_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-11 14:26:08', '用户性别列表'), ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表'), ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表'), ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表'), ('5', '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表'), ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表'), ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表'), ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表'), ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表'), ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表'), ('11', '职位类别', 'job_position_type', '0', 'admin', '2020-02-05 10:13:26', 'admin', '2020-02-05 10:25:47', '职位类别'), ('12', '薪资范围', 'job_salary', '0', 'admin', '2020-02-05 10:15:51', 'admin', '2020-02-05 10:25:40', ''), ('13', '简历状态', 'job_resume_status', '0', 'admin', '2020-02-05 10:26:28', '', null, null), ('14', '地区', 'job_area', '0', 'admin', '2020-02-05 12:13:16', '', null, null), ('15', '处理状态', 'job_operate_status', '0', 'admin', '2020-02-05 18:18:02', '', null, null), ('16', '处理结果', 'job_operate_result', '0', 'admin', '2020-02-05 18:18:52', '', null, null), ('17', 'VIP等级', 'job_vip_level', '0', 'admin', '2020-02-07 13:27:08', '', null, null), ('18', '企业规模', 'job_enterprise_scale', '0', 'admin', '2020-02-10 13:08:24', '', null, null), ('19', '企业性质', 'job_enterprise_category', '0', 'admin', '2020-02-10 13:10:54', '', null, null), ('22', '用户性别1', 'sys_user_sex1', '0', 'admin', '2022-02-11 17:01:29', '', null, 'xxxxxx'), ('23', '愿望类型', 'sys_user_wishType', '0', 'admin', '2022-02-21 21:50:31', '', null, '愿望类型 0：金钱援助 1：人力物力援助'), ('24', '审核类型', 'sys_audit_status', '0', 'admin', '2022-02-22 15:53:34', '', null, '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望');
COMMIT;

-- ----------------------------
--  Table structure for `t_logininfor`
-- ----------------------------
DROP TABLE IF EXISTS `t_logininfor`;
CREATE TABLE `t_logininfor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
--  Records of `t_logininfor`
-- ----------------------------
BEGIN;
INSERT INTO `t_logininfor` VALUES ('100', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-04 20:49:05'), ('101', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:33:54'), ('102', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:34:23'), ('103', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:34:31'), ('104', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:36:38'), ('105', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:37:33'), ('106', 'common', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '用户不存在/密码错误', '2020-02-05 09:37:45'), ('107', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '密码输入错误1次', '2020-02-05 09:38:24'), ('108', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '密码输入错误2次', '2020-02-05 09:38:42'), ('109', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '密码输入错误1次', '2020-02-05 09:40:01'), ('110', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:40:23'), ('111', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:48:01'), ('112', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:48:49'), ('113', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:48:54'), ('114', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:49:08'), ('115', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:50:36'), ('116', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:50:48'), ('117', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 10:13:49'), ('118', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 10:25:21'), ('119', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 10:50:14'), ('120', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-05 11:13:20'), ('121', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:21:16'), ('122', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:24:18'), ('123', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:28:47'), ('124', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:38:33'), ('125', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:50:43'), ('126', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 11:54:07'), ('127', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:54:09'), ('128', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:01:26'), ('129', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:12:37'), ('130', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:31:38'), ('131', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:47:10'), ('132', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:47:16'), ('133', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:47:26'), ('134', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:47:28'), ('135', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:47:50'), ('136', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:47:54'), ('137', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:48:22'), ('138', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:48:26'), ('139', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:49:23'), ('140', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:49:25'), ('141', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:55:44'), ('142', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:57:52'), ('143', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:18:02'), ('144', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:20:12'), ('145', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 13:20:36'), ('146', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:20:39'), ('147', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:22:18'), ('148', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:32:14'), ('149', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:34:37'), ('150', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:35:51'), ('151', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:37:24'), ('152', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:41:01'), ('153', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:43:45'), ('154', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:46:29'), ('155', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 13:46:56'), ('156', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:46:58'), ('157', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:24:09'), ('158', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:37:54'), ('159', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:37:57'), ('160', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:38:01'), ('161', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:38:02'), ('162', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:38:16'), ('163', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:38:18'), ('164', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:39:07'), ('165', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:39:10'), ('166', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:40:16'), ('167', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:40:19'), ('168', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:44:27'), ('169', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 15:47:33'), ('170', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 16:09:33'), ('171', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 16:41:28'), ('172', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 17:08:26'), ('173', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 17:11:26'), ('174', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 17:46:13'), ('175', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 18:07:30'), ('176', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 18:16:18');
COMMIT;

-- ----------------------------
--  Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1110 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
--  Records of `t_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` VALUES ('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录'), ('2', '系统监控', '0', '2', '#', 'menuItem', 'M', '1', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-23 15:03:39', '系统监控目录'), ('3', '系统工具', '0', '3', '#', 'menuItem', 'M', '1', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-23 15:03:59', '系统工具目录'), ('4', '前端展示', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-area-chart', 'admin', '2022-02-21 11:04:44', 'admin', '2022-02-21 14:45:21', ''), ('100', '用户管理', '1', '1', '/admin/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单'), ('101', '角色管理', '1', '2', '/admin/role', '', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单'), ('102', '菜单管理', '1', '3', '/admin/menu', '', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单'), ('103', '部门管理', '1', '4', '/sadmin/dept', 'menuItem', 'C', '1', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:27', '部门管理菜单'), ('104', '岗位管理', '1', '5', '/admin/post', 'menuItem', 'C', '1', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:33', '岗位管理菜单'), ('105', '字典管理', '1', '6', '/admin/dict', '', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单'), ('106', '参数设置', '1', '7', '/admin/config', 'menuItem', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 10:00:54', '参数设置菜单'), ('107', '通知公告', '1', '8', '/admin/notice', 'menuItem', 'C', '1', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 14:50:01', '通知公告菜单'), ('108', '日志管理', '1', '9', '#', 'menuItem', 'M', '1', '', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:59', '日志管理菜单'), ('109', '在线用户', '2', '1', '/monitor/online', '', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单'), ('110', '定时任务', '2', '2', '/monitor/job', '', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单'), ('111', '数据监控', '2', '3', '/monitor/data', '', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单'), ('112', '服务监控', '2', '3', '/monitor/server', '', 'C', '0', 'monitor:server:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单'), ('113', '表单构建', '3', '1', '/tool/build', '', 'C', '0', 'tool:build:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单'), ('114', '代码生成', '3', '2', '/tool/gen', '', 'C', '0', 'tool:gen:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单'), ('115', '系统接口', '3', '3', '/tool/swagger', '', 'C', '0', 'tool:swagger:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单'), ('500', '操作日志', '108', '1', '/monitor/operlog', '', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单'), ('501', '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单'), ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1006', '重置密码', '100', '7', '#', '', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1007', '角色查询', '101', '1', '#', '', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1008', '角色新增', '101', '2', '#', '', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1009', '角色修改', '101', '3', '#', '', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1010', '角色删除', '101', '4', '#', '', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1011', '角色导出', '101', '5', '#', '', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1016', '部门查询', '103', '1', '#', '', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1017', '部门新增', '103', '2', '#', '', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1018', '部门修改', '103', '3', '#', '', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1019', '部门删除', '103', '4', '#', '', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1020', '岗位查询', '104', '1', '#', '', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1021', '岗位新增', '104', '2', '#', '', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1022', '岗位修改', '104', '3', '#', '', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1023', '岗位删除', '104', '4', '#', '', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1024', '岗位导出', '104', '5', '#', '', 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1025', '字典查询', '105', '1', '#', '', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1026', '字典新增', '105', '2', '#', '', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1027', '字典修改', '105', '3', '#', '', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1028', '字典删除', '105', '4', '#', '', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1029', '字典导出', '105', '5', '#', '', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1030', '参数查询', '106', '1', '#', '', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1031', '参数新增', '106', '2', '#', '', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1032', '参数修改', '106', '3', '#', '', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1033', '参数删除', '106', '4', '#', '', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1034', '参数导出', '106', '5', '#', '', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1035', '公告查询', '107', '1', '#', '', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1036', '公告新增', '107', '2', '#', '', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1037', '公告修改', '107', '3', '#', '', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1038', '公告删除', '107', '4', '#', '', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1039', '操作查询', '500', '1', '#', '', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1040', '操作删除', '500', '2', '#', '', 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1041', '详细信息', '500', '3', '#', '', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1042', '日志导出', '500', '4', '#', '', 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1043', '登录查询', '501', '1', '#', '', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1044', '登录删除', '501', '2', '#', '', 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1045', '日志导出', '501', '3', '#', '', 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1046', '账户解锁', '501', '4', '#', '', 'F', '0', 'monitor:logininfor:unlock', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1047', '在线查询', '109', '1', '#', '', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1048', '批量强退', '109', '2', '#', '', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1049', '单条强退', '109', '3', '#', '', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1050', '任务查询', '110', '1', '#', '', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1051', '任务新增', '110', '2', '#', '', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1052', '任务修改', '110', '3', '#', '', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1053', '任务删除', '110', '4', '#', '', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1054', '状态修改', '110', '5', '#', '', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1055', '任务详细', '110', '6', '#', '', 'F', '0', 'monitor:job:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1056', '任务导出', '110', '7', '#', '', 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1057', '生成查询', '114', '1', '#', '', 'F', '0', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1058', '生成修改', '114', '2', '#', '', 'F', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1059', '生成删除', '114', '3', '#', '', 'F', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1060', '预览代码', '114', '4', '#', '', 'F', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1061', '生成代码', '114', '5', '#', '', 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1062', '志愿者模块', '0', '4', '#', 'menuItem', 'M', '0', null, 'fa fa-handshake-o', 'admin', '2020-02-05 11:52:26', 'admin', '2022-02-14 10:23:15', ''), ('1063', '简历管理', '1062', '1', '/job/resume', 'menuItem', 'C', '1', 'job:resume:view', '#', 'admin', '2020-02-05 11:53:07', 'admin', '2022-02-23 15:03:16', ''), ('1064', '职位管理', '1062', '2', '/job/position', 'menuItem', 'C', '1', 'job:position:view', '#', 'admin', '2020-02-05 12:03:54', 'admin', '2022-02-23 15:04:11', ''), ('1065', '新增', '1063', '1', '#', 'menuItem', 'F', '0', 'job:position:add', '#', 'admin', '2020-02-05 12:04:48', '', null, ''), ('1066', '编辑', '1063', '2', '#', 'menuItem', 'F', '0', 'job:position:edit', '#', 'admin', '2020-02-05 12:05:12', '', null, ''), ('1067', '删除', '1063', '3', '#', 'menuItem', 'F', '0', 'job:position:remove', '#', 'admin', '2020-02-05 12:05:31', '', null, ''), ('1068', '关于我们', '4', '1', '/admin/about', '', 'C', '0', 'system:about:view', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '关于我们菜单'), ('1069', '查询', '1068', '1', '#', '', 'F', '0', 'system:about:list', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1070', '新增', '1068', '2', '#', '', 'F', '0', 'system:about:add', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1071', '修改', '1068', '3', '#', '', 'F', '0', 'system:about:edit', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1072', '删除', '1068', '4', '#', '', 'F', '0', 'system:about:remove', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1073', '关于我们导出', '1068', '5', '#', '', 'F', '0', 'system:about:export', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1075', '人员审核', '0', '2', '#', 'menuItem', 'M', '0', null, 'fa fa-group', 'admin', '2022-02-21 19:04:00', '', null, ''), ('1076', '待审核志愿者', '1075', '1', '/admin/audit', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-4', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:41', ''), ('1077', '查询', '1076', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, ''), ('1078', '审核', '1076', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, ''), ('1079', '待审核求助者', '1075', '1', '/admin/auditQ', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-0', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:30', ''), ('1080', '查询', '1079', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, ''), ('1081', '审核', '1079', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, ''), ('1082', '待审失败', '1075', '1', '/admin/auditF', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-certificate', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:13:44', ''), ('1083', '查询', '1082', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, ''), ('1084', '审核', '1082', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, ''), ('1085', '求助管理', '0', '5', '#', 'menuItem', 'M', '0', null, 'fa fa-heartbeat', 'admin', '2022-02-21 21:12:17', 'admin', '2022-02-21 21:14:00', ''), ('1086', '我的愿望', '1085', '1', '/admin/wish', '', 'C', '0', 'system:wish:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '关于我们菜单'), ('1087', '查询', '1086', '1', '#', '', 'F', '0', 'system:wish:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1088', '新增', '1086', '2', '#', '', 'F', '0', 'system:wish:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1089', '修改', '1086', '3', '#', '', 'F', '0', 'system:wish:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1090', '删除', '1086', '4', '#', '', 'F', '0', 'system:wish:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1091', '导出', '1086', '5', '#', '', 'F', '0', 'system:wish:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1092', '审核心愿', '1085', '1', '/admin/wish/auditView', '', 'C', '0', 'system:wishA:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '关于我们菜单'), ('1093', '查询', '1092', '1', '#', '', 'F', '0', 'system:wishA:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1094', '审核', '1092', '2', '#', '', 'F', '0', 'system:wishA:audit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1095', '审核心愿', '1062', '1', '/admin/wish/VolunteerView', 'menuItem', 'C', '0', 'system:wishV:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2022-02-23 15:17:24', '关于我们菜单'), ('1096', '查询', '1095', '1', '#', '', 'F', '0', 'system:wishA:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1097', '审核', '1095', '2', '#', '', 'F', '0', 'system:wishA:audit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1098', '愿望申领单', '1062', '1', '/admin/apply', 'menuItem', 'C', '0', 'system:apply:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2022-02-23 22:01:40', '愿望申领单菜单'), ('1099', '查询', '1098', '1', '#', '', 'F', '0', 'system:apply:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1100', '新增', '1098', '2', '#', '', 'F', '0', 'system:apply:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1101', '修改', '1098', '3', '#', '', 'F', '0', 'system:apply:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1102', '删除', '1098', '4', '#', '', 'F', '0', 'system:apply:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1103', '导出', '1098', '5', '#', '', 'F', '0', 'system:apply:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1104', '圆梦故事', '4', '1', '/admin/story', '', 'C', '0', 'system:story:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '圆梦故事菜单'), ('1105', '查询', '1104', '1', '#', '', 'F', '0', 'system:story:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1106', '新增', '1104', '2', '#', '', 'F', '0', 'system:story:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1107', '修改', '1104', '3', '#', '', 'F', '0', 'system:story:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1108', '删除', '1104', '4', '#', '', 'F', '0', 'system:story:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1109', '导出', '1104', '5', '#', '', 'F', '0', 'system:story:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
COMMIT;

-- ----------------------------
--  Table structure for `t_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
--  Table structure for `t_oper_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_oper_log`;
CREATE TABLE `t_oper_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
--  Table structure for `t_post`
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
--  Records of `t_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员'), ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-05 09:50:56', '普通角色'), ('3', '志愿者', 'job_wanted', '3', '1', '0', '0', 'admin', '2020-02-05 11:25:28', 'admin', '2020-02-08 13:47:12', ''), ('4', '求助者', 'enterprise', '4', '1', '0', '0', 'admin', '2020-02-05 11:25:48', 'admin', '2020-02-10 13:58:33', ''), ('5', '游客', 'tourist', '5', '1', '0', '0', 'admin', '2020-02-05 11:26:13', 'admin', '2020-02-06 18:01:19', '');
COMMIT;

-- ----------------------------
--  Table structure for `t_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_dept`;
CREATE TABLE `t_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
--  Records of `t_role_dept`
-- ----------------------------
BEGIN;
INSERT INTO `t_role_dept` VALUES ('2', '2', '100'), ('3', '2', '101'), ('4', '2', '105');
COMMIT;

-- ----------------------------
--  Table structure for `t_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
--  Records of `t_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menu` VALUES ('1', '1', '1'), ('2', '2', '1'), ('3', '2', '2'), ('4', '2', '3'), ('5', '2', '100'), ('6', '2', '101'), ('7', '2', '102'), ('8', '2', '103'), ('9', '2', '104'), ('10', '2', '105'), ('11', '2', '106'), ('12', '2', '107'), ('13', '2', '108'), ('14', '2', '109'), ('15', '2', '110'), ('16', '2', '111'), ('17', '2', '112'), ('18', '2', '113'), ('19', '2', '114'), ('20', '2', '115'), ('21', '2', '500'), ('22', '2', '501'), ('23', '2', '1000'), ('24', '2', '1001'), ('25', '2', '1002'), ('26', '2', '1003'), ('27', '2', '1004'), ('28', '2', '1005'), ('29', '2', '1006'), ('30', '2', '1007'), ('31', '2', '1008'), ('32', '2', '1009'), ('33', '2', '1010'), ('34', '2', '1011'), ('35', '2', '1012'), ('36', '2', '1013'), ('37', '2', '1014'), ('38', '2', '1015'), ('39', '2', '1016'), ('40', '2', '1017'), ('41', '2', '1018'), ('42', '2', '1019'), ('43', '2', '1020'), ('44', '2', '1021'), ('45', '2', '1022'), ('46', '2', '1023'), ('47', '2', '1024'), ('48', '2', '1025'), ('49', '2', '1026'), ('50', '2', '1027'), ('51', '2', '1028'), ('52', '2', '1029'), ('53', '2', '1030'), ('54', '2', '1031'), ('55', '2', '1032'), ('56', '2', '1033'), ('57', '2', '1034'), ('58', '2', '1035'), ('59', '2', '1036'), ('60', '2', '1037'), ('61', '2', '1038'), ('62', '2', '1039'), ('63', '2', '1040'), ('64', '2', '1041'), ('65', '2', '1042'), ('66', '2', '1043'), ('67', '2', '1044'), ('68', '2', '1045'), ('69', '2', '1046'), ('70', '2', '1047'), ('71', '2', '1048'), ('72', '2', '1049'), ('73', '2', '1050'), ('74', '2', '1051'), ('75', '2', '1052'), ('76', '2', '1053'), ('77', '2', '1054'), ('78', '2', '1055'), ('79', '2', '1056'), ('80', '2', '1057'), ('81', '2', '1058'), ('82', '2', '1059'), ('83', '2', '1060'), ('84', '2', '1061'), ('85', '3', '1062'), ('86', '3', '1063'), ('87', '3', '1065'), ('88', '3', '1066'), ('89', '3', '1067'), ('90', '3', '1068'), ('91', '3', '1070'), ('92', '4', '1062'), ('93', '4', '1064'), ('94', '4', '1069'), ('95', '4', '1085'), ('96', '5', '1062'), ('97', '5', '1069'), ('98', '5', '1070');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `vip` tinyint(3) DEFAULT '0' COMMENT '是否是vip（0否1是）',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `guarder_name` varchar(30) DEFAULT NULL COMMENT '监护人名字',
  `guarder_phone` varchar(11) DEFAULT NULL COMMENT '监护人电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `audit` int(6) DEFAULT NULL COMMENT '审核状态 0：待审核 1：已审核 2：审核未通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', '103', '0', 'admin', 'lquan', '00', 'lquan@163.com', '15888888888', '1', '/headImage/c74dd2dc8533b952786b3c0cc3c4f6dd.png', 'admin123', '111111', '0', '0', '', '2022-02-07 14:38:23', 'admin', '2018-03-16 11:33:00', '', '2022-02-23 11:27:11', '管理员', null, null, '北京 东城区志愿者', null), ('2', '105', '0', 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '123456', '75242d', '0', '0', '', '2020-02-05 09:49:08', 'admin', '2018-03-16 11:33:00', 'ry', '2022-02-24 20:59:29', '测试员', null, null, null, null), ('22', null, '0', 'lquans', 'lquans', '00', '', '15810607111', '0', '', '123456', 'e83b02', '0', '0', '', null, 'admin', '2022-02-21 18:43:12', '', null, '北京 朝阳 surp', null, null, '北京 朝阳', '0'), ('23', null, '0', 'lquanz', 'lquanz2', '01', '', '15810607122', '1', '', '123456', '9ed206', '0', '0', '', null, 'admin', '2022-02-21 18:45:27', 'admin', '2022-02-21 21:02:09', '北京 东城区志愿者2', null, null, '北京 东城区志愿者', '2'), ('25', null, '0', 'lquanq', 'lquanq1', '02', '', '15810607112', '0', '', '123456', '452d07', '0', '0', '', null, 'admin', '2022-02-21 20:33:17', 'admin', '2022-02-24 15:58:00', '123', '习大大', '18888888889', '北京 通州', '1'), ('26', null, '0', 'lquanx', 'lquanqx', '00', '', '15810607114', '0', '', '123456', 'f50426', '0', '2', '', null, 'admin', '2022-02-24 21:00:24', 'admin', '2022-02-24 21:00:41', 'xxxx', null, null, '北京', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_online`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_online`;
CREATE TABLE `t_user_online` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

-- ----------------------------
--  Table structure for `t_user_post`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_post`;
CREATE TABLE `t_user_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
--  Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
--  Records of `t_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES ('2', '1', '1'), ('3', '2', '2'), ('58', '24', '4'), ('66', '23', '2'), ('67', '25', '4'), ('69', '26', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_wish`
-- ----------------------------
DROP TABLE IF EXISTS `t_wish`;
CREATE TABLE `t_wish` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `wish_short` varchar(200) DEFAULT '' COMMENT '愿望简介',
  `wish_info` longtext COMMENT '愿望简介',
  `wish_type` int(2) DEFAULT NULL COMMENT '愿望类型 0:代表金钱；1：人力物力',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  `audit_status` int(2) DEFAULT '0' COMMENT '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望',
  `audit_id` int(5) DEFAULT NULL COMMENT '审核人员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='愿望清单';

-- ----------------------------
--  Records of `t_wish`
-- ----------------------------
BEGIN;
INSERT INTO `t_wish` VALUES ('3', 'xxxxxxxy', '01d709bbf5e0365dd45ab25a11726566.jpg', 'xxxxxyy', '<p>ss<b><span style=\"font-size: 9px;\">s<span style=\"font-size: 36px;\">s</span></span></b><span style=\"font-size: 36px;\">﻿</span><span style=\"font-size: 36px;\">sss</span>sBBB vvvyyygkvghfffk</p>', '1', '0', '', '2022-02-22 12:14:33', 'admin', '2022-02-24 15:19:15', null, '1', '1', '1'), ('4', '啊发顺丰', '2faf2ced959ad835185c9bcbbc27e93b.jpg', '阿士大夫撒范德萨发的', '<p>广发的GV持续性差V型成本是多少方法</p><p><img src=\"data:image/png;base64,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\" alt=\"\"><br></p>', '0', '0', 'admin', '2022-02-22 14:33:46', 'admin', '2022-02-24 15:19:05', null, '1', '2', '1'), ('5', '看望山区的儿童呀', 'e2269fa959aa9e3be4522cab4bc37b32.jpg', 'prprpr地说一堆东西，虽然并没有什么卵用，可是让人看了会很感动，很感动。所以你还是能编什么就编什么啦', 'prprpr地说一堆东西，虽然并没有什么卵用，可是让人看了会很感动，很感动。所以你还是能编什么就编什么啦prprpr地说一堆东西，虽然并没有什么卵用，可是让人看了会很感动，很感动。所以你还是能编什么就编什么啦', '1', '0', 'admin', '2022-02-24 15:18:32', 'admin', '2022-02-24 15:20:35', null, '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_wish_story`
-- ----------------------------
DROP TABLE IF EXISTS `t_wish_story`;
CREATE TABLE `t_wish_story` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `story_short` varchar(1000) DEFAULT '' COMMENT '圆梦简介',
  `story_info` longtext COMMENT '圆梦故事内容',
  `is_publish` int(2) DEFAULT '0' COMMENT '审核状态 0：带发布  1：发布',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='圆梦故事';

-- ----------------------------
--  Records of `t_wish_story`
-- ----------------------------
BEGIN;
INSERT INTO `t_wish_story` VALUES ('6', '123312313', '1a244038018e845e69c2cdfcf8eba2a6.jpg', 'qwrqwe', '<p>rqwerqwerqwerqwer</p>', '1', '0', '', '2022-02-24 01:00:25', 'admin', '2022-02-24 15:13:18', null), ('7', '果度有好多人系度量血压啊，猴赛雷啊', '111c8e62196fc4570789a15eaced5974.jpg', '中国的慈善事业，同样有着自己悠久的传统。汉唐寺院济贫、赈灾、医疗、戒残杀的长盛不衰；宋代养老扶幼事业的勃兴；元医疗救助的兴起；明清民间慈善群体在中国慈善史上首屈一指 。更有当今国门开放以来，涌现出一批批社会贤达、名流、企业家、离退休干部为水灾、为贫困大中小学生、为艾滋病、白内障的贫困患者，默默从事的慈善救助。统计表明，至少一半的富豪要求对其捐款事实及数额“保密”。中国的慈善事业，同样有着自己悠久的传统。汉唐寺院济贫、赈灾、医疗、戒残杀的长盛不衰；宋代养老扶幼事业的勃兴；元医疗救助的兴起；明清民间慈善群体在中国慈善史上首屈一指 。更有当今国门开放以来，涌现出一批批社会贤达、名流、企业家、离退休干部为水灾、为贫困大中小学生、为艾滋病、白内障的贫困患者，默默从事的慈善救助。统计表明，至少一半的富豪要求对其捐款事实及数额“保密”。', '<p></p><p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 14px;\">6月10日放学后，姐妹俩吃了垃圾堆里的食物后中毒。事发后住在附近的小孩过来看。图/潇湘晨报记者陈正 从学校回出租屋的那条路，只有一公里，姐妹俩却再也走不到了。 6月10日放学后，她们走了一条与往常不一样的路：来到离学校不远的山脚下，这里，堆了一些被丢弃的垃圾。 姐妹俩应该有些饿，她们吃起了垃圾堆里的食物。 没过多久，这对14岁和8岁的姐妹俩的生命，因“毒鼠强”而终止。 “我看到小妹子的时候，她眼睛都翻白了。”6月11日下午，见到记者时，60岁的汤和平老泪纵横。 一天前，他的两个女儿放学后回家，在途中死亡。衡阳警方认定，两女孩的死因系中毒引发。 14岁的姐姐汤银霞、8岁的妹妹汤溪林，都在衡阳县界牌镇银瓷完小读书，姐姐读六年级，妹妹读一年级。 6月10日下午放学后，姐妹俩一起回家。她们家在镇上租的房子离学校仅一公里左右，谁也没料到，姐妹俩会在途中出事。 汤和平事后了解到的情况是，大女儿死在离家半公里的山下——这并不是从学校回家的路。随后，妹妹哭着回家喊人，倒在半途中，后来被附近居民发现。汤和平赶到医院不久，小女儿停止了呼吸。 当地流传的说法称，汤银霞姐妹俩途中遇上两名男子，两男子请她们喝可乐，之后姐妹俩倒地死亡。 “这种说法基本可以排除。”6月11日，衡阳县公安局刑侦大队大队长黄均说。 事发后，当地公安机关迅速介入调查。 据了解，事发时，汤银霞的同学陈文华也在现场。11日晚，陈文华仍在派出所配合调查。据她的奶奶凌红燕转述，在当天回家途中，陈文华看到汤银霞姐妹捡垃圾堆里的食物吃。“什么麻辣烫呀，还有一些脏的东西都吃，里面可能有老鼠药。”凌红燕说，“她们是吃垃圾中毒的。” 正在当地调查的黄均确认，汤银霞姐妹系中毒身亡，“是毒鼠强。具体什么原因，还在调查。” 哪里来的毒鼠强? 孩子们倒在毒鼠强之下的新闻并不少见。今年3月，山东巨野6岁男童路边捡到一根棒棒糖，吃完后中毒死亡。 毒鼠强，毒性极强，几毫克毒鼠强便可致成人死亡，目前尚无特效解毒剂。早在1991年，农业部即将毒鼠强为禁用品种。2003年，“两高”曾出台司法解释，明确非法制造、买卖、运输、储存毒鼠强等禁用剧毒化学品，最高可判处死刑。 然而，因成本低廉，购买方便，这种毒药在很多农村乡镇集市上可以随意买到，毒鼠强中毒事件仍然不断发生。 这一次，毒死衡阳县两姐妹的毒鼠强到底从何而来?仍待警方调查。 父母可以做到这些 衡阳县两姐妹的悲剧，令人唏嘘。作为家长，应该告诫孩子“不要捡掉地上的食物吃”，并懂得一定的急救知识。 专家建议，父母首先以身作则，家里吃饭时，食物掉地上不要捡起来吃。此外，在公共场所发现的食物，即使包装完好，也不要让孩子碰。 除了预防，父母还必须懂得一些中毒急救方法。如果孩子食物中毒，要及时进行催吐。孩子吃过的食物，怀疑变质或者有毒时，要保存起来，交给医生急救时分析处理。同时要第一时间送往医院检查救治。 常随母亲捡废品，常饿肚子 两个女儿的生命无法挽回了，汤和平，这个60岁的老人，头发泛白，满面憔悴，接受采访时哭成了泪人。 这并非是他第一次面对命运的残酷。 十六年前，13岁的儿子在水塘里溺亡。此后，夫妻俩陆续生下两个女儿。谁也没想到，夫妻俩要再次承受丧女之痛。 母亲捡垃圾常忘记给她们做饭 汤和平的家位于偏僻的界牌镇高山村，离镇上七八公里远。村里的小学早撤了，汤和平只能将女儿送到镇里的银瓷完小就读。 6月11日，潇湘晨报记者来到界牌镇一家破旧的瓷器厂仓库。走过一条狭长的小道，看到一间小杂屋，透过破烂的木门，可见屋内堆积的杂乱废品。 这间杂屋曾是破产企业的一个澡堂，改造后用来出租。七年前，为了方便孩子读书，汤和平租下这间小杂房，月租50元。 汤和平平常都在老家务农，农闲时节出去帮人弹棉被挣些零用钱。这些年，在镇上出租屋照顾两个女儿的任务，便由汤和平的妻子承担。 汤妻比他小十来岁，没读过书，有智力障碍。“脑子有问题。”汤和平说，妻子唯一的技能，就是捡废品。她不懂算术，挑废品去卖，“老板给多少就多少。” 住在附近的居民王兰兰介绍，汤妻经常半夜三更出来走动。令邻居们担忧的是，汤妻白天外出捡垃圾，常常忘记回家给两个女儿煮饭，“有时候一天吃一顿饭，有时候两顿。”王兰兰说。 垃圾堆里有她们喜欢的麻辣小吃 汤银霞姐妹的学习成绩不好。 她的一名同学说，在班上69个同学中，汤银霞总是倒数一二名，“三科加起来都考不到30分。” 办案民警对姐妹俩的生活状况进行过调查。据黄均介绍，姐妹俩有捡垃圾的生活习性，常跟母亲外出捡废品，“有时也捡一些东西吃。” 6月10日下午放学回家，姐妹俩没有直接走马路回，而是来到离学校不远的山脚下，这里有一些被居民们丢弃的垃圾废品。当时，姐妹俩应该有些饿，而回到家，也许要几小时后才能等到母亲做的晚饭。姐妹俩从垃圾堆里捡了一些别人扔弃的食物，其中有她们喜欢的麻辣小吃。 幼小的她们没考虑到，这些垃圾废品中，可能有当地居民毒鼠用过的“食品”——毒鼠强。 14岁的姐姐先倒地，她吃得多，也吃得快。 8岁的妹妹吓得往前跑，没多久，也倒在了半途中。 从大瑶山来到县城，开始了照顾母亲兼打工的生活</span><br></p><p><br></p><p><br></p><p><br></p>', '1', '0', '', '2022-02-24 01:28:26', 'admin', '2022-02-24 15:08:37', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_wishxxx`
-- ----------------------------
DROP TABLE IF EXISTS `t_wishxxx`;
CREATE TABLE `t_wishxxx` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT '' COMMENT '名称',
  `imgUrl` varchar(200) DEFAULT '' COMMENT '图片地址',
  `wish_short` varchar(200) DEFAULT '' COMMENT '愿望简介',
  `wish_info` longtext COMMENT '愿望简介',
  `wish_type` int(2) DEFAULT NULL COMMENT '愿望类型 0:代表金钱；1：人力物力',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='关于我们';

-- ----------------------------
--  Records of `t_wishxxx`
-- ----------------------------
BEGIN;
INSERT INTO `t_wishxxx` VALUES ('3', 'xxxxxxxy', 'ba28991cbcdec83afdbe75b00035f225.jpg', 'xxxxxyy', '<p>ss<b><span style=\"font-size: 9px;\">s<span style=\"font-size: 36px;\">s</span></span></b><span style=\"font-size: 36px;\">﻿</span><span style=\"font-size: 36px;\">sss</span>sBBB</p>', '1', '0', '', '2022-02-22 12:14:33', '', '2022-02-22 14:05:33', null, null), ('4', '啊发顺丰', '8f8f4ea1ef47cb5512114d10fb5d5be2.jpg', '阿士大夫撒范德萨发的', '<p>广发的GV持续性差V型成本是多少方法</p><p><img src=\"data:image/png;base64,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\" alt=\"\"><br></p>', '0', '0', 'admin', '2022-02-22 14:33:46', 'admin', '2022-02-22 14:34:26', null, '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
