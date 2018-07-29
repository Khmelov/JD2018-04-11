package by.test.SCAND.java.dao;

import by.test.SCAND.java.DBC.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AbstractDao {
    int executeUpdate(String sql) throws SQLException{
        try(Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement()
        ){
          if (sql.trim().toUpperCase().startsWith("INSERT")){
              if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                  ResultSet generatedKeys = statement.getGeneratedKeys();
                  if(generatedKeys.next()){
                      return generatedKeys.getInt(1);
                  }
              }
          }else
              return statement.executeUpdate(sql);
        }
        return 0;
    }
}
