package by.it.rogov.jd03_02.crud;

import by.it.rogov.jd03_02.beans.Labrary;
import by.it.rogov.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudLabrary {


    public Labrary read(long id) throws SQLException {
        Labrary labrary = null;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "SELECT `ID`, `textFree`, `textPay` FROM `labrary` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                labrary = new Labrary(
                        resultSet.getLong("id"),
                        resultSet.getString("textFree"),
                        resultSet.getString("textPay")

                );
            }
        }
        return labrary;
    }


    public boolean create(Labrary labrary) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"INSERT INTO `labrary`(`textFree`, `textPay`) " +
                            "VALUES ('%s','%s')",
                    labrary.getTextFree(),labrary.getTextPay());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    labrary.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Labrary labrary) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `labrary` SET `textFree`='%s',`textPay`='%s' WHERE id=%d",
                    labrary.getTextFree(),labrary.getTextPay(),labrary.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Labrary labrary) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `labrary` WHERE id=%d",
                    labrary.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
