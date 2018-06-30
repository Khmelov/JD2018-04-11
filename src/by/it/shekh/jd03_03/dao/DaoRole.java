package by.it.shekh.jd03_03.dao;

import by.it.shekh.jd03_03.abstractdao.AbstractDao;
import by.it.shekh.jd03_03.abstractdao.InterfaceDao;
import by.it.shekh.jd03_03.beans.Role;
import by.it.shekh.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoRole extends AbstractDao implements InterfaceDao<Role> {
    @Override
    public Role read(int id) throws SQLException {
        List<Role> roles = getAll("WHERE id_roles=" + id);
        if (roles.size() > 0) {
            return roles.get(0);

        } else return null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO roles " +
                        "(role) VALUES ('%s')", role.getRole());
        role.setId_roles(executeUpdate(sql));
        return role.getId_roles() > 0;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE roles SET " +
                        "role='%s' WHERE id_roles='%d'", role.getRole(), role.getId_roles());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM roles WHERE roles.id_roles='%d'", role.getId_roles());
        return 0 < executeUpdate(sql);
    }

    @Override
    public List<Role> getAll(String whereAndOrder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Role role = null;
            while (resultSet.next()) {
                role = new Role(resultSet.getLong("id_roles"),
                        resultSet.getString("role"));
                roles.add(role);
            }
        }
        return roles;
    }
}
