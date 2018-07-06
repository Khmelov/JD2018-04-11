package by.it.gavrilchik.jd03_03.DAO;

import by.it.gavrilchik.jd03_03.beans.Role;

public class DaoRole extends UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "roles");
    }
}
