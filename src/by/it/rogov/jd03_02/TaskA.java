package by.it.rogov.jd03_02;

import by.it.rogov.jd03_02.beans.User;
import by.it.rogov.jd03_02.crud.CrudUser;


import java.sql.SQLException;

public class TaskA {

    public static void main(String[] args) throws SQLException {

        CrudUser crudUser = new CrudUser();
        User testUser = new User(
                3,
                "TestLogin",
                "TestPassword",
                "TestEmail",
                123456,
                2);
        if(crudUser.create(testUser)) {
            System.out.println("Creat: " + testUser);
        }
        testUser=crudUser.read(testUser.getId());

        if(testUser!=null) {
            System.out.println("Read: " + testUser);
        }
        testUser.setPhone(234568);
        if(crudUser.update(testUser)) {
            System.out.println("Update: " + testUser);
        }
        if (crudUser.delete(testUser)) {
            System.out.println("Delete: " + testUser);
        }

    }
}
