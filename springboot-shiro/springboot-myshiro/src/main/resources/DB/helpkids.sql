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

 Date: 02/25/2022 00:10:13 AM
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
INSERT INTO `t_about` VALUES ('1', '联系我们', '<pre style=\"background-color: rgb(255, 255, 255);\"><div style=\"color: rgb(0, 0, 0); font-family: &quot;Courier New&quot;; font-size: 9pt; text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您有正能量需要投稿分享...</span></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\"><span style=\"font-size: 12px;\"><br></span></font></div><font color=\"#000000\" face=\"Courier New\"><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您身边有人需要帮忙...</span></div><div style=\"text-align: right;\"><span style=\"font-size: 12px;\"><br></span></div><span style=\"font-size: 9pt;\"><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您要寻找亲人...</span></div><br><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">请联系我们！</span></div><br><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\">我们的联系方式是xxxxxx</span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div></span></font></pre>', '0', '', '2022-02-21 13:47:27', 'admin', '2022-02-21 18:56:20', 'dddddd'), ('3', 'aaaqwer', 'qwerwqqqqq', '0', '', '2022-02-21 12:36:31', 'lquan2', '2022-02-24 23:45:19', 'qwerqwress水电费是梵蒂冈的');
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
INSERT INTO `t_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-purple', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-24 22:59:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'), ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456'), ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-24 23:00:56', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');
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
INSERT INTO `t_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男'), ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女'), ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知'), ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单'), ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单'), ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态'), ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态'), ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组'), ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组'), ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是'), ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否'), ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知'), ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告'), ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态'), ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作'), ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作'), ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作'), ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作'), ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作'), ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作'), ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作'), ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作'), ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作'), ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态'), ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态'), ('60', '1', 'lquan01tab', 'lquan01key', 'sys_user_sex1', '', 'primary', 'Y', '0', 'admin', '2022-02-11 17:02:09', 'admin', '2022-02-11 17:03:31', 'lquan01'), ('61', '2', 'lquan02tab', 'lquan02key', 'sys_user_sex1', '', 'default', 'Y', '0', 'admin', '2022-02-11 17:02:49', null, null, 'lquan02'), ('63', '4', 'lquan03tab1', 'lquan03key1', 'sys_user_sex1', '', 'success', 'Y', '0', 'admin', '2022-02-11 17:13:30', 'admin', '2022-02-11 17:13:53', 'lquan03tab1'), ('64', '1', '货币', '0', 'sys_user_wishType', '', '', 'Y', '0', 'admin', '2022-02-21 21:52:07', null, null, '货币援助'), ('65', '2', '人力物力', '1', 'sys_user_wishType', '', '', 'Y', '0', 'admin', '2022-02-21 21:52:43', null, null, '人力物力援助'), ('66', '1', '待审核', '0', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:54:39', 'admin', '2022-02-22 15:55:21', '0：待审核'), ('67', '2', '审核通过', '1', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:55:11', null, null, '1：审核通过'), ('68', '3', '审核失败', '2', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:55:53', null, null, '2：审核失败'), ('69', '4', '圆梦', '3', 'sys_audit_status', '', '', 'Y', '0', 'admin', '2022-02-22 15:56:47', null, null, '3：圆梦');
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
INSERT INTO `t_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-11 14:26:08', '用户性别列表'), ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表'), ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表'), ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表'), ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表'), ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表'), ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表'), ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表'), ('22', '用户性别1', 'sys_user_sex1', '0', 'admin', '2022-02-11 17:01:29', '', null, 'xxxxxx'), ('23', '愿望类型', 'sys_user_wishType', '0', 'admin', '2022-02-21 21:50:31', '', null, '愿望类型 0：金钱援助 1：人力物力援助'), ('24', '审核类型', 'sys_audit_status', '0', 'admin', '2022-02-22 15:53:34', '', null, '审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望');
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
INSERT INTO `t_menu` VALUES ('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录'), ('4', '前端展示', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-area-chart', 'admin', '2022-02-21 11:04:44', 'admin', '2022-02-21 14:45:21', ''), ('100', '用户管理', '1', '1', '/admin/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单'), ('101', '角色管理', '1', '2', '/admin/role', '', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单'), ('102', '菜单管理', '1', '3', '/admin/menu', '', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单'), ('103', '部门管理', '1', '4', '/sadmin/dept', 'menuItem', 'C', '1', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:27', '部门管理菜单'), ('104', '岗位管理', '1', '5', '/admin/post', 'menuItem', 'C', '1', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:33', '岗位管理菜单'), ('105', '字典管理', '1', '6', '/admin/dict', '', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单'), ('106', '参数设置', '1', '7', '/admin/config', 'menuItem', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 10:00:54', '参数设置菜单'), ('107', '通知公告', '1', '8', '/admin/notice', 'menuItem', 'C', '1', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 14:50:01', '通知公告菜单'), ('108', '日志管理', '1', '9', '#', 'menuItem', 'M', '1', '', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:59', '日志管理菜单'), ('500', '操作日志', '108', '1', '/monitor/operlog', '', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单'), ('501', '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单'), ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1006', '重置密码', '100', '7', '#', '', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1007', '角色查询', '101', '1', '#', '', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1008', '角色新增', '101', '2', '#', '', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1009', '角色修改', '101', '3', '#', '', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1010', '角色删除', '101', '4', '#', '', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1011', '角色导出', '101', '5', '#', '', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1016', '部门查询', '103', '1', '#', '', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1017', '部门新增', '103', '2', '#', '', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1018', '部门修改', '103', '3', '#', '', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1019', '部门删除', '103', '4', '#', '', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1020', '岗位查询', '104', '1', '#', '', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1021', '岗位新增', '104', '2', '#', '', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1022', '岗位修改', '104', '3', '#', '', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1023', '岗位删除', '104', '4', '#', '', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1024', '岗位导出', '104', '5', '#', '', 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1025', '字典查询', '105', '1', '#', '', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1026', '字典新增', '105', '2', '#', '', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1027', '字典修改', '105', '3', '#', '', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1028', '字典删除', '105', '4', '#', '', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1029', '字典导出', '105', '5', '#', '', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1030', '参数查询', '106', '1', '#', '', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1031', '参数新增', '106', '2', '#', '', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1032', '参数修改', '106', '3', '#', '', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1033', '参数删除', '106', '4', '#', '', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1034', '参数导出', '106', '5', '#', '', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1035', '公告查询', '107', '1', '#', '', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1036', '公告新增', '107', '2', '#', '', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1037', '公告修改', '107', '3', '#', '', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1038', '公告删除', '107', '4', '#', '', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1039', '操作查询', '500', '1', '#', '', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1040', '操作删除', '500', '2', '#', '', 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1041', '详细信息', '500', '3', '#', '', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1042', '日志导出', '500', '4', '#', '', 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1043', '登录查询', '501', '1', '#', '', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1044', '登录删除', '501', '2', '#', '', 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1045', '日志导出', '501', '3', '#', '', 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1046', '账户解锁', '501', '4', '#', '', 'F', '0', 'monitor:logininfor:unlock', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''), ('1062', '志愿者模块', '0', '4', '#', 'menuItem', 'M', '0', null, 'fa fa-handshake-o', 'admin', '2020-02-05 11:52:26', 'admin', '2022-02-14 10:23:15', ''), ('1068', '关于我们', '4', '1', '/admin/about', '', 'C', '0', 'system:about:view', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '关于我们菜单'), ('1069', '查询', '1068', '1', '#', '', 'F', '0', 'system:about:list', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1070', '新增', '1068', '2', '#', '', 'F', '0', 'system:about:add', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1071', '修改', '1068', '3', '#', '', 'F', '0', 'system:about:edit', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1072', '删除', '1068', '4', '#', '', 'F', '0', 'system:about:remove', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1073', '关于我们导出', '1068', '5', '#', '', 'F', '0', 'system:about:export', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', ''), ('1075', '人员审核', '0', '2', '#', 'menuItem', 'M', '0', null, 'fa fa-group', 'admin', '2022-02-21 19:04:00', '', null, ''), ('1076', '待审核志愿者', '1075', '1', '/admin/audit', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-4', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:41', ''), ('1077', '查询', '1076', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, ''), ('1078', '审核', '1076', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, ''), ('1079', '待审核求助者', '1075', '1', '/admin/auditQ', 'menuItem', 'C', '0', 'system:auditQ:view', 'fa fa-battery-0', 'admin', '2022-02-21 19:07:54', 'lquan5', '2022-02-24 23:56:21', ''), ('1080', '查询', '1079', '1', '#', 'menuItem', 'F', '0', 'system:auditQ:list', '#', 'admin', '2022-02-21 19:09:48', '', null, ''), ('1081', '审核', '1079', '2', '#', 'menuItem', 'F', '0', 'system:auditQ:edit', '#', 'admin', '2022-02-21 19:11:36', '', null, ''), ('1082', '待审失败', '1075', '1', '/admin/auditF', 'menuItem', 'C', '0', 'system:auditF:view', 'fa fa-certificate', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:13:44', ''), ('1083', '查询', '1082', '1', '#', 'menuItem', 'F', '0', 'system:auditF:list', '#', 'admin', '2022-02-21 19:09:48', '', null, ''), ('1084', '审核', '1082', '2', '#', 'menuItem', 'F', '0', 'system:auditF:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, ''), ('1085', '求助管理', '0', '5', '#', 'menuItem', 'M', '0', null, 'fa fa-heartbeat', 'admin', '2022-02-21 21:12:17', 'admin', '2022-02-21 21:14:00', ''), ('1086', '我的愿望', '1085', '1', '/admin/wish', '', 'C', '0', 'system:wish:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '关于我们菜单'), ('1087', '查询', '1086', '1', '#', '', 'F', '0', 'system:wish:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1088', '新增', '1086', '2', '#', '', 'F', '0', 'system:wish:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1089', '修改', '1086', '3', '#', '', 'F', '0', 'system:wish:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1090', '删除', '1086', '4', '#', '', 'F', '0', 'system:wish:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1091', '导出', '1086', '5', '#', '', 'F', '0', 'system:wish:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1092', '审核心愿', '1085', '1', '/admin/wish/auditView', '', 'C', '0', 'system:wishA:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '关于我们菜单'), ('1093', '查询', '1092', '1', '#', 'menuItem', 'F', '0', 'system:wishA:list', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2022-02-24 22:20:06', ''), ('1094', '审核', '1092', '2', '#', '', 'F', '0', 'system:wishA:audit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1095', '审核心愿', '1062', '1', '/admin/wish/VolunteerView', 'menuItem', 'C', '0', 'system:wishV:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2022-02-23 15:17:24', '关于我们菜单'), ('1096', '查询', '1095', '1', '#', '', 'F', '0', 'system:wishA:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1097', '审核', '1095', '2', '#', '', 'F', '0', 'system:wishA:audit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1098', '愿望申领单', '1062', '1', '/admin/apply', 'menuItem', 'C', '0', 'system:apply:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2022-02-23 22:01:40', '愿望申领单菜单'), ('1099', '查询', '1098', '1', '#', '', 'F', '0', 'system:apply:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1100', '新增', '1098', '2', '#', '', 'F', '0', 'system:apply:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1101', '修改', '1098', '3', '#', '', 'F', '0', 'system:apply:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1102', '删除', '1098', '4', '#', '', 'F', '0', 'system:apply:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1103', '导出', '1098', '5', '#', '', 'F', '0', 'system:apply:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1104', '圆梦故事', '4', '1', '/admin/story', '', 'C', '0', 'system:story:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '圆梦故事菜单'), ('1105', '查询', '1104', '1', '#', '', 'F', '0', 'system:story:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1106', '新增', '1104', '2', '#', '', 'F', '0', 'system:story:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1107', '修改', '1104', '3', '#', '', 'F', '0', 'system:story:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1108', '删除', '1104', '4', '#', '', 'F', '0', 'system:story:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', ''), ('1109', '导出', '1104', '5', '#', '', 'F', '0', 'system:story:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
--  Records of `t_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员'), ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'super', '2022-02-24 23:39:03', '普通角色'), ('3', '志愿者', 'job_wanted', '3', '1', '0', '0', 'admin', '2020-02-05 11:25:28', 'admin', '2020-02-08 13:47:12', ''), ('4', '求助者', 'enterprise', '4', '1', '0', '0', 'admin', '2020-02-05 11:25:48', 'admin', '2022-02-24 22:08:07', ''), ('5', '游客', 'tourist', '5', '1', '0', '2', 'admin', '2020-02-05 11:26:13', 'admin', '2020-02-06 18:01:19', ''), ('6', 'role1', 'role1', '5', '1', '0', '0', 'super', '2022-02-24 23:40:21', '', null, null), ('7', 'role2', 'role2', '6', '1', '0', '0', 'super', '2022-02-24 23:40:38', 'super', '2022-02-24 23:41:53', null), ('8', 'role3', 'role3', '7', '1', '0', '0', 'super', '2022-02-24 23:41:01', '', null, null), ('9', 'role4', 'role4', '8', '1', '0', '0', 'super', '2022-02-24 23:41:22', '', null, null), ('10', 'role5', 'role5', '9', '1', '0', '0', 'super', '2022-02-24 23:41:45', '', null, null);
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
) ENGINE=InnoDB AUTO_INCREMENT=860 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
--  Records of `t_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menu` VALUES ('299', '2', '1'), ('300', '2', '100'), ('301', '2', '1000'), ('302', '2', '1001'), ('303', '2', '1002'), ('304', '2', '1003'), ('305', '2', '1004'), ('306', '2', '1005'), ('307', '2', '1006'), ('308', '2', '101'), ('309', '2', '1007'), ('310', '2', '1008'), ('311', '2', '1009'), ('312', '2', '1010'), ('313', '2', '1011'), ('314', '2', '102'), ('315', '2', '1012'), ('316', '2', '1013'), ('317', '2', '1014'), ('318', '2', '1015'), ('319', '2', '103'), ('320', '2', '1016'), ('321', '2', '1017'), ('322', '2', '1018'), ('323', '2', '1019'), ('324', '2', '104'), ('325', '2', '1020'), ('326', '2', '1021'), ('327', '2', '1022'), ('328', '2', '1023'), ('329', '2', '1024'), ('330', '2', '105'), ('331', '2', '1025'), ('332', '2', '1026'), ('333', '2', '1027'), ('334', '2', '1028'), ('335', '2', '1029'), ('336', '2', '106'), ('337', '2', '1030'), ('338', '2', '1031'), ('339', '2', '1032'), ('340', '2', '1033'), ('341', '2', '1034'), ('342', '2', '107'), ('343', '2', '1035'), ('344', '2', '1036'), ('345', '2', '1037'), ('346', '2', '1038'), ('347', '2', '108'), ('348', '2', '500'), ('349', '2', '1039'), ('350', '2', '1040'), ('351', '2', '1041'), ('352', '2', '1042'), ('353', '2', '501'), ('354', '2', '1043'), ('355', '2', '1044'), ('356', '2', '1045'), ('357', '2', '1046'), ('358', '2', '4'), ('359', '2', '1068'), ('360', '2', '1069'), ('361', '2', '1070'), ('362', '2', '1071'), ('363', '2', '1072'), ('364', '2', '1073'), ('365', '2', '1104'), ('366', '2', '1105'), ('367', '2', '1106'), ('368', '2', '1107'), ('369', '2', '1108'), ('370', '2', '1109'), ('371', '2', '1075'), ('372', '2', '1076'), ('373', '2', '1077'), ('374', '2', '1078'), ('375', '2', '1079'), ('376', '2', '1080'), ('377', '2', '1081'), ('378', '2', '1082'), ('379', '2', '1083'), ('380', '2', '1084'), ('381', '6', '1'), ('382', '6', '100'), ('383', '6', '1000'), ('384', '6', '1001'), ('385', '6', '1002'), ('386', '6', '1003'), ('387', '6', '1004'), ('388', '6', '1005'), ('389', '6', '1006'), ('390', '6', '101'), ('391', '6', '1007'), ('392', '6', '1008'), ('393', '6', '1009'), ('394', '6', '1010'), ('395', '6', '1011'), ('396', '6', '102'), ('397', '6', '1012'), ('398', '6', '1013'), ('399', '6', '1014'), ('400', '6', '1015'), ('401', '6', '103'), ('402', '6', '1016'), ('403', '6', '1017'), ('404', '6', '1018'), ('405', '6', '1019'), ('406', '6', '104'), ('407', '6', '1020'), ('408', '6', '1021'), ('409', '6', '1022'), ('410', '6', '1023'), ('411', '6', '1024'), ('412', '6', '105'), ('413', '6', '1025'), ('414', '6', '1026'), ('415', '6', '1027'), ('416', '6', '1028'), ('417', '6', '1029'), ('418', '6', '106'), ('419', '6', '1030'), ('420', '6', '1031'), ('421', '6', '1032'), ('422', '6', '1033'), ('423', '6', '1034'), ('424', '6', '107'), ('425', '6', '1035'), ('426', '6', '1036'), ('427', '6', '1037'), ('428', '6', '1038'), ('429', '6', '108'), ('430', '6', '500'), ('431', '6', '1039'), ('432', '6', '1040'), ('433', '6', '1041'), ('434', '6', '1042'), ('435', '6', '501'), ('436', '6', '1043'), ('437', '6', '1044'), ('438', '6', '1045'), ('439', '6', '1046'), ('512', '8', '1'), ('513', '8', '100'), ('514', '8', '1000'), ('515', '8', '1001'), ('516', '8', '1002'), ('517', '8', '1003'), ('518', '8', '1004'), ('519', '8', '1005'), ('520', '8', '1006'), ('521', '8', '101'), ('522', '8', '1007'), ('523', '8', '1008'), ('524', '8', '1009'), ('525', '8', '1010'), ('526', '8', '1011'), ('527', '8', '102'), ('528', '8', '1012'), ('529', '8', '1013'), ('530', '8', '1014'), ('531', '8', '1015'), ('532', '8', '103'), ('533', '8', '1016'), ('534', '8', '1017'), ('535', '8', '1018'), ('536', '8', '1019'), ('537', '8', '104'), ('538', '8', '1020'), ('539', '8', '1021'), ('540', '8', '1022'), ('541', '8', '1023'), ('542', '8', '1024'), ('543', '8', '105'), ('544', '8', '1025'), ('545', '8', '1026'), ('546', '8', '1027'), ('547', '8', '1028'), ('548', '8', '1029'), ('549', '8', '106'), ('550', '8', '1030'), ('551', '8', '1031'), ('552', '8', '1032'), ('553', '8', '1033'), ('554', '8', '1034'), ('555', '8', '107'), ('556', '8', '1035'), ('557', '8', '1036'), ('558', '8', '1037'), ('559', '8', '1038'), ('560', '8', '108'), ('561', '8', '500'), ('562', '8', '1039'), ('563', '8', '1040'), ('564', '8', '1041'), ('565', '8', '1042'), ('566', '8', '501'), ('567', '8', '1043'), ('568', '8', '1044'), ('569', '8', '1045'), ('570', '8', '1046'), ('571', '8', '4'), ('572', '8', '1068'), ('573', '8', '1069'), ('574', '8', '1070'), ('575', '8', '1071'), ('576', '8', '1072'), ('577', '8', '1073'), ('578', '8', '1104'), ('579', '8', '1105'), ('580', '8', '1106'), ('581', '8', '1107'), ('582', '8', '1108'), ('583', '8', '1109'), ('584', '8', '1075'), ('585', '8', '1076'), ('586', '8', '1077'), ('587', '8', '1078'), ('588', '8', '1079'), ('589', '8', '1080'), ('590', '8', '1081'), ('591', '8', '1082'), ('592', '8', '1083'), ('593', '8', '1084'), ('594', '9', '1'), ('595', '9', '100'), ('596', '9', '1000'), ('597', '9', '1001'), ('598', '9', '1002'), ('599', '9', '1003'), ('600', '9', '1004'), ('601', '9', '1005'), ('602', '9', '1006'), ('603', '9', '101'), ('604', '9', '1007'), ('605', '9', '1008'), ('606', '9', '1009'), ('607', '9', '1010'), ('608', '9', '1011'), ('609', '9', '102'), ('610', '9', '1012'), ('611', '9', '1013'), ('612', '9', '1014'), ('613', '9', '1015'), ('614', '9', '103'), ('615', '9', '1016'), ('616', '9', '1017'), ('617', '9', '1018'), ('618', '9', '1019'), ('619', '9', '104'), ('620', '9', '1020'), ('621', '9', '1021'), ('622', '9', '1022'), ('623', '9', '1023'), ('624', '9', '1024'), ('625', '9', '105'), ('626', '9', '1025'), ('627', '9', '1026'), ('628', '9', '1027'), ('629', '9', '1028'), ('630', '9', '1029'), ('631', '9', '106'), ('632', '9', '1030'), ('633', '9', '1031'), ('634', '9', '1032'), ('635', '9', '1033'), ('636', '9', '1034'), ('637', '9', '107'), ('638', '9', '1035'), ('639', '9', '1036'), ('640', '9', '1037'), ('641', '9', '1038'), ('642', '9', '108'), ('643', '9', '500'), ('644', '9', '1039'), ('645', '9', '1040'), ('646', '9', '1041'), ('647', '9', '1042'), ('648', '9', '501'), ('649', '9', '1043'), ('650', '9', '1044'), ('651', '9', '1045'), ('652', '9', '1046'), ('653', '9', '4'), ('654', '9', '1068'), ('655', '9', '1069'), ('656', '9', '1070'), ('657', '9', '1071'), ('658', '9', '1072'), ('659', '9', '1073'), ('660', '9', '1104'), ('661', '9', '1105'), ('662', '9', '1106'), ('663', '9', '1107'), ('664', '9', '1108'), ('665', '9', '1109'), ('666', '9', '1075'), ('667', '9', '1076'), ('668', '9', '1077'), ('669', '9', '1078'), ('670', '9', '1079'), ('671', '9', '1080'), ('672', '9', '1081'), ('673', '9', '1082'), ('674', '9', '1083'), ('675', '9', '1084'), ('676', '9', '1062'), ('677', '9', '1095'), ('678', '9', '1096'), ('679', '9', '1097'), ('680', '9', '1098'), ('681', '9', '1099'), ('682', '9', '1100'), ('683', '9', '1101'), ('684', '9', '1102'), ('685', '9', '1103'), ('686', '10', '1'), ('687', '10', '100'), ('688', '10', '1000'), ('689', '10', '1001'), ('690', '10', '1002'), ('691', '10', '1003'), ('692', '10', '1004'), ('693', '10', '1005'), ('694', '10', '1006'), ('695', '10', '101'), ('696', '10', '1007'), ('697', '10', '1008'), ('698', '10', '1009'), ('699', '10', '1010'), ('700', '10', '1011'), ('701', '10', '102'), ('702', '10', '1012'), ('703', '10', '1013'), ('704', '10', '1014'), ('705', '10', '1015'), ('706', '10', '103'), ('707', '10', '1016'), ('708', '10', '1017'), ('709', '10', '1018'), ('710', '10', '1019'), ('711', '10', '104'), ('712', '10', '1020'), ('713', '10', '1021'), ('714', '10', '1022'), ('715', '10', '1023'), ('716', '10', '1024'), ('717', '10', '105'), ('718', '10', '1025'), ('719', '10', '1026'), ('720', '10', '1027'), ('721', '10', '1028'), ('722', '10', '1029'), ('723', '10', '106'), ('724', '10', '1030'), ('725', '10', '1031'), ('726', '10', '1032'), ('727', '10', '1033'), ('728', '10', '1034'), ('729', '10', '107'), ('730', '10', '1035'), ('731', '10', '1036'), ('732', '10', '1037'), ('733', '10', '1038'), ('734', '10', '108'), ('735', '10', '500'), ('736', '10', '1039'), ('737', '10', '1040'), ('738', '10', '1041'), ('739', '10', '1042'), ('740', '10', '501'), ('741', '10', '1043'), ('742', '10', '1044'), ('743', '10', '1045'), ('744', '10', '1046'), ('745', '10', '4'), ('746', '10', '1068'), ('747', '10', '1069'), ('748', '10', '1070'), ('749', '10', '1071'), ('750', '10', '1072'), ('751', '10', '1073'), ('752', '10', '1104'), ('753', '10', '1105'), ('754', '10', '1106'), ('755', '10', '1107'), ('756', '10', '1108'), ('757', '10', '1109'), ('758', '10', '1075'), ('759', '10', '1076'), ('760', '10', '1077'), ('761', '10', '1078'), ('762', '10', '1079'), ('763', '10', '1080'), ('764', '10', '1081'), ('765', '10', '1082'), ('766', '10', '1083'), ('767', '10', '1084'), ('768', '10', '1062'), ('769', '10', '1095'), ('770', '10', '1096'), ('771', '10', '1097'), ('772', '10', '1098'), ('773', '10', '1099'), ('774', '10', '1100'), ('775', '10', '1101'), ('776', '10', '1102'), ('777', '10', '1103'), ('778', '10', '1085'), ('779', '10', '1086'), ('780', '10', '1087'), ('781', '10', '1088'), ('782', '10', '1089'), ('783', '10', '1090'), ('784', '10', '1091'), ('785', '10', '1092'), ('786', '10', '1093'), ('787', '10', '1094'), ('788', '7', '1'), ('789', '7', '100'), ('790', '7', '1000'), ('791', '7', '1001'), ('792', '7', '1002'), ('793', '7', '1003'), ('794', '7', '1004'), ('795', '7', '1005'), ('796', '7', '1006'), ('797', '7', '101'), ('798', '7', '1007'), ('799', '7', '1008'), ('800', '7', '1009'), ('801', '7', '1010'), ('802', '7', '1011'), ('803', '7', '102'), ('804', '7', '1012'), ('805', '7', '1013'), ('806', '7', '1014'), ('807', '7', '1015'), ('808', '7', '103'), ('809', '7', '1016'), ('810', '7', '1017'), ('811', '7', '1018'), ('812', '7', '1019'), ('813', '7', '104'), ('814', '7', '1020'), ('815', '7', '1021'), ('816', '7', '1022'), ('817', '7', '1023'), ('818', '7', '1024'), ('819', '7', '105'), ('820', '7', '1025'), ('821', '7', '1026'), ('822', '7', '1027'), ('823', '7', '1028'), ('824', '7', '1029'), ('825', '7', '106'), ('826', '7', '1030'), ('827', '7', '1031'), ('828', '7', '1032'), ('829', '7', '1033'), ('830', '7', '1034'), ('831', '7', '107'), ('832', '7', '1035'), ('833', '7', '1036'), ('834', '7', '1037'), ('835', '7', '1038'), ('836', '7', '108'), ('837', '7', '500'), ('838', '7', '1039'), ('839', '7', '1040'), ('840', '7', '1041'), ('841', '7', '1042'), ('842', '7', '501'), ('843', '7', '1043'), ('844', '7', '1044'), ('845', '7', '1045'), ('846', '7', '1046'), ('847', '7', '4'), ('848', '7', '1068'), ('849', '7', '1069'), ('850', '7', '1070'), ('851', '7', '1071'), ('852', '7', '1072'), ('853', '7', '1073'), ('854', '7', '1104'), ('855', '7', '1105'), ('856', '7', '1106'), ('857', '7', '1107'), ('858', '7', '1108'), ('859', '7', '1109');
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', '0', '0', 'super', 'super', '00', 'lquan@163.com', '15888888888', '1', '/headImage/c74dd2dc8533b952786b3c0cc3c4f6dd.png', '123456', '111111', '0', '0', '', '2022-02-07 14:38:23', 'admin', '2018-03-16 11:33:00', '', '2022-02-23 11:27:11', '管理员', null, null, '北京 东城区', null), ('26', null, '0', 'lquan', 'lquan', '00', '', '15810607114', '0', '', '123456', 'f50426', '0', '0', '', null, 'admin', '2022-02-24 21:00:24', 'admin', '2022-02-24 21:00:41', 'xxxx', null, null, '北京', '0'), ('27', null, '0', 'lquan001', 'lquanqx', '00', '', '15810607110', '0', '', '123456', '42e734', '0', '0', '', null, 'admin', '2022-02-24 21:15:38', 'admin', '2022-02-24 21:31:50', 'nn', null, null, '北京', '0'), ('28', null, '0', 'lquan1', 'lquan1', '00', '', '15810608111', '0', '', '123456', '060ec6', '0', '0', '', null, 'super', '2022-02-24 23:42:42', '', null, null, null, null, '比较', '0'), ('29', null, '0', 'lquan2', 'lquan2', '00', '', '15810608112', '0', '', '123456', 'c97fc5', '0', '0', '', null, 'super', '2022-02-24 23:43:06', '', null, null, null, null, '比较', '0'), ('30', null, '0', 'lquan3', 'lquan3', '00', '', '15810608113', '0', '', '123456', '1f32d2', '0', '0', '', null, 'super', '2022-02-24 23:43:32', '', null, null, null, null, '比较', '0'), ('31', null, '0', 'lquan4', 'lquan4', '00', '', '15810608114', '0', '', '123456', 'cb9257', '0', '0', '', null, 'super', '2022-02-24 23:43:51', '', null, null, null, null, '比较', '0'), ('32', null, '0', 'lquan5', 'lquan5', '00', '', '15810608115', '0', '', '123456', 'd9b7fb', '0', '0', '', null, 'super', '2022-02-24 23:44:07', '', null, null, null, null, '比较', '0'), ('33', null, '0', 'xxx', 'xx', '02', '', '15810608110', '0', '', '123456', '2bcf15', '0', '0', '', null, 'lquan5', '2022-02-24 23:53:41', '', '2022-02-25 00:06:58', null, '15810608110', '15810608110', '比较', '1'), ('34', null, '0', 'zyz', 'zyz', '01', '', '15810602311', '0', '', '123456', 'e5b9cd', '0', '0', '', null, 'super', '2022-02-25 00:05:34', '', null, null, null, null, '比较', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
--  Records of `t_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES ('2', '1', '1'), ('92', '27', '1'), ('93', '27', '2'), ('94', '26', '2'), ('95', '28', '6'), ('96', '29', '7'), ('97', '30', '8'), ('98', '31', '9'), ('99', '32', '10'), ('100', '33', '2'), ('101', '34', '3');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='愿望清单';

-- ----------------------------
--  Records of `t_wish`
-- ----------------------------
BEGIN;
INSERT INTO `t_wish` VALUES ('3', 'xxxxxxxy', '01d709bbf5e0365dd45ab25a11726566.jpg', 'xxxxxyy', '<p>ss<b><span style=\"font-size: 9px;\">s<span style=\"font-size: 36px;\">s</span></span></b><span style=\"font-size: 36px;\">﻿</span><span style=\"font-size: 36px;\">sss</span>sBBB vvvyyygkvghfffk</p>', '1', '0', '', '2022-02-22 12:14:33', 'admin', '2022-02-24 15:19:15', null, '1', '1', '1'), ('4', '啊发顺丰', '2faf2ced959ad835185c9bcbbc27e93b.jpg', '阿士大夫撒范德萨发的', '<p>广发的GV持续性差V型成本是多少方法</p><p><br></p>', '0', '0', 'admin', '2022-02-22 14:33:46', 'admin', '2022-02-24 21:26:01', null, '1', '2', '1'), ('5', '看望山区的儿童呀', 'e2269fa959aa9e3be4522cab4bc37b32.jpg', 'prprpr地说一堆东西，虽然并没有什么卵用，可是让人看了会很感动，很感动。所以你还是能编什么就编什么啦', 'prprpr地说一堆东西，虽然并没有什么卵用，可是让人看了会很感动，很感动。所以你还是能编什么就编什么啦prprpr地说一堆东西，虽然并没有什么卵用，可是让人看了会很感动，很感动。所以你还是能编什么就编什么啦', '1', '0', 'admin', '2022-02-24 15:18:32', 'admin', '2022-02-24 15:20:35', null, '1', '1', '1'), ('6', 'qerqwrwqer', '61133060e2ae688b0d239a6664db7c2e.jpg', 'qwerwqer', '<p>qwerwqerwqer</p>', '0', '0', 'lquan5', '2022-02-24 23:47:49', 'lquan5', '2022-02-24 23:51:24', null, '32', '1', '32');
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
INSERT INTO `t_wish_story` VALUES ('6', '123312313', '1a244038018e845e69c2cdfcf8eba2a6.jpg', 'qwrqwe', '<p>rqwerqwerqwerqwer</p>', '1', '0', '', '2022-02-24 01:00:25', 'lquan2', '2022-02-24 23:44:59', null), ('7', '果度有好多人系度量血压啊，猴赛雷啊', '111c8e62196fc4570789a15eaced5974.jpg', '中国的慈善事业，同样有着自己悠久的传统。汉唐寺院济贫、赈灾、医疗、戒残杀的长盛不衰；宋代养老扶幼事业的勃兴；元医疗救助的兴起；明清民间慈善群体在中国慈善史上首屈一指 。更有当今国门开放以来，涌现出一批批社会贤达、名流、企业家、离退休干部为水灾、为贫困大中小学生、为艾滋病、白内障的贫困患者，默默从事的慈善救助。统计表明，至少一半的富豪要求对其捐款事实及数额“保密”。中国的慈善事业，同样有着自己悠久的传统。汉唐寺院济贫、赈灾、医疗、戒残杀的长盛不衰；宋代养老扶幼事业的勃兴；元医疗救助的兴起；明清民间慈善群体在中国慈善史上首屈一指 。更有当今国门开放以来，涌现出一批批社会贤达、名流、企业家、离退休干部为水灾、为贫困大中小学生、为艾滋病、白内障的贫困患者，默默从事的慈善救助。统计表明，至少一半的富豪要求对其捐款事实及数额“保密”。', '<p></p><p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 14px;\">6月10日放学后，姐妹俩吃了垃圾堆里的食物后中毒。事发后住在附近的小孩过来看。图/潇湘晨报记者陈正 从学校回出租屋的那条路，只有一公里，姐妹俩却再也走不到了。 6月10日放学后，她们走了一条与往常不一样的路：来到离学校不远的山脚下，这里，堆了一些被丢弃的垃圾。 姐妹俩应该有些饿，她们吃起了垃圾堆里的食物。 没过多久，这对14岁和8岁的姐妹俩的生命，因“毒鼠强”而终止。 “我看到小妹子的时候，她眼睛都翻白了。”6月11日下午，见到记者时，60岁的汤和平老泪纵横。 一天前，他的两个女儿放学后回家，在途中死亡。衡阳警方认定，两女孩的死因系中毒引发。 14岁的姐姐汤银霞、8岁的妹妹汤溪林，都在衡阳县界牌镇银瓷完小读书，姐姐读六年级，妹妹读一年级。 6月10日下午放学后，姐妹俩一起回家。她们家在镇上租的房子离学校仅一公里左右，谁也没料到，姐妹俩会在途中出事。 汤和平事后了解到的情况是，大女儿死在离家半公里的山下——这并不是从学校回家的路。随后，妹妹哭着回家喊人，倒在半途中，后来被附近居民发现。汤和平赶到医院不久，小女儿停止了呼吸。 当地流传的说法称，汤银霞姐妹俩途中遇上两名男子，两男子请她们喝可乐，之后姐妹俩倒地死亡。 “这种说法基本可以排除。”6月11日，衡阳县公安局刑侦大队大队长黄均说。 事发后，当地公安机关迅速介入调查。 据了解，事发时，汤银霞的同学陈文华也在现场。11日晚，陈文华仍在派出所配合调查。据她的奶奶凌红燕转述，在当天回家途中，陈文华看到汤银霞姐妹捡垃圾堆里的食物吃。“什么麻辣烫呀，还有一些脏的东西都吃，里面可能有老鼠药。”凌红燕说，“她们是吃垃圾中毒的。” 正在当地调查的黄均确认，汤银霞姐妹系中毒身亡，“是毒鼠强。具体什么原因，还在调查。” 哪里来的毒鼠强? 孩子们倒在毒鼠强之下的新闻并不少见。今年3月，山东巨野6岁男童路边捡到一根棒棒糖，吃完后中毒死亡。 毒鼠强，毒性极强，几毫克毒鼠强便可致成人死亡，目前尚无特效解毒剂。早在1991年，农业部即将毒鼠强为禁用品种。2003年，“两高”曾出台司法解释，明确非法制造、买卖、运输、储存毒鼠强等禁用剧毒化学品，最高可判处死刑。 然而，因成本低廉，购买方便，这种毒药在很多农村乡镇集市上可以随意买到，毒鼠强中毒事件仍然不断发生。 这一次，毒死衡阳县两姐妹的毒鼠强到底从何而来?仍待警方调查。 父母可以做到这些 衡阳县两姐妹的悲剧，令人唏嘘。作为家长，应该告诫孩子“不要捡掉地上的食物吃”，并懂得一定的急救知识。 专家建议，父母首先以身作则，家里吃饭时，食物掉地上不要捡起来吃。此外，在公共场所发现的食物，即使包装完好，也不要让孩子碰。 除了预防，父母还必须懂得一些中毒急救方法。如果孩子食物中毒，要及时进行催吐。孩子吃过的食物，怀疑变质或者有毒时，要保存起来，交给医生急救时分析处理。同时要第一时间送往医院检查救治。 常随母亲捡废品，常饿肚子 两个女儿的生命无法挽回了，汤和平，这个60岁的老人，头发泛白，满面憔悴，接受采访时哭成了泪人。 这并非是他第一次面对命运的残酷。 十六年前，13岁的儿子在水塘里溺亡。此后，夫妻俩陆续生下两个女儿。谁也没想到，夫妻俩要再次承受丧女之痛。 母亲捡垃圾常忘记给她们做饭 汤和平的家位于偏僻的界牌镇高山村，离镇上七八公里远。村里的小学早撤了，汤和平只能将女儿送到镇里的银瓷完小就读。 6月11日，潇湘晨报记者来到界牌镇一家破旧的瓷器厂仓库。走过一条狭长的小道，看到一间小杂屋，透过破烂的木门，可见屋内堆积的杂乱废品。 这间杂屋曾是破产企业的一个澡堂，改造后用来出租。七年前，为了方便孩子读书，汤和平租下这间小杂房，月租50元。 汤和平平常都在老家务农，农闲时节出去帮人弹棉被挣些零用钱。这些年，在镇上出租屋照顾两个女儿的任务，便由汤和平的妻子承担。 汤妻比他小十来岁，没读过书，有智力障碍。“脑子有问题。”汤和平说，妻子唯一的技能，就是捡废品。她不懂算术，挑废品去卖，“老板给多少就多少。” 住在附近的居民王兰兰介绍，汤妻经常半夜三更出来走动。令邻居们担忧的是，汤妻白天外出捡垃圾，常常忘记回家给两个女儿煮饭，“有时候一天吃一顿饭，有时候两顿。”王兰兰说。 垃圾堆里有她们喜欢的麻辣小吃 汤银霞姐妹的学习成绩不好。 她的一名同学说，在班上69个同学中，汤银霞总是倒数一二名，“三科加起来都考不到30分。” 办案民警对姐妹俩的生活状况进行过调查。据黄均介绍，姐妹俩有捡垃圾的生活习性，常跟母亲外出捡废品，“有时也捡一些东西吃。” 6月10日下午放学回家，姐妹俩没有直接走马路回，而是来到离学校不远的山脚下，这里有一些被居民们丢弃的垃圾废品。当时，姐妹俩应该有些饿，而回到家，也许要几小时后才能等到母亲做的晚饭。姐妹俩从垃圾堆里捡了一些别人扔弃的食物，其中有她们喜欢的麻辣小吃。 幼小的她们没考虑到，这些垃圾废品中，可能有当地居民毒鼠用过的“食品”——毒鼠强。 14岁的姐姐先倒地，她吃得多，也吃得快。 8岁的妹妹吓得往前跑，没多久，也倒在了半途中。 从大瑶山来到县城，开始了照顾母亲兼打工的生活</span><br></p><p><br></p><p><br></p><p><br></p>', '1', '0', '', '2022-02-24 01:28:26', 'lquan2', '2022-02-24 23:45:06', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
