-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mokhart
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mokhart` ;

-- -----------------------------------------------------
-- Schema mokhart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mokhart` DEFAULT CHARACTER SET utf8 ;
USE `mokhart` ;

-- -----------------------------------------------------
-- Table `mokhart`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mokhart`.`roles` ;

CREATE TABLE IF NOT EXISTS `mokhart`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mokhart`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mokhart`.`users` ;

CREATE TABLE IF NOT EXISTS `mokhart`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `mokhart`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mokhart`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mokhart`.`ads` ;

CREATE TABLE IF NOT EXISTS `mokhart`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NULL,
  `price` DOUBLE NULL,
  `size` VARCHAR(6) NULL,
  `fabric` VARCHAR(45) NULL,
  `colour` VARCHAR(45) NULL,
  `sex` VARCHAR(5) NULL,
  `producer` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `mokhart`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mokhart`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `mokhart`;
INSERT INTO `mokhart`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Admin');
INSERT INTO `mokhart`.`roles` (`id`, `role`) VALUES (DEFAULT, 'User');
INSERT INTO `mokhart`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mokhart`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `mokhart`;
INSERT INTO `mokhart`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);
INSERT INTO `mokhart`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mokhart`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `mokhart`;
INSERT INTO `mokhart`.`ads` (`id`, `description`, `price`, `size`, `fabric`, `colour`, `sex`, `producer`, `users_id`) VALUES (DEFAULT, 'Jeans', 112.5, 'M', 'jeans', 'blue', 'Male', 'Lewice', 2);

COMMIT;
