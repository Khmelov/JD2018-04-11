package by.it.obmetko.project.java.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropAllTables {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (
                Connection connection =
                        DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate("USE obmetko");
            statement.executeUpdate("DROP TABLE IF EXISTS `List of purchases` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Books` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Category` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Catalog` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Roles` ;");

            // удаление всей БД сразу
            // statement.executeUpdate("DROP DATABASE `obmetko` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}