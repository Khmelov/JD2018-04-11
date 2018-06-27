package by.it.rogov.jd03_03;


import by.it.rogov.jd03_03.beans.Labrary;
import by.it.rogov.jd03_03.beans.Permission;
import by.it.rogov.jd03_03.beans.Role;
import by.it.rogov.jd03_03.beans.User;
import by.it.rogov.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();

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
                123445,
                2
        );
        dao.user.create(user);
        user.setPhone(235689);
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);

        //Test Permission
        Permission permission=new Permission(
                0,
                true,
                2,
                1,
                false
        );
        dao.permission.create(permission);
        permission.setPemissionAccess(false);
        dao.permission.update(permission);
        dao.permission.delete(permission);
        System.out.println(permission);

        //Test Labrary
        Labrary labrary = new Labrary(
                0,
                " It's some infarmation about sports",
                " You have a pay subscription, sou you have a lot of information about sports"
        );
        dao.labrary.create(labrary);
        labrary.setTextFree(" I change text in this base");
        dao.labrary.update(labrary);
        dao.labrary.delete(labrary);
        System.out.println(labrary);

    }
}
