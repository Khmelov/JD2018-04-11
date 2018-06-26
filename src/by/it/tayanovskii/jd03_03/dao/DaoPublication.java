package by.it.tayanovskii.jd03_03.dao;

import by.it.tayanovskii.jd03_03.beans.Publication;
import by.it.tayanovskii.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoPublication extends AbstractDao implements InterfaceDAO<Publication> {

    @Override
    public Publication read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Publication publication) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `publications`(`title`, `number`, `date`, `description`, `price`) VALUES ('%s',%d,'%s','%s',%f)",
                publication.getTitle(),publication.getNumber(),publication.getDate(),publication.getDescription(),publication.getPrice());
        long id = executeUpdate(sql);
        if (id > 0) {
            publication.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Publication publication) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `publications` SET `title`='%s',`number`=%d,`date`='%s',`description`='%s',`price`=%f WHERE id=%d",
                publication.getTitle(),publication.getNumber(),publication.getDate(),publication.getDescription(),publication.getPrice(),publication.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Publication publication) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `publications` WHERE id=%d",
                publication.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Publication> getAll(String whereAndOrder) throws SQLException {
        List<Publication> publications = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT * FROM `publications` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Publication publication = new Publication(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("number"),
                        resultSet.getString("date"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price")
                );
                publications.add(publication);
            }
        }
        return publications;
    }
}
