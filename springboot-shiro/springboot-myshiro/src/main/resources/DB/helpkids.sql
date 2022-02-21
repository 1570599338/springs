/*
Navicat MySQL Data Transfer

Source Server         : localhost3306
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : helpkids

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2022-02-21 22:01:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_about
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='关于我们';

-- ----------------------------
-- Records of t_about
-- ----------------------------
INSERT INTO `t_about` VALUES ('1', '联系我们', '<pre style=\"background-color: rgb(255, 255, 255);\"><div style=\"color: rgb(0, 0, 0); font-family: &quot;Courier New&quot;; font-size: 9pt; text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您有正能量需要投稿分享...</span></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\"><span style=\"font-size: 12px;\"><br></span></font></div><font color=\"#000000\" face=\"Courier New\"><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您身边有人需要帮忙...</span></div><div style=\"text-align: right;\"><span style=\"font-size: 12px;\"><br></span></div><span style=\"font-size: 9pt;\"><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">如果您要寻找亲人...</span></div><br><div style=\"text-align: right;\"><span style=\"font-size: 24px; font-family: Helvetica;\">请联系我们！</span></div><br><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\">我们的联系方式是xxxxxx</span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div><div style=\"text-align: right;\"><font color=\"#000000\" face=\"Courier New\" style=\"font-size: 13px;\"><span style=\"font-size: 24px; font-family: Helvetica;\"><br></span></font></div></span></font></pre>', '0', '', '2022-02-21 13:47:27', 'admin', '2022-02-21 18:56:20', 'dddddd');
INSERT INTO `t_about` VALUES ('3', 'qwer', 'qwerwq', '0', '', '2022-02-21 12:36:31', '', '2022-02-21 12:36:39', 'qwerqwress水电费是梵蒂冈的');

-- ----------------------------
-- Table structure for t_config
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
-- Records of t_config
-- ----------------------------
INSERT INTO `t_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `t_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');
INSERT INTO `t_config` VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');

-- ----------------------------
-- Table structure for t_dept
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
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('100', '0', '0', '若依科技', '0', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `t_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');

-- ----------------------------
-- Table structure for t_dict_data
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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of t_dict_data
-- ----------------------------
INSERT INTO `t_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男');
INSERT INTO `t_dict_data` VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女');
INSERT INTO `t_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `t_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `t_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `t_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `t_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `t_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `t_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `t_dict_data` VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认分组');
INSERT INTO `t_dict_data` VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统分组');
INSERT INTO `t_dict_data` VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是');
INSERT INTO `t_dict_data` VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否');
INSERT INTO `t_dict_data` VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知');
INSERT INTO `t_dict_data` VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告');
INSERT INTO `t_dict_data` VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `t_dict_data` VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `t_dict_data` VALUES ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `t_dict_data` VALUES ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作');
INSERT INTO `t_dict_data` VALUES ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作');
INSERT INTO `t_dict_data` VALUES ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作');
INSERT INTO `t_dict_data` VALUES ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作');
INSERT INTO `t_dict_data` VALUES ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作');
INSERT INTO `t_dict_data` VALUES ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作');
INSERT INTO `t_dict_data` VALUES ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作');
INSERT INTO `t_dict_data` VALUES ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作');
INSERT INTO `t_dict_data` VALUES ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `t_dict_data` VALUES ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `t_dict_data` VALUES ('29', '1', '计算机类', '0', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:14:42', 'admin', '2020-02-05 10:37:05', '');
INSERT INTO `t_dict_data` VALUES ('30', '1', '文职类', '1', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:15:05', 'admin', '2020-02-05 10:37:16', '');
INSERT INTO `t_dict_data` VALUES ('31', '2', '销售类', '2', 'job_position_type', '', '', 'Y', '0', 'admin', '2020-02-05 10:15:18', 'admin', '2020-02-05 10:37:27', '');
INSERT INTO `t_dict_data` VALUES ('32', '0', '1000以下', '0', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:18', '', null, null);
INSERT INTO `t_dict_data` VALUES ('33', '1', '1000~3000', '1', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:34', '', null, null);
INSERT INTO `t_dict_data` VALUES ('34', '2', '3001~8000', '2', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:16:51', '', null, null);
INSERT INTO `t_dict_data` VALUES ('35', '3', '8001~12000', '3', 'job_salary', null, null, 'Y', '0', 'admin', '2020-02-05 10:17:07', '', null, null);
INSERT INTO `t_dict_data` VALUES ('36', '0', '未发布', '0', 'job_resume_status', null, null, 'Y', '0', 'admin', '2020-02-05 10:26:54', '', null, null);
INSERT INTO `t_dict_data` VALUES ('37', '1', '发布', '1', 'job_resume_status', null, null, 'Y', '0', 'admin', '2020-02-05 10:27:06', '', null, null);
INSERT INTO `t_dict_data` VALUES ('38', '0', '北京市', '0', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:31', '', null, null);
INSERT INTO `t_dict_data` VALUES ('39', '1', '上海市', '1', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:40', '', null, null);
INSERT INTO `t_dict_data` VALUES ('40', '2', '广州市', '2', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:13:51', '', null, null);
INSERT INTO `t_dict_data` VALUES ('41', '3', '深圳市', '3', 'job_area', null, null, 'Y', '0', 'admin', '2020-02-05 12:14:03', '', null, null);
INSERT INTO `t_dict_data` VALUES ('42', '0', '未处理', '0', 'job_operate_status', null, null, 'Y', '0', 'admin', '2020-02-05 18:18:19', '', null, null);
INSERT INTO `t_dict_data` VALUES ('43', '1', '已处理', '1', 'job_operate_status', null, null, 'Y', '0', 'admin', '2020-02-05 18:18:32', '', null, null);
INSERT INTO `t_dict_data` VALUES ('44', '0', '同意', '0', 'job_operate_result', null, null, 'Y', '0', 'admin', '2020-02-05 18:19:13', '', null, null);
INSERT INTO `t_dict_data` VALUES ('45', '1', '拒绝', '1', 'job_operate_result', null, null, 'Y', '0', 'admin', '2020-02-05 18:19:20', '', null, null);
INSERT INTO `t_dict_data` VALUES ('46', '1', '30天(10元)', '10', 'job_vip_level', '', '', 'Y', '0', 'admin', '2020-02-07 13:27:38', 'admin', '2020-02-07 13:29:08', '');
INSERT INTO `t_dict_data` VALUES ('47', '2', '90天(25元)', '25', 'job_vip_level', '', '', 'Y', '0', 'admin', '2020-02-07 13:27:58', 'admin', '2020-02-07 13:29:01', '');
INSERT INTO `t_dict_data` VALUES ('48', '3', '180天(45元)', '45', 'job_vip_level', null, null, 'Y', '0', 'admin', '2020-02-07 13:28:51', '', null, null);
INSERT INTO `t_dict_data` VALUES ('49', '4', '360天(80元)', '80', 'job_vip_level', null, null, 'Y', '0', 'admin', '2020-02-07 13:29:34', '', null, null);
INSERT INTO `t_dict_data` VALUES ('50', '1', '20人以下', '1', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:12', '', null, null);
INSERT INTO `t_dict_data` VALUES ('51', '2', '20~50人', '2', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:30', '', null, null);
INSERT INTO `t_dict_data` VALUES ('52', '3', '50~100人', '3', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:09:46', '', null, null);
INSERT INTO `t_dict_data` VALUES ('53', '4', '100~500人', '4', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:10:00', '', null, null);
INSERT INTO `t_dict_data` VALUES ('54', '5', '500人以上', '5', 'job_enterprise_scale', null, null, 'Y', '0', 'admin', '2020-02-10 13:10:14', '', null, null);
INSERT INTO `t_dict_data` VALUES ('55', '1', '金融/投资/证券', '1', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:11:35', '', null, null);
INSERT INTO `t_dict_data` VALUES ('56', '2', '计算机软件', '2', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:11:51', '', null, null);
INSERT INTO `t_dict_data` VALUES ('57', '3', '汽车及零配件', '3', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:12:26', '', null, null);
INSERT INTO `t_dict_data` VALUES ('58', '4', '房地产/汽车', '4', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 13:12:40', '', null, null);
INSERT INTO `t_dict_data` VALUES ('59', '5', '快速消费品(食品、饮料、化妆品) 批发/零售', '5', 'job_enterprise_category', null, null, 'Y', '0', 'admin', '2020-02-10 14:15:16', '', null, null);
INSERT INTO `t_dict_data` VALUES ('60', '1', 'lquan01tab', 'lquan01key', 'sys_user_sex1', '', 'primary', 'Y', '0', 'admin', '2022-02-11 17:02:09', 'admin', '2022-02-11 17:03:31', 'lquan01');
INSERT INTO `t_dict_data` VALUES ('61', '2', 'lquan02tab', 'lquan02key', 'sys_user_sex1', '', 'default', 'Y', '0', 'admin', '2022-02-11 17:02:49', null, null, 'lquan02');
INSERT INTO `t_dict_data` VALUES ('63', '4', 'lquan03tab1', 'lquan03key1', 'sys_user_sex1', '', 'success', 'Y', '0', 'admin', '2022-02-11 17:13:30', 'admin', '2022-02-11 17:13:53', 'lquan03tab1');
INSERT INTO `t_dict_data` VALUES ('64', '1', '货币', '0', 'sys_user_wishType', '', '', 'Y', '0', 'admin', '2022-02-21 21:52:07', null, null, '货币援助');
INSERT INTO `t_dict_data` VALUES ('65', '2', '人力物力', '1', 'sys_user_wishType', '', '', 'Y', '0', 'admin', '2022-02-21 21:52:43', null, null, '人力物力援助');

-- ----------------------------
-- Table structure for t_dict_type
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of t_dict_type
-- ----------------------------
INSERT INTO `t_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-11 14:26:08', '用户性别列表');
INSERT INTO `t_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表');
INSERT INTO `t_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表');
INSERT INTO `t_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表');
INSERT INTO `t_dict_type` VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务分组列表');
INSERT INTO `t_dict_type` VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表');
INSERT INTO `t_dict_type` VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表');
INSERT INTO `t_dict_type` VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表');
INSERT INTO `t_dict_type` VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表');
INSERT INTO `t_dict_type` VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表');
INSERT INTO `t_dict_type` VALUES ('11', '职位类别', 'job_position_type', '0', 'admin', '2020-02-05 10:13:26', 'admin', '2020-02-05 10:25:47', '职位类别');
INSERT INTO `t_dict_type` VALUES ('12', '薪资范围', 'job_salary', '0', 'admin', '2020-02-05 10:15:51', 'admin', '2020-02-05 10:25:40', '');
INSERT INTO `t_dict_type` VALUES ('13', '简历状态', 'job_resume_status', '0', 'admin', '2020-02-05 10:26:28', '', null, null);
INSERT INTO `t_dict_type` VALUES ('14', '地区', 'job_area', '0', 'admin', '2020-02-05 12:13:16', '', null, null);
INSERT INTO `t_dict_type` VALUES ('15', '处理状态', 'job_operate_status', '0', 'admin', '2020-02-05 18:18:02', '', null, null);
INSERT INTO `t_dict_type` VALUES ('16', '处理结果', 'job_operate_result', '0', 'admin', '2020-02-05 18:18:52', '', null, null);
INSERT INTO `t_dict_type` VALUES ('17', 'VIP等级', 'job_vip_level', '0', 'admin', '2020-02-07 13:27:08', '', null, null);
INSERT INTO `t_dict_type` VALUES ('18', '企业规模', 'job_enterprise_scale', '0', 'admin', '2020-02-10 13:08:24', '', null, null);
INSERT INTO `t_dict_type` VALUES ('19', '企业性质', 'job_enterprise_category', '0', 'admin', '2020-02-10 13:10:54', '', null, null);
INSERT INTO `t_dict_type` VALUES ('22', '用户性别1', 'sys_user_sex1', '0', 'admin', '2022-02-11 17:01:29', '', null, 'xxxxxx');
INSERT INTO `t_dict_type` VALUES ('23', '愿望类型', 'sys_user_wishType', '0', 'admin', '2022-02-21 21:50:31', '', null, '愿望类型 0：金钱援助 1：人力物力援助');

-- ----------------------------
-- Table structure for t_logininfor
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
-- Records of t_logininfor
-- ----------------------------
INSERT INTO `t_logininfor` VALUES ('100', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-04 20:49:05');
INSERT INTO `t_logininfor` VALUES ('101', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:33:54');
INSERT INTO `t_logininfor` VALUES ('102', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:34:23');
INSERT INTO `t_logininfor` VALUES ('103', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:34:31');
INSERT INTO `t_logininfor` VALUES ('104', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:36:38');
INSERT INTO `t_logininfor` VALUES ('105', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:37:33');
INSERT INTO `t_logininfor` VALUES ('106', 'common', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '用户不存在/密码错误', '2020-02-05 09:37:45');
INSERT INTO `t_logininfor` VALUES ('107', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '密码输入错误1次', '2020-02-05 09:38:24');
INSERT INTO `t_logininfor` VALUES ('108', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '密码输入错误2次', '2020-02-05 09:38:42');
INSERT INTO `t_logininfor` VALUES ('109', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '密码输入错误1次', '2020-02-05 09:40:01');
INSERT INTO `t_logininfor` VALUES ('110', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:40:23');
INSERT INTO `t_logininfor` VALUES ('111', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:48:01');
INSERT INTO `t_logininfor` VALUES ('112', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:48:49');
INSERT INTO `t_logininfor` VALUES ('113', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:48:54');
INSERT INTO `t_logininfor` VALUES ('114', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:49:08');
INSERT INTO `t_logininfor` VALUES ('115', 'ry', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 09:50:36');
INSERT INTO `t_logininfor` VALUES ('116', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 09:50:48');
INSERT INTO `t_logininfor` VALUES ('117', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 10:13:49');
INSERT INTO `t_logininfor` VALUES ('118', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 10:25:21');
INSERT INTO `t_logininfor` VALUES ('119', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 10:50:14');
INSERT INTO `t_logininfor` VALUES ('120', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '1', '验证码错误', '2020-02-05 11:13:20');
INSERT INTO `t_logininfor` VALUES ('121', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:21:16');
INSERT INTO `t_logininfor` VALUES ('122', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:24:18');
INSERT INTO `t_logininfor` VALUES ('123', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:28:47');
INSERT INTO `t_logininfor` VALUES ('124', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:38:33');
INSERT INTO `t_logininfor` VALUES ('125', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:50:43');
INSERT INTO `t_logininfor` VALUES ('126', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 11:54:07');
INSERT INTO `t_logininfor` VALUES ('127', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 11:54:09');
INSERT INTO `t_logininfor` VALUES ('128', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:01:26');
INSERT INTO `t_logininfor` VALUES ('129', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:12:37');
INSERT INTO `t_logininfor` VALUES ('130', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:31:38');
INSERT INTO `t_logininfor` VALUES ('131', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:47:10');
INSERT INTO `t_logininfor` VALUES ('132', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:47:16');
INSERT INTO `t_logininfor` VALUES ('133', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:47:26');
INSERT INTO `t_logininfor` VALUES ('134', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:47:28');
INSERT INTO `t_logininfor` VALUES ('135', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:47:50');
INSERT INTO `t_logininfor` VALUES ('136', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:47:54');
INSERT INTO `t_logininfor` VALUES ('137', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:48:22');
INSERT INTO `t_logininfor` VALUES ('138', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:48:26');
INSERT INTO `t_logininfor` VALUES ('139', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 12:49:23');
INSERT INTO `t_logininfor` VALUES ('140', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:49:25');
INSERT INTO `t_logininfor` VALUES ('141', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:55:44');
INSERT INTO `t_logininfor` VALUES ('142', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 12:57:52');
INSERT INTO `t_logininfor` VALUES ('143', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:18:02');
INSERT INTO `t_logininfor` VALUES ('144', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:20:12');
INSERT INTO `t_logininfor` VALUES ('145', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 13:20:36');
INSERT INTO `t_logininfor` VALUES ('146', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:20:39');
INSERT INTO `t_logininfor` VALUES ('147', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:22:18');
INSERT INTO `t_logininfor` VALUES ('148', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:32:14');
INSERT INTO `t_logininfor` VALUES ('149', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:34:37');
INSERT INTO `t_logininfor` VALUES ('150', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:35:51');
INSERT INTO `t_logininfor` VALUES ('151', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:37:24');
INSERT INTO `t_logininfor` VALUES ('152', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:41:01');
INSERT INTO `t_logininfor` VALUES ('153', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:43:45');
INSERT INTO `t_logininfor` VALUES ('154', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:46:29');
INSERT INTO `t_logininfor` VALUES ('155', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 13:46:56');
INSERT INTO `t_logininfor` VALUES ('156', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 13:46:58');
INSERT INTO `t_logininfor` VALUES ('157', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:24:09');
INSERT INTO `t_logininfor` VALUES ('158', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:37:54');
INSERT INTO `t_logininfor` VALUES ('159', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:37:57');
INSERT INTO `t_logininfor` VALUES ('160', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:38:01');
INSERT INTO `t_logininfor` VALUES ('161', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:38:02');
INSERT INTO `t_logininfor` VALUES ('162', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:38:16');
INSERT INTO `t_logininfor` VALUES ('163', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:38:18');
INSERT INTO `t_logininfor` VALUES ('164', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:39:07');
INSERT INTO `t_logininfor` VALUES ('165', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:39:10');
INSERT INTO `t_logininfor` VALUES ('166', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '退出成功', '2020-02-05 14:40:16');
INSERT INTO `t_logininfor` VALUES ('167', 'qiye', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:40:19');
INSERT INTO `t_logininfor` VALUES ('168', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 14:44:27');
INSERT INTO `t_logininfor` VALUES ('169', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 15:47:33');
INSERT INTO `t_logininfor` VALUES ('170', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 16:09:33');
INSERT INTO `t_logininfor` VALUES ('171', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 16:41:28');
INSERT INTO `t_logininfor` VALUES ('172', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 17:08:26');
INSERT INTO `t_logininfor` VALUES ('173', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 17:11:26');
INSERT INTO `t_logininfor` VALUES ('174', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 17:46:13');
INSERT INTO `t_logininfor` VALUES ('175', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 18:07:30');
INSERT INTO `t_logininfor` VALUES ('176', 'admin', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10', '0', '登录成功', '2020-02-05 18:16:18');

-- ----------------------------
-- Table structure for t_menu
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
) ENGINE=InnoDB AUTO_INCREMENT=1092 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `t_menu` VALUES ('2', '系统监控', '0', '2', '#', 'menuItem', 'M', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 11:02:17', '系统监控目录');
INSERT INTO `t_menu` VALUES ('3', '系统工具', '0', '3', '#', 'menuItem', 'M', '1', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:11', '系统工具目录');
INSERT INTO `t_menu` VALUES ('4', '前端展示', '0', '1', '#', 'menuItem', 'M', '0', null, 'fa fa-area-chart', 'admin', '2022-02-21 11:04:44', 'admin', '2022-02-21 14:45:21', '');
INSERT INTO `t_menu` VALUES ('100', '用户管理', '1', '1', '/system/user', '', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `t_menu` VALUES ('101', '角色管理', '1', '2', '/system/role', '', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `t_menu` VALUES ('102', '菜单管理', '1', '3', '/system/menu', '', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `t_menu` VALUES ('103', '部门管理', '1', '4', '/system/dept', 'menuItem', 'C', '1', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:27', '部门管理菜单');
INSERT INTO `t_menu` VALUES ('104', '岗位管理', '1', '5', '/system/post', 'menuItem', 'C', '1', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:33', '岗位管理菜单');
INSERT INTO `t_menu` VALUES ('105', '字典管理', '1', '6', '/system/dict', '', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `t_menu` VALUES ('106', '参数设置', '1', '7', '/system/config', 'menuItem', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 10:00:54', '参数设置菜单');
INSERT INTO `t_menu` VALUES ('107', '通知公告', '1', '8', '/system/notice', 'menuItem', 'C', '1', 'system:notice:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2022-02-21 14:50:01', '通知公告菜单');
INSERT INTO `t_menu` VALUES ('108', '日志管理', '1', '9', '#', 'menuItem', 'M', '1', '', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-11 09:57:59', '日志管理菜单');
INSERT INTO `t_menu` VALUES ('109', '在线用户', '2', '1', '/monitor/online', '', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `t_menu` VALUES ('110', '定时任务', '2', '2', '/monitor/job', '', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `t_menu` VALUES ('111', '数据监控', '2', '3', '/monitor/data', '', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `t_menu` VALUES ('112', '服务监控', '2', '3', '/monitor/server', '', 'C', '0', 'monitor:server:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `t_menu` VALUES ('113', '表单构建', '3', '1', '/tool/build', '', 'C', '0', 'tool:build:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `t_menu` VALUES ('114', '代码生成', '3', '2', '/tool/gen', '', 'C', '0', 'tool:gen:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `t_menu` VALUES ('115', '系统接口', '3', '3', '/tool/swagger', '', 'C', '0', 'tool:swagger:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `t_menu` VALUES ('500', '操作日志', '108', '1', '/monitor/operlog', '', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `t_menu` VALUES ('501', '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `t_menu` VALUES ('1000', '用户查询', '100', '1', '#', '', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1001', '用户新增', '100', '2', '#', '', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1002', '用户修改', '100', '3', '#', '', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1003', '用户删除', '100', '4', '#', '', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1004', '用户导出', '100', '5', '#', '', 'F', '0', 'system:user:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1005', '用户导入', '100', '6', '#', '', 'F', '0', 'system:user:import', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1006', '重置密码', '100', '7', '#', '', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1007', '角色查询', '101', '1', '#', '', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1008', '角色新增', '101', '2', '#', '', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1009', '角色修改', '101', '3', '#', '', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1010', '角色删除', '101', '4', '#', '', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1011', '角色导出', '101', '5', '#', '', 'F', '0', 'system:role:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1016', '部门查询', '103', '1', '#', '', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1017', '部门新增', '103', '2', '#', '', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1018', '部门修改', '103', '3', '#', '', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1019', '部门删除', '103', '4', '#', '', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1020', '岗位查询', '104', '1', '#', '', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1021', '岗位新增', '104', '2', '#', '', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1022', '岗位修改', '104', '3', '#', '', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1023', '岗位删除', '104', '4', '#', '', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1024', '岗位导出', '104', '5', '#', '', 'F', '0', 'system:post:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1025', '字典查询', '105', '1', '#', '', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1026', '字典新增', '105', '2', '#', '', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1027', '字典修改', '105', '3', '#', '', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1028', '字典删除', '105', '4', '#', '', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1029', '字典导出', '105', '5', '#', '', 'F', '0', 'system:dict:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1030', '参数查询', '106', '1', '#', '', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1031', '参数新增', '106', '2', '#', '', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1032', '参数修改', '106', '3', '#', '', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1033', '参数删除', '106', '4', '#', '', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1034', '参数导出', '106', '5', '#', '', 'F', '0', 'system:config:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1035', '公告查询', '107', '1', '#', '', 'F', '0', 'system:notice:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1036', '公告新增', '107', '2', '#', '', 'F', '0', 'system:notice:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1037', '公告修改', '107', '3', '#', '', 'F', '0', 'system:notice:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1038', '公告删除', '107', '4', '#', '', 'F', '0', 'system:notice:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1039', '操作查询', '500', '1', '#', '', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1040', '操作删除', '500', '2', '#', '', 'F', '0', 'monitor:operlog:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1041', '详细信息', '500', '3', '#', '', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', 'F', '0', 'monitor:operlog:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', 'F', '0', 'monitor:logininfor:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', 'F', '0', 'monitor:logininfor:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1046', '账户解锁', '501', '4', '#', '', 'F', '0', 'monitor:logininfor:unlock', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1047', '在线查询', '109', '1', '#', '', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1048', '批量强退', '109', '2', '#', '', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1049', '单条强退', '109', '3', '#', '', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1050', '任务查询', '110', '1', '#', '', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1051', '任务新增', '110', '2', '#', '', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1052', '任务修改', '110', '3', '#', '', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1053', '任务删除', '110', '4', '#', '', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1054', '状态修改', '110', '5', '#', '', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1055', '任务详细', '110', '6', '#', '', 'F', '0', 'monitor:job:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1056', '任务导出', '110', '7', '#', '', 'F', '0', 'monitor:job:export', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1057', '生成查询', '114', '1', '#', '', 'F', '0', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1058', '生成修改', '114', '2', '#', '', 'F', '0', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1059', '生成删除', '114', '3', '#', '', 'F', '0', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1060', '预览代码', '114', '4', '#', '', 'F', '0', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1061', '生成代码', '114', '5', '#', '', 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `t_menu` VALUES ('1062', '志愿者模块', '0', '4', '#', 'menuItem', 'M', '0', null, 'fa fa-handshake-o', 'admin', '2020-02-05 11:52:26', 'admin', '2022-02-14 10:23:15', '');
INSERT INTO `t_menu` VALUES ('1063', '简历管理', '1062', '1', '/job/resume', 'menuItem', 'C', '0', 'job:resume:view', '#', 'admin', '2020-02-05 11:53:07', 'admin', '2020-02-06 13:51:55', '');
INSERT INTO `t_menu` VALUES ('1064', '职位管理', '1062', '2', '/job/position', 'menuItem', 'C', '0', 'job:position:view', '#', 'admin', '2020-02-05 12:03:54', 'admin', '2020-02-05 15:47:51', '');
INSERT INTO `t_menu` VALUES ('1065', '新增', '1063', '1', '#', 'menuItem', 'F', '0', 'job:position:add', '#', 'admin', '2020-02-05 12:04:48', '', null, '');
INSERT INTO `t_menu` VALUES ('1066', '编辑', '1063', '2', '#', 'menuItem', 'F', '0', 'job:position:edit', '#', 'admin', '2020-02-05 12:05:12', '', null, '');
INSERT INTO `t_menu` VALUES ('1067', '删除', '1063', '3', '#', 'menuItem', 'F', '0', 'job:position:remove', '#', 'admin', '2020-02-05 12:05:31', '', null, '');
INSERT INTO `t_menu` VALUES ('1068', '关于我们', '4', '1', '/admin/about', '', 'C', '0', 'system:about:view', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '关于我们菜单');
INSERT INTO `t_menu` VALUES ('1069', '查询', '1068', '1', '#', '', 'F', '0', 'system:about:list', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1070', '新增', '1068', '2', '#', '', 'F', '0', 'system:about:add', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1071', '修改', '1068', '3', '#', '', 'F', '0', 'system:about:edit', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1072', '删除', '1068', '4', '#', '', 'F', '0', 'system:about:remove', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1073', '关于我们导出', '1068', '5', '#', '', 'F', '0', 'system:about:export', '#', 'admin', '2018-03-01 00:00:00', 'lquan', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1075', '人员审核', '0', '2', '#', 'menuItem', 'M', '0', null, 'fa fa-group', 'admin', '2022-02-21 19:04:00', '', null, '');
INSERT INTO `t_menu` VALUES ('1076', '待审核志愿者', '1075', '1', '/admin/audit', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-4', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:41', '');
INSERT INTO `t_menu` VALUES ('1077', '查询', '1076', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, '');
INSERT INTO `t_menu` VALUES ('1078', '审核', '1076', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, '');
INSERT INTO `t_menu` VALUES ('1079', '待审核求助者', '1075', '1', '/admin/auditQ', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-battery-0', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:16:30', '');
INSERT INTO `t_menu` VALUES ('1080', '查询', '1079', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, '');
INSERT INTO `t_menu` VALUES ('1081', '审核', '1079', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, '');
INSERT INTO `t_menu` VALUES ('1082', '待审失败', '1075', '1', '/admin/auditF', 'menuItem', 'C', '0', 'system:audit:view', 'fa fa-certificate', 'admin', '2022-02-21 19:07:54', 'admin', '2022-02-21 19:13:44', '');
INSERT INTO `t_menu` VALUES ('1083', '查询', '1082', '1', '#', 'menuItem', 'F', '0', 'system:audit:list', '#', 'admin', '2022-02-21 19:09:48', '', null, '');
INSERT INTO `t_menu` VALUES ('1084', '审核', '1082', '2', '#', 'menuItem', 'F', '0', 'system:audit:audited', '#', 'admin', '2022-02-21 19:11:36', '', null, '');
INSERT INTO `t_menu` VALUES ('1085', '求助管理', '0', '5', '#', 'menuItem', 'M', '0', null, 'fa fa-heartbeat', 'admin', '2022-02-21 21:12:17', 'admin', '2022-02-21 21:14:00', '');
INSERT INTO `t_menu` VALUES ('1086', '我的愿望', '1085', '1', '/admin/wish', '', 'C', '0', 'system:wish:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '关于我们菜单');
INSERT INTO `t_menu` VALUES ('1087', '查询', '1086', '1', '#', '', 'F', '0', 'system:wish:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1088', '新增', '1086', '2', '#', '', 'F', '0', 'system:wish:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1089', '修改', '1086', '3', '#', '', 'F', '0', 'system:wish:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1090', '删除', '1086', '4', '#', '', 'F', '0', 'system:wish:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `t_menu` VALUES ('1091', '导出', '1086', '5', '#', '', 'F', '0', 'system:wish:export', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');

-- ----------------------------
-- Table structure for t_notice
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
-- Records of t_notice
-- ----------------------------

-- ----------------------------
-- Table structure for t_oper_log
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
-- Records of t_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_post
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
-- Records of t_post
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
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
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '管理员');
INSERT INTO `t_role` VALUES ('2', '普通角色', 'common', '2', '2', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-02-05 09:50:56', '普通角色');
INSERT INTO `t_role` VALUES ('3', '志愿者', 'job_wanted', '3', '1', '0', '0', 'admin', '2020-02-05 11:25:28', 'admin', '2020-02-08 13:47:12', '');
INSERT INTO `t_role` VALUES ('4', '求助者', 'enterprise', '4', '1', '0', '0', 'admin', '2020-02-05 11:25:48', 'admin', '2020-02-10 13:58:33', '');
INSERT INTO `t_role` VALUES ('5', '游客', 'tourist', '5', '1', '0', '0', 'admin', '2020-02-05 11:26:13', 'admin', '2020-02-06 18:01:19', '');

-- ----------------------------
-- Table structure for t_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_role_dept`;
CREATE TABLE `t_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of t_role_dept
-- ----------------------------
INSERT INTO `t_role_dept` VALUES ('2', '2', '100');
INSERT INTO `t_role_dept` VALUES ('3', '2', '101');
INSERT INTO `t_role_dept` VALUES ('4', '2', '105');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1', '1');
INSERT INTO `t_role_menu` VALUES ('2', '2', '1');
INSERT INTO `t_role_menu` VALUES ('3', '2', '2');
INSERT INTO `t_role_menu` VALUES ('4', '2', '3');
INSERT INTO `t_role_menu` VALUES ('5', '2', '100');
INSERT INTO `t_role_menu` VALUES ('6', '2', '101');
INSERT INTO `t_role_menu` VALUES ('7', '2', '102');
INSERT INTO `t_role_menu` VALUES ('8', '2', '103');
INSERT INTO `t_role_menu` VALUES ('9', '2', '104');
INSERT INTO `t_role_menu` VALUES ('10', '2', '105');
INSERT INTO `t_role_menu` VALUES ('11', '2', '106');
INSERT INTO `t_role_menu` VALUES ('12', '2', '107');
INSERT INTO `t_role_menu` VALUES ('13', '2', '108');
INSERT INTO `t_role_menu` VALUES ('14', '2', '109');
INSERT INTO `t_role_menu` VALUES ('15', '2', '110');
INSERT INTO `t_role_menu` VALUES ('16', '2', '111');
INSERT INTO `t_role_menu` VALUES ('17', '2', '112');
INSERT INTO `t_role_menu` VALUES ('18', '2', '113');
INSERT INTO `t_role_menu` VALUES ('19', '2', '114');
INSERT INTO `t_role_menu` VALUES ('20', '2', '115');
INSERT INTO `t_role_menu` VALUES ('21', '2', '500');
INSERT INTO `t_role_menu` VALUES ('22', '2', '501');
INSERT INTO `t_role_menu` VALUES ('23', '2', '1000');
INSERT INTO `t_role_menu` VALUES ('24', '2', '1001');
INSERT INTO `t_role_menu` VALUES ('25', '2', '1002');
INSERT INTO `t_role_menu` VALUES ('26', '2', '1003');
INSERT INTO `t_role_menu` VALUES ('27', '2', '1004');
INSERT INTO `t_role_menu` VALUES ('28', '2', '1005');
INSERT INTO `t_role_menu` VALUES ('29', '2', '1006');
INSERT INTO `t_role_menu` VALUES ('30', '2', '1007');
INSERT INTO `t_role_menu` VALUES ('31', '2', '1008');
INSERT INTO `t_role_menu` VALUES ('32', '2', '1009');
INSERT INTO `t_role_menu` VALUES ('33', '2', '1010');
INSERT INTO `t_role_menu` VALUES ('34', '2', '1011');
INSERT INTO `t_role_menu` VALUES ('35', '2', '1012');
INSERT INTO `t_role_menu` VALUES ('36', '2', '1013');
INSERT INTO `t_role_menu` VALUES ('37', '2', '1014');
INSERT INTO `t_role_menu` VALUES ('38', '2', '1015');
INSERT INTO `t_role_menu` VALUES ('39', '2', '1016');
INSERT INTO `t_role_menu` VALUES ('40', '2', '1017');
INSERT INTO `t_role_menu` VALUES ('41', '2', '1018');
INSERT INTO `t_role_menu` VALUES ('42', '2', '1019');
INSERT INTO `t_role_menu` VALUES ('43', '2', '1020');
INSERT INTO `t_role_menu` VALUES ('44', '2', '1021');
INSERT INTO `t_role_menu` VALUES ('45', '2', '1022');
INSERT INTO `t_role_menu` VALUES ('46', '2', '1023');
INSERT INTO `t_role_menu` VALUES ('47', '2', '1024');
INSERT INTO `t_role_menu` VALUES ('48', '2', '1025');
INSERT INTO `t_role_menu` VALUES ('49', '2', '1026');
INSERT INTO `t_role_menu` VALUES ('50', '2', '1027');
INSERT INTO `t_role_menu` VALUES ('51', '2', '1028');
INSERT INTO `t_role_menu` VALUES ('52', '2', '1029');
INSERT INTO `t_role_menu` VALUES ('53', '2', '1030');
INSERT INTO `t_role_menu` VALUES ('54', '2', '1031');
INSERT INTO `t_role_menu` VALUES ('55', '2', '1032');
INSERT INTO `t_role_menu` VALUES ('56', '2', '1033');
INSERT INTO `t_role_menu` VALUES ('57', '2', '1034');
INSERT INTO `t_role_menu` VALUES ('58', '2', '1035');
INSERT INTO `t_role_menu` VALUES ('59', '2', '1036');
INSERT INTO `t_role_menu` VALUES ('60', '2', '1037');
INSERT INTO `t_role_menu` VALUES ('61', '2', '1038');
INSERT INTO `t_role_menu` VALUES ('62', '2', '1039');
INSERT INTO `t_role_menu` VALUES ('63', '2', '1040');
INSERT INTO `t_role_menu` VALUES ('64', '2', '1041');
INSERT INTO `t_role_menu` VALUES ('65', '2', '1042');
INSERT INTO `t_role_menu` VALUES ('66', '2', '1043');
INSERT INTO `t_role_menu` VALUES ('67', '2', '1044');
INSERT INTO `t_role_menu` VALUES ('68', '2', '1045');
INSERT INTO `t_role_menu` VALUES ('69', '2', '1046');
INSERT INTO `t_role_menu` VALUES ('70', '2', '1047');
INSERT INTO `t_role_menu` VALUES ('71', '2', '1048');
INSERT INTO `t_role_menu` VALUES ('72', '2', '1049');
INSERT INTO `t_role_menu` VALUES ('73', '2', '1050');
INSERT INTO `t_role_menu` VALUES ('74', '2', '1051');
INSERT INTO `t_role_menu` VALUES ('75', '2', '1052');
INSERT INTO `t_role_menu` VALUES ('76', '2', '1053');
INSERT INTO `t_role_menu` VALUES ('77', '2', '1054');
INSERT INTO `t_role_menu` VALUES ('78', '2', '1055');
INSERT INTO `t_role_menu` VALUES ('79', '2', '1056');
INSERT INTO `t_role_menu` VALUES ('80', '2', '1057');
INSERT INTO `t_role_menu` VALUES ('81', '2', '1058');
INSERT INTO `t_role_menu` VALUES ('82', '2', '1059');
INSERT INTO `t_role_menu` VALUES ('83', '2', '1060');
INSERT INTO `t_role_menu` VALUES ('84', '2', '1061');
INSERT INTO `t_role_menu` VALUES ('85', '3', '1062');
INSERT INTO `t_role_menu` VALUES ('86', '3', '1063');
INSERT INTO `t_role_menu` VALUES ('87', '3', '1065');
INSERT INTO `t_role_menu` VALUES ('88', '3', '1066');
INSERT INTO `t_role_menu` VALUES ('89', '3', '1067');
INSERT INTO `t_role_menu` VALUES ('90', '3', '1068');
INSERT INTO `t_role_menu` VALUES ('91', '3', '1070');
INSERT INTO `t_role_menu` VALUES ('92', '4', '1062');
INSERT INTO `t_role_menu` VALUES ('93', '4', '1064');
INSERT INTO `t_role_menu` VALUES ('94', '4', '1069');
INSERT INTO `t_role_menu` VALUES ('95', '4', '1085');
INSERT INTO `t_role_menu` VALUES ('96', '5', '1062');
INSERT INTO `t_role_menu` VALUES ('97', '5', '1069');
INSERT INTO `t_role_menu` VALUES ('98', '5', '1070');

-- ----------------------------
-- Table structure for t_user
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '103', '0', 'admin', 'lquan', '00', 'lquan@163.com', '15888888888', '1', '/headImage/d03124dd10707a029e36786bffeb60e2.png', 'admin123', '111111', '0', '0', '', '2022-02-07 14:38:23', 'admin', '2018-03-16 11:33:00', '', '2022-02-15 09:59:39', '管理员', null, null, null, null);
INSERT INTO `t_user` VALUES ('2', '105', '0', 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '', '2020-02-05 09:49:08', 'admin', '2018-03-16 11:33:00', 'ry', '2020-02-05 09:49:08', '测试员', null, null, null, null);
INSERT INTO `t_user` VALUES ('22', null, '0', 'lquans', 'lquans', '00', '', '15810607111', '0', '', '123456', 'e83b02', '0', '0', '', null, 'admin', '2022-02-21 18:43:12', '', null, '北京 朝阳 surp', null, null, '北京 朝阳', '0');
INSERT INTO `t_user` VALUES ('23', null, '0', 'lquanz', 'lquanz2', '01', '', '15810607122', '1', '', '123456', '9ed206', '0', '0', '', null, 'admin', '2022-02-21 18:45:27', 'admin', '2022-02-21 21:02:09', '北京 东城区志愿者2', null, null, '北京 东城区志愿者', '2');
INSERT INTO `t_user` VALUES ('25', null, '0', 'lquanq', 'lquanq', '02', '', '15810607113', '0', '', '123456', '452d07', '0', '0', '', null, 'admin', '2022-02-21 20:33:17', 'admin', '2022-02-21 20:44:35', null, '习大大', '18888888888', '北京 通州', '1');

-- ----------------------------
-- Table structure for t_user_online
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
-- Records of t_user_online
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_post
-- ----------------------------
DROP TABLE IF EXISTS `t_user_post`;
CREATE TABLE `t_user_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of t_user_post
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('2', '1', '1');
INSERT INTO `t_user_role` VALUES ('3', '2', '2');
INSERT INTO `t_user_role` VALUES ('58', '24', '4');
INSERT INTO `t_user_role` VALUES ('60', '25', '4');
INSERT INTO `t_user_role` VALUES ('66', '23', '2');

-- ----------------------------
-- Table structure for t_wish
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='关于我们';

-- ----------------------------
-- Records of t_wish
-- ----------------------------
INSERT INTO `t_wish` VALUES ('1', '1234', '41234', '1234', '1234', '0', '1', '', '2022-02-21 21:54:10', '', null, null);
INSERT INTO `t_wish` VALUES ('2', '而我让他认为', '委托人头', '台湾而特特', '台湾而问题', '1', '1', '', '2022-02-21 22:00:30', '', null, null);
