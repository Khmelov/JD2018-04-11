package by.it.rogov.jd03_02.crud;

import by.it.rogov.jd03_02.beans.User;
import by.it.rogov.jd03_02.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {

    public boolean create(User user) throws SQLException {
        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
           String sql = String.format(Locale.US,"INSERT INTO " +
                   "`users`(`Login`, `Password`, `Email`, `Phone`, `roles_ID`) " +
                   "VALUES (%s,%s,%s,%d,%d)",
                   user.getLogin(),user.getPassword(),user.getEmail(),user.getPhone(),user.getRoles_id());
            if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
           }
           return false;
    }
}
