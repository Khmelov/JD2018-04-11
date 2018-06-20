package by.it.tarasiuk.jd03_03.dao;

import by.it.tarasiuk.jd03_03.beans.User;

public class DaoUser extends UniversalDAO<User> {
    public DaoUser(){
        super(new User(),"users");
    }
}

