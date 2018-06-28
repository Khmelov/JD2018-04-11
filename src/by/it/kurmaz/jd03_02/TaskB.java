package by.it.kurmaz.jd03_02;

import by.it.kurmaz.jd03_02.connection.dbConnection;
import java.sql.*;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM users INNER JOIN roles ON users.Roles_ID=roles.ID";
            ResultSet resultSet = statement.executeQuery(sql);
            int counter = 0;
            while (resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columns = metaData.getColumnCount();
                for (int i = 1; i < columns+1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + " = " + resultSet.getString(i) + " ");
                }
                counter++;
                System.out.println();
            }
            System.out.println("Users total: " + counter);

            sql = "SELECT * FROM admins INNER JOIN roles ON admins.Roles_ID=roles.ID";
            resultSet = statement.executeQuery(sql);
            counter = 0;
            while (resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columns = metaData.getColumnCount();
                for (int i = 1; i < columns+1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + " = " + resultSet.getString(i) + " ");
                }
                System.out.println();
                counter++;
            }
            System.out.println("Admins total: " + counter);

            sql = "SELECT COUNT(Roles) FROM roles";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next())
                System.out.println("Roles total: " + resultSet.getInt(1));

            sql = "SELECT * FROM users INNER JOIN address ON users.ID=address.Users_ID";
            resultSet = statement.executeQuery(sql);
            counter = 0;
            while (resultSet.next()){
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columns = metaData.getColumnCount();
                for (int i = 1; i < columns+1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + " = " + resultSet.getString(i) + " ");
                }
                System.out.println();
                counter++;
            }
            System.out.println("Addresses total: " + counter);
        }
    }
}
