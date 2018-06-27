package by.it.krivenkova.jd03_02.crud;

import by.it.krivenkova.jd03_02.beans.User;
import by.it.krivenkova.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {
    public boolean create(User user) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO " +
                            "`users`(`login`, `password`,`surname`,`name`,`patronymic`, `email`, `roles_id`) " +
                            "VALUES ('%s','%s','%s','%s','%s','%s', %d)",
                    user.getLogin(), user.getPassword(), user.getSurname(), user.getName(), user.getPatronymic(), user.getEmail(), user.getRoles_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public User read(long id) throws SQLException {
        User user = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `login`, `password`,`surname`,`name`,`patronymic`, `email`, `roles_id` FROM `users` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );
            }
        }
        ;
        return user;
    }

    public boolean update(User user) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `users` " +
                            "SET `login`='%s', `password`='%s',`email`='%s'," +
                            "`roles_id`=%d WHERE id=%d",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(User user) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `users` WHERE id=%d",
                    user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
