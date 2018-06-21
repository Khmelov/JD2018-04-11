-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema obmetko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `obmetko` ;

-- -----------------------------------------------------
-- Schema obmetko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `obmetko` DEFAULT CHARACTER SET utf8 ;
USE `obmetko` ;

-- -----------------------------------------------------
-- Table `obmetko`.`catalog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `obmetko`.`catalog` ;

CREATE TABLE IF NOT EXISTS `obmetko`.`catalog` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(4000) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `obmetko`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `obmetko`.`category` ;

CREATE TABLE IF NOT EXISTS `obmetko`.`category` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(4000) NULL DEFAULT NULL,
  `catalog_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Category_catalog1_idx` (`catalog_ID` ASC),
  CONSTRAINT `fk_Category_catalog1`
    FOREIGN KEY (`catalog_ID`)
    REFERENCES `obmetko`.`catalog` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `obmetko`.`books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `obmetko`.`books` ;

CREATE TABLE IF NOT EXISTS `obmetko`.`books` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(4000) NULL DEFAULT NULL,
  `autor` VARCHAR(4000) NULL DEFAULT NULL,
  `price` VARCHAR(4000) NULL DEFAULT NULL,
  `Category_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_books_Category1_idx` (`Category_ID` ASC),
  CONSTRAINT `fk_books_Category1`
    FOREIGN KEY (`Category_ID`)
    REFERENCES `obmetko`.`category` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `obmetko`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `obmetko`.`roles` ;

CREATE TABLE IF NOT EXISTS `obmetko`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(405) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `obmetko`.`buyers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `obmetko`.`buyers` ;

CREATE TABLE IF NOT EXISTS `obmetko`.`buyers` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(4000) NULL DEFAULT NULL,
  `password` VARCHAR(4000) NULL DEFAULT NULL,
  `email` VARCHAR(4000) NULL DEFAULT NULL,
  `roles_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_buyers_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_buyers_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `obmetko`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `obmetko`.`list of purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `obmetko`.`list of purchases` ;

CREATE TABLE IF NOT EXISTS `obmetko`.`list of purchases` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `buyers_ID` INT(11) NOT NULL,
  `books_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_list of purchases_buyers1_idx` (`buyers_ID` ASC),
  INDEX `fk_list of purchases_books1_idx` (`books_ID` ASC),
  CONSTRAINT `fk_list of purchases_books1`
    FOREIGN KEY (`books_ID`)
    REFERENCES `obmetko`.`books` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_list of purchases_buyers1`
    FOREIGN KEY (`buyers_ID`)
    REFERENCES `obmetko`.`buyers` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `obmetko`.`catalog`
-- -----------------------------------------------------
START TRANSACTION;
USE `obmetko`;
INSERT INTO `obmetko`.`catalog` (`ID`, `Name`) VALUES (DEFAULT, 'каталог книг');
INSERT INTO `obmetko`.`catalog` (`ID`, `Name`) VALUES (DEFAULT, 'каталог манги и комиксов');

COMMIT;


-- -----------------------------------------------------
-- Data for table `obmetko`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `obmetko`;
INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'художественная', 1);
INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'программирование', 1);
INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'комиксы', 2);
INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'манга', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `obmetko`.`books`
-- -----------------------------------------------------
START TRANSACTION;
USE `obmetko`;
INSERT INTO `obmetko`.`books` (`ID`, `name`, `autor`, `price`, `Category_ID`) VALUES (DEFAULT, 'Ведьмак', 'Анжей Сапковский', '100', 1);
INSERT INTO `obmetko`.`books` (`ID`, `name`, `autor`, `price`, `Category_ID`) VALUES (DEFAULT, 'Java для начинающих. Объектно-ориентированный подход', 'Барт Бэзинс', '55', 2);
INSERT INTO `obmetko`.`books` (`ID`, `name`, `autor`, `price`, `Category_ID`) VALUES (DEFAULT, 'Тор. Бог грома', 'Джейсон Аарон', '49', 3);
INSERT INTO `obmetko`.`books` (`ID`, `name`, `autor`, `price`, `Category_ID`) VALUES (DEFAULT, 'Волчица и пряности. Том 1', 'Исуна Хасэкура', '18', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `obmetko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `obmetko`;
INSERT INTO `obmetko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'admin');
INSERT INTO `obmetko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'buyer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `obmetko`.`buyers`
-- -----------------------------------------------------
START TRANSACTION;
USE `obmetko`;
INSERT INTO `obmetko`.`buyers` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'admin', 'admin@tut.by', 1);
INSERT INTO `obmetko`.`buyers` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'user', 'user', 'user@tut.by', 2);

COMMIT;

