package by.it.tayanovskii.jd03_02.crud;
import by.it.tayanovskii.jd03_02.connection.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_CreateTable {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }



        try (
                Connection connection =
                        DriverManager.getConnection
                                (CN.DB_URL_SHORT,CN.DB_USER, CN.DB_PASSWORD);
                Statement statement = connection.createStatement())
        {
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `tayanovskii` DEFAULT CHARACTER SET utf8 ;");
            //генерация всех таблиц
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `tayanovskii`.`roles` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `role` VARCHAR(45) NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `tayanovskii`.`users` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `login` VARCHAR(45) NULL,\n" +
                            "  `password` VARCHAR(45) NULL,\n" +
                            "  `email` VARCHAR(100) NULL,\n" +
                            "  `roles_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                            "  CONSTRAINT `fk_users_roles`\n" +
                            "    FOREIGN KEY (`roles_id`)\n" +
                            "    REFERENCES `tayanovskii`.`roles` (`id`)\n" +
                            "    ON DELETE RESTRICT\n" +
                            "    ON UPDATE RESTRICT)\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `tayanovskii`.`publications` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `title` VARCHAR(1000) NULL,\n" +
                            "  `number` INT NULL,\n" +
                            "  `date` VARCHAR(45) NULL,\n" +
                            "  `description` VARCHAR(20000) NULL,\n" +
                            "  `price` DOUBLE NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `tayanovskii`.`permissions` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `access` TINYINT(1) NULL,\n" +
                            "  `users_id` INT NOT NULL,\n" +
                            "  `publications_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_permissions_users1_idx` (`users_id` ASC),\n" +
                            "  INDEX `fk_permissions_publications1_idx` (`publications_id` ASC),\n" +
                            "  CONSTRAINT `fk_permissions_users1`\n" +
                            "    FOREIGN KEY (`users_id`)\n" +
                            "    REFERENCES `tayanovskii`.`users` (`id`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE,\n" +
                            "  CONSTRAINT `fk_permissions_publications1`\n" +
                            "    FOREIGN KEY (`publications_id`)\n" +
                            "    REFERENCES `tayanovskii`.`publications` (`id`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE)\n" +
                            "ENGINE = InnoDB;"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
