package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.beans.User;
import by.it.kurmaz.jd03_02.connection.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {

    public User read(long id) throws SQLException {
        User user = null;
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "SELECT `ID`, `Login`, `Password`, `Email`, `Phone`, `Carma`, `Roles_ID` FROM `users` WHERE id=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            user = new User(
                    resultSet.getLong("ID"),
                    resultSet.getString("Login"),
                    resultSet.getString("Password"),
                    resultSet.getString("Email"),
                    resultSet.getString("Phone"),
                    resultSet.getString("Carma"),
                    resultSet.getLong("Roles_ID")
            );
        }
        return user;
    }

    public boolean create(User user) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"INSERT INTO `users`(`Login`, `Password`, `Email`, `Phone`, `Carma`, `Roles_ID`)" +
                            "VALUES ('%s','%s','%s','%s','%s', %d)",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.getCarma(), user.getRoles_id());
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

    public boolean update(User user) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,
                    "UPDATE `users` SET `Login`='%s', `Password`='%s', `Email`='%s', `Phone`='%s', `Carma`='%s', `Roles_ID`='%d' WHERE id=%d",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.getCarma(), user.getRoles_id(), user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(User user) throws SQLException {
        try (
                Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"DELETE FROM `users` WHERE id=%d", user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
