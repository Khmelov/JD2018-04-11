package by.it.shumilov.jd03_02.crud;

import by.it.shumilov.jd03_02.beans.User;
import by.it.shumilov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {

    User read(long id) throws SQLException {
        User user = null;

        try(
        Connection connection = DbConnection.getConnection();
        Statement statement = connection.createStatement();){
            String sql = String.format(Locale.US, " SELECT * FROM `dbusers` WHERE ID=%d", id);

        }
        return  user;
    }


}
