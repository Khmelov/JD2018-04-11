package by.it.lanevich.jd03_03.dao;

import by.it.lanevich.jd03_03.beans.Order;
import by.it.lanevich.jd03_03.connection.DbConnection;
import by.it.lanevich.jd03_03.dao.InterfaceDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//public class DaoOrder extends UniversalDAO<Order>{
//    public DaoOrder() { super(new Order(), "orders");}
//}

public class DaoOrder extends AbstractDao implements InterfaceDAO<Order> {

    @Override
    public Order read(long id) throws SQLException {
        List<Order> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Order order) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`orders`(`ord_id`, `numgood`, `users_id`, `goods_id`) " +
                        "VALUES ('%d','%d',2,3)",//TODO fix dis!!!  get no values
                order.getOrd_id(), order.getNumgood(), order.getUsers_id(), order.getGoods_id());
             //          "VALUES (1, 2, 2, 3) ");

        long id = executeUpdate(sql);
        if (id > 0) {
            order.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `orders` " +
                        "SET `ord_id`='%d', `numgood`='%d',`users_id`='%d'," +
                        "`goods_id`='%d' WHERE id=%d",
                order.getOrd_id(), order.getNumgood(), order.getUsers_id(), order.getGoods_id(), order.getId()); //TODO  FIX IT!!!
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Order order) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `orders` WHERE id=%d",
                order.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Order> getAll(String whereAndOrder) throws SQLException {
        List<Order> orders = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `ord_id`, `numgood`, `users_id`, `goods_id` FROM `orders` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getLong("ord_id"),
                        resultSet.getLong("numgood"),
                        resultSet.getLong("users_id"),
                        resultSet.getLong("goods_id")
                );
                orders.add(order);
            }
        }
        return orders;
    }
}