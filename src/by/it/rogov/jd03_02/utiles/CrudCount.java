package by.it.rogov.jd03_02.utiles;

import by.it.rogov.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudCount {
    int countRole;
    public int readCountRole() throws SQLException {

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "SELECT COUNT(id) FROM `roles` ");
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                countRole = resultSet.getInt(1);
                return countRole;
            }
        }
        return 0;
    }
}
