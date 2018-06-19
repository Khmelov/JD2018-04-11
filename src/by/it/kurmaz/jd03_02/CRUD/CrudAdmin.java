package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.beans.Admin;
import by.it.kurmaz.jd03_02.connection.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudAdmin {
    public Admin read(long id) throws SQLException {
        Admin admin = null;
        Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "SELECT `ID`, `Login`, `Password`, `Email`, `Phone Number`, `Roles_ID` FROM `admins` WHERE id=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            admin = new Admin(
                    resultSet.getLong("ID"),
                    resultSet.getString("Login"),
                    resultSet.getString("Password"),
                    resultSet.getString("Email"),
                    resultSet.getString("Phone Number"),
                    resultSet.getLong("Roles_ID")
            );
        }
        return admin;
    }

    public boolean create(Admin admin) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,"INSERT INTO `admins`(`Login`, `Password`, `Email`, `Phone Number`, `Roles_ID`)" +
                            "VALUES ('%s','%s','%s','%s', %d)",
                    admin.getLogin(), admin.getPassword(), admin.getEmail(), admin.getPhone(), admin.getRoles_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    admin.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Admin admin) throws SQLException {
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US,
                    "UPDATE `admins` SET `Login`='%s', `Password`='%s', `Email`='%s', `Phone Number`='%s', `Roles_ID`='%d' WHERE id=%d",
                    admin.getLogin(), admin.getPassword(), admin.getEmail(), admin.getPhone(), admin.getRoles_id(), admin.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Admin admin) throws SQLException {
        try (
                Connection connection = dbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"DELETE FROM `admins` WHERE id=%d", admin.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
