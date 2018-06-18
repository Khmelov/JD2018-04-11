package by.it.kurmaz.jd03_02.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String dbURL = "jdbc:mysql://127.0.0.1:2016/kurmaz";
    //add unicode
    private static final String dbUser = "root";
    private static final String dbPassword = "";

    public static Connection returnConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try(Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
