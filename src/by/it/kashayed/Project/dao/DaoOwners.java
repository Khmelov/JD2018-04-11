package by.it.kashayed.Project.dao;

import by.it.kashayed.Project.bean.Owners;

public class DaoOwners extends UniversalDAO<Owners> implements DaoInterface<Owners> {
    public DaoOwners() {
        super(new Owners(),"owners");
    }
}
