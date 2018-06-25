package by.it.kasiyanov.jd03_02.crud;

import by.it.kasiyanov.jd03_02.beans.Roles;
import by.it.kasiyanov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudRoles {

    public boolean create(Roles roles) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO `roles`(`role`) VALUES ('%s')",
                    roles.getRole());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roles.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Roles read(long id) throws SQLException {
        Roles roles = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "SELECT `role` FROM `roles` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                roles = new Roles(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
            }
        }
        return roles;
    }

    public boolean update(Roles roles) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "UPDATE `roles` SET `role`='%s' WHERE id=%d",
                    roles.getRole(), roles.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Roles roles) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "DELETE FROM `roles` WHERE id=%d", roles.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
