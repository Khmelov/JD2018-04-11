package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.connection.dbConnection;
import by.it.kurmaz.jd03_03.beans.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudOrder {
    public Order read(long id) throws SQLException {
        Order order = null;
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "SELECT `ID`, `Completed`, `Users_ID` FROM `orders` WHERE id=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            order = new Order(
                    resultSet.getLong("ID"),
                    resultSet.getInt("Completed"),
                    resultSet.getInt("Users_ID")

            );
        }
        return order;
    }

    public boolean create(Order order) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"INSERT INTO `orders`(`Completed`, `Users_ID`)" +
                            "VALUES ('%d','%d')",
                    order.isCompleted(), order.getUsers_ID());
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

    public boolean update(Order order) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,
                    "UPDATE `orders` SET `Completed`=%d, `Users_ID`=%d WHERE id=%d",
                    order.isCompleted(), order.getUsers_ID(), order.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Order order) throws SQLException {
        try (
                Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"DELETE FROM `orders` WHERE id=%d", order.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
