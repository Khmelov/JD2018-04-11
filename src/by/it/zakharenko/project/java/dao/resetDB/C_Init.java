package by.it.zakharenko.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (
                Connection connection =
                        DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zakharenko` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zakharenko` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharenko`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharenko`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zakharenko`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharenko`.`books` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(100) NULL,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `author` VARCHAR(45) NULL,\n" +
                    "  `genre` VARCHAR(45) NULL,\n" +
                    "  `pages` INT NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_books_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_books_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `zakharenko`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Dima', '123984ytf', 'dima12345@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Anna', 'anna678', 'anna3928@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`books` (`id`, `description`, `name`, `author`, `genre`, `pages`, `price`, `users_id`)" +
                    " VALUES (DEFAULT, 'A fascinating detective for fans of this genre!', 'The Adventures of Sherlock Holmes', 'George Newnes', 'Detective story', 307, 79, 2);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`books` (`id`, `description`, `name`, `author`, `genre`, `pages`, `price`, `users_id`)" +
                    " VALUES (DEFAULT, 'A good book about love!', 'Pride and Prejudice', 'Jane Austen', 'Novel', 416, 193, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}