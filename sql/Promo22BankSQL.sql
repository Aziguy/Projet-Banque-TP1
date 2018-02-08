/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.6.36 : Database - promo22bank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`promo22bank` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `promo22bank`;

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `idClients` int(11) NOT NULL AUTO_INCREMENT,
  `noms` varchar(50) DEFAULT NULL,
  `prenoms` varchar(50) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `adresse` varchar(70) DEFAULT NULL,
  `Gestionnaires_idGestionnaires` int(11) NOT NULL,
  PRIMARY KEY (`idClients`),
  KEY `fk_Clients_Gestionnaires1_idx` (`Gestionnaires_idGestionnaires`),
  CONSTRAINT `fk_Clients_Gestionnaires1` FOREIGN KEY (`Gestionnaires_idGestionnaires`) REFERENCES `gestionnaires` (`idGestionnaires`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `clients` */

insert  into `clients`(`idClients`,`noms`,`prenoms`,`dateNaissance`,`telephone`,`adresse`,`Gestionnaires_idGestionnaires`) values (1,'KENGNI','Hippolyte','1988-08-22','0961378004','Yaoundé-Cameroun',2),(2,'TEST NOMS','Test Prenoms','1992-05-12','694770830','121, Rue 1851 Bastos',1),(3,'OUSSEINI','Abdoul','1996-04-25','0165945412','KTX My Dinh, NGUYEN 1',2);

/*Table structure for table `comptes` */

DROP TABLE IF EXISTS `comptes`;

CREATE TABLE `comptes` (
  `numComptes` int(5) NOT NULL,
  `numIdent` int(5) DEFAULT NULL,
  `solde` float DEFAULT NULL,
  `Clients_idClients` int(11) NOT NULL,
  `Gestionnaires_idGestionnaires` int(11) NOT NULL,
  `TypeComptes_idTypeComptes` int(11) NOT NULL,
  PRIMARY KEY (`numComptes`),
  KEY `fk_Comptes_Clients_idx` (`Clients_idClients`),
  KEY `fk_Comptes_Gestionnaires1_idx` (`Gestionnaires_idGestionnaires`),
  KEY `fk_Comptes_TypeComptes1_idx` (`TypeComptes_idTypeComptes`),
  CONSTRAINT `fk_Comptes_Clients` FOREIGN KEY (`Clients_idClients`) REFERENCES `clients` (`idClients`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comptes_Gestionnaires1` FOREIGN KEY (`Gestionnaires_idGestionnaires`) REFERENCES `gestionnaires` (`idGestionnaires`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comptes_TypeComptes1` FOREIGN KEY (`TypeComptes_idTypeComptes`) REFERENCES `typecomptes` (`idTypeComptes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comptes` */

insert  into `comptes`(`numComptes`,`numIdent`,`solde`,`Clients_idClients`,`Gestionnaires_idGestionnaires`,`TypeComptes_idTypeComptes`) values (123,147,292.308,2,1,2),(11208,31748,974.359,3,2,2),(11850,97716,670.048,1,1,1),(98952,91352,1340.09,3,2,1);

/*Table structure for table `connexion` */

DROP TABLE IF EXISTS `connexion`;

CREATE TABLE `connexion` (
  `idConnexion` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `nomComplet` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idConnexion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `connexion` */

insert  into `connexion`(`idConnexion`,`login`,`password`,`type`,`nomComplet`) values (1,'Admin','admin','Administrateur','Ousseini Hamza Abdoul Djalil'),(2,'Guard','admin','Guardian','KENGNI Hippolyte');

/*Table structure for table `gestionnaires` */

DROP TABLE IF EXISTS `gestionnaires`;

CREATE TABLE `gestionnaires` (
  `idGestionnaires` int(11) NOT NULL AUTO_INCREMENT,
  `noms` varchar(50) DEFAULT NULL,
  `prenoms` varchar(50) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `adresse` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`idGestionnaires`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `gestionnaires` */

insert  into `gestionnaires`(`idGestionnaires`,`noms`,`prenoms`,`dateEmbauche`,`telephone`,`adresse`) values (1,'NGUYEN','Hang Minh','2015-08-22','0961378004','KTX My Dinh '),(2,'PHONG','Sun May','2014-02-14','0955526047','DH Quoc Gia Ha Noï');

/*Table structure for table `transactions` */

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
  `idTransactions` int(11) NOT NULL AUTO_INCREMENT,
  `numComptes` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `typeTransaction` varchar(50) DEFAULT NULL,
  `montant` float DEFAULT NULL,
  `Gestionnaires_idGestionnaires` int(11) NOT NULL,
  PRIMARY KEY (`idTransactions`),
  KEY `fk_Transactions_Gestionnaires1_idx` (`Gestionnaires_idGestionnaires`),
  KEY `numComptes` (`numComptes`),
  CONSTRAINT `fk_Transactions_Gestionnaires1` FOREIGN KEY (`Gestionnaires_idGestionnaires`) REFERENCES `gestionnaires` (`idGestionnaires`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`numComptes`) REFERENCES `comptes` (`numComptes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `transactions` */

insert  into `transactions`(`idTransactions`,`numComptes`,`date`,`typeTransaction`,`montant`,`Gestionnaires_idGestionnaires`) values (1,123,'2018-02-01','Crédit',150,2),(2,11850,'2018-01-31','Débit',50,1),(3,123,'2018-02-03','Crédit',100,1),(4,11850,'2018-02-04','Débit',250,1),(5,11850,'2018-02-04','Débit',350,1),(6,11850,'2018-02-04','Crédit',250,2),(7,98952,'2018-02-04','Débit',500,2);

/*Table structure for table `typecomptes` */

DROP TABLE IF EXISTS `typecomptes`;

CREATE TABLE `typecomptes` (
  `idTypeComptes` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) DEFAULT NULL,
  `tauxInteret` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTypeComptes`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `typecomptes` */

insert  into `typecomptes`(`idTypeComptes`,`libelle`,`tauxInteret`) values (1,'Epargne',5),(2,'Courant',10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
