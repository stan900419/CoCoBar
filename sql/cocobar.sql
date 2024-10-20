CREATE DATABASE  IF NOT EXISTS `cocobar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cocobar`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: cocobar
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beer`
--

DROP TABLE IF EXISTS `beer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `corona` int DEFAULT NULL,
  `budweiser` int DEFAULT NULL,
  `heineken` int DEFAULT NULL,
  `skol` int DEFAULT NULL,
  `asahi` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beer`
--

LOCK TABLES `beer` WRITE;
/*!40000 ALTER TABLE `beer` DISABLE KEYS */;
INSERT INTO `beer` VALUES (1,1,1,1,1,1),(2,2,2,2,2,2),(3,1,0,0,0,1),(4,1,0,0,0,1),(5,2,2,2,2,2),(6,2,2,0,0,0),(7,3,0,0,0,0),(8,2,1,0,1,0),(9,1,0,1,0,1),(10,3,2,1,0,0),(11,1,5,1,1,1),(12,12,24,5,5,12),(13,1,0,0,0,0),(14,5,12,0,0,0),(15,2,2,0,0,0);
/*!40000 ALTER TABLE `beer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cocktail`
--

DROP TABLE IF EXISTS `cocktail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cocktail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `martini` int DEFAULT NULL,
  `tequilaSunShine` int DEFAULT NULL,
  `whiteRussian` int DEFAULT NULL,
  `magarita` int DEFAULT NULL,
  `mojito` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cocktail`
--

LOCK TABLES `cocktail` WRITE;
/*!40000 ALTER TABLE `cocktail` DISABLE KEYS */;
INSERT INTO `cocktail` VALUES (1,1,1,1,2,1),(2,1,0,0,0,1),(3,1,0,0,0,1),(4,2,2,2,2,2),(5,0,0,0,1,1),(6,0,0,2,0,0),(7,0,0,1,0,0),(8,0,1,0,1,0),(9,0,0,2,0,0),(10,0,0,0,0,1),(11,1,0,0,1,1),(12,0,0,0,0,0),(13,0,0,0,0,1),(14,0,0,0,0,2);
/*!40000 ALTER TABLE `cocktail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'Stanley Lee','stan','0419','stanlee@gmail.com'),(2,'Bow Chen','bow210','20010210','bowchen@gmail.com'),(3,'CoCo Liu','coco421','900421','cocoliu@gmail.com'),(4,'Kai','ken','1015','kai@gmail.com'),(5,'swer','sefrw','900421','sunny@gmail.com'),(6,'James','jms','00000','jms@gmail.com'),(7,'Kaboo','kbo','0913','kaboo@gmail.com'),(8,'Rebecca','rbca','123','rbca@gmail.com'),(9,'Cindy Lee','cindy810','0810','cindy@gmail.com'),(10,'Megan','mgn','0820','megan@gmail.com'),(12,'Luka','luk','0000','luk@yahoo.com.tw'),(13,'Cindy','angel147','880810','cdy@gmail.com'),(16,'Louis','louis','111','louis@yahoo.ocm'),(18,'Bow Z','Bowz0210','29524550','sunny210693@gmail.com');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `membername` varchar(45) DEFAULT NULL,
  `memberaccount` varchar(45) DEFAULT NULL,
  `beeramount` int DEFAULT NULL,
  `cocktailamount` int DEFAULT NULL,
  `softdrinkamount` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Stanley Lee','stan419',5,5,5,1650),(2,'Stanley Lee ','stan419',6,2,4,1850),(3,'Bow Chen','bow210',9,1,4,1936),(4,'CoCo Liu','coco421',58,3,2,9207),(5,'Stanley Lee ','stan419',1,0,1,264),(6,'CoCo Liu','coco421',17,1,1,2651),(7,'Bow Chen','bow210',4,2,3,1342);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `softdrink`
--

DROP TABLE IF EXISTS `softdrink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `softdrink` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cola` int DEFAULT NULL,
  `soda` int DEFAULT NULL,
  `mountainDew` int DEFAULT NULL,
  `blackTea` int DEFAULT NULL,
  `appleJuice` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `softdrink`
--

LOCK TABLES `softdrink` WRITE;
/*!40000 ALTER TABLE `softdrink` DISABLE KEYS */;
INSERT INTO `softdrink` VALUES (1,1,1,1,1,1),(2,1,0,0,0,1),(3,1,0,0,0,1),(4,2,2,2,2,2),(5,2,0,0,3,0),(6,0,1,1,0,0),(7,0,0,0,1,0),(8,1,2,0,0,0),(9,1,1,1,0,1),(10,2,0,0,2,0),(11,2,0,0,0,0),(12,0,1,0,0,0),(13,1,0,0,0,0),(14,0,0,0,3,0);
/*!40000 ALTER TABLE `softdrink` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-13  1:18:49
