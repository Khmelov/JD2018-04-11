package by.it.rogov.jd03_03.dao;

import by.it.rogov.jd03_03.beans.Labrary;

public class DaoLabrary extends UniversalDAO<Labrary> {

    public DaoLabrary() {
        super(new Labrary(), "biblioteca");
    }
}
