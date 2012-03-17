/*
SQLyog Ultimate v9.30 
MySQL - 5.5.16-log : Database - gestiondepacientes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gestiondepacientes` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `gestiondepacientes`;

/*Table structure for table `alergias` */

DROP TABLE IF EXISTS `alergias`;

CREATE TABLE `alergias` (
  `IdAlergia` int(11) NOT NULL AUTO_INCREMENT,
  `NombreAlergia` varchar(255) NOT NULL,
  PRIMARY KEY (`IdAlergia`),
  KEY `FK_Alergias` (`NombreAlergia`),
  CONSTRAINT `FK_Alergias` FOREIGN KEY (`NombreAlergia`) REFERENCES `pacientes` (`Alergias`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alergias` */

LOCK TABLES `alergias` WRITE;

UNLOCK TABLES;

/*Table structure for table `asistentes` */

DROP TABLE IF EXISTS `asistentes`;

CREATE TABLE `asistentes` (
  `IdAsistente` int(11) NOT NULL AUTO_INCREMENT,
  `IdUsuario` int(11) NOT NULL,
  PRIMARY KEY (`IdAsistente`),
  KEY `FK_Asistentes_Usuarios` (`IdUsuario`),
  CONSTRAINT `FK_Asistentes_Usuarios` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `asistentes` */

LOCK TABLES `asistentes` WRITE;

UNLOCK TABLES;

/*Table structure for table `citas` */

DROP TABLE IF EXISTS `citas`;

CREATE TABLE `citas` (
  `IdCita` int(11) NOT NULL AUTO_INCREMENT,
  `IdPaciente` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `IdMedico` int(11) NOT NULL,
  `CausaCita` varchar(255) NOT NULL,
  PRIMARY KEY (`IdCita`),
  KEY `FK_Citas_Medicos` (`IdMedico`),
  KEY `FK_Citas` (`IdPaciente`),
  CONSTRAINT `FK_Citas` FOREIGN KEY (`IdPaciente`) REFERENCES `pacientes` (`IdPaciente`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Citas_Medicos` FOREIGN KEY (`IdMedico`) REFERENCES `medicos` (`IdMedico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `citas` */

LOCK TABLES `citas` WRITE;

UNLOCK TABLES;

/*Table structure for table `especialidades` */

DROP TABLE IF EXISTS `especialidades`;

CREATE TABLE `especialidades` (
  `IdEspecialidad` int(11) NOT NULL AUTO_INCREMENT,
  `NombreEspecialidad` varchar(255) NOT NULL,
  PRIMARY KEY (`IdEspecialidad`),
  KEY `NewIndex1` (`NombreEspecialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `especialidades` */

LOCK TABLES `especialidades` WRITE;

insert  into `especialidades`(`IdEspecialidad`,`NombreEspecialidad`) values (1,'Cardiologia');

UNLOCK TABLES;

/*Table structure for table `medicamentos` */

DROP TABLE IF EXISTS `medicamentos`;

CREATE TABLE `medicamentos` (
  `IdMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `NombreMedicamento` varchar(11) NOT NULL,
  PRIMARY KEY (`IdMedicamento`),
  KEY `NewIndex1` (`NombreMedicamento`),
  CONSTRAINT `FK_Medicamentos` FOREIGN KEY (`NombreMedicamento`) REFERENCES `recetas` (`Medicamentos`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `medicamentos` */

LOCK TABLES `medicamentos` WRITE;

UNLOCK TABLES;

/*Table structure for table `medicos` */

DROP TABLE IF EXISTS `medicos`;

CREATE TABLE `medicos` (
  `IdMedico` int(11) NOT NULL AUTO_INCREMENT,
  `IdUsuario` int(11) NOT NULL,
  `Especialidades` varchar(255) NOT NULL,
  PRIMARY KEY (`IdMedico`),
  KEY `FK_Medicos_Usuarios` (`IdUsuario`),
  KEY `FK_Medicos` (`Especialidades`),
  CONSTRAINT `FK_Medic` FOREIGN KEY (`Especialidades`) REFERENCES `especialidades` (`NombreEspecialidad`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Medicos_Usuarios` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `medicos` */

LOCK TABLES `medicos` WRITE;

UNLOCK TABLES;

/*Table structure for table `pacientes` */

DROP TABLE IF EXISTS `pacientes`;

CREATE TABLE `pacientes` (
  `IdPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Cedula` varchar(255) NOT NULL,
  `Telefonos` varchar(255) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Fumador` tinyint(1) NOT NULL,
  `Alergias` varchar(255) DEFAULT NULL,
  `Foto` blob,
  PRIMARY KEY (`IdPaciente`),
  KEY `FK_Pacientes` (`Alergias`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pacientes` */

LOCK TABLES `pacientes` WRITE;

UNLOCK TABLES;

/*Table structure for table `padecimientos` */

DROP TABLE IF EXISTS `padecimientos`;

CREATE TABLE `padecimientos` (
  `IdPadecimiento` int(11) NOT NULL AUTO_INCREMENT,
  `NombrePadecimiento` varchar(255) NOT NULL,
  PRIMARY KEY (`IdPadecimiento`),
  KEY `FK_Padecimientos` (`NombrePadecimiento`),
  CONSTRAINT `FK_Padecimientos` FOREIGN KEY (`NombrePadecimiento`) REFERENCES `recetas` (`Padecimientos`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `padecimientos` */

LOCK TABLES `padecimientos` WRITE;

UNLOCK TABLES;

/*Table structure for table `pruebaslab` */

DROP TABLE IF EXISTS `pruebaslab`;

CREATE TABLE `pruebaslab` (
  `IdPruebaLab` int(11) NOT NULL AUTO_INCREMENT,
  `NombrePruebaLab` varchar(255) NOT NULL,
  PRIMARY KEY (`IdPruebaLab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pruebaslab` */

LOCK TABLES `pruebaslab` WRITE;

UNLOCK TABLES;

/*Table structure for table `recetas` */

DROP TABLE IF EXISTS `recetas`;

CREATE TABLE `recetas` (
  `IdReceta` int(11) NOT NULL AUTO_INCREMENT,
  `IdPaciente` int(11) NOT NULL,
  `Padecimientos` varchar(255) NOT NULL,
  `Medicamentos` varchar(255) NOT NULL,
  PRIMARY KEY (`IdReceta`),
  KEY `FK_Recetas_Padecimientos` (`Padecimientos`),
  KEY `FK_Recetas_Pacientes` (`IdPaciente`),
  KEY `FK_Recetas` (`Medicamentos`),
  CONSTRAINT `FK_Recetas_Pacientes` FOREIGN KEY (`IdPaciente`) REFERENCES `pacientes` (`IdPaciente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `recetas` */

LOCK TABLES `recetas` WRITE;

UNLOCK TABLES;

/*Table structure for table `resultadospruebaslab` */

DROP TABLE IF EXISTS `resultadospruebaslab`;

CREATE TABLE `resultadospruebaslab` (
  `IdResultadoPruebaLab` int(11) NOT NULL AUTO_INCREMENT,
  `IdPruebaLab` int(11) NOT NULL,
  `IdPaciente` int(11) NOT NULL,
  `Resultado` varchar(255) NOT NULL,
  PRIMARY KEY (`IdResultadoPruebaLab`),
  KEY `FK_ResultadosPruebasLab_Pacientes` (`IdPaciente`),
  KEY `FK_ResultadosPruebasLab_Pruebas` (`IdPruebaLab`),
  CONSTRAINT `FK_ResultadosPruebasLab_Pacientes` FOREIGN KEY (`IdPaciente`) REFERENCES `pacientes` (`IdPaciente`) ON UPDATE CASCADE,
  CONSTRAINT `FK_ResultadosPruebasLab_Pruebas` FOREIGN KEY (`IdPruebaLab`) REFERENCES `pruebaslab` (`IdPruebaLab`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `resultadospruebaslab` */

LOCK TABLES `resultadospruebaslab` WRITE;

UNLOCK TABLES;

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `NombreUsuario` varchar(255) NOT NULL,
  `Clave` varchar(255) NOT NULL,
  `Rol` varchar(255) NOT NULL,
  `Cedula` varchar(255) NOT NULL,
  `Telefonos` varchar(255) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

LOCK TABLES `usuario` WRITE;

insert  into `usuario`(`IdUsuario`,`Nombre`,`Apellido`,`NombreUsuario`,`Clave`,`Rol`,`Cedula`,`Telefonos`,`Direccion`) values (4,'Sterling','','a','1','ADMINISTRADOR','','',''),(8,'','','a','2','ADMINISTRADOR','','',''),(9,'','','a','3','ADMINISTRADOR','','',''),(10,'','','v','2','ADMINISTRADOR','','',''),(11,'','','d','a','ADMINISTRADOR','','','');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
