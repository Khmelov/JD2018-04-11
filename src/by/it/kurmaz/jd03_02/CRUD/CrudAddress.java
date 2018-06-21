package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.beans.Address;
import by.it.kurmaz.jd03_02.connection.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudAddress {
    public Address read(long id) throws SQLException {
        Address address = null;
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "SELECT `ID`, `Country`, `City`, `Street`, `Building`, `Apt`, `ZIP`,  `Users_ID` FROM `address` WHERE ID=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            address = new Address(
                    resultSet.getLong("ID"),
                    resultSet.getString("Country"),
                    resultSet.getString("City"),
                    resultSet.getString("Street"),
                    resultSet.getString("Building"),
                    resultSet.getString("Apt"),
                    resultSet.getString("ZIP"),
                    resultSet.getLong("Users_ID")
            );
        }
        return address;
    }

    public boolean create(Address address) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"INSERT INTO `address`(`Country`, `City`, `Street`, `Building`, `Apt`, `ZIP`,  `Users_ID`)" +
                            "VALUES ('%s','%s','%s','%s','%s', '%s', %d)",
                    address.getCountry(), address.getCity(), address.getStreet(), address.getBuilding(), address.getApt(), address.getZip(), address.getUsers_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    address.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Address address) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,
                    "UPDATE `address` SET `Country`='%s', `City`='%s', `Street`='%s', `Building`='%s', `Apt`='%s', ZIP='%s', `Users_ID`='%d' WHERE ID=%d",
                    address.getCountry(), address.getCity(), address.getStreet(), address.getBuilding(), address.getApt(), address.getZip(), address.getUsers_id(), address.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Address address) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"DELETE FROM `address` WHERE id=%d", address.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
