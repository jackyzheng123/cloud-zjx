/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.7.28 : Database - db_order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_order` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_order`;

/*Table structure for table `order_tbl` */

DROP TABLE IF EXISTS `order_tbl`;

CREATE TABLE `order_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `order_no` varchar(255) DEFAULT NULL COMMENT '订单号',
  `commodity_code` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `count` int(11) DEFAULT '0' COMMENT '订单数量',
  `money` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `order_tbl` */

insert  into `order_tbl`(`id`,`user_id`,`order_no`,`commodity_code`,`count`,`money`,`create_date`) values (1,'1001','d7195bcee8194ae7a8377c059ddad586','TB001',1,'4999.99','2020-03-27 06:52:20'),(2,'1001','e4498d19a4dc4e479944e40bc56c46b1','TB001',1,'4999.99','2020-03-27 06:53:16'),(3,'1001','a35bbd5841a9411c81021bd665bca0a9','TB001',2,'9999.98','2020-05-20 07:08:05'),(4,'1001','3437a3c2312e44abb45ff9e31e2e4ca0','TB001',2,'9999.98','2020-05-20 07:10:26'),(5,'1001','c417d28636e8417da6472874d321b998','TB001',2,'9999.98','2020-05-20 07:45:29'),(6,'1001','cee55832ae3247a5a687f2f35c32ccc1','TB001',2,'9999.98','2020-05-20 07:46:16'),(7,'1001','af964251404a460fa6ed91c4b6146c1f','TB001',2,'9999.98','2020-05-20 07:48:27'),(8,'1001','f6763eee564f4a24a2dbe074b31bdbe7','TB001',2,'10000.00','2020-05-20 08:14:14'),(9,'1001','a8cdb50db437455e910422bfc820cfde','TB001',2,'10000.00','2020-05-20 08:15:55');

/*Table structure for table `undo_log` */

DROP TABLE IF EXISTS `undo_log`;

CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `undo_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
