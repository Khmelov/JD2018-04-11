package by.it.zakharenko.jd03_03;

import by.it.zakharenko.jd03_03.beans.Book;
import by.it.zakharenko.jd03_03.beans.Role;
import by.it.zakharenko.jd03_03.beans.User;
import by.it.zakharenko.jd03_03.dao.Dao;

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

        //проверим book
        Book book=new Book();
        book.setDescription("testBook");
        book.setName("testName");
        book.setAuthor("testAuthor");
        book.setGenre("testGenre");
        book.setPages(356);
        book.setPrice(23.5);
        book.setUsers_id(1);
        dao.book.create(book);
        book.setDescription("updateBook");
        dao.book.update(book);
        dao.book.delete(book);
        System.out.println(book);

        //проверим чтение
        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
        System.out.println(dao.book.getAll(""));
    }
}
