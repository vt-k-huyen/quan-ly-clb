CREATE DATABASE  IF NOT EXISTS `quantri_clb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `quantri_clb`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: quantri_clb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcements`
--

DROP TABLE IF EXISTS `announcements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `announcements` (
  `announcement_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  `club_id` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `create_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `notes` text COLLATE utf8_bin,
  PRIMARY KEY (`announcement_id`),
  KEY `fk_announcements_clubs` (`club_id`),
  CONSTRAINT `fk_announcements_clubs` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcements`
--

LOCK TABLES `announcements` WRITE;
/*!40000 ALTER TABLE `announcements` DISABLE KEYS */;
INSERT INTO `announcements` VALUES (1,'Thông báo 1','fsdsdff','HTSV','2023-05-29 17:00:00','admin','no'),(2,'Thông báo 2','Thông báo 2','HM',NULL,NULL,NULL),(3,'Thông báo 3','Thông báo 3','GT',NULL,NULL,NULL),(5,'dfdsf','wqew','HTSV','2023-08-04 03:12:55','HUYEN','qe'),(6,'fghjk','wqew','HM','2023-08-04 03:13:00','HUYEN','qe'),(7,'thongbáo','huyen','HM','2023-08-04 13:50:19','HUYEN','no'),(8,'Thông Báo 5','Thông báo 5','HTSV','2023-08-04 14:05:03','HUYEN','12132'),(9,'TB','21362','HM','2023-08-07 17:03:03','HUYEN','bnm'),(11,'qw','dss','HTSV','2023-08-07 17:08:04','HUYEN',''),(12,'dsmm','','HTSV','2023-08-07 17:19:32','HUYEN','');
/*!40000 ALTER TABLE `announcements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clubs`
--

DROP TABLE IF EXISTS `clubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clubs` (
  `club_id` varchar(30) COLLATE utf8_bin NOT NULL,
  `club_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` text COLLATE utf8_bin,
  `create_date` timestamp NULL DEFAULT NULL,
  `dissolution_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubs`
--

LOCK TABLES `clubs` WRITE;
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
INSERT INTO `clubs` VALUES ('BC','CLB Bóng chuyền','Câu lạc bộ  Bóng chuyền','2023-08-17 09:14:34',NULL),('BR','CLB Bóng rổ','Câu lạc bộ  Bóng rỗ','2023-08-17 08:58:31',NULL),('GT','Câu lạc bộ Ghita','Câu lạc bộ ghi-ta','2019-08-08 17:00:00',NULL),('HM','CLB Hiến máu','Câu lạc bộ hiến máu','2019-08-08 17:00:00',NULL),('HTSV','CLB Hỗ trợ sinh viên','Câu lạc bộ hỗ trợ sinh viên','2019-03-01 17:00:00',NULL);
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `events` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `from_date` timestamp NULL DEFAULT NULL,
  `to_date` timestamp NULL DEFAULT NULL,
  `detail` text COLLATE utf8_bin,
  `club_id` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `notes` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `fk_events_clubs` (`club_id`),
  CONSTRAINT `fk_events_clubs` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Hỗ trợ sinh viên 1','2023-07-16 00:00:00','2023-07-16 10:30:00','Hội trường','HTSV',NULL),(2,'Hỗ trợ sinh viên 2','2020-03-20 00:00:00','2020-03-21 10:00:00',NULL,'HTSV',NULL),(3,'Hoạt động 1','2020-04-20 00:00:00','2020-04-21 10:00:00',NULL,'GT',NULL),(4,'Bóng chuyền 1','2020-03-20 10:00:00','2020-03-20 12:00:00','Sân bóng','BC',NULL),(5,'Hiến máu 1','2021-03-20 00:00:00','2021-03-21 10:00:00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_status`
--

DROP TABLE IF EXISTS `member_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `member_status` (
  `status` int(11) NOT NULL,
  `description` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_status`
--

LOCK TABLES `member_status` WRITE;
/*!40000 ALTER TABLE `member_status` DISABLE KEYS */;
INSERT INTO `member_status` VALUES (0,'Đang chờ duyệt'),(1,'Đã duyệt'),(2,'Cựu thành viên');
/*!40000 ALTER TABLE `member_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `members` (
  `member_id` varchar(30) COLLATE utf8_bin NOT NULL,
  `first_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `notes` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES ('20T1020411','Võ Thị Khánh','Huyền','2002-10-05','huyen@gmail.com','Huế',NULL,'0979674741',NULL),('20T1020942','Nguyễn Văn','An','2002-01-06','vanan237@gmail.com','Đà Nẵng',NULL,'0979574618',NULL),('20T1024726','Lê Thị','Hiền','2002-06-03','lehien123@gmail.com','TT Huế',NULL,'0917055395',NULL),('20T8278212','Minh','Thư','2002-03-13','khanh13@gmail.com','TT Huế',NULL,'0927821922',NULL),('20T8290011','Minh','Nam','2000-02-12','ad123@gmail.com','ĐN',NULL,'0281818881',NULL),('admin1','Khánh','Huyền','2002-05-10','beo132@gmail.com','Huế',NULL,'0272678812',NULL);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members_events`
--

DROP TABLE IF EXISTS `members_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `members_events` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_id` bigint(20) NOT NULL,
  `member_id` varchar(30) COLLATE utf8_bin NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_members_events_events_idx` (`event_id`),
  KEY `fk_events_members_members` (`member_id`),
  CONSTRAINT `fk_events_members_members` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`),
  CONSTRAINT `fk_members_events_events` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members_events`
--

LOCK TABLES `members_events` WRITE;
/*!40000 ALTER TABLE `members_events` DISABLE KEYS */;
INSERT INTO `members_events` VALUES (1,1,'20T1020411',1),(2,2,'20T8278212',0),(4,1,'20T1020942',1),(5,1,'20T8290011',1),(6,2,'20T1020411',1);
/*!40000 ALTER TABLE `members_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messanges`
--

DROP TABLE IF EXISTS `messanges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `messanges` (
  `messange_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` text COLLATE utf8_bin,
  `member_id` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL,
  `receive_time` timestamp NULL DEFAULT NULL,
  `member_send` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`messange_id`),
  KEY `fk_message_members` (`member_id`),
  CONSTRAINT `fk_message_members` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messanges`
--

LOCK TABLES `messanges` WRITE;
/*!40000 ALTER TABLE `messanges` DISABLE KEYS */;
/*!40000 ALTER TABLE `messanges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests_list`
--

DROP TABLE IF EXISTS `requests_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requests_list` (
  `request_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `club_id` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `member_id` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `request_time` timestamp NULL DEFAULT NULL,
  `accept_time` timestamp NULL DEFAULT NULL,
  `finish_time` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`request_id`),
  KEY `fk_requests_list_members` (`member_id`),
  KEY `fk_requests_list_clubs` (`club_id`),
  KEY `fk_requests_list_member_status` (`status`),
  CONSTRAINT `fk_requests_list_clubs` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`club_id`),
  CONSTRAINT `fk_requests_list_member_status` FOREIGN KEY (`status`) REFERENCES `member_status` (`status`),
  CONSTRAINT `fk_requests_list_members` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests_list`
--

LOCK TABLES `requests_list` WRITE;
/*!40000 ALTER TABLE `requests_list` DISABLE KEYS */;
INSERT INTO `requests_list` VALUES (1,'HM','20T1020411','2023-08-10 12:59:10','2023-08-11 09:32:38','2023-08-11 12:59:10',2),(4,'GT','20T1024726','2023-08-10 12:59:10','2023-08-11 09:32:38','2023-08-11 09:53:35',1),(5,'HM','20T8278212','2023-08-10 12:59:10','2023-08-11 09:32:38',NULL,1),(6,'HM','20T8290011','2023-08-10 17:00:00','2023-08-11 09:32:11',NULL,1),(7,'GT','20T8290011','2023-08-10 17:00:00','2023-08-11 09:32:38',NULL,1),(9,'HTSV','20T8290011','2023-08-10 17:00:00','2023-08-11 09:44:44',NULL,1),(10,'HTSV','20T1020411','2023-08-13 10:38:26','2023-08-13 15:54:05',NULL,1),(11,'HTSV','20T1020942','2023-08-13 10:40:26',NULL,NULL,1),(12,'HTSV','20T8278212','2023-08-17 03:15:03',NULL,NULL,0);
/*!40000 ALTER TABLE `requests_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_account`
--

DROP TABLE IF EXISTS `role_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_account` (
  `id` varchar(30) COLLATE utf8_bin NOT NULL,
  `role_name` varchar(70) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_account`
--

LOCK TABLES `role_account` WRITE;
/*!40000 ALTER TABLE `role_account` DISABLE KEYS */;
INSERT INTO `role_account` VALUES ('ADMIN','ADMIN'),('USER','USER');
/*!40000 ALTER TABLE `role_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_account` (
  `user_id` varchar(30) NOT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `role_id` varchar(30) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `modify_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('20T1020411','huyen','huyen@gmail.com','123',1,'USER',NULL,NULL),('20T1020942','AN','vanan237@gmail.com','123',1,'USER',NULL,NULL),('20T1024726','hien','lehien123@gmail.com','123',1,'USER',NULL,NULL),('20T8278212','khanh','khanh13@gmail.com','123',1,'USER',NULL,NULL),('20T8290011','khanh huyen','ad123@gmail.com','123',1,'USER',NULL,NULL),('admin1','ADMIN','beo132@gmail.com','2344',1,'ADMIN',NULL,NULL);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-18  0:50:26
