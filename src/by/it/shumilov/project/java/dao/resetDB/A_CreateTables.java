package by.it.shumilov.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_CreateTables {
    static void create(Connection connection){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL DEFAULT 2,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `Shumilov`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`avtos` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `mark` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `nvin` VARCHAR(17) NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `ngos` VARCHAR(9) NULL,\n" +
                    "  `rate` DOUBLE NULL,\n" +
                    "  `foto` VARCHAR(45) NULL DEFAULT 'default.jpg',\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `startorder` DATE NULL,\n" +
                    "  `tenancy` INT NULL,\n" +
                    "  `endorder` DATE NULL,\n" +
                    "  `cost` DOUBLE NULL,\n" +
                    "  `discount` INT NULL,\n" +
                    "  `realcost` DOUBLE NULL,\n" +
                    "  `avtos_id` INT NOT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_avtos_idx` (`avtos_id` ASC),\n" +
                    "  INDEX `fk_orders_users_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_avtos`\n" +
                    "    FOREIGN KEY (`avtos_id`)\n" +
                    "    REFERENCES `Shumilov`.`avtos` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_orders_users`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `Shumilov`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`passports` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `firstname` VARCHAR(100) NULL,\n" +
                    "  `lastname` VARCHAR(100) NULL,\n" +
                    "  `pasportid` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(12) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_passport_users_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_pasport_users`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `Shumilov`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
