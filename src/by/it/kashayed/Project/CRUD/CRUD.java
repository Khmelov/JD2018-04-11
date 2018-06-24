package by.it.kashayed.Project.CRUD;

import by.it.kashayed.Project.DBC.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CRUD {

    public boolean create(User user) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO `owner`" +
                            "(`Login`, `email`, `Password`, `Name`, `Owners_id`) " +
                            "VALUES ('%s','%s','%s','%s','%d')",
                    user.getLogin(), user.getEmail(), user.getPassword(), user.getName(), user.getOwners_id());
            if (1 == statement.executeUpdate(sql, 1)) {
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
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `Login`, `email`, `Password`, `Name`, `Owners_id` FROM `Owner` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("Login"),
                        resultSet.getString("email"),
                        resultSet.getString("Password"),
                        resultSet.getString("Name"),
                        resultSet.getLong("Owners_id")
                );
            }
        }
        return user;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `owner` SET `Login`='%s',`email`='%s',`Password`='%s',`Name`='%s',`Owners_id`=%d WHERE id=%d",
                    user.getLogin(), user.getEmail(), user.getPassword(), user.getName(), user.getOwners_id(), user.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
    public boolean delete(User user) throws SQLException {
        try(Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US,
                    "DELETE FROM `owner` WHERE id=%d",user.getId());
            return 1==statement.executeUpdate(sql);
        }
    }
}
