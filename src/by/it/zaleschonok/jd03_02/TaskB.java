package by.it.zaleschonok.jd03_02;

import by.it.zaleschonok.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {


        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String sql = "SELECT users.login, roles.role FROM users JOIN roles ON users.roles_id=roles.id";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf("%s - %s\n", resultSet.getString("login"), resultSet.getString("role"));
            }
            System.out.println();
            sql = "SELECT COUNT(*) FROM users";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("All users with roles: " + resultSet.getString(1));
            }
            sql = "SELECT COUNT(*) FROM roles";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("All roles: " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
