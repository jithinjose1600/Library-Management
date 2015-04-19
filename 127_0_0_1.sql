-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2015 at 05:32 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library`
--
CREATE DATABASE IF NOT EXISTS `library` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `library`;

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE IF NOT EXISTS `bookings` (
  `userid` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `bookid` varchar(10) NOT NULL,
  `booktitle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `bookid` varchar(10) NOT NULL,
  `booktitle` varchar(50) NOT NULL,
  `author` varchar(30) NOT NULL,
  `category` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `availableno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookid`, `booktitle`, `author`, `category`, `description`, `quantity`, `availableno`) VALUES
('B1542', 'Harry Potter', 'J K Rowling', 'Fantasy', 'Story about a magical world', 7, 7),
('B1745', 'Two States', 'Chetan Baghath', 'Romance', 'A love story between two people from different states.', 12, 12),
('B1901', 'Twilight', 'Stephenie Meyer', 'Romance', 'Love stoey between a human and a vampire', 5, 4),
('B1967', 'Dracula', 'Bram Stoker', 'Horror', 'Story of the Vampire, Count Dracula', 10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `records`
--

CREATE TABLE IF NOT EXISTS `records` (
  `userid` varchar(10) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `bookid` varchar(10) NOT NULL,
  `booktitle` varchar(30) NOT NULL,
  `issuedate` date NOT NULL,
  `returndate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `records`
--

INSERT INTO `records` (`userid`, `firstname`, `lastname`, `bookid`, `booktitle`, `issuedate`, `returndate`) VALUES
('M1326', 'jithin', 'jose', 'B1745', 'Two States', '2015-04-18', '2015-04-18'),
('M1326', 'jithin', 'jose', 'B1745', 'Two States', '2015-04-18', '2015-04-18'),
('M1326', 'jithin', 'jose', 'B1745', 'Two States', '2015-04-18', '2015-04-18'),
('M1326', 'jithin', 'jose', 'B1745', 'Two States', '2015-04-18', '2015-04-18'),
('M1474', 'jithz', 'jose', 'B1901', 'Twilight', '2015-04-10', 'not returned');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` varchar(10) NOT NULL,
  `fname` varchar(25) NOT NULL,
  `lname` varchar(25) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fname`, `lname`, `address`, `phone`, `email`, `password`) VALUES
('M1054', 'Biby', 'zsgtrd', 'Sarnia', '376452123', 'bibymichael@gmail.com', 'biby'),
('M1326', 'jithin', 'jose', 'sarnia', '5193124570', 'jithinjose1600@gmail.com', 'jithin'),
('M1474', 'jithz', 'jose', 'toronto', '5193124570', 'jithz@gmail.com', 'jithz'),
('M1551', 'Tony', 'Thomas', 'India', '9995334411', 'tony@gmail.com', 'tony'),
('M1577', 'Arun', 'Sebastian', 'London', '2265431871', 'arun@gmail.com', 'arun'),
('M1613', 'Albin', 'Francis', 'India', '9847534157', 'albin@gmail.com', 'albin'),
('M1634', 'sreejith', 'unnikrishnan', 'toronto', '9976487790', 'sreejith@gmail.com', 'sreejith');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
 ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
