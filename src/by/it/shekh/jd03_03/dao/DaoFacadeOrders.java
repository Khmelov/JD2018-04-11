package by.it.shekh.jd03_03.dao;

import by.it.shekh.jd03_03.abstractdao.AbstractDao;
import by.it.shekh.jd03_03.abstractdao.InterfaceDao;
import by.it.shekh.jd03_03.beans.FacadeOrders;
import by.it.shekh.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoFacadeOrders extends AbstractDao implements InterfaceDao<FacadeOrders> {
    @Override
    public FacadeOrders read(int id) throws SQLException {
        List<FacadeOrders> facadeOrders = getAll("WHERE idfacade_order=" + id);
        if (facadeOrders.size() > 0) {
            return facadeOrders.get(0);
        } else return null;
    }

    @Override
    public boolean create(FacadeOrders facadeOrders) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO facade_orders " +
                        "(id_facade, idOrders) VALUES " +
                        "('%d','%d')", facadeOrders.getId_facade(), facadeOrders.getIdOrder());
        facadeOrders.setIdfacade_order(executeUpdate(sql));
        return facadeOrders.getIdfacade_order() > 0;
    }

    @Override
    public boolean update(FacadeOrders facadeOrders) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE facade_orders SET " +
                        "id_facade='%d', idOrders='%d' WHERE idfacade_order='%d'",
                facadeOrders.getId_facade(), facadeOrders.getIdOrder(), facadeOrders.getIdfacade_order());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(FacadeOrders facadeOrders) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM facade_orders WHERE " +
                        "idfacade_orders='%d'", facadeOrders.getIdfacade_order());
        return 0 < executeUpdate(sql);
    }

    @Override
    public List<FacadeOrders> getAll(String whereAndOrder) throws SQLException {
        List<FacadeOrders> facadeOrders = new ArrayList<>();
        String sql = "SELECT * FROM facade_orders " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            FacadeOrders facadeOrder = null;
            while (resultSet.next()) {
                facadeOrder = new FacadeOrders(resultSet.getInt("idfacade_orders"),
                        resultSet.getLong("id_facade"),
                        resultSet.getLong("idOrders"));
                facadeOrders.add(facadeOrder);
            }
        }
        return facadeOrders;
    }
}
