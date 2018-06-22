package by.it.kashayed.jd03_03.dao;

import by.it.kashayed.jd03_03.bean.Owners;

public class DaoOwners extends UniversalDAO<Owners> {
    public DaoOwners() {
        super(new Owners(),"owners");
    }
}
