package by.it.obmetko.project.java.DAO;

import by.it.obmetko.project.java.DAO.beens.User;
import by.it.obmetko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO implements I_DAO<User> {

     @Override
     public boolean create(User user) throws SQLException {
         user.setId(0);
         int id = executeUpdate(
                 String.format("INSERT INTO `users`(`login`, `password`, `email`, `Roles_id`) " +
                                 "VALUES ('%s','%s','%s','%d')",
                         user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id()));
         if (id > 0) user.setId(id);
         return id > 0;
     }

     @Override
     public User read(int id) throws SQLException {
         List<User> userList = getAll(" where id=" + id);
         return !userList.isEmpty() ? userList.get(0) : null;
     }


     @Override
     public boolean update(User user) throws SQLException {
         return 1 == executeUpdate(
                 String.format("UPDATE `users` SET `login`='%s',`password`='%s',`email`='%s',`Roles_id`='%d' WHERE id=%d",
                         user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId()));
     }

     @Override
     public boolean delete(User user) throws SQLException {
         return 1 == executeUpdate(
                 String.format("DELETE FROM `users` WHERE id=%d", user.getId()));
     }

     @Override
     public List<User> getAll(String where) throws SQLException {
         List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM `Users`" + where + ";";
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet Users = statement.executeQuery(sql)
        ) {
            while (Users.next()) {
                userList.add(
                        new User(
                                Users.getInt("id"),
                               Users.getString("login"),
                                Users.getString("password"),
                                Users.getString("email"),
                                Users.getInt("Roles_id")
                        )
                );
            }
         }
         return userList;
     }

}