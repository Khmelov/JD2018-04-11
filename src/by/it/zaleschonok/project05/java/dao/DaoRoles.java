package by.it.zaleschonok.jd03_03.dao;

import by.it.zaleschonok.jd03_03.beans.Roles;

public class DaoRoles extends UniversalDAO<Roles> {
    public DaoRoles() {
        super(new Roles(), "roles");
    }
}
