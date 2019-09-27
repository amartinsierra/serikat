-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema viajes
--

CREATE DATABASE IF NOT EXISTS viajes;
USE viajes;

--
-- Definition of table `hoteles`
--

DROP TABLE IF EXISTS `hoteles`;
CREATE TABLE `hoteles` (
  `idHotel` int(10) unsigned NOT NULL default '0',
  `nombre` varchar(45) NOT NULL,
  `categoria` int(10) unsigned NOT NULL,
  `precio` double NOT NULL,
  `disponible` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY  (`idHotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hoteles`
--

/*!40000 ALTER TABLE `hoteles` DISABLE KEYS */;
INSERT INTO `hoteles` (`idHotel`,`nombre`,`categoria`,`precio`,`disponible`) VALUES 
 (1,'Norte',3,120,1),
 (2,'Ritz',5,400,1),
 (3,'Estrella sur',4,190,0),
 (4,'Meridian',4,210,1);
/*!40000 ALTER TABLE `hoteles` ENABLE KEYS */;


--
-- Definition of table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
CREATE TABLE `reservas` (
  `idreserva` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `hotel` int(10) unsigned NOT NULL,
  `vuelo` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`idreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservas`
--

/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;


--
-- Definition of table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
CREATE TABLE `vuelos` (
  `idvuelo` int(10) unsigned NOT NULL default '0',
  `company` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `plazas` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`idvuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vuelos`
--

/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` (`idvuelo`,`company`,`fecha`,`precio`,`plazas`) VALUES 
 (1,'Iberia','10-12-2017',200,10),
 (2,'Air Europa','11-12-2027',170,6);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
