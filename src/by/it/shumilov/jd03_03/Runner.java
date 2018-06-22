package by.it.shumilov.jd03_03;

import by.it.shumilov.jd03_03.beans.*;
import by.it.shumilov.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Runner {
    public static void main(String[] args) throws SQLException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

        Avto avto = new Avto(0,"1","2","3","4",1988,"2121 as-4", 22.2, null);
        dao.avto.create(avto);
        avto.setModel("Bla");
        dao.avto.update(avto);
        dao.avto.delete(avto);
        System.out.println(avto);




        Order order = new Order(0,sdf.parse("2015-05-26"),10 ,null ,12.2, 312, 12.4, 2,2);
        dao.order.create(order);
        order.setDiscount(72);
        dao.order.update(order);
        dao.order.delete(order);
        System.out.println(order);

        Passport passport = new Passport(0,"qw","ewq", "asdsd","212121",2);

        dao.passport.create(passport);
        passport.setFirstname("asdsfswfgfg");
        dao.passport.update(passport);
        dao.passport.delete(passport);
        System.out.println(passport);

        //проверим чтение
        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));


    }
}
