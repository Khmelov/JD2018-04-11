package by.it.kasiyanov.jd03_03;

import by.it.kasiyanov.jd03_03.beans.Roles;
import by.it.kasiyanov.jd03_03.beans.TravelOffers;
import by.it.kasiyanov.jd03_03.beans.User;
import by.it.kasiyanov.jd03_03.dao.Dao;


import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

        Roles role = new Roles(0, "RoleTest");
        dao.roles.create(role);
        role.setRole("updateRole");
        dao.roles.update(role);
        System.out.println(dao.roles.getAll(""));
        dao.roles.delete(role);
        System.out.println(role);

        User user = new User(
                0,
                "TestUser03",
                "TestUser03",
                "TestUser03",
                2);
        dao.user.create(user);
        user.setLogin("changeLogin");
        dao.user.update(user);
        System.out.println(dao.user.getAll(""));
        dao.user.delete(user);
        System.out.println(user);

        TravelOffers travelOffers = new TravelOffers(
                0,
                "Offer",
                "Holiday",
                "Iland",
                "Hotel",
                "4 Stars",
                12,
                724,
                2);
        travelOffers.setDescription("testOffer");
        travelOffers.setUsers_id(1);
        dao.travelOffers.create(travelOffers);
        travelOffers.setDescription("updatOffer");
        dao.travelOffers.update(travelOffers);
        System.out.println(dao.travelOffers.getAll(""));
        dao.travelOffers.delete(travelOffers);
        System.out.println(travelOffers);

    }
}
