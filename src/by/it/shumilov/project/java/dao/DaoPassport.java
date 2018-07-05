package by.it.shumilov.project.java.dao;


import by.it.shumilov.project.java.beans.Passport;
import by.it.shumilov.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoPassport extends AbstractDao implements DaoInterface<Passport> {

    @Override
    public Passport read(long id) throws SQLException {
        List<Passport> all = getAll("WHERE id=" + id);
        if(all.size()>0)
            return  all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Passport passport) throws SQLException {

        String sql = String.format(Locale.US, "INSERT INTO `passports`(`firstname`, `lastname`, `pasportid`, `phone`, `users_id`) VALUES ('%s','%s','%s','%s','%d')",
                passport.getFirstname(),passport.getLastname(),passport.getPasportid(), passport.getPhone(),passport.getUsers_id());
        long id = executeUpdate(sql);
        if(id>0) {
            passport.setId(id);
            return  true;
        }
        else
            return  false;
    }

    @Override
    public boolean update(Passport passport) throws SQLException {

        String sql = String.format(Locale.US, " UPDATE `passports` SET `firstname`='%s',`lastname`='%s',`pasportid`='%s',`phone`='%s',`users_id`=%d WHERE id=%d",
                passport.getFirstname(),passport.getLastname(),passport.getPasportid(), passport.getPhone(),passport.getUsers_id(), passport.getId());

        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Passport passport) throws SQLException {

        String sql = String.format(Locale.US, " DELETE FROM `passports`  WHERE id=%d", passport.getId());

        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Passport> getAll(String whereAndOther) throws SQLException {
        List<Passport> passports = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US, " SELECT " +
                    " `id`, `firstname`, `lastname`, `pasportid`, `phone`, `users_id`" +
                    " FROM `passports` %s", whereAndOther);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Passport passport = new Passport(
                        resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("pasportid"),
                        resultSet.getString("phone"),
                        resultSet.getLong("users_id"));
                passports.add(passport);
            }

        }
        return  passports;
    }
}
