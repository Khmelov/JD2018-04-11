package by.test.SCAND.java.dao.resetDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {

        static final String DBURL = "jdbc:mysql://127.0.0.1:2016/"
                + "?useUnicode=true&characterEncoding=UTF-8";
        static final String DBUSER = "root";
        static final String PASS = "";

        static {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Error loading driver: " + e);
            }
        }


        public static void main(String[] args) {
            try (Connection connection = DriverManager.getConnection(DBURL, DBUSER, PASS);
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("DROP SCHEMA IF EXISTS `shopdb` ;");
                statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `shopdb` DEFAULT CHARACTER SET utf8 ;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `shopdb`.`clients` (\n" +
                        "  `idclients` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `roles` VARCHAR(45) NULL,\n" +
                        "  PRIMARY KEY (`idclients`))\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `shopdb`.`user` (\n" +
                        "  `iduser` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` VARCHAR(45) NULL,\n" +
                        "  `address` VARCHAR(45) NULL,\n" +
                        "  `phone` VARCHAR(45) NULL,\n" +
                        "  `clients_idclients` INT NOT NULL,\n" +
                        "  PRIMARY KEY (`iduser`),\n" +
                        "  INDEX `fk_user_clients_idx` (`clients_idclients` ASC),\n" +
                        "  CONSTRAINT `fk_user_clients`\n" +
                        "    FOREIGN KEY (`clients_idclients`)\n" +
                        "    REFERENCES `shopdb`.`clients` (`idclients`)\n" +
                        "    ON DELETE RESTRICT\n" +
                        "    ON UPDATE RESTRICT)\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `shopdb`.`goods` (\n" +
                        "  `idgoods` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` VARCHAR(45) NULL,\n" +
                        "  `description` VARCHAR(1500) NULL,\n" +
                        "  `price` DOUBLE NULL,\n" +
                        "  `photo` MEDIUMBLOB NULL,\n" +
                        "  `user_iduser` INT NOT NULL,\n" +
                        "  PRIMARY KEY (`idgoods`),\n" +
                        "  INDEX `fk_goods_user1_idx` (`user_iduser` ASC),\n" +
                        "  CONSTRAINT `fk_goods_user1`\n" +
                        "    FOREIGN KEY (`user_iduser`)\n" +
                        "    REFERENCES `shopdb`.`user` (`iduser`)\n" +
                        "    ON DELETE CASCADE\n" +
                        "    ON UPDATE CASCADE)\n" +
                        "ENGINE = InnoDB;");

                statement.executeUpdate("INSERT INTO " +
                        "`shopdb`.`clients`(`idclients`, `roles`) " +
                        "VALUES (DEFAULT,'ADMIN')");
                statement.executeUpdate("INSERT INTO " +
                        "`shopdb`.`clients`(`idclients`, `roles`) " +
                        "VALUES (DEFAULT,'GUEST')");
                statement.executeUpdate("INSERT INTO " +
                        "`shopdb`.`user`(`iduser`, `name`, `address`, `phone`, `clients_idclients`) " +
                        "VALUES (DEFAULT,'Admin','Admin','Admin',1)");
                statement.executeUpdate("INSERT INTO " +
                        "`shopdb`.`goods`(`idgoods`, `name`, `description`, `price`, `photo`, `user_iduser`) " +
                        "VALUES (DEFAULT,'Пылесос','Пылесос Panasonic MC-E863 Сухая уборка\n" +
                        "Индикатор заполнения пылесборника\n" +
                        "Потребляемая мощность 1400 Вт',2000,'4',1)");
            } catch (Exception e) {
                System.out.println(e);
            }
        }


}


