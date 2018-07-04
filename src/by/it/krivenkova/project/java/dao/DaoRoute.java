package by.it.krivenkova.project.java.dao;

import by.it.krivenkova.project.java.beans.Route;
import by.it.krivenkova.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class DaoRoute extends AbstractDao implements  InterfaceDAO<Route> {
     @Override
    public Route read(long id) throws SQLException {
        List<Route> list = getAll(" where id=" + id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean create(Route route) throws SQLException {
          String insert = String.format(Locale.US,"INSERT INTO `routes` (`depTown`, `depDate`, `depTime`, `arrTown`, `price`, `numTickets`, `users_id`) " +
                            "VALUES ('%s','%s','%s','%s','%s', %d, %d);",
                  route.getDepTown(), route.getDepDate(), route.getDepTime(), route.getArrTown(), route.getPrice(), route. getNumTickets(), route.getUsers_id());
          long recCount = executeUpdate(insert);
            if (recCount > 0) {
                route.setId(recCount);
                return true;
            } else
                return false;
    }

    @Override
    public boolean update(Route route) throws SQLException {
           String set = String.format("UPDATE `routes` " +
                            "SET `depTown`='%s', `depDate`='%s',`depTime`='%s', `arrTown`='%s',`price`='%s',`numTickets`='%d', " +
                            "`users_id`=%d WHERE id=%d",
                    route.getDepTown(), route.getDepDate(), route.getDepTime(), route.getArrTown(), route.getPrice(), route. getNumTickets(), route.getUsers_id(), route.getId());
        return executeUpdate(set) > 0;
    }

      @Override
    public boolean delete(Route route) throws SQLException {
           String query = String.format("DELETE FROM `routes` WHERE id=%d", route.getId());
          return executeUpdate(query) > 0;
    }

    @Override
    public List<Route> getAll(String where) throws SQLException {
        List<Route> list = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from routes " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Route ad = new Route(
                    rs.getInt("id"),
                    rs.getString("depTown"),
                    rs.getString("depDate"),
                    rs.getString("depTime"),
                    rs.getString("arrTown"),
                    rs.getDouble("price"),
                    rs.getInt("numTickets"),
                    rs.getInt("users_id"));
            list.add(ad);
        }
        return list;
    }
}
