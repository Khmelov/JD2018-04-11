package by.it.shumilov.jd03_02.crud;

import by.it.shumilov.jd03_02.beans.Order;
import by.it.shumilov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CrudOrder {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public boolean create(Order order) throws SQLException {



        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){



            String sql = String.format(Locale.US, "INSERT INTO `orders`(`startorder`, `tenancy`, `cost`, `discount`, `realcost`, `avtos_id`, `users_id`) VALUES ('%s','%d','%f','%d','%f','%d', %d)",
                    sdf.format(order.getStartorder()),
                    order.getTenancy(),
                    order.getCost(),
                    order.getDiscount(),
                    order.getRealcost(),
                    order.getAvtos_id(),
                    order.getUsers_id());

            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;

    }


    public Order read(long id) throws SQLException, ParseException {
        Order avto = null;

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
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
                    "FROM `orders` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                avto = new Order(

                        resultSet.getLong("id"),
                        sdf.parse(resultSet.getString("startorder")),
                        resultSet.getInt("tenancy"),
                        sdf.parse(resultSet.getString("endorder")),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("discount"),
                        resultSet.getDouble("realcost"),
                        resultSet.getLong("avtos_id"),
                        resultSet.getLong("users_id"));

            }
        }

        return  avto;
    }

    public boolean update(Order order) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){

            String sql = String.format(Locale.US, " UPDATE `orders` SET " +
                            "`startorder`='%s'," +
                            "`tenancy`='%s'," +
                            "`endorder`='%s'," +
                            "`cost`='%s'," +
                            "`discount`=%d," +
                            "`realcost`='%s'," +
                            "`avtos_id`=%d," +
                            "`users_id`='%d' " +
                            "WHERE id=%d",
                    sdf.format(order.getStartorder()),
                    order.getTenancy(),
                    sdf.format(order.getEndorder()),
                    order.getCost(),
                    order.getDiscount(),
                    order.getRealcost(),
                    order.getAvtos_id(),
                    order.getUsers_id(),
                    order.getId());

            return 1==statement.executeUpdate(sql);
        }


    }

    public boolean delete(Order order) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " DELETE FROM `orders`  WHERE id=%d", order.getId());


            return 1==statement.executeUpdate(sql);
        }


    }
}
