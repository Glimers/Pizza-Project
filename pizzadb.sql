CREATE DATABASE  IF NOT EXISTS `pizzadb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pizzadb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzadb
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `crusttypes`
--

DROP TABLE IF EXISTS `crusttypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crusttypes` (
  `crustTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`crustTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crusttypes`
--

LOCK TABLES `crusttypes` WRITE;
/*!40000 ALTER TABLE `crusttypes` DISABLE KEYS */;
INSERT INTO `crusttypes` VALUES (1,'Thin Crust',0),(2,'Handmade Pan',0),(3,'Original',0),(4,'Gluten',2),(5,'Chicago Style',1.5);
/*!40000 ALTER TABLE `crusttypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `houseNumber` int(11) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `province` varchar(2) DEFAULT NULL,
  `postalCode` varchar(7) DEFAULT NULL,
  `delivery` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (70,'e','e','e','e',1,'e','NB','e',1),(71,'e','e','e','e',1,'e','NB','e',1),(72,'e','e','e','e',1,'e','NB','e3b 3s4',1),(73,'1','1','1','1',1,'1','NB','1',1),(74,'e','e','e','e',1,'e','NB','e7g 2k1',1),(75,'e','e','e','e',1,'e','NB','e3b 3s4',0),(76,'e','ee','e','e@e.e',12,'e','NB','e3b 3s4',0),(77,'e','e','e','e',1,'e','NB','e',0),(78,'e','e','e','e',1,'e','NB','e',0),(79,'e','e','e','e',1,'e','NB','e',0),(80,'q','q','q','q',1,'w','NB','w',0),(81,'q','q','q','q',1,'qwe','NB','q1q 1q1',1),(82,'q','q','q','q',1,'qwe','NB','q1q 1q1',1),(83,'q','q','q','q',1,'qwe','NB','q1q 1q1',1),(84,'q','q','q','q',1,'qwe','NB','q1q 1q1',1),(85,'q','q','q','q',1,'qwe','NB','q1q 1q1',1),(86,'3','e','e','e',1,'e','NB','e',0),(87,'e','e','e','e',1,'e','NB','e',0),(88,'e','e','e','e',1,'e','NB','e3b 3s4',0),(89,'e','e','e','e',1,'e','NB','e3b 3s4',0),(90,'e','e','e','e',1,'e','NB','e3b 3s4',0),(91,'e','e','e','e',1,'e','NB','e',0),(92,'e','e','e','e',1,'e','NB','e',0),(93,'e','e','e','e',1,'e','NB','e',0),(94,'','','','',0,'',NULL,'',0),(95,'ew','ewq','ewqe','ew',2,'',NULL,'',1),(96,'','','','',0,'',NULL,'',1),(97,'ew','ew','ew','ew',12,'e','NB','we',1),(98,'ew','ew','ew','ew',12,'e','NB','we',1),(99,'e','e','e','e',1,'e','NB','e',0),(100,'e','e','e','e',1,'','NB','e',0),(101,'e','e','e','e',1,'','NB','e',1),(102,'','','','',0,'',NULL,'',0),(103,'e','e','(506)236-2323','ew',0,'',NULL,'',0),(104,'e','e','(506)236-2323','ew',0,'',NULL,'',0),(105,'e','e','(506)236-2323','ew',0,'',NULL,'',0),(106,'e','e','(506)236-2323','ew',0,'',NULL,'',0),(107,'e','e','e','e',0,'',NULL,'',0),(108,'e','e','e','e',0,'',NULL,'',0),(109,'e','e','e','e',0,'',NULL,'',0),(110,'e','e','e','e',0,'',NULL,'',0),(111,'e','e','e','e',0,'',NULL,'',0),(112,'e','e','e','e',0,'',NULL,'',0),(113,'e','e','e','e',0,'',NULL,'',0),(114,'e','e','e','e',0,'',NULL,'',0),(115,'e','e','e','e',0,'',NULL,'',0),(116,'e','e','e','e',0,'',NULL,'',0),(117,'e','e','e','e',0,'',NULL,'',0),(118,'e','ee','e','e',0,'',NULL,'',0),(119,'e','e','e','e',0,'',NULL,'',0),(120,'e','e','e','e',0,'',NULL,'',0),(121,'e','e','e','e',0,'',NULL,'',0),(122,'e','e','e','e',0,'',NULL,'',0),(123,'e','e','e','e',0,'',NULL,'',0),(124,'e','e','e','e',0,'',NULL,'',0),(125,'e','e','e','e',1,'e','NB','e3b 3s4',0),(126,'e','e','e','e',1,'e','NB','e3b 3s4',0),(127,'e','e','e','e',1,'e','NB','e',0),(128,'e','e','e','e',1,'e','NB','e',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','12345');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `totalPrice` float NOT NULL DEFAULT '0',
  `deliveryDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `placedDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `customerId` int(11) NOT NULL,
  `orderStatus` varchar(45) NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`orderId`),
  KEY `customeridFK_idx` (`customerId`),
  CONSTRAINT `customeridFK` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (17,5.75,'2019-12-09 14:00:25','2019-12-09 13:30:25',75,'filled'),(18,8.0385,'2019-12-09 14:23:42','2019-12-09 13:53:42',76,'pending'),(19,111.389,'2019-12-09 14:37:58','2019-12-09 14:07:58',78,'pending'),(20,8.0385,'2019-12-09 14:47:39','2019-12-09 14:17:39',80,'pending'),(21,19.5385,'2019-12-09 15:10:00','2019-12-09 14:40:00',88,'pending'),(22,75.8655,'2019-12-09 16:11:18','2019-12-09 14:41:18',89,'filled'),(23,112.631,'2019-12-09 15:13:07','2019-12-09 14:43:07',90,'filled'),(24,5.75,'2019-12-09 15:16:41','2019-12-09 14:46:41',91,'filled'),(25,45.9425,'2019-12-09 15:48:42','2019-12-09 14:48:42',92,'filled'),(26,5.75,'2019-12-09 15:20:30','2019-12-09 14:50:30',93,'filled'),(27,5.75,'2019-12-10 08:54:25','2019-12-10 08:24:25',99,'filled'),(28,42.527,'2019-12-10 11:56:32','2019-12-10 11:26:32',123,'pending'),(29,115.472,'2019-12-10 16:09:16','2019-12-10 14:39:16',125,'pending'),(31,22.425,'2019-12-10 16:32:23','2019-12-10 16:02:23',128,'pending');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza` (
  `pizzaId` int(11) NOT NULL AUTO_INCREMENT,
  `sizeId` int(11) NOT NULL,
  `isFinished` tinyint(4) NOT NULL DEFAULT '0',
  `crustTypeId` int(11) NOT NULL,
  `price` float NOT NULL,
  `orderId` int(11) NOT NULL,
  `quantity` int(1) DEFAULT NULL,
  PRIMARY KEY (`pizzaId`),
  KEY `crusttypeFK_idx` (`crustTypeId`),
  KEY `sizeidFK_idx` (`sizeId`),
  KEY `orderidFK_idx` (`orderId`),
  CONSTRAINT `crusttypeFK` FOREIGN KEY (`crustTypeId`) REFERENCES `crusttypes` (`crustTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderidFK` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sizeidFK` FOREIGN KEY (`sizeId`) REFERENCES `sizes` (`sizeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (24,1,0,1,6.99,25,3),(25,3,0,2,18.98,25,1),(26,1,0,1,5,26,1),(27,1,0,1,5,27,1),(28,3,0,5,18.49,28,1),(29,3,0,5,18.49,28,1),(30,3,0,5,18.49,29,3),(31,3,0,5,22.47,29,2),(32,3,0,5,19.5,31,1);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_toppings_map`
--

DROP TABLE IF EXISTS `pizza_toppings_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_toppings_map` (
  `toppingId` int(11) NOT NULL,
  `pizzaId` int(11) NOT NULL,
  `pizza_toppings_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pizza_toppings_id`),
  KEY `pizzaidFK_idx` (`pizzaId`),
  KEY `toppingidFK` (`toppingId`),
  CONSTRAINT `pizzaidFK` FOREIGN KEY (`pizzaId`) REFERENCES `pizza` (`pizzaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `toppingidFK` FOREIGN KEY (`toppingId`) REFERENCES `toppings` (`toppingId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_toppings_map`
--

LOCK TABLES `pizza_toppings_map` WRITE;
/*!40000 ALTER TABLE `pizza_toppings_map` DISABLE KEYS */;
INSERT INTO `pizza_toppings_map` VALUES (12,32,38);
/*!40000 ALTER TABLE `pizza_toppings_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sizes` (
  `sizeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`sizeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (1,'Small',5),(2,'Medium',10),(3,'Large',15);
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toppings`
--

DROP TABLE IF EXISTS `toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toppings` (
  `toppingId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL DEFAULT '0',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `empAddedBy` int(11) NOT NULL,
  `isActive` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`toppingId`),
  KEY `employeeidFK_idx` (`empAddedBy`),
  CONSTRAINT `employeeidFK` FOREIGN KEY (`empAddedBy`) REFERENCES `employee` (`employeeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings`
--

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;
INSERT INTO `toppings` VALUES (5,'cheese',0,'2017-11-04 23:35:40',1,1),(6,'extra cheese',1.99,'2017-11-04 23:35:40',1,1),(7,'pepperoni',1.99,'2017-11-04 23:35:40',1,1),(8,'green peppers',1.99,'2017-11-04 23:35:40',1,1),(9,'bacon',2.5,'2019-12-06 13:10:45',1,1),(10,'ham',2.5,'2019-12-06 13:11:17',1,1),(12,'Salami',3,'2019-12-08 18:18:42',1,1),(13,'Brooklyn Pepperoni',2.75,'2019-12-08 18:20:22',1,1),(14,'Mushrooms',1.25,'2019-12-10 12:13:21',1,1),(15,'Chicken',3.75,'2019-12-10 12:14:12',1,0);
/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-10 18:54:22
