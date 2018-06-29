package by.it.akhmelev.project06.java.connection;

import by.it.akhmelev.project06.java.connection.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    private static Connection connection;

    private DbConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DbConnection.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(by.it.akhmelev.project06.java.connection.CN.DB_URL, by.it.akhmelev.project06.java.connection.CN.DB_USER, CN.DB_PASSWORD);
                }
            }
        }
        return connection;
    }


}
