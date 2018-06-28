package by.it.tarasiuk.jd03_03.dao;

import by.it.tarasiuk.jd03_03.beans.User;
import by.it.tarasiuk.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users`(" +
                        "`login`, " +
                        "`password`, " +
                        "`email`, " +
                        "`roles_id`)" +
                        "\n VALUES ('%s','%s','%s',%d)",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles_id());
        user.setId(executeUpdate(sql));
        return (user.getId() > 0);
    }

    @Override
    public User read(long id) throws SQLException {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login`='%s', " +
                        "`password`='%s', " +
                        "`email`='%s', " +
                        "`roles_id`=%d " +
                        "WHERE `users`.`id`=%d",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles_id(),
                user.getId());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id`=%d;", user.getId()
        );
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<User> getAll(String whereAndOrder) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            User user;
            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id"));
                users.add(user);
            }
        }
        return users;
    }
}

