package by.it.zaleschonok.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init{

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        createDB();

    }

    public static void createDB(){
        try (
                Connection connection =
                        DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zaleschonok` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zaleschonok` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zaleschonok`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zaleschonok`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zaleschonok`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zaleschonok`.`goods` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `product` VARCHAR(100) NULL,\n" +
                    "  `price` INT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zaleschonok`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `amount` INT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `goods_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_orders_goods1_idx` (`goods_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `zaleschonok`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_orders_goods1`\n" +
                    "    FOREIGN KEY (`goods_id`)\n" +
                    "    REFERENCES `zaleschonok`.`goods` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");



            statement.executeUpdate("INSERT INTO `zaleschonok`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Admin');");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`roles` (`id`, `role`) VALUES (DEFAULT, 'User');");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`users` (`id`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'UserVasia', 'passVasia', 1);");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`users` (`id`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'UserPetya', 'passPertya', 2);");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`goods` (`id`, `product`, `price`) VALUES (DEFAULT, 'Product100', 100);");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`goods` (`id`, `product`, `price`) VALUES (DEFAULT, 'Product200', 200);");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`orders` (`id`, `amount`, `users_id`, `goods_id`) VALUES (DEFAULT, 1, 1, 1);");
            statement.executeUpdate("INSERT INTO `zaleschonok`.`orders` (`id`, `amount`, `users_id`, `goods_id`) VALUES (DEFAULT, 2, 2, 2);");

            System.out.println("Database successfully created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
