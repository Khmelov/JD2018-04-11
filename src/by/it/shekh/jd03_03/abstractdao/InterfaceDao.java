package by.it.shekh.jd03_03.abstractdao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<Bean> {
    //READ чтение отдельной сущности
    Bean read(int id) throws SQLException;

    //CREATE,UPDATE,DELETE обновление сущности
    boolean create(Bean bean) throws SQLException;

    boolean update(Bean bean) throws SQLException;

    boolean delete(Bean bean) throws SQLException;

    //READ - чтение всех элементов по условию
    List<Bean> getAll(String whereAndOrder) throws SQLException;
    //и другие необходимые системе операции

}
