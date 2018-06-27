package by.it.kashayed.Project.java.dao;

import by.it.kashayed.Project.java.bean.Owners;

public class DaoOwners extends UniversalDAO<Owners> implements DaoInterface<Owners> {
    public DaoOwners() {
        super(new Owners(),"owners");
    }
}
