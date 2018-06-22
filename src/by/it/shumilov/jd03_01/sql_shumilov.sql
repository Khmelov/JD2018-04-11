-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Shumilov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Shumilov` ;

-- -----------------------------------------------------
-- Schema Shumilov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Shumilov` DEFAULT CHARACTER SET utf8 ;
USE `Shumilov` ;

-- -----------------------------------------------------
-- Table `Shumilov`.`dbRoles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`dbRoles` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`dbRoles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`dbUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`dbUsers` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`dbUsers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `dbRoles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dbUsers_dbRoles1_idx` (`dbRoles_id` ASC),
  CONSTRAINT `fk_dbUsers_dbRoles1`
    FOREIGN KEY (`dbRoles_id`)
    REFERENCES `Shumilov`.`dbRoles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`dbAvtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`dbAvtos` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`dbAvtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `nvin` VARCHAR(17) NULL,
  `year` INT NULL,
  `ngos` VARCHAR(9) NULL,
  `rate` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`dbOrders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`dbOrders` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`dbOrders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `startorder` DATE NULL,
  `tenancy` INT NULL,
  `endorder` DATE NULL,
  `cost` DOUBLE NULL,
  `discount` INT NULL,
  `realcost` DOUBLE NULL,
  `dbAvto_id` INT NOT NULL,
  `dbUsers_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dbOrder_dbAvto_idx` (`dbAvto_id` ASC),
  INDEX `fk_dbOrder_dbUsers1_idx` (`dbUsers_id` ASC),
  CONSTRAINT `fk_dbOrder_dbAvto`
    FOREIGN KEY (`dbAvto_id`)
    REFERENCES `Shumilov`.`dbAvtos` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_dbOrder_dbUsers1`
    FOREIGN KEY (`dbUsers_id`)
    REFERENCES `Shumilov`.`dbUsers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`dbPassports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`dbPassports` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`dbPassports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(100) NULL,
  `lastname` VARCHAR(100) NULL,
  `pasportid` VARCHAR(45) NULL,
  `phone` VARCHAR(12) NULL,
  `dbUsers_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dbPasport_dbUsers1_idx` (`dbUsers_id` ASC),
  CONSTRAINT `fk_dbPasport_dbUsers1`
    FOREIGN KEY (`dbUsers_id`)
    REFERENCES `Shumilov`.`dbUsers` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Shumilov`.`dbRoles`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (1, 'Admin');
INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (2, 'User');
INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (3, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`dbUsers`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`dbUsers` (`id`, `login`, `password`, `email`, `dbRoles_id`) VALUES (1, 'admin', 'admin1', 'admin@it.by', 1);
INSERT INTO `Shumilov`.`dbUsers` (`id`, `login`, `password`, `email`, `dbRoles_id`) VALUES (2, 'sas', 'qwerty', 'sas@tut.by', 2);
INSERT INTO `Shumilov`.`dbUsers` (`id`, `login`, `password`, `email`, `dbRoles_id`) VALUES (3, 'dsa', 'asd12', 'dima2017', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`dbAvtos`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`dbAvtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`) VALUES (1, 'VW', 'Pasat B6', 'Black', '1A2S3D4F5G6H7J8K9', 2012, '1234 SW-5', 40.4);
INSERT INTO `Shumilov`.`dbAvtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`) VALUES (2, 'Porshe', '911', 'Red', '1A2S3D4F5G6H7J8KY', 2017, '5432 AD-4', 199.9);
INSERT INTO `Shumilov`.`dbAvtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`) VALUES (3, 'Infiniti', 'p40', 'White', '1A2S3D4F5G6H7J8FD', 2015, '8888 BO-7', 149.9);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`dbOrders`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`dbOrders` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `dbAvto_id`, `dbUsers_id`) VALUES (1, '2018-03-11', 11, '2018-03-21', 444.4, 1, 439.96, 1, 2);
INSERT INTO `Shumilov`.`dbOrders` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `dbAvto_id`, `dbUsers_id`) VALUES (2, '2018-05-26', 2, '2018-05-27', 399.8, 0, 399.8, 2, 3);
INSERT INTO `Shumilov`.`dbOrders` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `dbAvto_id`, `dbUsers_id`) VALUES (3, '2018-06-11', 30, NULL, 4497.0, 10, 4047.3, 3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`dbPassports`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`dbPassports` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `dbUsers_id`) VALUES (1, 'Aleks', 'State', '866534435908896RB7', '375771234567', 2);
INSERT INTO `Shumilov`.`dbPassports` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `dbUsers_id`) VALUES (2, 'Dmitrii', 'Amenko', '854352754324123RB3', '375227654321', 3);

COMMIT;

