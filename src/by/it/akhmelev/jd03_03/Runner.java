package by.it.akhmelev.jd03_03;

import by.it.akhmelev.jd03_03.beans.User;
import by.it.akhmelev.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        User user=new User(
                0,
                "jd03_03",
                "jd03_03",
                "jd03_03",
                2);
        dao.user.create(user);
        user.setLogin("changeLogin");
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);
    }
}
