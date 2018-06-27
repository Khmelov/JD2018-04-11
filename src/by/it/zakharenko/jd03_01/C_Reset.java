package by.it.zakharenko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset{

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver:" + e);;
        }
    }

    public static void main(String[] args) {
        try(Connection connection =
                    DriverManager.getConnection
                            (CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
            Statement statement=connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zakharenko`");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
