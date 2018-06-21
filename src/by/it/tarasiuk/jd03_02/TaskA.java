package by.it.tarasiuk.jd03_02;

import by.it.tarasiuk.jd03_02.beans.User;
import by.it.tarasiuk.jd03_02.crud.CrudUser;

import java.sql.SQLException;

public class TaskA {
    public static void main(String[] args) throws SQLException {
        CrudUser crud = new CrudUser();
        User testUser = new User(
                0,
                "Nick",
                "passwordNick",
                "nick22@tut.by",
                2);
        if (crud.create(testUser))
            System.out.println("Create "+testUser);
        testUser=crud.read(testUser.getId());
        if (testUser!=null)
            System.out.println("Read "+testUser);
        testUser.setEmail("01nick@mail.com");
        if (crud.update(testUser))
            System.out.println("Update "+testUser);
        if (crud.delete(testUser))
            System.out.println("Delete "+testUser);
    }
}
