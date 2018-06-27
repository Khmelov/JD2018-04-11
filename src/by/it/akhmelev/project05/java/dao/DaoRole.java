package by.it.akhmelev.project05.java.dao;

import by.it.akhmelev.project05.java.beans.Role;

public class DaoRole extends UniversalDAO<Role>{
    public DaoRole() {
        super(new Role(), "roles");
    }
}
