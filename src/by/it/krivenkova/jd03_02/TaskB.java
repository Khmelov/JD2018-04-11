package by.it.krivenkova.jd03_02;

import by.it.krivenkova.jd03_02.connection.DbConnection;

import java.sql.*;

public class TaskB {
    private static int userCount = 0;

    public static void main(String[] args) {
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = "SELECT * FROM users INNER JOIN roles ON users.roles_id=roles.id;";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                userCount++;
                ResultSetMetaData meta = result.getMetaData();
                int columnCount = meta.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%s: %-15s\t", meta.getColumnLabel(i), result.getString(i));
                }
                System.out.println();
            }
            System.out.println("Total users: " + userCount);
            result = statement.executeQuery("SELECT COUNT(ID) FROM roles;");
            if (result.next()) {
                System.out.println("Number of possible roles: " + result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
