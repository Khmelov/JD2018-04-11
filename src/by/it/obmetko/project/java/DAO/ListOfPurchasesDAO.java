package by.it.obmetko.project.java.DAO;

import by.it.obmetko.project.java.DAO.beens.ListOfPurchases;
import by.it.obmetko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListOfPurchasesDAO extends DAO implements I_DAO<ListOfPurchases> {

    @Override
    public boolean create(ListOfPurchases list) throws SQLException {
        list.setId(0);
        int id = executeUpdate(
                String.format("INSERT INTO `list of purchases`(`Users_id`, `Books_id`) VALUES ('%d','%d')",
                        list.getUsers_id(), list.getBooks_id()));
        if (id > 0) list.setId(id);
        return id > 0;
    }

    @Override
    public ListOfPurchases read(int id) throws SQLException {
        List<ListOfPurchases> listOfPurchasesList = getAll(" where id=" + id);
        return !listOfPurchasesList.isEmpty() ? listOfPurchasesList.get(0) : null;
    }

    @Override
    public boolean update(ListOfPurchases list) throws SQLException {
        return 1 == executeUpdate(
                String.format("UPDATE `list of purchases` SET `Users_id`='%d',`Books_id`='%d' WHERE id=%d",
                        list.getUsers_id(), list.getBooks_id(), list.getId()));
    }

    @Override
    public boolean delete(ListOfPurchases list) throws SQLException {
        return 1 == executeUpdate(
                String.format("DELETE FROM `list of purchases` WHERE id=%d", list.getId()));
    }

    @Override
    public List<ListOfPurchases> getAll(String where) throws SQLException {
        List<ListOfPurchases> listOfPurchasesList = new ArrayList<>();
                String sql = "SELECT * FROM `list of purchases`" + where + ";";
        try (Connection connection = DbConnection.getConnection();
                    Statement statement = connection.createStatement();
                         ResultSet lists = statement.executeQuery(sql)
                            ) {
                while (lists.next()) {
                    listOfPurchasesList.add(
                            new ListOfPurchases(
                                    lists.getInt("id"),
                                    lists.getInt("Users_id"),
                                    lists.getInt("Books_id")
                            )
                    );
                }
            }
            return listOfPurchasesList;
        }
    }