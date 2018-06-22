package by.it.obmetko.jd03_03.helper;

import by.it.obmetko.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropAllTables {
    public static void main(String[] args) {
        try (Connection connection = DbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE obmetko");
            statement.executeUpdate("DROP TABLE IF EXISTS `List of purchases` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Books` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Category` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Catalog` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Buyers` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `Roles` ;");

            // удаление всей БД сразу
            // statement.executeUpdate("DROP DATABASE `obmetko` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}