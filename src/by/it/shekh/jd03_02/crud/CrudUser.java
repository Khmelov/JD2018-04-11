package by.it.shekh.jd03_02.crud;

import by.it.shekh.jd03_02.beans.User;
import by.it.shekh.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {
    boolean read(User user) throws SQLException {
        try(Connection connection= DbConnection.getConnection();
            Statement statement = connection.createStatement();
        ){
         String sql=String.format(Locale.US,""+
         "");
        }
        return true;
    }
}
