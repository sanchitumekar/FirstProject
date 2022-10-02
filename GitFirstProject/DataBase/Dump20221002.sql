CREATE DATABASE  IF NOT EXISTS `mcq` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mcq`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: mcq
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `q_no` int NOT NULL AUTO_INCREMENT,
  `quest` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `answer` int NOT NULL,
  `marks` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`q_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Who developed Java Programming language?','James Gosling','James Lock','James Gator','James Rich',1,0),(2,'In which year Java was developed?','1991','1995','1996','1997',2,0),(3,'What is datatype of value 20.5?','int','String','byte','float',4,0),(4,'Which of the following are Object Oriented Programming pillars?','Inheritance','Encpasulation','Polymorphism','All of above',4,0),(5,'Which of the following is a non-primitive datatype in Java?','long','String','float','double',2,0),(6,'Which of the following is a primitive datatype in Java?','int','byte','boolean','All of above',4,0),(7,'Which of the following type of inheritance is not implemented in Java?','Single Inheritance','Multiple Inheritance','Multi-level Inheritance','Hierarchical Inheritance',2,0),(8,'Which of the following are keywords in Java?','if','else','class','All of above',4,0),(9,'Which of the following provides data security in Java?','Methods','Encpasulation','Classes','Datatypes',2,0),(10,'What kind of methods can a interface have in it in Java?','Argumented Methods','No-Arg Methods','Abstract Methods','None of Above',3,0);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score_table`
--

DROP TABLE IF EXISTS `score_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score_table` (
  `s_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score_table`
--

LOCK TABLES `score_table` WRITE;
/*!40000 ALTER TABLE `score_table` DISABLE KEYS */;
INSERT INTO `score_table` VALUES (1,'sanchit',10),(2,'rucha',2),(3,'rucha',10);
/*!40000 ALTER TABLE `score_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-02 20:21:03
