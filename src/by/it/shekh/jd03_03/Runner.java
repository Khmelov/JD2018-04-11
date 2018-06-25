package by.it.shekh.jd03_03;

import by.it.shekh.jd03_03.beans.FacadeGeneral;
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
//
//        Order order = new Order(
//                 0L,
//                "2018-06-25",
//                3);
//        dao.order.create(order);
////        order.setDate("2018-06-25");
////        dao.order.update(order);
//        System.out.println(order);
//
//        FacadeGeneral facade = new FacadeGeneral(
//                0L,
//                "Retro",
//                "1x1 m2",
//                "MDF facade",
//                145.0,
//                "Best facade for now");
//        dao.facadeGeneral.create(facade);
//        facade.setId_facade(1L);
//        facade.setFacade_price(131.15);
//        dao.facadeGeneral.update(facade);
//        FacadeGeneral facade1=new FacadeGeneral();
//        facade1.setFacade_price(140.11);
//        facade1.setFacade_description("Cutted mdf facade");
//        facade1.setFacade_dimensions("1 m2");
//        facade1.setFacade_specs("Beautiful and colourful");
//        facade1.setId_facade(2L);
//        facade1.setFacade_name("Nord");
//        dao.facadeGeneral.update(facade1);
    }
}
