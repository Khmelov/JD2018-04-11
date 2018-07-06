package by.it.rogov.progect.java.dao;



import by.it.rogov.progect.java.beans.Permission;
import by.it.rogov.progect.java.connection.DBConnection;

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
        List<Permission> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Permission permission) throws SQLException {
        String sql = String.format(Locale.US,"INSERT INTO `permission`(`pemissionAccess`, `users_ID`) " +
                        "VALUES (%d,%d)",
                permission.getPemissionAccess(),permission.getUsers_id());
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
                "UPDATE `permission` SET `pemissionAccess`=%d,`users_ID`=%d " +
                        "WHERE id=%d",
                permission.getPemissionAccess(),permission.getUsers_id(),permission.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Permission permission) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `permission` WHERE id=%d",
                permission.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Permission> getAll(String whereAndOrder) throws SQLException {
        List<Permission> permissions = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"SELECT `ID`, `pemissionAccess`, `users_ID` FROM `permission` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Permission permission = new Permission(
                        resultSet.getLong("id"),
                        resultSet.getInt("pemissionAccess"),
                        resultSet.getLong("users_ID")
                );
                permissions.add(permission);
            }
        }
        return permissions;

    }
}
