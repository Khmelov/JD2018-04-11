package by.it.rogov.jd03_03.utiles;


import by.it.rogov.jd03_03.connection.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    public static void creatTables() throws SQLException {

        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `rogov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `rogov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `phone` INT NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `rogov`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`biblioteca` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `artaical1` VARCHAR(10000) NULL,\n" +
                    "  `artaical2` VARCHAR(10000) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`user_biblioteca` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `permission` INT NULL,\n" +
                    "  `biblioteca_ID` INT NOT NULL,\n" +
                    "  `update permission` INT NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_user_biblioteca_biblioteca1_idx` (`biblioteca_ID` ASC),\n" +
                    "  INDEX `fk_user_biblioteca_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_user_biblioteca_biblioteca1`\n" +
                    "    FOREIGN KEY (`biblioteca_ID`)\n" +
                    "    REFERENCES `rogov`.`biblioteca` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_user_biblioteca_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `rogov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB");
            System.out.println("Creat All Table");
        }

    }
}
