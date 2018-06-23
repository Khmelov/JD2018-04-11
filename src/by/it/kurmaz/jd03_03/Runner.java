package by.it.kurmaz.jd03_03;

import by.it.kurmaz.jd03_03.DAO.DAO;
import by.it.kurmaz.jd03_03.beans.*;
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
        System.out.println(dao.user.getAll(""));
        dao.user.read(1);
        dao.user.delete(user);

        Admin admin = new Admin(
                0,
                "SuperAdmin",
                "password1",
                "email",
                "+3757373737",
                1
        );
        dao.admin.create(admin);
        admin.setPassword("password2");
        dao.admin.update(admin);
        System.out.println(dao.admin.getAll(""));
        System.out.println(dao.admin.read(1));
        dao.admin.delete(admin);

        Address address = new Address();
        address.setCountry("USA");
        address.setCity("NYC");
        address.setStreet("54 AV");
        address.setBuilding("55");
        address.setApt("111");
        address.setUsers_id(4);
        address.setZip("22200999");
        dao.address.create(address);
        address.setZip("999000222");
        dao.address.update(address);
        System.out.println(dao.address.getAll(""));
        System.out.println(dao.address.read(2));
        dao.address.delete(address);

        Catalog catalog = new Catalog();
        catalog.setAmount(100);
        catalog.setName("Bormotuha");
        catalog.setPrice(1);
        dao.catalog.create(catalog);
        catalog.setPrice(1.5);
        dao.catalog.update(catalog);
        System.out.println(dao.catalog.getAll(""));
        System.out.println(dao.catalog.read(3));
        dao.catalog.delete(catalog);

        Order order = new Order(0, 0, 1);
        dao.order.create(order);
        order.setUsers_ID(2);
        dao.order.update(order);
        System.out.println(dao.order.getAll(""));
        System.out.println(dao.order.read(1));
        dao.order.delete(order);

        ShippingList list = new ShippingList();
        list.setQuantity("5");
        list.setOrder_ID(2);
        list.setCatalog_ID(3);
        dao.shippingList.create(list);
        list.setQuantity("10");
        dao.shippingList.update(list);
        System.out.println(dao.shippingList.getAll(""));
        System.out.println(dao.shippingList.read(1));
        dao.shippingList.delete(list);

        Role role = new Role();
        role.setRole("Baklan");
        dao.roles.create(role);
        role.setRole("SuperBaklan");
        dao.roles.update(role);
        System.out.println(dao.roles.getAll(""));
        System.out.println(dao.roles.read(3));
        dao.roles.delete(role);
    }
}
