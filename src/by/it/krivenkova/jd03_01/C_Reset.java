package by.it.krivenkova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Reset {
    // static block to load driver
    public static void main(String[] args) {
    resetDB();
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void resetDB(){

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `krivenkova`;");
            System.out.println("Database successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
