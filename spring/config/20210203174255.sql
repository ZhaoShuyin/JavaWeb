/*
MySQL Backup
Database: spring
Backup Time: 2021-02-03 17:42:56
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `spring`.`accounts`;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `amount` float(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `spring`.`accounts` WRITE;
DELETE FROM `spring`.`accounts`;
INSERT INTO `spring`.`accounts` (`id`,`name`,`amount`) VALUES (1, 'aaa', 499992),(2, 'bbb', 120),(3, 'ccc', 1000),(5, 'ggg', 1000),(6, 'jjj', 1000),(7, 'hhh', 1000),(8, 'hhh', 1000),(9, 'hhh', 1000);
UNLOCK TABLES;
COMMIT;
