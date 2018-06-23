package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.connection.dbConnection;
import by.it.kurmaz.jd03_03.beans.ShippingList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudList {
    public ShippingList read(long id) throws SQLException {
        ShippingList list = null;
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "SELECT `ID`, `Quantity`, `Catalog_ID`, `Orders_ID` FROM `shippinglist` WHERE id=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            list = new ShippingList(
                    resultSet.getLong("ID"),
                    resultSet.getString("Quantity"),
                    resultSet.getInt("Catalog_ID"),
                    resultSet.getInt("Orders_ID")
            );
        }
        return list;
    }

    public boolean create(ShippingList list) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"INSERT INTO `shippinglist`(`Quantity`, `Catalog_ID`, `Orders_ID`)" +
                            "VALUES ('%s','%d', %d)",
                    list.getQuantity(), list.getCatalog_ID(), list.getOrder_ID());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    list.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(ShippingList list) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,
                    "UPDATE `shippinglist` SET `Quantity`=%s, `Catalog_ID`=%d, `Orders_ID`=%d WHERE id=%d",
                    list.getQuantity(), list.getCatalog_ID(), list.getOrder_ID(), list.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(ShippingList list) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"DELETE FROM `shippinglist` WHERE id=%d", list.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
