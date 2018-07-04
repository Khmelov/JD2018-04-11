package by.it.lanevich.jd03_03;

import by.it.lanevich.jd03_03.beans.Good;
import by.it.lanevich.jd03_03.beans.Order;
import by.it.lanevich.jd03_03.beans.Role;
import by.it.lanevich.jd03_03.beans.User;
import by.it.lanevich.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        //проверим роль
        Role role=new Role(0,"roleTest");
        dao.role.create(role);
        role.setRole("updateRole");
        dao.role.update(role);
        dao.role.delete(role);
        System.out.println(role);

        //проверим user
        User user=new User(
                0,
                "jd03_03",
                "jd03_03",
                "jd03_03",
                "jd03_03",
                "jd03_03",
                2);
        dao.user.create(user);
        user.setLogin("changeLogin");
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);

        //проверим good
        Good good=new Good();
        good.setDescription("test description");
        good.setIdgood(1245);
        good.setGoodname("update name222");
        good.setPiecies(4);
        good.setPrice(45);
        dao.good.create(good);
        dao.good.update(good);
  //      dao.good.delete(good);
        System.out.println(good);

        //проверим order
        Order order=new Order();
        order.setNumgood(2);
        order.setOrd_id(1);
        order.setUsers_id(1);
        order.setGoods_id(3);
        dao.order.create(order);
        dao.order.update(order);
        dao.order.delete(order);
        System.out.println(order);



        //проверим чтение
        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
        System.out.println(dao.good.getAll(""));
        System.out.println(dao.order.getAll(""));
    }
}
