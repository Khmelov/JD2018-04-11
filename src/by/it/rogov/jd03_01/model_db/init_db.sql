-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema rogov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rogov` ;

-- -----------------------------------------------------
-- Schema rogov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rogov` DEFAULT CHARACTER SET utf8 ;
USE `rogov` ;

-- -----------------------------------------------------
-- Table `rogov`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rogov`.`roles` ;

CREATE TABLE IF NOT EXISTS `rogov`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rogov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rogov`.`users` ;

CREATE TABLE IF NOT EXISTS `rogov`.`users` (
  `ID` INT NOT NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` INT NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `rogov`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rogov`.`biblioteca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rogov`.`biblioteca` ;

CREATE TABLE IF NOT EXISTS `rogov`.`biblioteca` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `artaical1` VARCHAR(10000) NULL,
  `artaical2` VARCHAR(10000) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rogov`.`user_biblioteca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rogov`.`user_biblioteca` ;

CREATE TABLE IF NOT EXISTS `rogov`.`user_biblioteca` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `permission` TINYINT(1) NULL,
  `users_ID` INT NOT NULL,
  `biblioteca_ID` INT NOT NULL,
  `update permission` TINYINT(1) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_user_biblioteca_users1_idx` (`users_ID` ASC),
  INDEX `fk_user_biblioteca_biblioteca1_idx` (`biblioteca_ID` ASC),
  CONSTRAINT `fk_user_biblioteca_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `rogov`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_biblioteca_biblioteca1`
    FOREIGN KEY (`biblioteca_ID`)
    REFERENCES `rogov`.`biblioteca` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `rogov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `rogov`;
INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administator');
INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'User');
INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rogov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `rogov`;
INSERT INTO `rogov`.`users` (`ID`, `login`, `password`, `email`, `phone`, `roles_ID`) VALUES (DEFAULT, 'admin', 'pasadmin', 'admin@mail@ru', 123456, 1);
INSERT INTO `rogov`.`users` (`ID`, `login`, `password`, `email`, `phone`, `roles_ID`) VALUES (DEFAULT, 'user', 'pasuser', 'user@mail.ru', 234567, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rogov`.`biblioteca`
-- -----------------------------------------------------
START TRANSACTION;
USE `rogov`;
INSERT INTO `rogov`.`biblioteca` (`ID`, `artaical1`, `artaical2`) VALUES (DEFAULT, 'some text', 'some text2');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rogov`.`user_biblioteca`
-- -----------------------------------------------------
START TRANSACTION;
USE `rogov`;
INSERT INTO `rogov`.`user_biblioteca` (`ID`, `permission`, `users_ID`, `biblioteca_ID`, `update permission`) VALUES (DEFAULT, true, 1, 1, true);

COMMIT;

