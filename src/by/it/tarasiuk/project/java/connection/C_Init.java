package by.it.tarasiuk.project.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    static void db_init() {
        try (Connection connection =
                     DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `tarasiuk` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `tarasiuk` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `tarasiuk`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(10) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `tarasiuk`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `tarasiuk`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `tarasiuk`.`adverts` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `brand` VARCHAR(20) NULL,\n" +
                    "  `model` VARCHAR(20) NULL,\n" +
                    "  `year` YEAR NULL,\n" +
                    "  `type` VARCHAR(20) NULL,\n" +
                    "  `grade` VARCHAR(20) NULL,\n" +
                    "  `color` VARCHAR(20) NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `description` VARCHAR(2500) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_adverts_users_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_adverts_users`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `tarasiuk`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `tarasiuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `tarasiuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `tarasiuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `tarasiuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@admin.com', 1);");
            statement.executeUpdate("INSERT INTO `tarasiuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Nick', '123321', 'nick98@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `tarasiuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'ZiZi', 'qwerty', 'zohan@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `tarasiuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'ololoshka321', 'fghffh03', 'Lucy01@ya.ru', 2);");
            statement.executeUpdate("INSERT INTO `tarasiuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'watcher1', '321', 'watcher@tut.by', 3);");

            statement.executeUpdate("INSERT INTO `tarasiuk`.`adverts` (`id`, `brand`, `model`, `year`, `type`, `grade`, `color`, `price`, `description`, `users_id`) " +
                    "VALUES (DEFAULT, 'AIST', 'Turbo', 2017, 'adult', 'highway', 'blue', 300, 'Good bike!', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}