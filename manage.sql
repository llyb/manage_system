-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: manage
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `manage`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `manage` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `manage`;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `goods_number` int NOT NULL,
  `goods_name` varchar(20) NOT NULL,
  `goods_num` int NOT NULL,
  `in_storage` int NOT NULL,
  PRIMARY KEY (`goods_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'可乐',5,2),(2,'薯片',10,1);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `in_table`
--

DROP TABLE IF EXISTS `in_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `in_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_number` int NOT NULL,
  `storage_id` int NOT NULL,
  `time` datetime NOT NULL,
  `user_id` int NOT NULL,
  `info` varchar(5) NOT NULL DEFAULT (_utf8mb4'入库'),
  `good_num` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `in_table`
--

LOCK TABLES `in_table` WRITE;
/*!40000 ALTER TABLE `in_table` DISABLE KEYS */;
INSERT INTO `in_table` VALUES (27,1,2,'2023-05-26 10:34:47',1,'入库',5),(28,2,1,'2023-05-26 10:35:20',1,'入库',10),(29,1,2,'2023-05-26 10:44:46',1,'入库',5),(30,2,1,'2023-05-26 10:45:11',1,'入库',10);
/*!40000 ALTER TABLE `in_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `out_table`
--

DROP TABLE IF EXISTS `out_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goods_number` int NOT NULL,
  `storage_id` int NOT NULL,
  `time` date NOT NULL,
  `user_id` int NOT NULL,
  `info` varchar(5) DEFAULT (_utf8mb4'出库'),
  `good_num` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_table`
--

LOCK TABLES `out_table` WRITE;
/*!40000 ALTER TABLE `out_table` DISABLE KEYS */;
INSERT INTO `out_table` VALUES (8,1,2,'2023-05-26',1,'出库',5);
/*!40000 ALTER TABLE `out_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage` (
  `s_id` int NOT NULL,
  `s_volume` int DEFAULT NULL,
  `s_type` varchar(30) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,30,'水果仓库'),(2,90,'零食仓库'),(3,150,'货物仓库'),(4,200,'闲置仓库');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `permission` varchar(20) NOT NULL COMMENT '当前用户的权限',
  `user_info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lyb','$2a$10$ONaLnUhditGQviDTAEDRa.UAg2UMRIr7hNU0w37k1vvaqPTo6AgtO','老板','我是老板'),(2,'liyb','$2a$10$ZP4aPBHUHlneQHxKH93Wp.fKHNk0IsSqbqBf56yCH3b0wWEdZfDge','员工','今天很开心'),(4,'aaa','$2a$10$BpKqixXArMmrFAVz23ayIeimfyl0yqXcHrpbdJ90RgKhgKhy0hbiy','员工','不知道');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26 22:23:35
