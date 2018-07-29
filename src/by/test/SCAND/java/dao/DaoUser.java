package by.test.SCAND.java.dao;

import by.test.SCAND.java.DBC.DBConnection;
import by.test.SCAND.java.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoUser extends AbstractDao implements DaoInterface<User> {

    @Override
    public User read(int id) throws SQLException {
        List<User> allUser = getAll("where iduser="+id);
        if(allUser.size()>0){
            return allUser.get(0);
        }
        else return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `user`(`name`, `address`, `phone`, `clients_idclients`)" +
                        " VALUES ('%s','%s','%s',%d)",
                user.getName(),user.getAddress(),user.getPhone(),user.getClients_idclients());
        int id = executeUpdate(sql);
        if(id>0){
            user.setIduser(id);
            return true;
        }
        else return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `user` " +
                        "SET `name`='%s',`address`='%s',`phone`='%s',`clients_idclients`=%d WHERE iduser=%d",
                user.getName(),user.getAddress(),user.getPhone(),user.getClients_idclients(),user.getIduser());
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `user` WHERE iduser=%d",user.getIduser());
        return executeUpdate(sql)>0;
    }

    @Override
    public List<User> getAll(String whereAndOrder) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US,
                    "SELECT `iduser`, `name`, `address`, `phone`, `clients_idclients` FROM `user` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt("iduser"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("clients_idclients"));
                users.add(user);
            }
        }
        return users;
    }
}
