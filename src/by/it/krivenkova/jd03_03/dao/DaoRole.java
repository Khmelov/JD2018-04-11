package by.it.krivenkova.jd03_03.dao;

import by.it.krivenkova.jd03_03.beans.Role;
import by.it.krivenkova.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;




public class DaoRole extends AbstractDao implements InterfaceDAO<Role>  {


    @Override
    public Role read(long id) throws SQLException {
        List<Role> all=getAll("WHERE `id`="+id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `roles`(`role`) VALUES ('%s')",
                role.getRole());
        long id = executeUpdate(sql);
        if (id > 0) {
            role.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `roles` SET `role`='%s' " +
                "WHERE `id`=%d", role.getRole(), role.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `roles` WHERE `id`=%d", role.getId());
        return executeUpdate(sql) > 0;
    }

      @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> list = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "SELECT * FROM `roles` " + where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("role")
                ));
            }
        }
        return list;
    }
}

