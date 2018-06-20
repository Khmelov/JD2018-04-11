package by.it.shumilov.jd03_03.dao;

import by.it._examples_.jd03_03.beans.Role;

public class DaoRole extends  UniversalDAO<Role> {
    public DaoRole() {
        super(new Role(), "dbroles");
    }
}
