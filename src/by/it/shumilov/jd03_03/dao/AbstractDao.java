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


            if(sql.trim().toUpperCase().startsWith("INSERT")){
                if(1== statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                    ResultSet genKeys = statement.getGeneratedKeys();
                    if(genKeys.next()){
                        return  genKeys.getLong(1);
                    }
                }
            }
            else statement.executeUpdate(sql);



            }
            return  0;
        }

    }
