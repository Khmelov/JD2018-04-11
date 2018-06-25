package by.it.shekh.jd03_03.dao;

import by.it.shekh.jd03_03.abstractdao.AbstractDao;
import by.it.shekh.jd03_03.beans.FacadeGeneral;
import by.it.shekh.jd03_03.abstractdao.InterfaceDao;
import by.it.shekh.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoFacadeGeneral extends AbstractDao implements InterfaceDao<FacadeGeneral> {
    @Override
    public FacadeGeneral read(int id) throws SQLException {
        List<FacadeGeneral> facadeGenerals = getAll("WHERE id_facade=" + id + " LIMIT 0,1");
        if (facadeGenerals.size() > 0) {
            return facadeGenerals.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(FacadeGeneral entity) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO facade_general (" +
                        "facade_name, facade_dimensions, facade_description," +
                        " facade_price, facade_specs) VALUES " +
                        "('%s','%s','%s',%f,'%s')", entity.getFacade_name(), entity.getFacade_dimensions(),
                entity.getFacade_description(), entity.getFacade_price(), entity.getFacade_specs());
        entity.setId_facade(executeUpdate(sql));
        return (entity.getId_facade() > 0);
    }

    @Override
    public boolean update(FacadeGeneral entity) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE facade_general " +
                        " SET facade_name='%s', facade_dimensions='%s', facade_description='%s'," +
                        " facade_price='%f', facade_specs='%s' " +
                        "WHERE id_facade='%d'", entity.getFacade_name(), entity.getFacade_dimensions(),
                entity.getFacade_description(), entity.getFacade_price(), entity.getFacade_specs(), entity.getId_facade());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(FacadeGeneral entity) throws SQLException {
        String sql = String.format("DELETE FROM facade_general " +
                "WHERE facade_general.id_facade = '%d'", entity.getId_facade());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<FacadeGeneral> getAll(String whereAndOrder) throws SQLException {
        List<FacadeGeneral> facadeGenerals = new ArrayList<>();
        String sql = "SELECT * FROM facade_general " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            FacadeGeneral facadeGeneral = null;
            while (resultSet.next()) {
                facadeGeneral = new FacadeGeneral(resultSet.getLong("id_facade"),
                        resultSet.getString("facade_name"),
                        resultSet.getString("facade_dimensions"),
                        resultSet.getString("facade_description"),
                        resultSet.getDouble("facade_price"),
                        resultSet.getString("facade_specs"));
                facadeGenerals.add(facadeGeneral);
            }
        }
        return facadeGenerals;
    }
}
