package by.it.tarasiuk.project.java.dao;

import by.it.tarasiuk.project.java.beans.Advert;
import by.it.tarasiuk.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdvertDao extends AbstractDao implements InterfaceDao<Advert> {

    @Override
    public boolean create(Advert advert) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `adverts`(" +
                        "`brand`, " +
                        "`model`, " +
                        "`year`, " +
                        "`type`, " +
                        "`grade`, " +
                        "`color`, " +
                        "`price`, " +
                        "`description`, " +
                        "`users_id`)" +
                        "\n VALUES ('%s','%s',%d,'%s','%s','%s',%.2f,'%s',%d)",
                advert.getBrand(),
                advert.getModel(),
                advert.getYear(),
                advert.getType(),
                advert.getGrade(),
                advert.getColor(),
                advert.getPrice(),
                advert.getDescription(),
                advert.getUsers_id());
        advert.setId(executeUpdate(sql));
        return (advert.getId() > 0);
    }

    @Override
    public Advert read(long id) throws SQLException {
        List<Advert> adverts = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (adverts.size() > 0) {
            return adverts.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(Advert advert) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `adverts` SET " +
                        "`brand`='%s', " +
                        "`model`='%s', " +
                        "`year`=%d, " +
                        "`type`='%s', " +
                        "`grade`='%s', " +
                        "`color`='%s', " +
                        "`price`=%.2f, " +
                        "`description`='%s', " +
                        "`users_id`=%d " +
                        "WHERE `adverts`.`id`=%d",
                advert.getBrand(),
                advert.getModel(),
                advert.getYear(),
                advert.getType(),
                advert.getGrade(),
                advert.getColor(),
                advert.getPrice(),
                advert.getDescription(),
                advert.getUsers_id(),
                advert.getId());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(Advert advert) throws SQLException {
        String sql = String.format(
                "DELETE FROM `adverts` WHERE `adverts`.`id`=%d;", advert.getId()
        );
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<Advert> getAll(String whereAndOrder) throws SQLException {
        List<Advert> adverts = new ArrayList<>();
        String sql = "SELECT * FROM adverts " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Advert advert;
            while (resultSet.next()) {
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
                        resultSet.getLong("users_id"));
                adverts.add(advert);
            }
        }
        return adverts;
    }
}

