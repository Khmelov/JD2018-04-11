package by.it.mokhart.jd03_03;

import by.it.mokhart.jd03_03.beans.Ad;
import by.it.mokhart.jd03_03.beans.Role;
import by.it.mokhart.jd03_03.beans.User;
import by.it.mokhart.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();

        Role role=new Role();
        dao.role.create(role);
        role.setRole("updateRole");
        dao.role.update(role);
        dao.role.delete(role);
        System.out.println(role);


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


        Ad ad=new Ad();
        ad.setDescription("testAd");
        ad.setUsers_id(1);
        ad.setPrice(3.0);
        ad.setSize("testL");
        ad.setFabric("testFabric");
        ad.setColour("testColour");
        ad.setSex("testSex");
        ad.setProducer("testProducer");
        dao.ad.create(ad);
        ad.setDescription("updateAd");
        dao.ad.update(ad);
        dao.ad.delete(ad);
        System.out.println(ad);


        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
        //System.out.println(dao.ad.getAll(""));
    }
}
