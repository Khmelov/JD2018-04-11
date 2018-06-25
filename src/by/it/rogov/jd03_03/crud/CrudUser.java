package by.it.rogov.jd03_03.crud;

import by.it.rogov.jd03_03.beans.User;
import by.it.rogov.jd03_03.connection.DBConnection;

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
           String sql = String.format(Locale.US,"INSERT INTO `users`(`login`, `password`, `email`, `phone`, `roles_ID`) " +
                           "VALUES ('%s','%s','%s',%d,%d)",
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

    public User read(long id) throws SQLException {
        User user= null;
        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
            String sql =String.format(Locale.US,"SELECT `ID`, `login`, `password`, `email`, `phone`, `roles_ID` FROM `users` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                user=new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("phone"),
                        resultSet.getLong("roles_id")
                        );
            }
        }
        return user;
    }

    public boolean update(User user) throws SQLException {
        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ) {
            String sql= String.format(Locale.US,
                    "UPDATE `users` SET `login`='%s',`password`='%s',`email`='%s',`phone`=%d,`roles_ID`=%d " +
                            "WHERE id=%d",
                    user.getLogin(),user.getPassword(),user.getEmail(),user.getPhone(),user.getRoles_id(),user.getId());
            return  1==statement.executeUpdate(sql);
        }
    }

    public boolean delete(User user) throws SQLException {
        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ) {
           String sql = String.format(Locale.US,
                   "DELETE FROM `users` WHERE id=%d",user.getId());
            return 1==statement.executeUpdate(sql);
        }
    }


}
