package by.it.kurmaz.jd03_03.DAO;

import by.it.kurmaz.jd03_03.beans.Admin;
import java.sql.SQLException;
import java.util.List;

public class AdminDao implements daoInterface<Admin> {


    @Override
    public Admin read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Admin admin) throws SQLException {
        return false;
    }

    @Override
    public List<Admin> getAll(String whereANDorder) throws SQLException {
        return null;
    }
}
