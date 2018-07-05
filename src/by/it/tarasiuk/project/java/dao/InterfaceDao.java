package by.it.tarasiuk.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Bean> {
    boolean create(Bean bean) throws SQLException;

    Bean read(long id) throws SQLException;

    boolean update(Bean bean) throws SQLException;

    boolean delete(Bean bean) throws SQLException;

    List<Bean> getAll(String whereAndOrder) throws SQLException;
}
