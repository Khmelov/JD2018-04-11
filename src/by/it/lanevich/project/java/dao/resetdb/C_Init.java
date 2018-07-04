package by.it.lanevich.project.java.dao.resetdb;


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
            statement.executeUpdate("DROP SCHEMA IF EXISTS `lanevich` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `lanevich` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lanevich`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lanevich`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `phone` VARCHAR(13) NULL,\n" +
                    "  `address` VARCHAR(200) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `lanevich`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate(" CREATE TABLE IF NOT EXISTS `lanevich`.`goods` (\n" +
                    " `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    " `idgood` INT NULL,\n" +
                    " `goodname` VARCHAR(45) NULL,\n" +
                    " `description` VARCHAR(700) NULL,\n" +
                    " `piecies` INT NULL,\n" +
                    " `price` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "  ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lanevich`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `ord_id` INT NULL,\n" +
                    "  `numgood` INT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `goods_id` INT NOT NULL,\n" +
                    "   PRIMARY KEY (`id`),\n" +
                    "   INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                    "   INDEX `fk_orders_goods1_idx` (`goods_id` ASC),\n" +
                    "   CONSTRAINT `fk_orders_users1`\n" +
                    "   FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `lanevich`.`users` (`id`)\n" +
                    "     ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "     CONSTRAINT `fk_orders_goods1`\n" +
                    "    FOREIGN KEY (`goods_id`)\n" +
                    "   REFERENCES `lanevich`.`goods` (`id`)\n" +
                    "   ON DELETE RESTRICT\n" +
                    "   ON UPDATE RESTRICT)\n" +
                    "   ENGINE = InnoDB;");



            statement.executeUpdate("INSERT INTO `lanevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `lanevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `lanevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `lanevich`.`users` (`id`, `login`, `password`, `email`, `phone`, `address`, `roles_id`) VALUES (DEFAULT, 'lanevich   ', '1234567', 'lanevich@gmail.com', '375295755656', 'Minsk', 1);");
            statement.executeUpdate("INSERT INTO `lanevich`.`users` (`id`, `login`, `password`, `email`, `phone`, `address`, `roles_id`) VALUES (DEFAULT, 'ivanova', '12345678', 'ivanova@mail.ru', '375294567812', 'Minsk, Lenina street, 40 кв.123', 2);");
            statement.executeUpdate("INSERT INTO `lanevich`.`users` (`id`, `login`, `password`, `email`, `phone`, `address`, `roles_id`) VALUES (DEFAULT, 'petrova', 'qwerty', 'petrova@mail.ru', '375294456785', '375294456785', 2);");
            statement.executeUpdate("INSERT INTO `lanevich`.`users` (`id`, `login`, `password`, `email`, `phone`, `address`, `roles_id`) VALUES (DEFAULT, 'sidorova', '123qwer', 'sidorova@mail.ru', '375294845124', 'Minsk, Bogdanovicha street, 168 кв.130', 2);");
            statement.executeUpdate("INSERT INTO `lanevich`.`goods` (`id`, `idgood`, `goodname`, `description`, `piecies`, `price`) VALUES (DEFAULT, 411511, 'Mulan\\'s Training Day', 'LEGO® l Disney Mulan’s Training Day is easy to build and perfect for recreating favorite moments from the movie.', 104, 15);");
            statement.executeUpdate("INSERT INTO `lanevich`.`goods` (`id`, `idgood`, `goodname`, `description`, `piecies`, `price`) VALUES (DEFAULT, 108581, 'My First Puzzle Pets', 'Help your child build these colorful 3-D puzzles out of chunky LEGO® DUPLO® bricks. Preschoolers will love sorting these baby bricks into 3 different colors, and seeing what animal they can build in each color. Use the decorated bricks to start stories and develop language as they learn what different pets like to eat. DUPLO bricks are specially designed to be fun and safe for small hands', 18, 10);");
            statement.executeUpdate("INSERT INTO `lanevich`.`goods` (`id`, `idgood`, `goodname`, `description`, `piecies`, `price`) VALUES (DEFAULT, 301161, 'Rapunzel\\'s Market Visit', NULL, 37, 4);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
