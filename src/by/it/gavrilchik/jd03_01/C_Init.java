package by.it.gavrilchik.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static final String DB_URL ="jdbc:mysql://127.0.0.1:2016/";
    static final String DB_USER ="root";
    static final String DB_PASSWORD ="";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

       public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()
        )
        {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `gavrilchik` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `gavrilchik` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `gavrilchik`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `gavrilchik`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `gavrilchik`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `gavrilchik`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(5000) NULL,\n" +
                    "  `flat` INT NULL,\n" +
                    "  `flats` INT NULL,\n" +
                    "  `rooms` INT NULL,\n" +
                    "  `area` DOUBLE NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `address` VARCHAR(1000) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `gavrilchik`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `gavrilchik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `gavrilchik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');\n");
            statement.executeUpdate("INSERT INTO `gavrilchik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');\n");
            statement.executeUpdate("INSERT INTO `gavrilchik`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);\n");
            statement.executeUpdate("INSERT INTO `gavrilchik`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);\n");
            statement.executeUpdate("INSERT INTO `gavrilchik`.`ads` (`id`, `description`, `flat`, `flats`, `rooms`, `area`, `price`, `address`, `users_id`) VALUES (DEFAULT, 'Test appartment', 1, 5, 2, 44, 66666, 'Minsk Lenina 1, app 1', 2);\n");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
