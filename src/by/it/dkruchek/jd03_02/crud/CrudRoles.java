package by.it.dkruchek.jd03_02.crud;

import by.it.dkruchek.jd03_02.beans.Role;
import by.it.dkruchek.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudRoles {


    public static Long getIdByRole(String roleString) throws SQLException {
            try (
                    Connection connection = DBConnection.getConnection();
                    Statement statement = connection.createStatement();
            ){
                String sql = String.format(Locale.US,
                        "SELECT `id`, `role` FROM `roles` WHERE role='%s'", roleString);
                ResultSet resultSet = statement.executeQuery(sql);
                Role role = null;
                if (resultSet.next()){
                    role = new Role(resultSet.getLong("id"),
                            resultSet.getString("role"));
                }
                return role.getId();
            }
        }
    }

