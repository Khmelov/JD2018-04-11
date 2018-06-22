package by.it.rogov.jd03_02;


import by.it.rogov.jd03_02.beans.Role;
import by.it.rogov.jd03_02.beans.User;
import by.it.rogov.jd03_02.crud.CrudRole;
import by.it.rogov.jd03_02.crud.CrudUser;
import by.it.rogov.jd03_02.utiles.C_Init;
import by.it.rogov.jd03_02.utiles.C_Reset;

import java.sql.SQLException;


public class TaskC {
    public static void main(String[] args) throws SQLException {
        C_Reset.dropTables();
        C_Init.creatTables();

        CrudRole crudRole= new CrudRole();
        Role role = new Role(
           0,
           "Administrator"
        );
        if(crudRole.create(role))
            System.out.println("Creat: " +role);
        CrudUser crudUser = new CrudUser();
        User testUser = new User(
                0,
                "Admin",
                "pasadmin",
                "admin@mail.ru",
                123456,
                1);
        if(crudUser.create(testUser)) {
            System.out.println("Creat: " + testUser);
        }
         role = new Role(
                0,
                "User"
        );
        if(crudRole.create(role))
            System.out.println("Creat: " +role);
         testUser = new User(
                0,
                "User",
                "pasuser",
                "user@mail.ru",
                143458,
                2);
        if(crudUser.create(testUser)) {
            System.out.println("Creat: " + testUser);
        }
        role = new Role(
                0,
                "Guest"
        );
        if(crudRole.create(role))
            System.out.println("Creat: " +role);
    }
}
