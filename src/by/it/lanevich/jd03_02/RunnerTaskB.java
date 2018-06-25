package by.it.lanevich.jd03_02;

import by.it.lanevich.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;



public class RunnerTaskB {
    public static void main(String[] args) throws SQLException {

        String sql = String.format(Locale.US,
                "SELECT users.id, users.login, roles.role "+
                        "FROM users, roles WHERE roles.id=users.roles_id");
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            int counter = 0;
            while (resultSet.next()) {
                String txt = "Пользователь id " +
                        resultSet.getString("users.id") + ":\t" +
                        resultSet.getString("users.login") + " : " +
                        resultSet.getString("roles.role");
                System.out.println(txt);
                counter++;
            }
            System.out.println("Всего пользователей в базе: " + counter);
            sql = "SELECT COUNT(Role) FROM roles";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next())
                System.out.println("Всего возможных ролей: " + resultSet.getInt(1));

        }



    }

}
