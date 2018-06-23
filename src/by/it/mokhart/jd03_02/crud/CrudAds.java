package by.it.mokhart.jd03_02.crud;

import by.it.mokhart.jd03_02.beans.Ad;
import by.it.mokhart.jd03_02.connection.DbConnection;

import java.sql.*;
import java.util.Locale;

public class CrudAds {

    public boolean create(Ad ad) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO" +
                            " `ads` (`description`, `price`, `size`, `fabric`, `colour`, `sex`, `producer`, `users_id`)" +
                            " VALUES ('%s', '%d', '%s', '%s', '%s', '%s', '%s', '%d')"
                    ,
                    ad.getDescription(), ad.getPrice(), ad.getSize(), ad.getFabric(), ad.getColour(), ad.getSex(), ad.getProducer(), ad.getUser_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ad.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Ad read(long id) throws SQLException {
        Ad ad = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `ad` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                ad = new Ad(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("size"),
                        resultSet.getString("fabric"),
                        resultSet.getString("colour"),
                        resultSet.getString("sex"),
                        resultSet.getString("producer"),
                        resultSet.getLong("user_id")
                );
            }
        }
        ;
        return ad;
    }

    public boolean update(Ad ad) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `ads` " +
                            "SET `description`='%s', 'price'='%d', 'size'='%s', 'fabric'='%s', 'colour'='%s', 'sex'='%s', 'producer'='%s', 'user_id'='%d' WHERE id=%d",
                    ad.getDescription(),ad.getPrice(),ad.getSize(),ad.getFabric(),ad.getColour(),ad.getSex(),ad.getProducer(),ad.getUser_id(), ad.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Ad ad) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `ads` WHERE id=%d",
                    ad.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}