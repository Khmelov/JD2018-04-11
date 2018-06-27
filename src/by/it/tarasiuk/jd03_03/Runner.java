package by.it.tarasiuk.jd03_03;

import by.it.tarasiuk.jd03_03.beans.Role;
import by.it.tarasiuk.jd03_03.beans.User;
import by.it.tarasiuk.jd03_03.dao.Dao;
import by.it.tarasiuk.jd03_03.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    private static void showAllUsers() throws SQLException{
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDao().getAll("");
        for (User each:users) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showAllUsers();

        User user = new User(0,"Nick01","pnick","nick01@gmail.com",2);
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showAllUsers();

        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("NICK");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showAllUsers();

        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showAllUsers();
    }
}

