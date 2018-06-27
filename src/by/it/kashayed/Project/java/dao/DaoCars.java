package by.it.kashayed.Project.java.dao;


import by.it.kashayed.Project.java.bean.Cars;

public class DaoCars extends UniversalDAO<Cars> implements DaoInterface<Cars> {
    public DaoCars() {
        super(new Cars(),"cars");
    }
}
