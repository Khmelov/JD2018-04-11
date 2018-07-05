package by.it.shekh.project.java.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Loading driver error: " + e);
        }
    }

    private DbConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DbConnection.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASS);
                }
            }
        }
        return connection;
    }

}