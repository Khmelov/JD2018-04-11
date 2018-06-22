-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tayanovskii
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tayanovskii` ;

-- -----------------------------------------------------
-- Schema tayanovskii
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tayanovskii` DEFAULT CHARACTER SET utf8 ;
USE `tayanovskii` ;

-- -----------------------------------------------------
-- Table `tayanovskii`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tayanovskii`.`roles` ;

CREATE TABLE IF NOT EXISTS `tayanovskii`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tayanovskii`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tayanovskii`.`users` ;

CREATE TABLE IF NOT EXISTS `tayanovskii`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `tayanovskii`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tayanovskii`.`publications`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tayanovskii`.`publications` ;

CREATE TABLE IF NOT EXISTS `tayanovskii`.`publications` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) NULL,
  `number` INT NULL,
  `date` VARCHAR(45) NULL,
  `description` VARCHAR(20000) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tayanovskii`.`permissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tayanovskii`.`permissions` ;

CREATE TABLE IF NOT EXISTS `tayanovskii`.`permissions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `access` TINYINT(1) NULL,
  `users_id` INT NOT NULL,
  `publications_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_permissions_users1_idx` (`users_id` ASC),
  INDEX `fk_permissions_publications1_idx` (`publications_id` ASC),
  CONSTRAINT `fk_permissions_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `tayanovskii`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_permissions_publications1`
    FOREIGN KEY (`publications_id`)
    REFERENCES `tayanovskii`.`publications` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tayanovskii`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `tayanovskii`;
INSERT INTO `tayanovskii`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `tayanovskii`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tayanovskii`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `tayanovskii`;
INSERT INTO `tayanovskii`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', 1);
INSERT INTO `tayanovskii`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user1', 'user1', 'user1@gmail.com', 2);
INSERT INTO `tayanovskii`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user2', 'user2', 'user2@gmail.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tayanovskii`.`publications`
-- -----------------------------------------------------
START TRANSACTION;
USE `tayanovskii`;
INSERT INTO `tayanovskii`.`publications` (`id`, `title`, `number`, `date`, `description`, `price`) VALUES (DEFAULT, 'Пожарная безопасность', 1, '2018-06-10', 'Контроль за пожарной безопасностью на предприятии', 10.0);
INSERT INTO `tayanovskii`.`publications` (`id`, `title`, `number`, `date`, `description`, `price`) VALUES (DEFAULT, 'Охрана труда', 3, '2018-05-01', 'Контроль за охраной труда на государсвенных предприятиях', 15.3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `tayanovskii`.`permissions`
-- -----------------------------------------------------
START TRANSACTION;
USE `tayanovskii`;
INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 1, 1);
INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 1, 2);
INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 2, 1);
INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 2, 2);
INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, false, 3, 1);
INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, false, 3, 2);

COMMIT;

