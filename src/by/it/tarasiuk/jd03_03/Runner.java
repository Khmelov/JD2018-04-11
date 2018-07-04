package by.it.tarasiuk.jd03_03;

import by.it.tarasiuk.jd03_03.beans.Advert;
import by.it.tarasiuk.jd03_03.beans.Role;
import by.it.tarasiuk.jd03_03.beans.User;
import by.it.tarasiuk.jd03_03.dao.AdvertDao;
import by.it.tarasiuk.jd03_03.dao.Dao;
import by.it.tarasiuk.jd03_03.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    //Метод для печати всех пользователей
    private static void showAllUsers() throws SQLException{
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDao().getAll("");
        for (User each:users) System.out.println(each);
    }
    //Тоже, только для объявлений
    private static void showAllAdverts() throws SQLException{
        System.out.println("\nТаблица объявлений:");
        List<Advert> adverts=new AdvertDao().getAll("");
        for (Advert each:adverts) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //Получаем DAO и печатаем все роли и всех пользователей
        Dao dao = Dao.getDao();
        System.out.println("Роли пользователей:");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showAllUsers();
        //Добаляем пользователя
        User user = new User(0,"Nick01","pnick","nick01@gmail.com",2);
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showAllUsers();
        //меняем ему имя
        user = dao.user.getAll("WHERE ID="+user.getId()).get(0);
        user.setLogin("Nikolai");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showAllUsers();
        //удаляем его
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showAllUsers();

        showAllAdverts();
        //Добаляем объявление
        Advert advert = new Advert(0,"biker","new",2018,"test","rustic","white",50.4956,"simple bike",1);
        if (dao.advert.create(advert)) System.out.println("\nДобавлено объявление:" + advert);
        showAllAdverts();
        //Меняем значение поля "color"
        advert = dao.advert.getAll("WHERE ID="+advert.getId()).get(0);
        advert.setColor("red");
        if (dao.advert.update(advert))  System.out.println("\nИзменено:" + advert);
        showAllAdverts();
        //удаляем объявление
        if (dao.advert.delete(advert))  System.out.println("\nУдалено:" + advert);
        showAllAdverts();
    }
}

