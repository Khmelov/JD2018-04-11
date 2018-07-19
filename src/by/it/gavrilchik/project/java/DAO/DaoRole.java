package by.it.gavrilchik.project.java.DAO;

import by.it.gavrilchik.project.java.beans.Role;

public class DaoRole extends UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "roles");
    }
}
