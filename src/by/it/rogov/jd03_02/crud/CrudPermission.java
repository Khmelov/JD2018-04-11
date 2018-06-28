package by.it.rogov.jd03_02.crud;

import by.it.rogov.jd03_02.beans.Permission;
import by.it.rogov.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;


public class CrudPermission {


    public Permission read(long id) throws SQLException {
        Permission permission = null;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "SELECT `ID`, `pemissionAccess`, `permissionUpdate`, `users_ID`, `labrary_ID` FROM `permission` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                permission = new Permission(
                        resultSet.getLong("id"),
                        resultSet.getInt("pemissionAccess"),
                        resultSet.getInt("permissionUpdate"),
                        resultSet.getLong("users_ID"),
                        resultSet.getLong("labrary_ID")
                );
            }
        }
        return permission;
    }


    public boolean create(Permission permission) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"INSERT INTO `permission`( `pemissionAccess`, `permissionUpdate`, `users_ID`, `labrary_ID`) " +
                            "VALUES (%d,%d,%d,%d)",
                    permission.isPemissionAccess(),permission.isPermissionUpdate(),permission.getUsers_id(),permission.getLibrary_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    permission.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Permission permission) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `permission` SET `pemissionAccess`=%d,`permissionUpdate`=%d,`users_ID`=%d,`labrary_ID`=%d " +
                            "WHERE id=%d",
                    permission.isPemissionAccess(),permission.isPermissionUpdate(),permission.getUsers_id(),permission.getLibrary_id(),permission.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Permission permission) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `permission` WHERE id=%d",
                    permission.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
