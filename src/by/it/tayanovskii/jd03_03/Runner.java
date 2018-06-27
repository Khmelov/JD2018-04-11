package by.it.tayanovskii.jd03_03;

import by.it.tayanovskii.jd03_03.beans.Permission;
import by.it.tayanovskii.jd03_03.beans.Publication;
import by.it.tayanovskii.jd03_03.beans.Role;
import by.it.tayanovskii.jd03_03.beans.User;
import by.it.tayanovskii.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();
        //проверим роль
        Role role=new Role(0,"roleTest");
        dao.role.create(role);
        System.out.println(role);
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
        System.out.println(user);
        user.setLogin("changeLogin");
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);

        //проверим publication
        Publication publication=new Publication();
        publication.setTitle("testPublic");
        publication.setDescription("testPublic testPublic testPublic");
        publication.setDate("22.06.2018");
        publication.setNumber(2);
        publication.setPrice(15.5);
        dao.publication.create(publication);
        System.out.println(publication);
        publication.setDescription("updatePublication");
        dao.publication.update(publication);
        dao.publication.delete(publication);
        System.out.println(publication);

        //проверим permission
        Permission permission=new Permission();
        permission.setAccess(false);
        permission.setPublications_id(2);
        permission.setUsers_id(2);
        dao.permission.create(permission);
        System.out.println(permission);
        permission.setAccess(true);
        dao.permission.update(permission);
        dao.permission.delete(permission);
        System.out.println(permission);

        //проверим чтение
        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
        System.out.println(dao.permission.getAll(""));
        System.out.println(dao.publication.getAll(""));
    }
}
