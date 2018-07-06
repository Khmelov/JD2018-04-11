package by.it.gavrilchik.jd03_03.DAO;

import by.it.gavrilchik.jd03_03.beans.Ad;

public class DaoAd extends UniversalDAO<Ad> {

    public DaoAd() {
        super(new Ad(), "ads");
    }
}
