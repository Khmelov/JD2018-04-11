package by.it.shekh.project.java.dao.resetdb;

import by.it.shekh.project.java.connection.CN;
import by.it.shekh.project.java.connection.DbConnection;

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
                Connection connection = DriverManager.getConnection(CN.DB_URL,CN.DB_USER,CN.DB_PASS);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP DATABASE IF EXISTS `shekh`");
            statement.executeUpdate("create database `shekh` DEFAULT CHARSET utf8");
            statement.executeUpdate("use `shekh`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `facade_general` (\n" +
                    "  `id_facade` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `facade_name` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `facade_dimensions` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `facade_description` MEDIUMTEXT NULL DEFAULT NULL,\n" +
                    "  `facade_price` DOUBLE NULL DEFAULT NULL,\n" +
                    "  `facade_specs` VARCHAR(255) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id_facade`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `facade_pictures` (\n" +
                    "`id_pictures` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `picture_path` VARCHAR(255) NULL DEFAULT NULL,\n" +
                    "  `id_facade` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id_pictures`),\n" +
                    "  INDEX `fk_facade_pictures_facade_general1_idx` (`id_facade` ASC),\n" +
                    "  CONSTRAINT `fk_facade_pictures_facade_general1`\n" +
                    "    FOREIGN KEY (`id_facade`)\n" +
                    "    REFERENCES `shekh`.`facade_general` (`id_facade`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "    ENGINE = InnoDB\n" +
                    "    DEFAULT CHARACTER SET = utf8;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `roles` (\n" +
                    "  `id_roles` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL DEFAULT 'user',\n" +
                    "  PRIMARY KEY (`id_roles`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `users` (\n" +
                    "`id_users` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `id_roles` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id_users`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`id_roles` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`id_roles`)\n" +
                    "    REFERENCES `shekh`.`roles` (`id_roles`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "    ENGINE = InnoDB\n" +
                    "    AUTO_INCREMENT = 1\n" +
                    "    DEFAULT CHARACTER SET = utf8;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `orders` (\n" +
                    "  `idOrders` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` DATE NULL DEFAULT NULL,\n" +
                    "  `id_users` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`idOrders`),\n" +
                    "  INDEX `fk_Orders_users1_idx` (`id_users` ASC),\n" +
                    "  CONSTRAINT `fk_Orders_users1`\n" +
                    "    FOREIGN KEY (`id_users`)\n" +
                    "    REFERENCES `shekh`.`users` (`id_users`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `facade_orders` (\n" +
                    "  `idfacade_order` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `id_facade` INT(11) NOT NULL,\n" +
                    "  `idOrders` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`idfacade_order`),\n" +
                    "  INDEX `fk_facade_orders_facade_general_idx` (`id_facade` ASC),\n" +
                    "  INDEX `fk_facade_orders_Orders1_idx` (`idOrders` ASC),\n" +
                    "  CONSTRAINT `fk_facade_orders_Orders1`\n" +
                    "    FOREIGN KEY (`idOrders`)\n" +
                    "    REFERENCES `shekh`.`orders` (`idOrders`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_facade_orders_facade_general`\n" +
                    "    FOREIGN KEY (`id_facade`)\n" +
                    "    REFERENCES `shekh`.`facade_general` (`id_facade`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "    ENGINE = InnoDB\n" +
                    "    DEFAULT CHARACTER SET = utf8;");

            statement.executeUpdate("INSERT INTO `roles` (`id_roles`, `role`) VALUES\n" +
                    "(1, 'admin'),\n" +
                    "(2, 'user');");

            statement.executeUpdate("insert into `users`(`login`,`password`,`email`, `id_roles`) values\n" +
                    "('mainadmin', 'qwerty', 'admin1@mysites.by', 1),\n " +
                    "('Nikita', 'mybirth_111197', 'nikita11@tut.by', 2),\n" +
                    "('xacker0909', 'unknownpass', 'topboy@gmail.com', 2),\n" +
                    "('test', '11111', 'test@tester.by', 2);\n");

            statement.executeUpdate("INSERT INTO `facade_general` (`id_facade`, `facade_name`, `facade_dimensions`, `facade_description`, `facade_price`, `facade_specs`) VALUES\n" +
                    "(1, 'Retro', '1x1 m2', 'MDF facade', 131.15, 'Best facade for now'),\n" +
                    "(2, 'Nord', '1 m2', 'Cutted mdf facade', 140.11, 'Beautiful and colourful'),\n" +
                    "(3, 'Sicily', '1x1 m2', 'Oak facade', 145.1, 'aaaa'),\n" +
                    "(4, 'name1', '1x1 m2', 'description1', 130, '44'),\n" +
                    "(5, 'name3', '1x1 m2', 'description4', 130.05, '44asda'),\n" +
                    "(6, 'name', '1x1 m2', 'description', 130, '44'),\n" +
                    "(7, 'Facade5', '1x1 m2', 'descriptiondfs', 130, '44'),\n" +
                    "(8, 'Facade6', '1x1 m2', 'description', 130, '44');");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
