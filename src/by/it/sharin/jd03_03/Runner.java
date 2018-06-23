package by.it.sharin.jd03_03;

import by.it.sharin.jd03_03.beans.Ad;
import by.it.sharin.jd03_03.beans.Role;
import by.it.sharin.jd03_03.beans.User;
import by.it.sharin.jd03_03.dao.Dao;

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
                2);
        dao.user.create(user);
        user.setLogin("changeLogin");
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);

        //проверим ad
        Ad ad=new Ad();
        ad.setMarka("testAd");
        ad.setUsers_id(1);
        dao.ad.create(ad);
        ad.setMarka("updateAd");
        dao.ad.update(ad);
        dao.ad.delete(ad);
        System.out.println(ad);

        //проверим чтение
        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
        System.out.println(dao.ad.getAll(""));
    }
}
