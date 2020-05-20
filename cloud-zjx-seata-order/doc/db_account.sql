/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.7.28 : Database - db_account
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_account` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_account`;

/*Table structure for table `account_tbl` */

DROP TABLE IF EXISTS `account_tbl`;

CREATE TABLE `account_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `account_tbl` */

insert  into `account_tbl`(`id`,`user_id`,`money`) values (1,'1001','90000.00');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `undo_log` */

insert  into `undo_log`(`id`,`branch_id`,`xid`,`context`,`rollback_info`,`log_status`,`log_created`,`log_modified`) values (1,2043675087,'192.168.160.128:8091:2043675085','serializer=jackson','{\"@class\":\"io.seata.rm.datasource.undo.BranchUndoLog\",\"xid\":\"192.168.160.128:8091:2043675085\",\"branchId\":2043675087,\"sqlUndoLogs\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.undo.SQLUndoLog\",\"sqlType\":\"UPDATE\",\"tableName\":\"account_tbl\",\"beforeImage\":{\"@class\":\"io.seata.rm.datasource.sql.struct.TableRecords\",\"tableName\":\"account_tbl\",\"rows\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.sql.struct.Row\",\"fields\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"id\",\"keyType\":\"PRIMARY_KEY\",\"type\":4,\"value\":1},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"money\",\"keyType\":\"NULL\",\"type\":3,\"value\":[\"java.math.BigDecimal\",100000.00]}]]}]]},\"afterImage\":{\"@class\":\"io.seata.rm.datasource.sql.struct.TableRecords\",\"tableName\":\"account_tbl\",\"rows\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.sql.struct.Row\",\"fields\":[\"java.util.ArrayList\",[{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"id\",\"keyType\":\"PRIMARY_KEY\",\"type\":4,\"value\":1},{\"@class\":\"io.seata.rm.datasource.sql.struct.Field\",\"name\":\"money\",\"keyType\":\"NULL\",\"type\":3,\"value\":[\"java.math.BigDecimal\",90000.02]}]]}]]}}]]}',0,'2020-05-20 07:10:27','2020-05-20 07:10:27');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
