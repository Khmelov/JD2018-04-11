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
  `ID` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles1_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `rogov`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rogov`.`labrary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rogov`.`labrary` ;

CREATE TABLE IF NOT EXISTS `rogov`.`labrary` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `textFree` VARCHAR(10000) NULL,
  `textPay` VARCHAR(10000) NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_labrary_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_labrary_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `rogov`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rogov`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rogov`.`permission` ;

CREATE TABLE IF NOT EXISTS `rogov`.`permission` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `pemissionAccess` INT NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_permission_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_permission_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `rogov`.`users` (`ID`)
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
INSERT INTO `rogov`.`users` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'pasadmin', 'admin@mail@ru', 1);
INSERT INTO `rogov`.`users` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'user', 'pasuser', 'user@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rogov`.`labrary`
-- -----------------------------------------------------
START TRANSACTION;
USE `rogov`;
INSERT INTO `rogov`.`labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES (DEFAULT, 'title', 'some text2', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rogov`.`permission`
-- -----------------------------------------------------
START TRANSACTION;
USE `rogov`;
INSERT INTO `rogov`.`permission` (`ID`, `pemissionAccess`, `users_ID`) VALUES (DEFAULT, 1, 1);
INSERT INTO `rogov`.`permission` (`ID`, `pemissionAccess`, `users_ID`) VALUES (DEFAULT, 1, 2);

COMMIT;

