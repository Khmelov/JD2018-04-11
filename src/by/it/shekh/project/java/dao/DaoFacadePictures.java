package by.it.shekh.project.java.dao;

import by.it.shekh.project.java.abstractdao.AbstractDao;
import by.it.shekh.project.java.abstractdao.InterfaceDao;
import by.it.shekh.project.java.beans.FacadePictures;
import by.it.shekh.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoFacadePictures extends AbstractDao implements InterfaceDao<FacadePictures> {
    @Override
    public FacadePictures read(int id) throws SQLException {
        List<FacadePictures> facadePictures = getAll("WHERE id_pictures=" + id);
        if (facadePictures.size() > 0) {
            return facadePictures.get(0);
        } else return null;
    }

    @Override
    public boolean create(FacadePictures facadePictures) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO facade_pictures " +
                        "(picture_path, id_facade) " +
                        "VALUES ('%s','%d')",
                facadePictures.getPicture_path(), facadePictures.getId_facade());
        facadePictures.setId_pictures(executeUpdate(sql));
        return facadePictures.getId_pictures() > 0;
    }

    @Override
    public boolean update(FacadePictures facadePictures) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE facade_pictures SET " +
                        "picture_path='%s', id_facade='%d' WHERE id_pictures='%d' ",
                facadePictures.getPicture_path(), facadePictures.getId_facade(), facadePictures.getId_pictures());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(FacadePictures facadePictures) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM facade_pictures WHERE id_pictures='%d'", facadePictures.getId_pictures());
        return 0 < executeUpdate(sql);
    }

    @Override
    public List<FacadePictures> getAll(String whereAndOrder) throws SQLException {
        List<FacadePictures> facadePictures = new ArrayList<>();
        String sql = "SELECT * FROM facade_pictures " + whereAndOrder;
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            FacadePictures facadePicture = null;
            while (resultSet.next()) {
                facadePicture = new FacadePictures(resultSet.getLong("id_pictures"),
                        resultSet.getString("picture_path"),
                        resultSet.getLong("id_facade"));
                facadePictures.add(facadePicture);
            }
        }
        return facadePictures;
    }
}
