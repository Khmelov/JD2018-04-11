package by.test.SCAND.java.dao;

import by.test.SCAND.java.DBC.DBConnection;
import by.test.SCAND.java.bean.Clients;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoClients extends AbstractDao implements DaoInterface<Clients> {

    @Override
    public Clients read(int id) throws SQLException {
        List<Clients> allClients = getAll("where idclients");
        if(allClients.size()>0){
            return allClients.get(0);
        }
        else return null;
    }

    @Override
    public boolean create(Clients clients) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `clients`(`roles`) VALUES ('%s')",clients.getRoles());
        int id = executeUpdate(sql);
        if(id>0){
            clients.setIdclients(id);
            return true;
        }
        else
        return false;
    }

    @Override
    public boolean update(Clients clients) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `clients` SET `roles`='%s' WHERE idclients=%d",clients.getRoles(),clients.getIdclients());
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Clients clients) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `clients` WHERE idclients=%d",clients.getIdclients());
        return executeUpdate(sql)>0;
    }

    @Override
    public List<Clients> getAll(String whereAndOrder) throws SQLException {
        List<Clients> allClients = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US,
                    "SELECT `idclients`, `roles` FROM `clients` %s",whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Clients clients = new Clients(
                        resultSet.getInt("idclients"),
                        resultSet.getString("roles"));
                allClients.add(clients);
            }
        }
        return allClients;
    }
}
