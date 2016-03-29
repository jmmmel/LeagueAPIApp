-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: leagueapi
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `followedSummoner` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `favId` (`followedSummoner`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,1,'celtavic'),(2,1,'souzin'),(3,1,'parrsifal');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `summonerName` varchar(45) NOT NULL,
  `kills` int(11) NOT NULL,
  `deaths` int(11) NOT NULL,
  `assists` int(11) NOT NULL,
  `creepScore` int(11) NOT NULL,
  `gold` int(11) NOT NULL,
  `createdTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics`
--

LOCK TABLES `statistics` WRITE;
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
INSERT INTO `statistics` VALUES (81,'OperativeQ',8,1,4,20,8579,'2016-03-29 11:11:58'),(82,'OperativeQ',3,4,14,7,8299,'2016-03-29 11:11:58'),(83,'OperativeQ',7,6,13,92,9050,'2016-03-29 11:11:58'),(84,'OperativeQ',18,4,13,81,11880,'2016-03-29 11:11:58'),(85,'OperativeQ',30,3,5,86,13327,'2016-03-29 11:11:58'),(86,'OperativeQ',6,8,10,157,11905,'2016-03-29 11:11:58'),(87,'OperativeQ',19,13,8,80,16004,'2016-03-29 11:11:58'),(88,'OperativeQ',23,14,11,127,19711,'2016-03-29 11:11:58'),(89,'OperativeQ',10,1,3,122,9353,'2016-03-29 11:11:58'),(90,'OperativeQ',3,0,21,9,9133,'2016-03-29 11:11:58'),(91,'celtavic',10,6,19,36,10931,'2016-03-29 11:11:59'),(92,'celtavic',14,4,10,70,9503,'2016-03-29 11:11:59'),(93,'celtavic',19,1,12,17,8695,'2016-03-29 11:11:59'),(94,'celtavic',10,1,9,81,8141,'2016-03-29 11:11:59'),(95,'celtavic',12,1,6,45,8582,'2016-03-29 11:11:59'),(96,'celtavic',10,8,14,36,10954,'2016-03-29 11:11:59'),(97,'celtavic',21,3,11,42,12398,'2016-03-29 11:11:59'),(98,'celtavic',11,12,14,39,11809,'2016-03-29 11:11:59'),(99,'celtavic',11,2,5,97,10781,'2016-03-29 11:11:59'),(100,'celtavic',10,1,8,46,8407,'2016-03-29 11:11:59'),(101,'souzin',16,7,13,124,15919,'2016-03-29 11:11:59'),(102,'souzin',11,1,15,47,8484,'2016-03-29 11:11:59'),(103,'souzin',14,2,18,66,9414,'2016-03-29 11:11:59'),(104,'souzin',8,1,16,39,8159,'2016-03-29 11:11:59'),(105,'souzin',6,0,16,32,7680,'2016-03-29 11:11:59'),(106,'souzin',14,5,6,154,14610,'2016-03-29 11:11:59'),(107,'souzin',8,6,18,41,10536,'2016-03-29 11:11:59'),(108,'souzin',9,8,16,87,12645,'2016-03-29 11:11:59'),(109,'souzin',15,2,9,67,10324,'2016-03-29 11:11:59'),(110,'souzin',5,2,15,50,8465,'2016-03-29 11:11:59'),(111,'parrsifal',4,7,14,117,10603,'2016-03-29 11:11:59'),(112,'parrsifal',6,6,12,117,10834,'2016-03-29 11:11:59'),(113,'parrsifal',7,3,14,99,10201,'2016-03-29 11:11:59'),(114,'parrsifal',14,10,12,108,13929,'2016-03-29 11:11:59'),(115,'parrsifal',7,2,13,56,8363,'2016-03-29 11:11:59'),(116,'parrsifal',6,3,7,46,7275,'2016-03-29 11:11:59'),(117,'parrsifal',14,3,19,73,12437,'2016-03-29 11:11:59'),(118,'parrsifal',5,0,10,47,6662,'2016-03-29 11:11:59'),(119,'parrsifal',13,4,11,83,10354,'2016-03-29 11:11:59'),(120,'parrsifal',14,2,8,76,10464,'2016-03-29 11:11:59');
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `summonerName` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'James','7c6a180b36896a0a8c02787eeafb0e4c','OperativeQ');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-29 11:14:08
