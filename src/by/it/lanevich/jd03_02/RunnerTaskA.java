package by.it.lanevich.jd03_02;

import by.it.lanevich.jd03_02.beans.User;
import by.it.lanevich.jd03_02.crud.CrudUser;
import by.it.lanevich.jd03_02.beans.Role;
import by.it.lanevich.jd03_02.crud.CrudRole;

import java.sql.SQLException;

public class RunnerTaskA {
    public static void main(String[] args) throws SQLException {
        CrudUser crud = new CrudUser();
        CrudRole role = new CrudRole();
        User testUser = new User(
                0,
                "TestUserLogin",
                "TestUserPassword",
                "TestUserEmail",
                "3752978",
                "TestUserAddress",
                2);
        if (crud.create(testUser))
            System.out.println("Create "+testUser);
        testUser=crud.read(testUser.getId());
        if (testUser!=null)
            System.out.println("Read "+testUser);
        testUser.setEmail("NewEmail");
                if (crud.update(testUser))
            System.out.println("Update "+testUser);
//        if (crud.find(testUser))
//            System.out.println("Find "+testUser);
        if (crud.delete(testUser))
            System.out.println("Delete "+testUser);
        int role_id = role.findRoleId("user");
        System.out.println("Id роли user = " + role_id);
    }
}
