package by.it.lanevich.jd03_03.dao;

import by.it.lanevich.jd03_03.beans.Good;

//public class DaoGood extends UniversalDAO<Good>{
//    public DaoGood() { super(new Good(), "goods"); }
//}


import by.it.lanevich.jd03_03.connection.DbConnection;
import by.it.lanevich.jd03_03.dao.InterfaceDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoGood extends AbstractDao implements InterfaceDAO<Good> {

    @Override
    public Good read(long id) throws SQLException {
        List<Good> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Good good) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`goods`(`idgood`, `goodname`, `description`, `piecies`, `price`) " +
                        "VALUES ('%d','%s','%s','%s','%s')",
                good.getIdgood(), good.getGoodname(),good.getDescription(), good.getPiecies(), good.getPrice());
        long id = executeUpdate(sql);
        if (id > 0) {
            good.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Good good) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `goods` " +
                        "SET `idgood`='%d', `goodname`='%s',`description`='%s', `piecies`='%d',`price`='%d'" +
                        "WHERE id=%d",
                good.getIdgood(), good.getGoodname(),good.getDescription(), good.getPiecies(), good.getPrice(), good.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Good good) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `goods` WHERE id=%d",
                good.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Good> getAll(String whereAndOrder) throws SQLException {
        List<Good> goods = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `idgood`, `goodname`, `description`, `piecies`, `price` FROM `goods` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Good good = new Good(
                        resultSet.getLong("id"),
                        resultSet.getLong("idgood"),
                        resultSet.getString("goodname"),
                        resultSet.getString("description"),
                        resultSet.getInt("piecies"),
                        resultSet.getInt("price")

                );
                goods.add(good);
            }
        }
        return goods;
    }
}