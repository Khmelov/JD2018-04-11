package by.it.rogov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {

            // drop schema and create new schema and new date
            statement.executeUpdate("DROP SCHEMA IF EXISTS `rogov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `rogov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `Phone` INT NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
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
                    "  `permission` TINYINT(1) NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  `biblioteca_ID` INT NOT NULL,\n" +
                    "  `update permission` TINYINT(1) NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_user_biblioteca_users1_idx` (`users_ID` ASC),\n" +
                    "  INDEX `fk_user_biblioteca_biblioteca1_idx` (`biblioteca_ID` ASC),\n" +
                    "  CONSTRAINT `fk_user_biblioteca_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `rogov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_user_biblioteca_biblioteca1`\n" +
                    "    FOREIGN KEY (`biblioteca_ID`)\n" +
                    "    REFERENCES `rogov`.`biblioteca` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administator')");
            statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'User')");
            statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Guest')");
            statement.executeUpdate("INSERT INTO `rogov`.`users` (`ID`, `Login`, `Password`, `Email`, `Phone`, `roles_ID`) VALUES (DEFAULT, 'admin', 'pasadmin', 'admin@mail@ru', 123456, 1)");
            statement.executeUpdate("INSERT INTO `rogov`.`users` (`ID`, `Login`, `Password`, `Email`, `Phone`, `roles_ID`) VALUES (DEFAULT, 'user', 'pasuser', 'user@mail.ru', 234567, 2)");
            statement.executeUpdate("INSERT INTO `rogov`.`biblioteca` (`ID`, `artaical1`, `artaical2`) VALUES (DEFAULT, 'some text', 'some text2')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
