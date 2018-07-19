package by.it.rogov.jd03_04;



import by.it.rogov.jd03_04.beans.Labrary;
import by.it.rogov.jd03_04.beans.Permission;
import by.it.rogov.jd03_04.beans.Role;
import by.it.rogov.jd03_04.beans.User;
import by.it.rogov.jd03_04.dao.Dao;
import by.it.rogov.jd03_04.utiles.C_Init;

import java.sql.SQLException;

public class Runner {

  // Table is empty,so you need use jd03_02.TaskC- you get full  the table
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        C_Init.creatTables();
        // Test Role
        Role role = new Role(0,"roleTest");
        dao.role.create(role);
        role.setRole("updateRole");
        dao.role.update(role);
        dao.role.delete(role);
        System.out.println(role);

        // Test User
        User user = new User(
                0,
                "testUser",
                "testpassword",
                "testEmail",
                2
        );
        dao.user.create(user);
        user.setEmail("test2mail");
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);

        //Test Permission
        Permission permission=new Permission(
                0,
                1,
                1

        );
        dao.permission.create(permission);
        permission.setPemissionAccess(0);
        dao.permission.update(permission);
        dao.permission.delete(permission);
        System.out.println(permission);

        //Test Labrary
        Labrary labrary = new Labrary(
                0,
                " It is some infarmation about sports",
                " You have a pay subscription, sou you have a lot of information about sports",
                1
        );
        dao.labrary.create(labrary);
        labrary.setTextFree(" I change text in this base");
        dao.labrary.update(labrary);
        dao.labrary.delete(labrary);
        System.out.println(labrary);

    }
}
