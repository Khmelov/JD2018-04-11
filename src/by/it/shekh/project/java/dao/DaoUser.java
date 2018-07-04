package by.it.shekh.project.java.dao;

import by.it.shekh.project.java.abstractdao.AbstractDao;
import by.it.shekh.project.java.abstractdao.InterfaceDao;
import by.it.shekh.project.java.beans.User;
import by.it.shekh.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoUser extends AbstractDao implements InterfaceDao<User> {


    @Override
    public User read(int id) throws SQLException {
        List<User> all = getAll("where id_users=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `id_roles`) " +
                        "VALUES ('%s','%s','%s',%d)",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getId_roles());
        long id = executeUpdate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `users` " +
                        "SET `login`='%s', `password`='%s',`email`='%s'," +
                        "`id_roles`=%d WHERE id_users=%d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getId_roles(), user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `users` WHERE id_users=%d",
                user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<User> getAll(String whereAndOrder) throws SQLException {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id_users`, `login`, `password`, `email`, `id_roles` FROM `users` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id_users"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("id_roles")
                );
                users.add(user);
            }
        }
        return users;
    }

}