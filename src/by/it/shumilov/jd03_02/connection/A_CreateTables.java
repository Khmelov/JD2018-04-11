package by.it.shumilov.jd03_02.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_CreateTables {
    static void create(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbRoles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbUsers` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `dbRoles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_dbUsers_dbRoles1_idx` (`dbRoles_id` ASC),\n" +
                    "  CONSTRAINT `fk_dbUsers_dbRoles1`\n" +
                    "    FOREIGN KEY (`dbRoles_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbRoles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbAvtos` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `mark` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `nvin` VARCHAR(17) NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `ngos` VARCHAR(9) NULL,\n" +
                    "  `rate` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbOrders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `startorder` DATE NULL,\n" +
                    "  `tenancy` INT NULL,\n" +
                    "  `endorder` DATE NULL,\n" +
                    "  `cost` DOUBLE NULL,\n" +
                    "  `discount` INT NULL,\n" +
                    "  `realcost` DOUBLE NULL,\n" +
                    "  `dbAvto_id` INT NOT NULL,\n" +
                    "  `dbUsers_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_dbOrder_dbAvto_idx` (`dbAvto_id` ASC),\n" +
                    "  INDEX `fk_dbOrder_dbUsers1_idx` (`dbUsers_id` ASC),\n" +
                    "  CONSTRAINT `fk_dbOrder_dbAvto`\n" +
                    "    FOREIGN KEY (`dbAvto_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbAvtos` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_dbOrder_dbUsers1`\n" +
                    "    FOREIGN KEY (`dbUsers_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbUsers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbPassports` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `firstname` VARCHAR(100) NULL,\n" +
                    "  `lastname` VARCHAR(100) NULL,\n" +
                    "  `pasportid` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(12) NULL,\n" +
                    "  `dbUsers_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_dbPasport_dbUsers1_idx` (`dbUsers_id` ASC),\n" +
                    "  CONSTRAINT `fk_dbPasport_dbUsers1`\n" +
                    "    FOREIGN KEY (`dbUsers_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbUsers` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
