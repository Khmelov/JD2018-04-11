package by.it.shumilov.jd03_03.dao;


import by.it.shumilov.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class AbstractDao {
    long executeUpdate (String sql) throws SQLException {
        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){

                       ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){


            }
        }
        return  0;
    }
}
