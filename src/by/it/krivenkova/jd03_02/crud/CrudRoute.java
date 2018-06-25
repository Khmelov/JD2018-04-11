package by.it.krivenkova.jd03_02.crud;

import by.it.krivenkova.jd03_02.beans.Route;
import by.it.krivenkova.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudRoute {
    public boolean create(Route route) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO " +
                            "`routes`(`depTown`, `depDate`, `depTime`, `arrTown`, `price`, `numTickets`, `users_id`) " +
                            "VALUES ('%s','%s','%s','%s','%s',%d,%d)",
                    route.getDepTown(), route.getDepDate(), route.getDepTime(), route.getArrTown(), route.getPrice(), route. getNumTickets(), route.getUsers_id());
             if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    route.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Route read(long id) throws SQLException {
        Route route = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `depTown`, `depDate`, `depTime`, `arrTown`, `price`, `numTickets`, `users_id` FROM `routes` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                route = new Route(
                        resultSet.getLong("id"),
                        resultSet.getString("depTown"),
                        resultSet.getString("depDate"),
                        resultSet.getString("depTime"),
                        resultSet.getString("arrTown"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("numTickets"),
                        resultSet.getLong("users_id")
                );
            }
        }
        ;
        return route;
    }

    public boolean update(Route route) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `routes` " +
                            "SET `depTown`='%s', `depDate`='%s',`depTime`='%s', `arrTown`='%s',`price`='%s',`numTickets`='%d', " +
                            "`users_id`=%d WHERE id=%d",
                    route.getDepTown(), route.getDepDate(), route.getDepTime(), route.getArrTown(), route.getPrice(), route. getNumTickets(), route.getUsers_id(), route.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Route route) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `routes` WHERE id=%d",
                    route.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
