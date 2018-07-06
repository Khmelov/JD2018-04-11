package by.it.shekh.project.java.dao;

import by.it.shekh.project.java.abstractdao.AbstractDao;
import by.it.shekh.project.java.abstractdao.InterfaceDao;
import by.it.shekh.project.java.beans.Order;
import by.it.shekh.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoOrder extends AbstractDao implements InterfaceDao<Order> {
    @Override
    public Order read(int id) throws SQLException {
        List<Order> orders = getAll("WHERE idOrders=" + id);
        if (orders.size() > 0) {
            return orders.get(0);
        } else return null;
    }

    @Override
    public boolean create(Order order) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO orders " +
                        "(date, id_users) " +
                        "VALUES('%s','%d')",
                order.getDate(), order.getId_users());
        order.setIdOrders(executeUpdate(sql));
        return order.getIdOrders() > 0;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE orders SET " +
                        "date='%s', id_users='%d' WHERE idOrders='%d'",
                order.getDate(), order.getId_users(), order.getIdOrders());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(Order order) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM orders WHERE idOrders='%d'", order.getIdOrders());
        return 0 < executeUpdate(sql);
    }

    @Override
    public List<Order> getAll(String whereAndOrder) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Order order=null;
            while (resultSet.next()){
                order=new Order(resultSet.getLong("idOrders"),
                        resultSet.getString("date"),
                        resultSet.getLong("id_users"));
                orders.add(order);
            }
        }
        return orders;
    }
}
