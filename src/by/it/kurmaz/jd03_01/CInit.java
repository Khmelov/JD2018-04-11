package by.it.kurmaz.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CInit {

    static final String dbURL = "jdbc:mysql://127.0.0.1:2016/";
    static final String dbUser = "root";
    static final String dbPassword = "";

    static {
        try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        Statement statement = connection.createStatement())

        {
            statement.execute("DROP SCHEMA IF EXISTS `kurmaz` ;");
            statement.execute("CREATE SCHEMA IF NOT EXISTS `kurmaz` DEFAULT CHARACTER SET utf8 ;");
            statement.execute("CREATE TABLE IF NOT EXISTS `kurmaz`.`Roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.execute("CREATE TABLE IF NOT EXISTS `kurmaz`.`Users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(100) NULL,\n" +
                    "  `Roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_Users_Roles_idx` (`Roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_Users_Roles`\n" +
                    "    FOREIGN KEY (`Roles_ID`)\n" +
                    "    REFERENCES `kurmaz`.`Roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.execute("CREATE TABLE IF NOT EXISTS `kurmaz`.`Ads` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Description` VARCHAR(500) NULL,\n" +
                    "  `Flat` INT NULL,\n" +
                    "  `Rooms` INT NULL,\n" +
                    "  `Square` DOUBLE NULL,\n" +
                    "  `Price` DOUBLE NULL,\n" +
                    "  `Address` VARCHAR(100) NULL,\n" +
                    "  `Users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_Ads_Users1_idx` (`Users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_Ads_Users1`\n" +
                    "    FOREIGN KEY (`Users_ID`)\n" +
                    "    REFERENCES `kurmaz`.`Users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
