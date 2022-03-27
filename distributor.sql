-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 27, 2022 at 09:25 AM
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
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `d_stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`id`, `name`, `country`, `artist`, `title`, `d_stock`) VALUES
(1, 'Prime', 'UK', 'Joel Mull', 'Archipelago', 5),
(2, 'Prime', 'UK', 'Joel Mull', 'Sun Set', 5),
(3, 'Prime', 'UK', 'Dave Angel', 'Excursions', 3),
(4, 'Prime', 'UK', 'Chris Liebing', 'Analogon', 6),
(5, 'Prime', 'UK', 'Henrik B', 'Stuntman', 8),
(6, 'NEWS', 'Belgium', 'Aphex Twin', 'Selected Ambient Works 85-92', 3),
(7, 'Triplevision', 'Netherlands', 'Adam Beyer', 'London', 10),
(8, 'Triplevision', 'Netherlands', 'Adam Beyer', 'Take Me Away', 2),
(9, 'Triplevision', 'Netherlands', 'Tiger Stripes', 'Body Shake', 0),
(10, 'Triplevision', 'Netherlands', 'Sam Paganini', 'Cobra EP', 2),
(11, 'Kompakt', 'Germany', 'Oxia', 'Speicher 34', 4),
(12, 'Kompakt', 'Germany', 'Jürgen Paape', 'Speicher 47', 0),
(13, 'Triplevision', 'Netherlands', 'Jeff Mills', 'Kat Moda', 5),
(14, 'Triplevision', 'Netherlands', 'Plastikman', 'Nostalgik.3', 2),
(15, 'NEWS', 'Belgium', 'Amelie Lens', 'Little Robot', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
