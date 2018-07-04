package by.it.kasiyanov.project.java.dao.resetdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static final String dbUrl = "jdbc:mysql://127.0.0.1:2016/";
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
        try (
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kasiyanov` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kasiyanov` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kasiyanov`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kasiyanov`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `kasiyanov`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kasiyanov`.`travelOffers` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Description` VARCHAR(5000) NULL,\n" +
                    "  `TypeOfTravel` VARCHAR(50) NULL,\n" +
                    "  `Destination` VARCHAR(50) NULL,\n" +
                    "  `Hotel` VARCHAR(50) NULL,\n" +
                    "  `LevelOfAccommodation` VARCHAR(50) NULL,\n" +
                    "  `NumberOfNights` INT NULL,\n" +
                    "  `Price` DOUBLE NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_trawelOffers_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_trawelOffers_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `kasiyanov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `kasiyanov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `kasiyanov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'TravelAgent');");
            statement.executeUpdate("INSERT INTO `kasiyanov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Buyer');");
            statement.executeUpdate("INSERT INTO `kasiyanov`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);");
            statement.executeUpdate("INSERT INTO `kasiyanov`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'travelAgent', 'ptravelAgent', 'travelAgent@it.by', 2);");
            statement.executeUpdate("INSERT INTO `kasiyanov`.`travelOffers` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `LevelOfAccommodation`, `NumberOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'Magnificent sandy beaches', 'Holiday', 'Malta', 'Hilton', '5 Stars', 7, 445.0, 2);");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
