package by.it.shumilov.project.java.dao;


import by.it.shumilov.project.java.beans.Order;
import by.it.shumilov.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoOrder extends AbstractDao implements DaoInterface<Order> {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Order read(long id) throws SQLException, ParseException {
    List<Order> all = getAll("WHERE id=" + id);
    if(all.size()>0)
        return  all.get(0);
    else
        return null;
}

    @Override
    public boolean create(Order order) throws SQLException {


        String sql = String.format(Locale.US, "INSERT INTO `orders`(`startorder`, `tenancy`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) VALUES ('%s','%d','%f','%d','%f','%d', %d)",
                sdf.format(order.getStartorder()),
                order.getTenancy(),
                order.getCost(),
                order.getDiscount(),
                order.getRealcost(),
                order.getAvtos_id(),
                order.getUsers_id());

        long id = executeUpdate(sql);
        if(id>0) {
            order.setId(id);
            return  true;
        }
        else
            return  false;
    }

    @Override
    public boolean update(Order order) throws SQLException {

        String end = "";
        if(order.getEndorder() !=  null)
            end = "`endorder`='"+sdf.format(order.getEndorder())+"',";

        String sql = String.format(Locale.US, " UPDATE `orders` SET " +
                        "`startorder`='%s'," +
                        "`tenancy`='%s'," +
                        "%s" +
                        "`cost`='%s'," +
                        "`discount`=%d," +
                        "`realcost`='%s'," +
                        "`avtos_id`=%d," +
                        "`users_id`='%d' " +
                        "WHERE id=%d",
                sdf.format(order.getStartorder()),
                order.getTenancy(),
                end,
                order.getCost(),
                order.getDiscount(),
                order.getRealcost(),
                order.getAvtos_id(),
                order.getUsers_id(),
                order.getId());

        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Order order) throws SQLException {

        String sql = String.format(Locale.US, " DELETE FROM `passports`  WHERE id=%d", order.getId());

        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Order> getAll(String whereAndOther) throws SQLException, ParseException {
        List<Order> orders = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US, " SELECT  " +
                    "`id`," +
                    "`startorder`, " +
                    "`tenancy`, " +
                    "`endorder`," +
                    " `cost`," +
                    " `discount`, " +
                    "`realcost`, " +
                    "`avtos_id`, " +
                    "`users_id` " +
                    "FROM `orders` %s", whereAndOther);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Order order = new Order(
                        resultSet.getLong("id"),
                        sdf.parse(resultSet.getString("startorder")),
                        resultSet.getInt("tenancy"),
                        sdf.parse(resultSet.getString("endorder")),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("discount"),
                        resultSet.getDouble("realcost"),
                        resultSet.getLong("avtos_id"),
                        resultSet.getLong("users_id"));
                orders.add(order);
            }

        }
        return  orders;
    }

}
