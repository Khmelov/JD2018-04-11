package by.it.kurmaz.jd03_03;

import by.it.kurmaz.jd03_03.DAO.DAO;
import by.it.kurmaz.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDao();
        User user = new User(
                0,
                "P1",
                "password",
                "email",
                "+3757373737",
                "regular",
                2
        );
        dao.user.create(user);
        user.setCarma("silver");
        dao.user.update(user);
    }
}
