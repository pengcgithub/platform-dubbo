CREATE DATABASE platform_dubbo;

CREATE TABLE `t_user` (
`id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,
`user_phone`  int(11) NULL DEFAULT NULL ,
`create_time`  datetime NOT NULL ,
`modify_time`  datetime NOT NULL ,
`score`  int(5) NOT NULL ,
PRIMARY KEY (`id`)
);