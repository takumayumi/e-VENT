-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2015 at 07:14 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `e-vent`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `mi` char(2) DEFAULT NULL,
  `bday` date NOT NULL,
  `gender` char(1) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone_no` varchar(50) DEFAULT NULL,
  `cell_no` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `client_id_UNIQUE` (`client_id`),
  UNIQUE KEY `cell_no_UNIQUE` (`cell_no`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2140010 ;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`client_id`, `lastname`, `firstname`, `mi`, `bday`, `gender`, `address`, `phone_no`, `cell_no`, `email`) VALUES
(2140001, 'Kazama', 'Jun', 'F', '1987-02-25', 'M', '130B, Roxas Street, Trancoville, Baguio City', '522-652-9878', '09275554832', 'kazama.party@gmail.com'),
(2140002, 'De Guzman', 'John Sebastian', 'H', '1985-07-12', 'M', '89, Salaan, Mangaldan, Pangasinan', '512-658-8889', '09156683231', 'sebastian.deguzman@gmail.com'),
(2140003, 'Aquino', 'John Vayne', 'S', '1990-10-10', 'M', '2B, Villanueva Building, Upper General Luna, Upper Bonifacio, Baguio City', '514-323-1567', '09165888972', 'jv_aquino@yahoo.com'),
(2140004, 'Gabay', 'Lovely', 'D', '1989-05-16', 'F', '23, Civilian Building, New Lucban, Baguio City', '522-513-5141', '09226556654', 'love_care@gmail.com'),
(2140005, 'Santos', 'Girly Hann', 'F', '1988-02-06', 'F', '165, Palua, Mangaldan, Pangasinan', '522-562-3108', '09156686241', 'girly.hann.santos@ymail.com'),
(2140006, 'De Vera', 'Nicole Anne', 'S', '1987-06-01', 'F', '94, Roxas Street, Trancoville, Baguio City', '522-513-7113', '09245679789', 'bieberfever@hotmail.com'),
(2140007, 'Abrogar', 'Shane Joy', 'E', '1991-07-30', 'F', 'ID34, KM5, La Trinidad, Benguet', '514-206-2139', '09125687815', 'shane.joy05@yahoo.com'),
(2140008, 'Catalan', 'Mark Dave', 'Q', '1983-11-15', 'M', '127, 2A, New Lucban, Baguio City', '512-512-2060', '09075565671', 'mdave_catalan_365@gmail.com'),
(2140009, 'Velasquez', 'Bobby', 'T', '1985-04-30', 'M', '32C, San Isidro Norte, Binmaley, Pangasinan', '532-936-1305', '09124564564', 'bobby_v@yahoo.com');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `occasion_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `venue` varchar(250) DEFAULT NULL,
  `details` varchar(360) DEFAULT NULL,
  `time_reg` time NOT NULL,
  `date_reg` date NOT NULL,
  `prof_fee` double DEFAULT '0',
  `profit` double DEFAULT '0',
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14009 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`event_id`, `occasion_id`, `client_id`, `date`, `start_time`, `end_time`, `venue`, `details`, `time_reg`, `date_reg`, `prof_fee`, `profit`) VALUES
(14000, 102, 214000, '2014-02-25', '10:50:00', '13:30:00', NULL, 'Client''s 17th bithday. He wants to make his birthday party as simple as ordinary birthday party.', '12:05:45', '2014-02-25', 2300, 3100),
(14001, 111, 214001, '2014-02-14', '19:30:00', '21:30:00', NULL, 'Dinner date with his girlfriend. Buy teddy bear, box of chocoloates, flowers, and necklace.', '11:56:21', '2014-02-14', 1500, 1800),
(14002, 112, 214002, '2014-05-16', '10:00:00', '16:00:00', NULL, 'Registration on church, reservation in otel & restau, buy gown, rental of outfits.', '12:24:03', '2014-05-16', 3500, 3300),
(14003, 107, 214003, '2014-03-30', '17:30:00', '19:30:00', NULL, 'Highschool graduation of client''s beloved sister.', '13:03:44', '2014-03-30', 1000, 2100),
(14004, 102, 214004, '2014-06-27', '10:30:00', '14:00:00', NULL, 'Client''s father''s 52nd birthday.', '14:27:29', '2014-06-27', 1100, 2600),
(14005, 103, 214005, '2014-03-21', '09:00:00', '13:30:00', NULL, 'Client''s daughter''s christening. Invitation, mugs, and others.', '13:15:30', '2014-03-21', 2100, 1500),
(14006, 109, 214006, '2014-04-10', '18:30:00', '20:00:00', NULL, 'Dinner date with their mom.', '11:53:48', '2014-04-10', 1600, 1000),
(14007, 101, 214007, '2014-05-23', '19:30:00', '21:00:00', NULL, '10th anniversary. Dinner with his wife. Buy expensive necklace and bouquet of white roses.', '12:48:20', '2014-05-23', 1900, 1350),
(14008, 102, 214008, '2014-06-03', '11:00:00', '14:00:00', NULL, '4th birthday of client''s son. Superman concept.', '13:41:01', '2014-06-03', 2050, 3050);

-- --------------------------------------------------------

--
-- Table structure for table `expense`
--

CREATE TABLE IF NOT EXISTS `expense` (
  `expense_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `item` varchar(250) NOT NULL DEFAULT 'Reservation w/ corporate package',
  `price` double NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`expense_id`),
  UNIQUE KEY `expense_id_UNIQUE` (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `occasion`
--

CREATE TABLE IF NOT EXISTS `occasion` (
  `occasion_id` int(11) NOT NULL AUTO_INCREMENT,
  `occasion_name` varchar(45) NOT NULL,
  PRIMARY KEY (`occasion_id`),
  UNIQUE KEY `occasion_id_UNIQUE` (`occasion_id`),
  UNIQUE KEY `occasion_name_UNIQUE` (`occasion_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=112 ;

--
-- Dumping data for table `occasion`
--

INSERT INTO `occasion` (`occasion_id`, `occasion_name`) VALUES
(101, 'Anniversary'),
(102, 'Birthday'),
(103, 'Christmas Party'),
(104, 'Debut'),
(105, 'Father''s Day'),
(106, 'Graduation'),
(107, 'Halloween Party'),
(108, 'Mother''s Day'),
(109, 'Random Occasion'),
(110, 'Valentine''s Day'),
(111, 'Wedding');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
