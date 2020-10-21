# Host: localhost  (Version 5.7.26)
# Date: 2020-06-27 15:42:40
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "m_comment"
#

DROP TABLE IF EXISTS `m_comment`;
CREATE TABLE `m_comment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `times` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Data for table "m_comment"
#

/*!40000 ALTER TABLE `m_comment` DISABLE KEYS */;
INSERT INTO `m_comment` VALUES (1,'lu','12306',3,'30','感觉不错'),(2,'李','12345',3,'20','非常好'),(3,'王','999',2,'40','还行吧'),(4,'赵','121',1,'50','真差劲'),(5,'钱','11345',5,'10','真的很好'),(20,'路','120394',3,'16','很不错'),(21,'lu','1234',3,'12','不错');
/*!40000 ALTER TABLE `m_comment` ENABLE KEYS */;
