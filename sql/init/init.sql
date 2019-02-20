CREATE DATABASE `platform_dev`;
use platform_dev;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `number` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `status` tinyint(4) NOT NULL,
  `product_id` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  `total_amount` decimal(10,0) NOT NULL,
  `count` int(4) NOT NULL,
  `user_id` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `t_user` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `freeze_amount` decimal(19,2) DEFAULT NULL,
  `amount` decimal(19,2) default null,
  `modify_time` datetime DEFAULT NULL,
  `user_name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `user_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `score` int(5) default 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


