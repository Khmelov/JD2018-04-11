package by.it.obmetko.jd03_03.DAO;

import by.it.obmetko.jd03_03.beens.Role;
import by.it.obmetko.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO implements I_DAO<Role> {

    @Override
    public boolean create(Role role) throws SQLException {
        role.setId(0);
        int id = executeUpdate(
                String.format("INSERT INTO `obmetko`.`roles`(`role`) VALUES ('%s')", role.getRole()));
        if (id > 0) role.setId(id);
        return id > 0;
    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> roleList = getAll(" where id="+  id);
        return !roleList.isEmpty() ? roleList.get(0) : null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `roles` SET `role`='%s' WHERE id=%d", role.getRole(), role.getId()));
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `roles` WHERE id=%d", role.getId()));
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> roleList = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet roles = statement.executeQuery("SELECT * FROM `roles`" + where);
        while (roles.next()) {
            roleList.add(
                    new Role(
                            roles.getInt("id"),
                            roles.getString("role")));
        }
        return roleList;
    }
}