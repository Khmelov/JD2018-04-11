package by.it.shumilov.jd03_03.dao;

import by.it.shumilov.jd03_03.beans.Avto;

public class DaoAvto extends UniversalDAO<Avto> {
    public DaoAvto() {
        super(new Avto(), "dbavto");
    }


}
