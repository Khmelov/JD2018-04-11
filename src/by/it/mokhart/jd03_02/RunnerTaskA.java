package by.it.mokhart.jd03_02;

import by.it.mokhart.jd03_02.beans.User;
import by.it.mokhart.jd03_02.crud.CrudUser;

import java.sql.SQLException;

public class RunnerTaskA {
    public static void main(String[] args) throws SQLException {
        CrudUser crud = new CrudUser();
        User testUser = new User(
                0,
                "TestUserLogin",
                "TestUserLogin",
                "TestUserLogin",
                2);
        if (crud.create(testUser))
            System.out.println("Create "+testUser);
        testUser=crud.read(testUser.getId());
        if (testUser!=null)
            System.out.println("Read "+testUser);
        testUser.setEmail("NewEmail");
        if (crud.update(testUser))
            System.out.println("Update "+testUser);
        if (crud.delete(testUser))
            System.out.println("Delete "+testUser);

    }
}
