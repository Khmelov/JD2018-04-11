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
-- Table `Shumilov`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`roles` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`users` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL DEFAULT 2,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `Shumilov`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`avtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`avtos` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`avtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `nvin` VARCHAR(17) NULL,
  `year` INT NULL,
  `ngos` VARCHAR(9) NULL,
  `rate` DOUBLE NULL,
  `foto` VARCHAR(45) NULL DEFAULT 'defaul.jpg',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`orders` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `startorder` DATE NULL,
  `tenancy` INT NULL,
  `endorder` DATE NULL,
  `cost` DOUBLE NULL,
  `discount` INT NULL,
  `realcost` DOUBLE NULL,
  `avtos_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_avtos_idx` (`avtos_id` ASC),
  INDEX `fk_orders_users_idx` (`users_id` ASC),
  CONSTRAINT `fk_orders_avtos`
    FOREIGN KEY (`avtos_id`)
    REFERENCES `Shumilov`.`avtos` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_orders_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `Shumilov`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shumilov`.`passports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Shumilov`.`passports` ;

CREATE TABLE IF NOT EXISTS `Shumilov`.`passports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(100) NULL,
  `lastname` VARCHAR(100) NULL,
  `pasportid` VARCHAR(45) NULL,
  `phone` VARCHAR(12) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_passport_users_idx` (`users_id` ASC),
  CONSTRAINT `fk_pasport_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `Shumilov`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Shumilov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`roles` (`id`, `role`) VALUES (1, 'Admin');
INSERT INTO `Shumilov`.`roles` (`id`, `role`) VALUES (2, 'User');
INSERT INTO `Shumilov`.`roles` (`id`, `role`) VALUES (3, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (1, 'admin', 'admin1', 'admin@it.by', 1);
INSERT INTO `Shumilov`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (2, 'sas', 'qwerty', 'sas@tut.by', 2);
INSERT INTO `Shumilov`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (3, 'dsa', 'asd12', 'dima2017', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`avtos`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`avtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) VALUES (1, 'VW', 'Pasat B6', 'Black', '1A2S3D4F5G6H7J8K9', 2012, '1234 SW-5', 40.4, NULL);
INSERT INTO `Shumilov`.`avtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) VALUES (2, 'Porshe', '911', 'Red', '1A2S3D4F5G6H7J8KY', 2017, '5432 AD-4', 199.9, NULL);
INSERT INTO `Shumilov`.`avtos` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) VALUES (3, 'Infiniti', 'p40', 'White', '1A2S3D4F5G6H7J8FD', 2015, '8888 BO-7', 149.9, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`orders` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) VALUES (1, '2018-03-11', 11, '2018-03-21', 444.4, 1, 439.96, 1, 2);
INSERT INTO `Shumilov`.`orders` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) VALUES (2, '2018-05-26', 2, '2018-05-27', 399.8, 0, 399.8, 2, 3);
INSERT INTO `Shumilov`.`orders` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) VALUES (3, '2018-06-11', 30, NULL, 4497.0, 10, 4047.3, 3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Shumilov`.`passports`
-- -----------------------------------------------------
START TRANSACTION;
USE `Shumilov`;
INSERT INTO `Shumilov`.`passports` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `users_id`) VALUES (1, 'Aleks', 'State', '866534435908896RB7', '375771234567', 2);
INSERT INTO `Shumilov`.`passports` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `users_id`) VALUES (2, 'Dmitrii', 'Amenko', '854352754324123RB3', '375227654321', 3);

COMMIT;

