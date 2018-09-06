CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '主键id',
  `user_name` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名称',
  `user_account` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  `user_dept_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门id',
  `user_role_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `sys_permission` (
  `permission_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '菜单id',
  `permission_name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT 'url访问路径',
  `icon` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '图标',
  `parent_id` varchar(32) DEFAULT NULL,
  `permission_type` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '区分菜单或者按钮',
  `code` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限code',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `sys_role` (
  `role_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '角色id',
  `role_name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
  `status` varchar(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色是否可用，1可用，0不可用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `sys_role_permission` (
  `role_permission_id` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '角色权限关联表id',
  `role_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `lints_lear`.`sys_user` (`user_id`, `user_name`, `user_account`, `user_password`, `user_dept_id`, `user_role_id`, `create_time`, `update_time`, `status`) VALUES ('1', 'linyi', '123456', '123456', '1', '1', '2018-09-05 15:58:18', '2018-09-05 15:58:21', '1');
INSERT INTO `lints_lear`.`sys_user` (`user_id`, `user_name`, `user_account`, `user_password`, `user_dept_id`, `user_role_id`, `create_time`, `update_time`, `status`) VALUES ('2', 'wanger', '123456', '123456', '1', '2', '2018-09-05 15:59:07', '2018-09-05 15:59:10', '1');
INSERT INTO `lints_lear`.`sys_user` (`user_id`, `user_name`, `user_account`, `user_password`, `user_dept_id`, `user_role_id`, `create_time`, `update_time`, `status`) VALUES ('3', 'zhangsan', '123456', '123456', '1', '1', '2018-09-05 15:59:27', '2018-09-05 15:59:29', '1');
INSERT INTO `lints_lear`.`sys_user` (`user_id`, `user_name`, `user_account`, `user_password`, `user_dept_id`, `user_role_id`, `create_time`, `update_time`, `status`) VALUES ('4', 'lisi', '123456', '123456', '1', '2', '2018-09-05 15:59:57', '2018-09-05 16:00:00', '1');

INSERT INTO `lints_lear`.`sys_role` (`role_id`, `role_name`, `status`) VALUES ('1', '管理员', '1');
INSERT INTO `lints_lear`.`sys_role` (`role_id`, `role_name`, `status`) VALUES ('2', '普通用户', '1');


INSERT INTO `lints_lear`.`sys_permission` (`permission_id`, `permission_name`, `url`, `icon`, `parent_id`, `permission_type`, `code`) VALUES ('1', '会员管理', NULL, NULL, NULL, 'menu', 'user:info');
INSERT INTO `lints_lear`.`sys_permission` (`permission_id`, `permission_name`, `url`, `icon`, `parent_id`, `permission_type`, `code`) VALUES ('2', '新增会员', NULL, NULL, NULL, 'button', 'user:add');
INSERT INTO `lints_lear`.`sys_permission` (`permission_id`, `permission_name`, `url`, `icon`, `parent_id`, `permission_type`, `code`) VALUES ('3', '编辑会员', NULL, NULL, NULL, 'button', 'user:edit');
INSERT INTO `lints_lear`.`sys_permission` (`permission_id`, `permission_name`, `url`, `icon`, `parent_id`, `permission_type`, `code`) VALUES ('4', '会员列表', NULL, NULL, NULL, 'button', 'user:view');
INSERT INTO `lints_lear`.`sys_permission` (`permission_id`, `permission_name`, `url`, `icon`, `parent_id`, `permission_type`, `code`) VALUES ('5', '删除会员', NULL, NULL, NULL, 'button', 'user:del');


INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('1', '1', '1');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('2', '1', '2');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('3', '1', '3');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('4', '1', '4');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('5', '1', '5');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('6', '2', '1');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('7', '2', '2');
INSERT INTO `lints_lear`.`sys_role_permission` (`role_permission_id`, `role_id`, `permission_id`) VALUES ('8', '2', '3');

