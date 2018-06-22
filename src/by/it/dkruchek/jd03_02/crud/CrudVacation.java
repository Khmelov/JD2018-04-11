package by.it.dkruchek.jd03_02.crud;

import by.it.dkruchek.jd03_02.beans.Vacation;
import by.it.dkruchek.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudVacation {

    public Vacation read(long id) throws SQLException {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ){
            String sql = String.format(Locale.US,
                    "SELECT `id`, `dates`, `approved`, `employees_id` FROM `vacations` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            Vacation vacation = null;
            if (resultSet.next()){
                vacation = new Vacation(resultSet.getLong("id"),
                        resultSet.getString("dates"),
                        resultSet.getBoolean("approved"),
                        resultSet.getLong("employees_id"));
            }
            return vacation;
        }
    }

    public boolean create(Vacation vacation) throws SQLException {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ){
            String sql = String.format(Locale.US,
                    "INSERT INTO `vacations` (`dates`, `approved`, `employees_id`) VALUES ('%s','%s','%s')",
                    vacation.getDates(), vacation.isApproved(), vacation.getEmployees_id());
            if (1==statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    vacation.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Vacation vacation) throws SQLException {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `vacations` " +
                            "SET `dates`='%s',`approved`='%s'," +
                            "`employees_id`=%d WHERE id=%d",
                    vacation.getDates(), vacation.isApproved(), vacation.getEmployees_id(), vacation.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Vacation vacation) throws SQLException {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ){
            String sql = String.format(Locale.US,
                    "DELETE FROM `vacations` WHERE id = %d", vacation.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }


}
