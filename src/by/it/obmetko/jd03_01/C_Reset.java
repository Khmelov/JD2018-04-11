package by.it.obmetko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class C_Reset {
    public static void main(String[] args) {
        try {
           Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       try (Connection connection =
                     DriverManager.getConnection(Connect.URL_DB, Connect.USER_DB, Connect.PASSWORD_DB)) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`List of purchases` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Books` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Category` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Catalog` ;");
           statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Buyers` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Roles` ;");
//            statement.executeUpdate("DROP SCHEMA IF EXISTS `obmetko` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}