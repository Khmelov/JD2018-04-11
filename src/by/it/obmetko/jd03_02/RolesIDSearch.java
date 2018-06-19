package by.it.obmetko.jd03_02;

import by.it.obmetko.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RolesIDSearch {

    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet roles = statement.executeQuery("SELECT * FROM `roles`");

            System.out.println("Введите имя роли для поиска: ");
            Scanner scanner = new Scanner(System.in);
            String roleName = scanner.nextLine();
            while (roles.next())
                if (roleName.equals(roles.getString("role")))
                    System.out.println(roles.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}