package by.it.shumilov.jd03_02.crud;

import by.it.shumilov.jd03_02.beans.User;
import by.it.shumilov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudUser {


    public boolean create(User user) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){


            String sql = String.format(Locale.US, "INSERT INTO `dbusers` (`login`, `password`, `email`, `dbRoles_id`) VALUES ('%s','%s','%s','%d')",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id());

            return 1==statement.executeUpdate(sql);
        }


    }


    public User read(long id) throws SQLException {
        User user = null;

        try(
        Connection connection = DbConnection.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " SELECT  `id`, `login`, `password`, `email`, `dbRoles_id`  FROM `dbusers` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("dbRoles_id")  );

            }
        }

        return  user;
    }

    public boolean update(User user) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){

            String sql = String.format(Locale.US, " UPDATE  `dbusers` SET  `login`='%s', `password`='%s', `email`='%s', `dbRoles_id`=%d  WHERE id=%d",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId());

            return 1==statement.executeUpdate(sql);
        }


    }

    public boolean delete(User user) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " DELETE FROM `dbusers`  WHERE id=%d", user.getId());


            return 1==statement.executeUpdate(sql);
        }


    }
}
