package by.it.tayanovskii.project.java.dao.resetdb;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Init {


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

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            //пересоздание базы целиком
            statement.executeUpdate("DROP SCHEMA IF EXISTS `tayanovskii` ;");
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
            //заполнение строками
            statement.executeUpdate("INSERT INTO `tayanovskii`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `tayanovskii`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");


            statement.executeUpdate("INSERT INTO `tayanovskii`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `tayanovskii`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@gmail.com', 2);");

            statement.executeUpdate("INSERT INTO `tayanovskii`.`publications` (`id`, `title`, `number`, `date`, `description`, `price`) VALUES (DEFAULT, 'Пожарная безопасность', 1, '2018-06-10', 'Контроль за пожарной безопасностью на предприятии', 10.0);");
            statement.executeUpdate("INSERT INTO `tayanovskii`.`publications` (`id`, `title`, `number`, `date`, `description`, `price`) VALUES (DEFAULT, 'Охрана труда', 3, '2018-05-01', 'Контроль за охраной труда на государсвенных предприятиях', 15.3);");

            statement.executeUpdate("INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 1, 1);");
            statement.executeUpdate("INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 1, 2);");
            statement.executeUpdate("INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, true, 2, 1);");
            statement.executeUpdate("INSERT INTO `tayanovskii`.`permissions` (`id`, `access`, `users_id`, `publications_id`) VALUES (DEFAULT, false, 2, 2);");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
