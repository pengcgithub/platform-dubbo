-- 用户中心
CREATE DATABASE platform_user;
CREATE TABLE `t_user` (
  `freeze_amount` decimal(20,2) default NULL,
  `balance` decimal(20,2) default NULL,
  `id` varchar(32) character set utf8 collate utf8_bin NOT NULL,
  `user_name` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `user_phone` int(11) default NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `score` int(5) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 订单中心
CREATE DATABASE platform_order;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL auto_increment,
  `create_time` datetime NOT NULL,
  `number` varchar(20) collate utf8_bin NOT NULL,
  `status` tinyint(4) NOT NULL,
  `product_id` varchar(128) collate utf8_bin NOT NULL,
  `total_amount` decimal(10,0) NOT NULL,
  `count` int(4) NOT NULL,
  `user_id` varchar(128) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 分布式事物
-- 一个服务中心对应一张TCC表，利用后缀来区分服务中心(_ord)。例如订单中心，tcc_transaction_ord
CREATE DATABASE tcc;
CREATE TABLE `tcc_transaction_ord` (
   `TRANSACTION_ID` int(11) NOT NULL auto_increment,
   `DOMAIN` varchar(100) default NULL,
   `GLOBAL_TX_ID` varbinary(32) NOT NULL,
   `BRANCH_QUALIFIER` varbinary(32) NOT NULL,
   `CONTENT` varbinary(8000) default NULL,
   `STATUS` int(11) default NULL,
   `TRANSACTION_TYPE` int(11) default NULL,
   `RETRIED_COUNT` int(11) default NULL,
   `CREATE_TIME` datetime default NULL,
   `LAST_UPDATE_TIME` datetime default NULL,
   `VERSION` int(11) default NULL,
   `IS_DELETE` tinyint(1) NOT NULL default '0',
   PRIMARY KEY  (`TRANSACTION_ID`),
   UNIQUE KEY `UX_TX_BQ` (`GLOBAL_TX_ID`,`BRANCH_QUALIFIER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

