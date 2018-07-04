package by.it.tarasiuk.jd03_02;

import by.it.tarasiuk.jd03_02.beans.Advert;
import by.it.tarasiuk.jd03_02.beans.Role;
import by.it.tarasiuk.jd03_02.beans.User;
import by.it.tarasiuk.jd03_02.crud.CrudAdvert;
import by.it.tarasiuk.jd03_02.crud.CrudRole;
import by.it.tarasiuk.jd03_02.crud.CrudUser;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        CrudRole crudRole = new CrudRole();
        Role newRole = new Role(0, "manager");

        CrudUser crudUser = new CrudUser();
        User newUser = new User(
                0,
                "Nick",
                "passwordNick",
                "nick22@tut.by",
                2);

        CrudAdvert crudAdvert = new CrudAdvert();
        Advert newAdvert = new Advert(
                0,
                "aist",
                "one",
                2015,
                "kids",
                "city",
                "black",
                125.50,
                "Best bike for kids ever.",
                2);

        if (crudRole.create(newRole) && crudUser.create(newUser) && crudAdvert.create(newAdvert))
            System.out.println("Create:" + "\n" + newRole + "\n" + newUser + "\n" + newAdvert);

        newRole = crudRole.read(newRole.getId());
        newUser = crudUser.read(newUser.getId());
        newAdvert = crudAdvert.read(newAdvert.getId());

        if (newRole != null && newUser != null && newAdvert != null)
            System.out.println("Read:" + "\n" + newRole + "\n" + newUser + "\n" + newAdvert);

        newRole.setRole("newuser");
        newUser.setEmail("NewEmailNick@mail.com");
        newAdvert.setYear(2018);

        if (crudRole.update(newRole) && crudUser.update(newUser) && crudAdvert.update(newAdvert))
            System.out.println("Update:" + "\n" + newRole + "\n" + newUser + "\n" + newAdvert);

        if (crudRole.delete(newRole) && crudUser.delete(newUser) && crudAdvert.delete(newAdvert))
            System.out.println("Delete:" + "\n" + newRole + "\n" + newUser + "\n" + newAdvert);
    }
}
