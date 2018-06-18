package by.it.kurmaz.jd03_02;
import by.it.kurmaz.jd03_02.CRUD.CrudUser;
import by.it.kurmaz.jd03_02.beans.User;

import java.sql.SQLException;

public class TaskA {
    public static void main(String[] args) throws SQLException {
        CrudUser user = new CrudUser();
        User test = new User(
                0,
                "Pavel",
                "54321",
                "pavel@tut.by",
                "+375297777777",
                "gold",
                2
        );
        if (user.create(test))
            System.out.println("Create "+test);
        test=user.read(test.getId());
        if (test !=null)
            System.out.println("Read "+test);
        assert test != null;
        test.setEmail("NewEmail@tut.by");
        if (user.update(test))
            System.out.println("Update "+test);
        if (user.delete(test))
            System.out.println("Delete "+test);
    }
}
