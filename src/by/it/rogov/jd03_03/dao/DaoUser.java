package by.it.rogov.jd03_03.dao;

import by.it.rogov.jd03_03.beans.User;

public class DaoUser extends UniversalDAO<User> {
    public DaoUser() {
        super(new User(), "users");
    }
}
