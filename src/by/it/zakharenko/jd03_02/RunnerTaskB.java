package by.it.zakharenko.jd03_02;

import by.it.zakharenko.jd03_02.connection.DbConnection;
import java.sql.*;
import java.util.Locale;

public class RunnerTaskB {

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "" +
                    "SELECT * FROM `users` INNER JOIN `roles` ON users.roles_id=roles.id");
            ResultSet resultSet = statement.executeQuery(sql);
            int count=0;
            while (resultSet.next())
            {
                count++;
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i < columnCount+1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "  ");
                }
                System.out.println();
            }
            sql = String.format(Locale.US, "" +
                    "SELECT COUNT(*) FROM `roles`");
            resultSet = statement.executeQuery(sql);
            int countOfRoles=-1;
            if(resultSet.next())
                countOfRoles=resultSet.getInt(1);
            System.out.println("Count of users: " + count + " " + "\n" + "Count of possible roles: " + countOfRoles);
        }
    }
}
