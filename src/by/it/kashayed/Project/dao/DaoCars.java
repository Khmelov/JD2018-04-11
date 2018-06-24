package by.it.kashayed.Project.dao;


import by.it.kashayed.Project.bean.Cars;

public class DaoCars extends UniversalDAO<Cars> implements DaoInterface<Cars> {
    public DaoCars() {
        super(new Cars(),"cars");
    }
}
