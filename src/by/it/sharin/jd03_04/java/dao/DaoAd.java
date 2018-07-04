package by.it.sharin.jd03_04.java.dao;

import by.it.sharin.jd03_04.java.beans.Ad;

public class DaoAd extends UniversalDAO<Ad> {
    public DaoAd() {
        super(new Ad(), "ads");
    }
}
