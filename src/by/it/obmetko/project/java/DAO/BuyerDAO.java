package by.it.obmetko.project.java.DAO;

import by.it.obmetko.project.java.DAO.beens.Buyer;
import by.it.obmetko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO extends DAO implements I_DAO<Buyer> {

    @Override
    public boolean create(Buyer buyer) throws SQLException {
        buyer.setId(0);
        int id = executeUpdate(
                String.format("INSERT INTO `buyers`(`login`, `password`, `email`, `Roles_id`) "+
                                "VALUES ('%s','%s','%s','%d')",
                        buyer.getLogin(), buyer.getPassword(), buyer.getEmail(), buyer.getRoles_id()));
        if (id > 0) buyer.setId(id);
        return id > 0;
    }

    @Override
    public Buyer read(int id) throws SQLException {
        List<Buyer> buyerList = getAll(" where id="+ id);
        return !buyerList.isEmpty() ? buyerList.get(0) : null;

    }
    public int read(String login, String password) throws SQLException {
        List<Buyer> buyerList = getAll(" where login='" + login + "' AND password='" + password + "'");
        return !buyerList.isEmpty() ? buyerList.get(0).getId() : null;
    }

    @Override
    public boolean update(Buyer buyer) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `buyers` SET `login`='%s',`password`='%s',`email`='%s',`Roles_id`='%d' WHERE id=%d",
                        buyer.getLogin(), buyer.getPassword(), buyer.getEmail(), buyer.getRoles_id(), buyer.getId()));
    }

    @Override
    public boolean delete(Buyer buyer) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `buyers` WHERE id=%d", buyer.getId()));
    }

    @Override
    public List<Buyer> getAll(String where) throws SQLException {
        List<Buyer> buyerList = new ArrayList<>();
        String sql = "SELECT * FROM `Buyers`" + where + ";";
               try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet Buyers = statement.executeQuery(sql)
                        ) {
                        while (Buyers.next()) {
                                buyerList.add(
                                                new Buyer(
                                                        Buyers.getInt("id"),
                                                        Buyers.getString("login"),
                                                        Buyers.getString("password"),
                                                        Buyers.getString("email"),
                                                        Buyers.getInt("Roles_id")
     )
     );
 }
        }
        return buyerList;
    }
    }
