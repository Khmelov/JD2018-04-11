package by.it.kurmaz.project.java.resetDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {
    private static final String dbURL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String dbUser = "root";
    private static final String dbPassword = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        {
            try(Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                C_Init.initialize(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
