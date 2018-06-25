package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.connection.dbConnection;
import by.it.kurmaz.jd03_03.beans.Catalog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudCatalog {
    public Catalog read(long id) throws SQLException {
        Catalog cat = null;
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "SELECT `ID`, `AmountLeft`, `Name`, `Price` FROM `catalog` WHERE id=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            cat = new Catalog(
                    resultSet.getLong("ID"),
                    resultSet.getInt("AmountLeft"),
                    resultSet.getString("Name"),
                    resultSet.getDouble("Price")
            );
        }
        return cat;
    }

    public boolean create(Catalog cat) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"INSERT INTO `catalog`(`AmountLeft`, `Name`, `Price`)" +
                            "VALUES ('%d','%s', %f)",
                    cat.getAmount(), cat.getName(), cat.getPrice());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cat.setID(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Catalog cat) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,
                    "UPDATE `catalog` SET `AmountLeft`=%d, `Name`='%s', `Price`=%f WHERE id=%d",
                    cat.getAmount(), cat.getName(), cat.getPrice(), cat.getID());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Catalog cat) throws SQLException {
        try (
                Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"DELETE FROM `catalog` WHERE id=%d", cat.getID());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
