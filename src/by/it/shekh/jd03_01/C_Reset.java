package by.it.shekh.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Loading driver error: " + e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(
                             CN.DB_URL, CN.DB_USER, CN.DB_PASS);
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("use shekh;");
            statement.executeUpdate("DROP TABLE facade_pictures;");//and so on naming tables
            statement.executeUpdate("DROP SCHEMA IF EXISTS `shekh`;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
