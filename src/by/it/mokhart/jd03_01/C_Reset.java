package by.it.mokhart.jd03_01;

import java.sql.*;

public class C_Reset {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `mokhart`;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}