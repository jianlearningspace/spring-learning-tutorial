DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `resource_name` varchar(100),
  `resource_url` varchar(100),
  `resource_operation` varchar(100),
  `resource_type` int,
  `create_date` timestamp DEFAULT CURRENT_TIMESTAMP,
  `order_by` int
);

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `role_name` varchar(100),
  `role_type` int,
  `create_date` timestamp DEFAULT CURRENT_TIMESTAMP,
  `order_by` int
);

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `department_id` int,
  `post_id` int,
  `last_login` date,
  `create_date` timestamp DEFAULT CURRENT_TIMESTAMP,
  `order_by` int
);

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL
);

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `resource_id` int NOT NULL,
  `role_id` int NOT NULL,
  `permission_status` int ,
  `create_date` timestamp DEFAULT CURRENT_TIMESTAMP,
  `order_by` int
);

ALTER TABLE sys_user_role ADD FOREIGN KEY (`user_id`) REFERENCES sys_user (`user_id`);
ALTER TABLE sys_user_role ADD FOREIGN KEY (`role_id`) REFERENCES sys_role (`role_id`);
ALTER TABLE sys_permission ADD FOREIGN KEY (`resource_id`) REFERENCES sys_resource (`resource_id`);
ALTER TABLE sys_permission ADD FOREIGN KEY (`role_id`) REFERENCES sys_role (`role_id`);