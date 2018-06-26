-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kasiyanov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kasiyanov` ;

-- -----------------------------------------------------
-- Schema kasiyanov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kasiyanov` DEFAULT CHARACTER SET utf8 ;
USE `kasiyanov` ;

-- -----------------------------------------------------
-- Table `kasiyanov`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kasiyanov`.`roles` ;

CREATE TABLE IF NOT EXISTS `kasiyanov`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kasiyanov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kasiyanov`.`users` ;

CREATE TABLE IF NOT EXISTS `kasiyanov`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `kasiyanov`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kasiyanov`.`trawelOffers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kasiyanov`.`trawelOffers` ;

CREATE TABLE IF NOT EXISTS `kasiyanov`.`trawelOffers` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(5000) NULL,
  `TypeOfTravel` VARCHAR(50) NULL,
  `Destination` VARCHAR(50) NULL,
  `Hotel` VARCHAR(50) NULL,
  `LevelOfAccommodation` VARCHAR(50) NULL,
  `NumberOfNights` INT NULL,
  `Price` DOUBLE NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_trawelOffers_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_trawelOffers_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `kasiyanov`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `kasiyanov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `kasiyanov`;
INSERT INTO `kasiyanov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `kasiyanov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');
INSERT INTO `kasiyanov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kasiyanov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `kasiyanov`;
INSERT INTO `kasiyanov`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);
INSERT INTO `kasiyanov`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `kasiyanov`.`trawelOffers`
-- -----------------------------------------------------
START TRANSACTION;
USE `kasiyanov`;
INSERT INTO `kasiyanov`.`trawelOffers` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `LevelOfAccommodation`, `NumberOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'Magnificent sandy beaches', 'Holiday', 'Malta', 'Hilton', '5 Stars', 7, 445.0, 2);

COMMIT;

