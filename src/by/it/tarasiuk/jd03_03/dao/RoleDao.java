package by.it.tarasiuk.jd03_03.dao;

import by.it.tarasiuk.jd03_03.beans.Role;
import by.it.tarasiuk.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO 'roles'('role') VALUES('%s')", role.getRole());
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }

    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE 'roles' SET 'role'='%s', WHERE 'roles'.'id'=%d",
                role.getRole(), role.getId());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id`=%d;", role.getId()
        );
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<Role> getAll(String whereAndOrder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Role role;
            while (resultSet.next()) {
                role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role"));
                roles.add(role);
            }
        }
        return roles;
    }
}
