package by.it.mokhart.project.java.dao;

import by.it.mokhart.project.java.beans.Ad;

public class DaoAd extends UniversalDAO<Ad>{
    public DaoAd() {
        super(new Ad(), "ads");
    }
}

//import by.it.mokhart.project.java.beans.Ad;
//import by.it.mokhart.project.java.connection.DbConnection;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class DaoAd extends AbstractDao implements InterfaceDAO<Ad> {
//
//    @Override
//    public Ad read(long id) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public boolean create(Ad ad) throws SQLException {
//        String sql = String.format(Locale.US,
//                "INSERT INTO " +
//                        "`ads`(`description`, `price`, `size`, `fabric`, `colour`, `sex`, `producer`, `users_id`) " +
//                        "VALUES ('%s','%f','%s','%s','%s','%s','%s','%d')",
//                ad.getDescription(), ad.getPrice(), ad.getSize(), ad.getFabric(), ad.getColour(), ad.getSex(), ad.getProducer(), ad.getUsers_id());
//        long id = executeUpdate(sql);
//        if (id > 0) {
//            ad.setId(id);
//            return true;
//        } else
//            return false;
//    }
//
//    @Override
//    public boolean update(Ad ad) throws SQLException {
//        String sql = String.format(Locale.US,
//                "UPDATE `ads` " +
//                        "SET `description`='%s', `price`='%f', `size`='%s', `fabric`='%s', `colour`='%s', `sex`='%s', `producer`='%s', `users_id`='%d' WHERE id=%d",
//                ad.getDescription(), ad.getPrice(), ad.getSize(), ad.getFabric(), ad.getColour(), ad.getSex(), ad.getProducer(), ad.getUsers_id(), ad.getId());
//        return executeUpdate(sql) > 0;
//    }
//
//    @Override
//    public boolean delete(Ad ad) throws SQLException {
//        String sql = String.format(Locale.US,
//                "DELETE FROM `ads` WHERE id=%d",
//                ad.getId());
//        return executeUpdate(sql) > 0;
//    }
//
//    @Override
//    public List<Ad> getAll(String whereAndOrder) throws SQLException {
//        List<Ad> ads = new ArrayList<>();
//        try (
//                Connection connection = DbConnection.getConnection();
//                Statement statement = connection.createStatement()
//        ) {
//            String sql = String.format(Locale.US, "" +
//                            "SELECT `id`, `description`, 'price', 'size', 'fabric', 'colour', 'sex', 'producer', 'users_id' FROM `ads` %s",
//                    whereAndOrder);
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                Ad ad = new Ad(
//                        resultSet.getLong("id"),
//                        resultSet.getString("description"),
//                        resultSet.getDouble("price"),
//                        resultSet.getString("size"),
//                        resultSet.getString("fabric"),
//                        resultSet.getString("colour"),
//                        resultSet.getString("sex"),
//                        resultSet.getString("producer"),
//                        resultSet.getLong("users_id")
//                );
//                ads.add(ad);
//            }
//        }
//        return ads;
//    }
//}