package by.it.zaleschonok.jd03_03.dao;

import by.it.zaleschonok.jd03_03.beans.Users;
import by.it.zaleschonok.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoUsers extends AbstractDao implements InterfaceDAO<Users> {

    @Override
    public Users read(int id) throws SQLException {
        List<Users> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Users user) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `roles_id`) " +
                        "VALUES ('%s','%s',%d)",
                user.getLogin(), user.getPassword(), user.getRoles_id());
        int id = executeUpdate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Users user) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `users` " +
                        "SET `login`='%s', `password`='%s'," +
                        "`roles_id`=%d WHERE id=%d",
                user.getLogin(), user.getPassword(), user.getRoles_id(), user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Users user) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `users` WHERE id=%d",
                user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Users> getAll(String whereAndOrder) throws SQLException {
        List<Users> users = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `login`, `password`, `roles_id` FROM `users` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Users user = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("roles_id")
                );
                users.add(user);
            }
        }
        return users;
    }
}
