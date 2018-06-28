package by.it.shekh.jd03_02;

import by.it.shekh.jd03_02.beans.Role;
import by.it.shekh.jd03_02.beans.User;
import by.it.shekh.jd03_02.crud.CrudRole;
import by.it.shekh.jd03_02.crud.CrudUser;
import by.it.shekh.jd03_02.utils.TableOperations;

import java.sql.SQLException;

public class RunnerTaskC {
    public static void main(String[] args) {
        CrudRole crudRole = new CrudRole();
        CrudUser crudUser = new CrudUser();
        TableOperations.dropTables();
        TableOperations.createTables();
        Role admin = new Role(1L, "admin");
        Role user = new Role(2L, "user");
        User administrator = new User(1L, "mainadmin", "qwerty", "admin@mysite.by", 1L);
        User user1 = new User(2L, "Nikita", "mybirth_111197", "nikita11@tut.by", 2L);
        User user2 = new User(3L, "xacker228", "unknownpass", "topboy@gmail.com", 2L);
        try {
            if(crudRole.create(admin)) System.out.println("admin is done");
            if(crudRole.create(user)) System.out.println("user is done");
            if(crudUser.create(administrator)) System.out.println("admin user is done");
            if(crudUser.create(user1)) System.out.println("user1 is done");
            if(crudUser.create(user2)) System.out.println("user2 is done");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
