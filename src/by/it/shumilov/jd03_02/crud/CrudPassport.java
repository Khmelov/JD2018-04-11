package by.it.shumilov.jd03_02.crud;

import by.it.shumilov.jd03_02.beans.Passport;
import by.it.shumilov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudPassport {
    public boolean create(Passport passport) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){


            String sql = String.format(Locale.US, "INSERT INTO `passports`(`firstname`, `lastname`, `pasportid`, `phone`, `users_id`) VALUES ('%s','%s','%s','%s','%d')",
                    passport.getFirstname(),passport.getLastname(),passport.getPasportid(), passport.getPhone(),passport.getUsers_id());

            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    passport.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;


    }


    public Passport read(long id) throws SQLException {
        Passport passport = null;

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " SELECT  `id`, `firstname`, `lastname`, `pasportid`, `phone`, `users_id` FROM `passports` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                passport = new Passport(
                        resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("pasportid"),
                        resultSet.getString("phone"),
                        resultSet.getLong("users_id"));

            }
        }

        return  passport;
    }

    public boolean update(Passport passport) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){


            String sql = String.format(Locale.US, " UPDATE `passports` SET `firstname`='%s',`lastname`='%s',`pasportid`='%s',`phone`='%s',`users_id`=%d WHERE id=%d",
                    passport.getFirstname(),passport.getLastname(),passport.getPasportid(), passport.getPhone(),passport.getUsers_id(), passport.getId());

            return 1==statement.executeUpdate(sql);
        }


    }

    public boolean delete(Passport passport) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " DELETE FROM `passports`  WHERE id=%d", passport.getId());


            return 1==statement.executeUpdate(sql);
        }


    }
}
