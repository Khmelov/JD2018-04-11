package by.it.kurmaz.jd03_02;
import by.it.kurmaz.jd03_02.CRUD.CrudAddress;
import by.it.kurmaz.jd03_02.CRUD.CrudAdmin;
import by.it.kurmaz.jd03_02.CRUD.CrudUser;
import by.it.kurmaz.jd03_02.beans.Address;
import by.it.kurmaz.jd03_02.beans.Admin;
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

        CrudAdmin admin = new CrudAdmin();
        Admin test1 = new Admin(
                0,
                "Admin1",
                "password1",
                "admin@tut.by",
                "+375291111111",
                1
        );
        if (admin.create(test1))
            System.out.println("Create "+test1);
        test1=admin.read(test1.getId());
        if (test1 !=null)
            System.out.println("Read "+test1);
        assert test1 != null;
        test1.setEmail("NewEmail@tut.by");
        if (admin.update(test1))
            System.out.println("Update "+test1);
        if (admin.delete(test1))
            System.out.println("Delete "+test1);

        CrudAddress address = new CrudAddress();
        Address test2 = new Address(
                0,
                "Russia",
                "Vladivostok",
                "Minskaya",
                "10",
                "5",
                "6669909",
                6
        );
        if (address.create(test2))
            System.out.println("Create "+test2);
        test2=address.read(test2.getId());
        if (test2 !=null)
            System.out.println("Read "+test2);
        assert test2 != null;
        test2.setApt("555");
        if (address.update(test2))
            System.out.println("Update "+test2);
        if (address.delete(test2))
           System.out.println("Delete "+test2);
    }
}
