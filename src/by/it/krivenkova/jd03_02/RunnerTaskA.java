package by.it.krivenkova.jd03_02;

import by.it.krivenkova.jd03_02.beans.Role;
import by.it.krivenkova.jd03_02.beans.Route;
import by.it.krivenkova.jd03_02.beans.User;
import by.it.krivenkova.jd03_02.crud.CrudRole;
import by.it.krivenkova.jd03_02.crud.CrudRoute;
import by.it.krivenkova.jd03_02.crud.CrudUser;

import java.sql.SQLException;

public class RunnerTaskA {
    public static void main(String[] args) throws SQLException {
        CrudUser crud = new CrudUser();
        User testUser = new User(
                0,
                "TestUserLogin",
                "TestUserLogin",
                "test",
                "test",
                "patr",
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
/*        if (crud.delete(testUser))
            System.out.println("Delete "+testUser);
*/

        CrudRole crudRole = new CrudRole();
        Role testRole = new Role(
                0,
                "TestUserLogin");
        if (crudRole.create(testRole))
            System.out.println("Create "+testRole);
        testRole=crudRole.read(testRole.getId());
        if (testRole!=null)
            System.out.println("Read "+testRole);
        testRole.setRole("NewRole");
        if (crudRole.update(testRole))
            System.out.println("Update "+testRole);
      /*  if (crudRole.delete(testRole))
            System.out.println("Delete "+testRole);
*/

        CrudRoute crudRoute = new CrudRoute();
        Route testRoute = new Route(
                0,
                "Tes",
                "Test",
                "Test",
                "Test",
                10.2,
                2,
                1
                );
        if (crudRoute.create(testRoute))
            System.out.println("Create "+testRoute);
        testRoute=crudRoute.read(testRoute.getId());
        if (testRoute!=null)
            System.out.println("Read "+testRoute);
        testRoute.setDepTown("NewRoute");
        if (crudRoute.update(testRoute))
            System.out.println("Update "+testRoute);
    /*   if (crudRoute.delete(testRoute))
            System.out.println("Delete "+testRoute);
*/

    }
}
