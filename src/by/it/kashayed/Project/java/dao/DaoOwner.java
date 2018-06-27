package by.it.kashayed.Project.java.dao;

import by.it.kashayed.Project.java.DBC.DBConnection;
import by.it.kashayed.Project.java.bean.Owner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoOwner extends DaoAbstract implements DaoInterface<Owner> {
    @Override
    public Owner read(int id) throws SQLException {
        List<Owner> all = getAll("WHERE id=" + id);
        if (all.size() > 0) {
            return all.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Owner owner) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`owner`(`Login`, `email`, `Password`, `Name`, `Owners_id`) " +
                        "VALUES ('%s','%s','%s','%s',%d)",
                owner.getLogin(), owner.getEmali(), owner.getPass(), owner.getName(), owner.getOwners_id());
        int id = executeUpdate(sql);
        if (id > 0) {
            owner.setId(id);
            return true;
        } else return false;
    }

    @Override
    public boolean update(Owner owner) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `owner` " +
                        "SET `Login`='%s',`email`='%s',`Password`='%s',`Name`='%s',`Owners_id`=%d WHERE id=%d",
                owner.getLogin(),owner.getEmali(),owner.getPass(),owner.getName(),owner.getOwners_id(),owner.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Owner owner) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `owner` WHERE id=%d",owner.getId());
        return executeUpdate(sql)>0;
    }

    @Override
    public List<Owner> getAll(String whereAndOrder) throws SQLException {
        List<Owner> all = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US,
                    "SELECT `id`, `Login`, `email`, `Password`, `Name`, `Owners_id` FROM `owner` %s",whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Owner owner = new Owner(
                        resultSet.getInt("id"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("email"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Owners_id")
                        );
                all.add(owner);
            }
        }
        return all;
    }
}
