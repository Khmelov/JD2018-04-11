package by.it.rogov.jd03_02.crud;

import by.it.rogov.jd03_02.beans.User;
import by.it.rogov.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudRole {

    String role;
    int countRole;

    public String readRole(int roleID) throws SQLException {

        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
            String sql =String.format(Locale.US,"SELECT `role` FROM `roles` WHERE id=%d",
                    roleID);
            ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next())
            return resultSet.getString(1);
        else
            return null;
        }
    }
    public int readCountRole() throws SQLException {

        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
            String sql =String.format(Locale.US,"SELECT COUNT(id) FROM `roles` ");
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                countRole = resultSet.getInt(1);
                return countRole;
            }
        }
        return 0;
    }

}
