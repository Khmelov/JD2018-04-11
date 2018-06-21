package by.it.dkruchek.jd03_02.utils;

import by.it.dkruchek.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper{

    public static void dropTables(){
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {

            String sql = "SET FOREIGN_KEY_CHECKS = 0;\n" +
                    "DROP TABLE IF EXISTS `roles`;\n" +
                    "DROP TABLE IF EXISTS `employees`;\n" +
                    "DROP TABLE IF EXISTS `vacations`;\n" +
                    "SET FOREIGN_KEY_CHECKS = 1;\n";
            System.out.println("Dropping all tables");
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables(){
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            System.out.println("Creating tables");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dkruchek`.`roles` (\n" +
                                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                                        "  `role` VARCHAR(100) NULL,\n" +
                                        "  PRIMARY KEY (`id`))\n" +
                                        "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dkruchek`.`employees` (\n" +
                                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                                        "  `name` VARCHAR(45) NULL,\n" +
                                        "  `lastname` VARCHAR(45) NULL,\n" +
                                        "  `email` VARCHAR(45) NULL,\n" +
                                        "  `password` VARCHAR(45) NULL,\n" +
                                        "  `roles_id` INT NOT NULL,\n" +
                                        "  PRIMARY KEY (`id`),\n" +
                                        "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                                        "  CONSTRAINT `fk_users_roles`\n" +
                                        "    FOREIGN KEY (`roles_id`)\n" +
                                        "    REFERENCES `dkruchek`.`roles` (`id`)\n" +
                                        "    ON DELETE RESTRICT\n" +
                                        "    ON UPDATE RESTRICT)\n" +
                                        "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dkruchek`.`vacations` (\n" +
                                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                                        "  `dates` VARCHAR(45) NULL,\n" +
                                        "  `approved` TINYINT(1) NULL,\n" +
                                        "  `employees_id` INT NOT NULL,\n" +
                                        "  PRIMARY KEY (`id`),\n" +
                                        "  INDEX `fk_Vacations_employees1_idx` (`employees_id` ASC),\n" +
                                        "  CONSTRAINT `fk_Vacations_employees1`\n" +
                                        "    FOREIGN KEY (`employees_id`)\n" +
                                        "    REFERENCES `dkruchek`.`employees` (`id`)\n" +
                                        "    ON DELETE CASCADE\n" +
                                        "    ON UPDATE CASCADE)\n" +
                                        "ENGINE = InnoDB;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
