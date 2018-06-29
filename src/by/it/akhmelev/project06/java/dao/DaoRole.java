package by.it.akhmelev.project06.java.dao;

import by.it.akhmelev.project06.java.beans.Role;
import by.it.akhmelev.project06.java.dao.UniversalDAO;

public class DaoRole extends UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "roles");
    }
}
