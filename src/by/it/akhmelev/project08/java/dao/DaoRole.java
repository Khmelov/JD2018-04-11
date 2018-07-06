package by.it.akhmelev.project08.java.dao;

import by.it.akhmelev.project08.java.beans.Role;
import by.it.akhmelev.project08.java.dao.UniversalDAO;

public class DaoRole extends UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "roles");
    }
}
