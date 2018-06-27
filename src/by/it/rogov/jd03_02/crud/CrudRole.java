package by.it.rogov.jd03_02.crud;

import by.it.rogov.jd03_02.beans.Role;
import by.it.rogov.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudRole {



    public Role read(long id) throws SQLException {
        Role role = null;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "SELECT `ID`, `role` FROM `roles` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                role = new Role(
                        resultSet.getLong("ID"),
                        resultSet.getString("role")
                );
            }
        }
        return role;
    }


    public boolean create(Role role) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "INSERT INTO `roles` ( `role`) " +
                            "VALUES ( '%s')",
                    role.getRole());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Role role) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `roles` SET `role`='%s' " +
                            "WHERE id=%d",
                    role.getRole(), role.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Role role) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `roles` WHERE id=%d", role.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }


}
