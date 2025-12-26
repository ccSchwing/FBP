CREATE DATABASE IF NOT EXISTS `FBP`;
USE `FBP`;
--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `displayName` varchar(45) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `emailAddress` varchar(45) DEFAULT NULL,
  `hashedPassword` varchar(255) DEFAULT NULL,
  `accountCreated` datetime DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT '0',
  `paidUser` tinyint(1) DEFAULT '0',
  `lastPaymentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`displayName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;