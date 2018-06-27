package by.it.kashayed.jd03_03.dao;

import by.it.kashayed.jd03_03.bean.Cars;

public class DaoCars extends UniversalDAO<Cars> implements DaoInterface<Cars>{
    public DaoCars() {
        super(new Cars(),"cars");
    }
}
