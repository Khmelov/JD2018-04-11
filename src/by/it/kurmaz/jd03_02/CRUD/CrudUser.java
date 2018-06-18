package by.it.kurmaz.jd03_02.CRUD;
import by.it.kurmaz.jd03_02.beans.User;
import by.it.kurmaz.jd03_02.connection.dbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {
    User read(long id) throws SQLException {
        User user = null;
        java.sql.Connection connection = dbConnection.returnConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(Locale.US, "" + "Select 'id', 'login', 'email', 'phone number', 'carma' FROM 'users' WHERE id=%d", id);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
        }
        return user;

    }
}
