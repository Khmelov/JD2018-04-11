package by.it.rogov.jd03_03.dao;

import by.it.rogov.jd03_03.beans.Labrary;
import by.it.rogov.jd03_03.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoLabrary extends AbstractDao implements InterfaceDAO<Labrary> {


    @Override
    public Labrary read(long id) throws SQLException {
        List<Labrary> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Labrary labrary) throws SQLException {
        String sql = String.format(Locale.US,"INSERT INTO `labrary`(`textFree`, `textPay`) " +
                        "VALUES ('%s','%s')",
                labrary.getTextFree(),labrary.getTextPay());
        long id = executeUpdate(sql);
        if (id > 0) {
            labrary.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Labrary labrary) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `labrary` SET `textFree`='%s',`textPay`='%s' WHERE id=%d",
                labrary.getTextFree(),labrary.getTextPay(),labrary.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Labrary labrary) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `labrary` WHERE id=%d",
                labrary.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Labrary> getAll(String whereAndOrder) throws SQLException {
        List<Labrary> labraries = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,"SELECT `ID`, `textFree`, `textPay` FROM `labrary` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Labrary labrary = new Labrary(
                        resultSet.getLong("id"),
                        resultSet.getString("textFree"),
                        resultSet.getString("textPay")

                );
                labraries.add(labrary);
            }
        }
        return labraries;
    }
}

