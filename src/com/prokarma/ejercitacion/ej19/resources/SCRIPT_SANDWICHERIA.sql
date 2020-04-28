-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-04-2020 a las 13:22:18
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `name` varchar(45) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingredient`
--

INSERT INTO `ingredient` (`name`, `id`) VALUES
('danbo', 1),
('cheddar', 2),
('cookedHam', 3),
('rawHam', 4),
('salami', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `number_ticket` int(11) NOT NULL,
  PRIMARY KEY (`number`),
  KEY `fk_order_number_ticket` (`number_ticket`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order_register_sandwich`
--

DROP TABLE IF EXISTS `order_register_sandwich`;
CREATE TABLE IF NOT EXISTS `order_register_sandwich` (
  `quantity` int(11) NOT NULL,
  `number_order` int(11) NOT NULL,
  `id_sandwich` int(11) NOT NULL,
  KEY `fk_number_order` (`number_order`),
  KEY `fk_id_sandwich` (`id_sandwich`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sandwich`
--

DROP TABLE IF EXISTS `sandwich`;
CREATE TABLE IF NOT EXISTS `sandwich` (
  `id_Sandwich` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id_Sandwich`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sandwich`
--

INSERT INTO `sandwich` (`id_Sandwich`, `stock`, `price`) VALUES
(1, 20, 200),
(2, 20, 170),
(3, 15, 150),
(4, 15, 130),
(5, 10, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sandwich_have_ingredient`
--

DROP TABLE IF EXISTS `sandwich_have_ingredient`;
CREATE TABLE IF NOT EXISTS `sandwich_have_ingredient` (
  `id_sandwich` int(11) NOT NULL,
  `id_ingredient` int(11) NOT NULL,
  KEY `fk_id_sandwich` (`id_sandwich`),
  KEY `fk_id_ingredient` (`id_ingredient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sandwich_have_ingredient`
--

INSERT INTO `sandwich_have_ingredient` (`id_sandwich`, `id_ingredient`) VALUES
(1, 2),
(1, 4),
(2, 2),
(2, 3),
(3, 1),
(3, 4),
(4, 1),
(4, 3),
(5, 1),
(5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `type_pay` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
