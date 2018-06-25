package by.it.rogov.jd03_03.dao;

import by.it.rogov.jd03_03.beans.Permission;

public class DaoPermission extends UniversalDAO<Permission>{
    public DaoPermission() {
        super(new Permission(), "permission");
    }
}
