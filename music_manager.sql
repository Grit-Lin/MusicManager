/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.30-log : Database - music_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `music_manager`;

/*Table structure for table `t_music` */

DROP TABLE IF EXISTS `t_music`;

CREATE TABLE `t_music` (
  `music_id` bigint(20) NOT NULL COMMENT '主键',
  `music_name` varchar(32) NOT NULL COMMENT '音乐名称',
  `musician_id` bigint(20) NOT NULL COMMENT '音乐家id',
  `music_address` varchar(256) NOT NULL COMMENT '音乐存储地址',
  `music_info` varchar(256) DEFAULT NULL COMMENT '音乐简介',
  `music_duratio` varchar(20) NOT NULL COMMENT '音乐时长',
  PRIMARY KEY (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_musician` */

DROP TABLE IF EXISTS `t_musician`;

CREATE TABLE `t_musician` (
  `musician_id` bigint(20) NOT NULL COMMENT '主键',
  `musician_name` varchar(32) NOT NULL COMMENT '音乐家名称',
  `musician_country` varchar(32) NOT NULL COMMENT '音乐家国籍',
  `musician_info` varchar(256) DEFAULT NULL COMMENT '音乐家简介',
  PRIMARY KEY (`musician_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL COMMENT '主键',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `user_password` varchar(64) NOT NULL COMMENT '密码',
  `user_sex` int(1) DEFAULT NULL COMMENT '性别',
  `user_age` int(2) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
