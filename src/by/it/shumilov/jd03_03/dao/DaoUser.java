package by.it.shumilov.jd03_03.dao;

import by.it._examples_.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class DaoUser extends AbstractDao implements DaoInterface<User> {

    @Override
    public User read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        return false;
    }

    @Override
    public List<User> getAll(String whereAndOther) throws SQLException {
        return null;
    }
}
