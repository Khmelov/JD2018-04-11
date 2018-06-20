package by.it.tarasiuk.jd03_03.dao;

import by.it.tarasiuk.jd03_02.beans.Advert;

public class DaoAdvert extends UniversalDAO<Advert> {
    public DaoAdvert() {
        super(new Advert(), "adverts");
    }
}

