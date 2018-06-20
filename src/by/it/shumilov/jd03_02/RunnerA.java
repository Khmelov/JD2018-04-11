package by.it.shumilov.jd03_02;

import by.it.shumilov.jd03_02.beans.User;
import by.it.shumilov.jd03_02.crud.CrudUser;

import java.sql.SQLException;

public class RunnerA {
    public static void main(String[] args) throws SQLException {
        CrudUser crudUser = new CrudUser();
        User user = new User(4,"testuser","testuser","testuser",2);
        if(crudUser.create(user)){
            System.out.println("Create "+ user);
        }

        User user1 = crudUser.read(user.getId());
        if(user1 != null){
            System.out.println("Read " + user1);
        }

        user.setEmail("321654");
        if(crudUser.update(user)){
            System.out.println("Update " +crudUser.read(user.getId()));

        }
        if(crudUser.delete(user)){
            System.out.println("Delete " + user);
        }


    }
}
