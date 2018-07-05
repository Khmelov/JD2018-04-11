package by.it.sharin.jd03_04.java.dao;

import by.it.sharin.jd03_04.java.beans.Role;

public class DaoRole extends UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "roles");
    }
}
