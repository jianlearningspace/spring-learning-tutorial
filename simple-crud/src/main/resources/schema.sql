DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `password` varchar(255)
);
