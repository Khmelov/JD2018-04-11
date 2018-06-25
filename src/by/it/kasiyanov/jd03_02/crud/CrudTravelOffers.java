package by.it.kasiyanov.jd03_02.crud;

import by.it.kasiyanov.jd03_02.beans.TravelOffers;
import by.it.kasiyanov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudTravelOffers {

    public boolean create(TravelOffers travelOffers) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "INSERT INTO " +
                            "`travelOffers`(`description`, `typeOfTravel`, `destination`, " +
                            "`hotel`, `levelOfAccommodation`, `numberOfNights`, `price`, `users_id`) " +
                            "VALUES ('%s','%s','%s','%s','%s',%d,%f,%d)",
                    travelOffers.getDescription(), travelOffers.getTypeOfTravel(), travelOffers.getDestination(),
                    travelOffers.getHotel(), travelOffers.getLevelOfAccommodation(), travelOffers.getNumberOfNights(),
                    travelOffers.getPrice(), travelOffers.getUsers_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    travelOffers.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public TravelOffers read(long id) throws SQLException {
        TravelOffers travelOffers = null;
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `description`, `typeOfTravel`, `destination`, " +
                            "`hotel`, `levelOfAccommodation`, `numberOfNights`, " +
                            "`price`, `users_id` FROM `travelOffers` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                travelOffers = new TravelOffers(
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
            }
        }
        return travelOffers;
    }

    public boolean update(TravelOffers travelOffers) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "UPDATE `travelOffers` " +
                            "SET `description`='%s', `typeOfTravel`='%s',`destination`='%s'," +
                            "`hotel`='%s', `levelOfAccommodation`='%s', `numberOfNights`=%d, " +
                            "`price`=%f, `users_id`=%d WHERE id=%d",
                    travelOffers.getDescription(), travelOffers.getTypeOfTravel(), travelOffers.getDestination(),
                    travelOffers.getHotel(), travelOffers.getLevelOfAccommodation(), travelOffers.getNumberOfNights(),
                    travelOffers.getPrice(), travelOffers.getUsers_id());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(TravelOffers travelOffers) throws SQLException {
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US,
                    "DELETE FROM `travelOffers` WHERE id=%d",
                    travelOffers.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
