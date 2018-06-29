package by.it.kurmaz.project.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    static {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private dbConnection() {}

    private static final String dbURL = "jdbc:mysql://127.0.0.1:2016/kurmaz" + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String dbUser = "root";
    private static final String dbPassword = "";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (dbConnection.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                }
            }
        }
        return connection;
    }
}
