-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tarasiuk
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tarasiuk` ;

-- -----------------------------------------------------
-- Schema tarasiuk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tarasiuk` DEFAULT CHARACTER SET utf8 ;
USE `tarasiuk` ;

-- -----------------------------------------------------
-- Table `tarasiuk`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tarasiuk`.`roles` ;

CREATE TABLE IF NOT EXISTS `tarasiuk`.`roles` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tarasiuk`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tarasiuk`.`users` ;

CREATE TABLE IF NOT EXISTS `tarasiuk`.`users` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `roles_id` INT(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `tarasiuk`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tarasiuk`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tarasiuk`.`ads` ;

CREATE TABLE IF NOT EXISTS `tarasiuk`.`ads` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(20) NOT NULL,
  `model` VARCHAR(20) NOT NULL,
  `year` YEAR NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `grade` VARCHAR(20) NOT NULL,
  `color` VARCHAR(20) NOT NULL,
  `price` DOUBLE NOT NULL,
  `description` VARCHAR(2500) NOT NULL,
  `users_id` INT(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `tarasiuk`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tarasiuk`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `tarasiuk`;
INSERT INTO `tarasiuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `tarasiuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `tarasiuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tarasiuk`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `tarasiuk`;
INSERT INTO `tarasiuk`.`users` (`id`, `email`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'admin@admin.com', 'admin', 'admin', 1);
INSERT INTO `tarasiuk`.`users` (`id`, `email`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'nick98@mail.ru', 'Nick	', '123321', 2);
INSERT INTO `tarasiuk`.`users` (`id`, `email`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'zohan@gmail.com', 'ZiZi', 'qwerty', 2);
INSERT INTO `tarasiuk`.`users` (`id`, `email`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'Lucy01@ya.ru', 'ololoshka321', 'fghffh03', 2);
INSERT INTO `tarasiuk`.`users` (`id`, `email`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'watcher@tut.by', 'watcher1', '321', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tarasiuk`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `tarasiuk`;
INSERT INTO `tarasiuk`.`ads` (`id`, `brand`, `model`, `year`, `type`, `grade`, `color`, `price`, `description`, `users_id`) VALUES (DEFAULT, 'AIST', 'Turbo', 2017, 'adult', 'highway', 'blue', 300, 'Good bike!', 2);
INSERT INTO `tarasiuk`.`ads` (`id`, `brand`, `model`, `year`, `type`, `grade`, `color`, `price`, `description`, `users_id`) VALUES (DEFAULT, 'Giant', 'Trance Advanced', 2016, 'adult', 'mountain', 'black', 5500, 'Extraordinary mountain bike!', 3);
INSERT INTO `tarasiuk`.`ads` (`id`, `brand`, `model`, `year`, `type`, `grade`, `color`, `price`, `description`, `users_id`) VALUES (DEFAULT, 'Altair', 'City', 2006, 'childish', 'city', 'red', 58, 'Normal bicycle for children.', 4);

COMMIT;

