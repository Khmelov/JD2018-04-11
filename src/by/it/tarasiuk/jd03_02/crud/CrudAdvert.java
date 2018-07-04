package by.it.tarasiuk.jd03_02.crud;

import by.it.tarasiuk.jd03_02.beans.Advert;
import by.it.tarasiuk.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudAdvert {
    public boolean create(Advert advert) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO " +
                            "`adverts`(`brand`, `model`, " +
                            "`year`, `type`," +
                            " `grade`, `color`," +
                            " `price`, `description`, `users_id`) " +
                            "VALUES ('%s','%s',%d,'%s','%s','%s',%.2f,'%s',%d)",
                    advert.getBrand(), advert.getModel(),
                    advert.getYear(), advert.getType(),
                    advert.getGrade(), advert.getColor(),
                    advert.getPrice(), advert.getDescription(), advert.getUsers_id()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    advert.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Advert read(long id) throws SQLException {
        Advert advert = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "SELECT `id`, `brand`, `model`, `year`, `type`," +
                            " `grade`, `color`, `price`, `description`, `users_id` FROM `adverts` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                advert = new Advert(
                        resultSet.getLong("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getString("type"),
                        resultSet.getString("grade"),
                        resultSet.getString("color"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getLong("users_id")
                );
            }
        }
        return advert;
    }

    public boolean update(Advert advert) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `adverts` " +
                            "SET `brand`='%s', `model`='%s', " +
                            "`year`=%d, `type`='%s'," +
                            " `grade`='%s', `color`='%s'," +
                            " `price`=%.2f, `description`='%s', `users_id`=%d WHERE id=%d",
                    advert.getBrand(), advert.getModel(),
                    advert.getYear(), advert.getType(),
                    advert.getGrade(), advert.getColor(),
                    advert.getPrice(), advert.getDescription(), advert.getUsers_id(), advert.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Advert advert) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `adverts` WHERE id=%d",
                    advert.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}

