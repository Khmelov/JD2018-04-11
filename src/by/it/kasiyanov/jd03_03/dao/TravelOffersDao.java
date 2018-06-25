package by.it.kasiyanov.jd03_03.dao;

import by.it.kasiyanov.jd03_03.beans.TravelOffers;
import by.it.kasiyanov.jd03_03.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TravelOffersDao extends AbstractDao implements InterfaceDAO<TravelOffers> {

    @Override
    public boolean create(TravelOffers travelOffers) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`travelOffers`(`description`, `typeOfTravel`, `destination`, " +
                        "`hotel`, `levelOfAccommodation`, `numberOfNights`, `price`, `users_id`) " +
                        "VALUES ('%s','%s','%s','%s','%s',%d,%f,%d)",
                travelOffers.getDescription(), travelOffers.getTypeOfTravel(), travelOffers.getDestination(),
                travelOffers.getHotel(), travelOffers.getLevelOfAccommodation(), travelOffers.getNumberOfNights(),
                travelOffers.getPrice(), travelOffers.getUsers_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            travelOffers.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public TravelOffers read(long id) throws SQLException {
        List<TravelOffers> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean update(TravelOffers travelOffers) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `travelOffers` " +
                        "SET `description`='%s', `typeOfTravel`='%s',`destination`='%s'," +
                        "`hotel`='%s', `levelOfAccommodation`='%s', `numberOfNights`=%d, " +
                        "`price`=%f, `users_id`=%d WHERE id=%d",
                travelOffers.getDescription(), travelOffers.getTypeOfTravel(), travelOffers.getDestination(),
                travelOffers.getHotel(), travelOffers.getLevelOfAccommodation(), travelOffers.getNumberOfNights(),
                travelOffers.getPrice(), travelOffers.getUsers_id());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(TravelOffers travelOffers) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `travelOffers` WHERE id=%d",
                travelOffers.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<TravelOffers> getAll(String whereAndOrder) throws SQLException {
        List<TravelOffers> travelOffers = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `description`, `typeOfTravel`, `destination`, " +
                            "`hotel`, `levelOfAccommodation`, `numberOfNights`, " +
                            "`price`, `users_id` FROM `travelOffers` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TravelOffers travelOffer = new TravelOffers(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getString("typeOfTravel"),
                        resultSet.getString("destination"),
                        resultSet.getString("hotel"),
                        resultSet.getString("levelOfAccommodation"),
                        resultSet.getInt("numberOfNights"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("users_id")
                );
                travelOffers.add(travelOffer);
            }
        }
        return travelOffers;
    }
}
