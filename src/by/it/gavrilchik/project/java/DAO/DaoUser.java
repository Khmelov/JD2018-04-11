package by.it.gavrilchik.project.java.DAO;

import by.it.gavrilchik.project.java.beans.User;

public class DaoUser extends UniversalDAO<User> {


    public DaoUser() {
        super(new User(), "users");
    }
}
