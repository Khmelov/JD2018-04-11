package by.it.shekh.jd03_03;

import by.it.shekh.jd03_03.beans.Order;
import by.it.shekh.jd03_03.beans.Role;
import by.it.shekh.jd03_03.beans.User;
import by.it.shekh.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Role role = new Role(3, "roleTest");
        dao.role.create(role);
        role.setRole("updateRole");
        dao.role.update(role);
        dao.role.delete(role);
        System.out.println(role);

        User user = new User(
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

        Order order = new Order(
                 0L,
                "2018-06-24",
                2);
        dao.order.create(order);
        order.setDate("2018-06-25");
        dao.order.update(order);
        dao.order.delete(order);
        System.out.println(order);
    }
}
