package by.it.kasiyanov.jd03_02;


import by.it.kasiyanov.jd03_02.connection.DbConnection;
import java.sql.*;


import java.sql.SQLException;

public class TaskB {
   public static void main(String[] args) {
       try (
               Connection connection = DbConnection.getConnection();
               Statement statement = connection.createStatement()
       ){
           ResultSet resultSet = statement.executeQuery("SELECT users.login, roles.role FROM users INNER JOIN roles ON users.roles_id=roles.id");
           while (resultSet.next()) {
               System.out.printf("%s = %s\n", resultSet.getString("login"), resultSet.getString("role"));
           }
           System.out.println();
           resultSet = statement.executeQuery("SELECT COUNT(*) FROM users ");
           while (resultSet.next()) {
               System.out.println("Number of users: " + resultSet.getString(1));
           }
           resultSet = statement.executeQuery("SELECT COUNT(*) FROM roles ");
           while (resultSet.next()) {
               System.out.println("Number of roles: " + resultSet.getString(1));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

    }
}
