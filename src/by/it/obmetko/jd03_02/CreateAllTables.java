package by.it.obmetko.jd03_02;

import by.it.obmetko.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAllTables {
    public static void main(String[] args) {
        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `obmetko` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `obmetko` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Roles` (" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "`Role` VARCHAR(405) NULL DEFAULT NULL,\n" +
                    "PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Buyers` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Buyers` (" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "`login` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "`password` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "`email` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "`roles_ID` INT(11) NOT NULL,\n" +
                    "PRIMARY KEY (`ID`),\n" +
                    "INDEX `fk_buyers_roles_idx` (`roles_ID` ASC),\n" +
                    "CONSTRAINT `fk_buyers_roles`\n" +
                    "FOREIGN KEY (`roles_ID`)\n" +
                    "REFERENCES `obmetko`.`roles` (`ID`)\n" +
                    "ON DELETE RESTRICT\n" +
                    "ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Catalog` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Catalog` (\n" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "`catalogName` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Category` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Category` (\n" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "`CategoryName` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "`catalog_ID` INT(11) NOT NULL,\n" +
                    "PRIMARY KEY (`ID`),\n" +
                    "INDEX `fk_Category_catalog1_idx` (`catalog_ID` ASC),\n" +
                    "CONSTRAINT `fk_Category_catalog1`\n" +
                    "FOREIGN KEY (`catalog_ID`)\n" +
                    "REFERENCES `obmetko`.`catalog` (`ID`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB \n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Books` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Books` (\n" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "`name` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "`author` VARCHAR(4000) NULL DEFAULT NULL,\n" +
                    "`price` DOUBLE NULL DEFAULT NULL,\n" +
                    "`Category_ID` INT(11) NOT NULL,\n" +
                    "PRIMARY KEY (`ID`),\n" +
                    "INDEX `fk_books_Category1_idx` (`Category_ID` ASC),\n" +
                    "CONSTRAINT `fk_books_Category1`\n" +
                    "FOREIGN KEY (`Category_ID`)\n" +
                    "REFERENCES `obmetko`.`category` (`ID`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`List of purchases` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`List of purchases` (\n" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "`buyers_ID` INT(11) NOT NULL,\n" +
                    "`books_ID` INT(11) NOT NULL,\n" +
                    "PRIMARY KEY (`ID`),\n" +
                    "INDEX `fk_list of purchases_buyers1_idx` (`buyers_ID` ASC),\n" +
                    "INDEX `fk_list of purchases_books1_idx` (`books_ID` ASC),\n" +
                    "CONSTRAINT `fk_list of purchases_books1`\n" +
                    "FOREIGN KEY (`books_ID`)\n" +
                    "REFERENCES `obmetko`.`books` (`ID`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION,\n" +
                    "CONSTRAINT `fk_list of purchases_buyers1`\n" +
                    "FOREIGN KEY (`buyers_ID`)\n" +
                    "REFERENCES `obmetko`.`buyers` (`ID`)\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("INSERT INTO `obmetko`.`catalog` (`ID`, `catalogName`) VALUES (DEFAULT, 'каталог книг');");
            statement.executeUpdate("INSERT INTO `obmetko`.`catalog` (`ID`, `catalogName`) VALUES (DEFAULT, 'каталог манги и комиксов');");
            statement.executeUpdate("INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'художественная', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'программирование', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'комиксы', 2);");
            statement.executeUpdate("INSERT INTO `obmetko`.`category` (`ID`, `CategoryName`, `catalog_ID`) VALUES (DEFAULT, 'манга', 2);");
            statement.executeUpdate("INSERT INTO `obmetko`.`books` (`ID`, `name`, `author`, `price`, `Category_ID`) VALUES (DEFAULT, 'Ведьмак', 'Анжей Сапковский', '100', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`books` (`ID`, `name`, `author`, `price`, `Category_ID`) VALUES (DEFAULT, 'Java для начинающих. Объектно-ориентированный подход', 'Барт Бэзинс', '55', 2);");
            statement.executeUpdate("INSERT INTO `obmetko`.`books` (`ID`, `name`, `author`, `price`, `Category_ID`) VALUES (DEFAULT, 'Тор. Бог грома', 'Джейсон Аарон', '49', 3);");
            statement.executeUpdate("INSERT INTO `obmetko`.`books` (`ID`, `name`, `author`, `price`, `Category_ID`) VALUES (DEFAULT, 'Волчица и пряности. Том 1', 'Исуна Хасэкура', '18', 4);");
            statement.executeUpdate("INSERT INTO `obmetko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `obmetko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'buyer');");
            statement.executeUpdate("INSERT INTO `obmetko`.`buyers` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'admin', 'admin@tut.by', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`buyers` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'user', 'user', 'user@tut.by', 2);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}