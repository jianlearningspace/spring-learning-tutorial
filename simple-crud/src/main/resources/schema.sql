DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `password` varchar(255),
  `address_id` bigint
);

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `address_name` varchar(255)
);

DROP TABLE IF EXISTS `hobby`;
CREATE TABLE `hobby` (
  `hobby_id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `hobby_name` varchar(255)
);

DROP TABLE IF EXISTS `user_hobby`;
CREATE TABLE `user_hobby` (
  `user_hobby_id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `hobby_id` bigint NOT NULL
);

ALTER TABLE user ADD FOREIGN KEY (`address_id`) REFERENCES address(`address_id`);
ALTER TABLE user_hobby ADD FOREIGN KEY (`user_id`) REFERENCES user(`user_id`);
ALTER TABLE user_hobby ADD FOREIGN KEY (`hobby_id`) REFERENCES hobby(`hobby_id`);