package by.it.zakharenko.jd03_02;

import by.it.zakharenko.jd03_02.crud.ReadRole;
import by.it.zakharenko.jd03_02.beans.User;
import by.it.zakharenko.jd03_02.crud.CrudUser;
import java.sql.SQLException;

public class RunnerTaskA {
    public static void main(String[] args) throws SQLException {
        CrudUser crud = new CrudUser();
        ReadRole readRole = new ReadRole();
        User testUser = new User(
                0,
                "TestUserLogin",
                "TestUserPassword",
                "TestUserEmail",
                2);
        long ID=readRole.getID("user");
        if(ID!=-1) System.out.println("Roles_ID for user: " + ID);
        else System.out.println("Role doesn`t exist");
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
