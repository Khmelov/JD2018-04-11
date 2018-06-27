package by.it.gavrilchik.jd03_03.DAO;

import by.it.gavrilchik.jd03_03.beans.User;

public class DaoUser extends UniversalDAO<User> {


    public DaoUser() {
        super(new User(), "users");
    }
}
