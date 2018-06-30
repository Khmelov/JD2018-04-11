package by.it.shekh.jd03_02.crud;

import by.it.shekh.jd03_02.beans.Role;
import by.it.shekh.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudRole {
    public boolean create(Role role) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO " +
                            " roles (role) " +
                            " VALUES ('%s')", role.getRole());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId_roles(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Role read(long id) throws SQLException {
        Role role = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "SELECT 'id_roles', 'role' FROM 'roles'" +
                            "WHERE 'id_roles'=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                role = new Role(
                        resultSet.getLong("id_roles"),
                        resultSet.getString("role")
                );
            }
        }
        return role;
    }

    public boolean update(Role role) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE 'roles'" +
                            "SET 'role'=%s WHERE 'id_roles'=%d",
                    role.getRole(), role.getId_roles());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Role role) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM 'roles' WHERE 'id_roles'=%d",
                    role.getId_roles());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
