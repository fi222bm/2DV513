-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 27, 2022 at 09:26 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

CREATE TABLE `record` (
  `id` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `year` int(10) NOT NULL,
  `s_stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`id`, `label`, `artist`, `title`, `year`, `s_stock`) VALUES
(1, 'Inside', 'Joel Mull', 'Archipelago', 1998, 2),
(2, 'Inside', 'Joel Mull', 'Sun Set', 1999, 0),
(3, 'Jericho', 'Dave Angel', 'Excursions', 1998, 4),
(4, 'CLR', 'Chris Liebing', 'Analogon', 2000, 4),
(5, 'Corb', 'Henrik B', 'Stuntman', 2000, 0),
(6, 'Apollo', 'Aphex Twin', 'Selected Ambient Works 85-92', 1992, 3),
(7, 'Drumcode', 'Adam Beyer', 'London', 2009, 0),
(8, 'Truesoul', 'Adam Beyer', 'Take Me Away', 2013, 3),
(9, 'TrueSoul', 'Tiger Stripes', 'Body Shake', 2016, 5),
(10, 'Plus 8', 'Sam Paganini', 'Cobra', 2011, 0),
(11, 'Kompakt Extra', 'Oxia', 'Speicher 34', 2006, 0),
(12, 'Kompakt Extra', 'Jürgen Paape', 'Speicher 47', 2007, 0),
(13, 'Purpose Maker', 'Jeff Mills', 'Kat Moda', 1997, 0),
(14, 'M_nus', 'Plastikman', 'Nostalgik.3', 2007, 2),
(15, 'Lenske', 'Amelie Lens', 'Little Robot', 2019, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
