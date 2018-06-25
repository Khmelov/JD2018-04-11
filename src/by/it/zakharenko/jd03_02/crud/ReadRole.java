package by.it.zakharenko.jd03_02.crud;

import by.it.zakharenko.jd03_02.beans.Role;
import by.it.zakharenko.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ReadRole {

    public Role read(long id) throws SQLException {
        Role role = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "" +
                            "SELECT * FROM `roles` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
            }
        }
        return role;
    }

    public long getID(String role) throws SQLException {
        long id = -1;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "" +
                    "SELECT * FROM `roles` WHERE role='%s'", role);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next())
                id = resultSet.getLong("id");
        }
        return id;
    }
}
