package by.it.dkruchek.jd03_02.crud;

import by.it.dkruchek.jd03_02.beans.Employee;
import by.it.dkruchek.jd03_02.connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudEmployee {

    public static Employee read(long id) throws SQLException {
        try (
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ){
            String sql = String.format(Locale.US,
                    "SELECT `id`, `name`, `lastname`, `email`, `password`, `roles_id` FROM `employees` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            Employee employee = null;
            if (resultSet.next()){
                employee = new Employee(resultSet.getLong("id"),
                resultSet.getString("name"),
                 resultSet.getString("lastname"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getLong("roles_id"));
            }
            return employee;
        }
    }

    public static boolean create(Employee employee) throws SQLException {
        try (
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ){
            String sql = String.format(Locale.US,
                    "INSERT INTO `employees` (`name`, `lastname`, `password`, `email`, `roles_id`) VALUES ('%s','%s','%s', '%s', '%s')",
                    employee.getName(), employee.getLastname(), employee.getPassword(), employee.getEmail(), employee.getRole_id());
            if (1==statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    employee.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
            return false;
        }

    public static boolean update(Employee employee) throws SQLException {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `employees` " +
                            "SET `password`='%s',`email`='%s'," +
                            "`roles_id`=%d WHERE id=%d",
                    employee.getPassword(), employee.getEmail(), employee.getRole_id(), employee.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public static boolean delete(Employee employee) throws SQLException {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ){
            String sql = String.format(Locale.US,
                    "DELETE FROM `employees` WHERE id = %d", employee.getId());
            return 1 == statement.executeUpdate(sql);
            }
        }
    }


