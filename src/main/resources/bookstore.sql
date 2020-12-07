-- MySQL dump 10.13  Distrib 5.6.45, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.6.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bookstore`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bookstore`;

--
-- Table structure for table `bs_book`
--

DROP TABLE IF EXISTS `bs_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `sales` int(11) unsigned DEFAULT NULL,
  `stock` int(11) unsigned DEFAULT NULL,
  `imgPath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_book`
--

LOCK TABLES `bs_book` WRITE;
/*!40000 ALTER TABLE `bs_book` DISABLE KEYS */;
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (6,'百年孤独','马尔克斯',29.50,103,97,'common/img/book/6.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (7,'扶桑','严歌苓',19.80,104,96,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (8,'给孩子的诗','北岛',22.20,105,95,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (9,'为奴十二年','所罗门',16.50,101,99,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (10,'平凡的世界','路遥',55.00,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (11,'悟空传','今何在',14.00,101,99,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (12,'硬派健身','斌卡',31.20,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (13,'从晚清到民国','唐德刚',39.90,101,99,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (14,'三体','刘慈欣',56.50,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (15,'看见','柴静',19.50,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (16,'活着','余华',11.00,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (17,'小王子','安托万',19.20,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (18,'我们仨','杨绛',11.30,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (19,'生命不息,折腾不止','罗永浩',25.20,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (20,'皮囊','蔡崇达',23.90,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (21,'恰到好处的幸福','毕淑敏',16.40,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (22,'大数据预测','埃里克',37.20,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (23,'人月神话','布鲁克斯',55.90,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (24,'C语言入门经典','霍尔顿',45.00,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (25,'数学之美','吴军',29.90,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (26,'Java编程思想','埃史尔',70.50,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (27,'设计模式之禅','秦小波',20.20,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (28,'图解机器学习','杉山将',33.80,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (29,'艾伦图灵传','安德鲁',47.20,100,100,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (30,'教父','马里奥普佐',29.00,101,99,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (32,'欧尼为士大夫','家地产',90.00,19,1,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (33,'九九九','说得很好',10.00,100,9,'common/img/default.jpg');
INSERT INTO `bs_book` (`id`, `title`, `author`, `price`, `sales`, `stock`, `imgPath`) VALUES (34,'大萨达','问问',1.00,111,12,'common/img/default.jpg');
/*!40000 ALTER TABLE `bs_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_order`
--

DROP TABLE IF EXISTS `bs_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_order` (
  `id` char(30) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `cost` double(11,2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`uid`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`uid`) REFERENCES `bs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_order`
--

LOCK TABLES `bs_order` WRITE;
/*!40000 ALTER TABLE `bs_order` DISABLE KEYS */;
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15846923822291',1,71.50,2,'2020-03-20 16:19:42');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15846927135011',1,71.50,0,'2020-03-20 16:25:14');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15846927765381',1,33.80,2,'2020-03-20 16:26:17');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15846933125051',1,39.10,1,'2020-03-20 16:35:13');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15847139051761',1,29.50,0,'2020-03-20 22:18:25');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15847139884451',1,60.90,0,'2020-03-20 22:19:48');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15847171507241',1,22.20,0,'2020-03-20 23:12:31');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15847197524631',1,39.90,0,'2020-03-20 23:55:52');
INSERT INTO `bs_order` (`id`, `uid`, `cost`, `status`, `createTime`) VALUES ('15847200151391',1,29.00,0,'2020-03-21 00:00:15');
/*!40000 ALTER TABLE `bs_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_order_item`
--

DROP TABLE IF EXISTS `bs_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` char(30) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `totalPrice` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_oid` (`oid`),
  CONSTRAINT `fk_oid` FOREIGN KEY (`oid`) REFERENCES `bs_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_order_item`
--

LOCK TABLES `bs_order_item` WRITE;
/*!40000 ALTER TABLE `bs_order_item` DISABLE KEYS */;
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (1,'15846923822291','扶桑','严歌苓',19.80,1,19.80);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (2,'15846923822291','给孩子的诗','北岛',22.20,1,22.20);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (3,'15846923822291','百年孤独','马尔克斯',29.50,1,29.50);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (4,'15846927135011','扶桑','严歌苓',19.80,1,19.80);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (5,'15846927135011','给孩子的诗','北岛',22.20,1,22.20);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (6,'15846927135011','百年孤独','马尔克斯',29.50,1,29.50);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (7,'15846927765381','扶桑','严歌苓',19.80,1,19.80);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (8,'15846927765381','悟空传','今何在',14.00,1,14.00);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (9,'15846933125051','扶桑','严歌苓',19.80,1,19.80);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (10,'15846933125051','??','???',19.30,1,19.30);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (11,'15847139051761','百年孤独','马尔克斯',29.50,1,29.50);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (12,'15847139884451','为奴十二年','所罗门',16.50,1,16.50);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (13,'15847139884451','给孩子的诗','北岛',22.20,2,44.40);
INSERT INTO `bs_order_item` (`id`, `oid`, `title`, `author`, `price`, `count`, `totalPrice`) VALUES (14,'15847197524631','从晚清到民国','唐德刚',39.90,1,39.90);
/*!40000 ALTER TABLE `bs_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bs_user`
--

DROP TABLE IF EXISTS `bs_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bs_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bs_user`
--

LOCK TABLES `bs_user` WRITE;
/*!40000 ALTER TABLE `bs_user` DISABLE KEYS */;
INSERT INTO `bs_user` (`id`, `username`, `password`, `email`) VALUES (1,'admin','123456','admin@163.com');
INSERT INTO `bs_user` (`id`, `username`, `password`, `email`) VALUES (2,'1231','111222','111@163.com');
INSERT INTO `bs_user` (`id`, `username`, `password`, `email`) VALUES (4,'','','');
INSERT INTO `bs_user` (`id`, `username`, `password`, `email`) VALUES (5,'1','1','');
INSERT INTO `bs_user` (`id`, `username`, `password`, `email`) VALUES (6,'123123','111222','111@163.com');
INSERT INTO `bs_user` (`id`, `username`, `password`, `email`) VALUES (7,'fasefa','111333','111@136.com');
/*!40000 ALTER TABLE `bs_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-21 15:46:35
