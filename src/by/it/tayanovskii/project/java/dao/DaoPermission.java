package by.it.tayanovskii.project.java.dao;

import by.it.tayanovskii.project.java.beans.Permission;
import by.it.tayanovskii.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoPermission extends AbstractDao implements InterfaceDAO<Permission> {
    @Override
    public Permission read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Permission permission) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `permissions`(`access`, `users_id`, `publications_id`) VALUES (%b,%d,%d)",permission.isAccess(),permission.getUsers_id(),permission.getPublications_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            permission.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Permission permission) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `permissions` SET `access`=%b,`users_id`=%d,`publications_id`=%d WHERE id=%d",
               permission.isAccess(),permission.getUsers_id(),permission.getPublications_id(),permission.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Permission permission) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `permissions` WHERE id=%d",
                permission.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Permission> getAll(String whereAndOrder) throws SQLException {
        List<Permission> permissions=new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT * FROM `permissions %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Permission permission = new Permission(
                        resultSet.getLong("id"),
                        resultSet.getBoolean("access"),
                        resultSet.getLong("users_id"),
                        resultSet.getLong("publications_id")
                );
                permissions.add(permission);
            }
        }

        return permissions;
    }
}
