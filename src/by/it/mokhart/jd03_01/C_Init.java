package by.it.mokhart.jd03_01;

import java.sql.*;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `mokhart` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `mokhart` DEFAULT CHARACTER SET utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mokhart`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mokhart`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `mokhart`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mokhart`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(100) NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `size` VARCHAR(6) NULL,\n" +
                    "  `fabric` VARCHAR(45) NULL,\n" +
                    "  `colour` VARCHAR(45) NULL,\n" +
                    "  `sex` VARCHAR(5) NULL,\n" +
                    "  `producer` VARCHAR(45) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `mokhart`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            // Roles table
            statement.execute("INSERT INTO `mokhart`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Admin');");
            statement.execute("INSERT INTO `mokhart`.`roles` (`id`, `role`) VALUES (DEFAULT, 'User');");
            statement.execute("INSERT INTO `mokhart`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Guest');;");

            // Users table
            statement.execute("INSERT INTO `mokhart`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);\n");
            statement.execute("INSERT INTO `mokhart`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);\n");

            // Ads table
            statement.execute("INSERT INTO `mokhart`.`ads` (`id`, `description`, `price`, `size`, `fabric`, `colour`, `sex`, `producer`, `users_id`) VALUES (DEFAULT, 'Jeans', 112.5, 'M', 'jeans', 'blue', 'Male', 'Lewice', 2);\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}