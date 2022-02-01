CREATE TABLE `shiro_user` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(32) DEFAULT NULL COMMENT '密码',
  `Author` varchar(200) DEFAULT NULL COMMENT '授权',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8