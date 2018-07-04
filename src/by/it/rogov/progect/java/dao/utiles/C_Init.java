package by.it.rogov.progect.java.dao.utiles;






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


    public static void creatTables() throws SQLException {

        try(Connection connection=
                    DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement=connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `rogov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `rogov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `rogov`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`labrary` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `textFree` VARCHAR(10000) NULL,\n" +
                    "  `textPay` VARCHAR(10000) NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_labrary_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_labrary_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `rogov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`permission` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `pemissionAccess` INT NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_permission_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_permission_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `rogov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
    statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administator')");
    statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'User')");
    statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Guest')");
    statement.executeUpdate("INSERT INTO `rogov`.`users` (`ID`, `login`, `password`, `email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'pasadmin', 'admin@mail@ru', 1)");
            System.out.println("Create All Table");
        }

    }
}
