package by.it.gavrilchik.project.java.DAO;

import by.it.gavrilchik.project.java.beans.Ad;

public class DaoAd extends UniversalDAO<Ad> {

    public DaoAd() {
        super(new Ad(), "ads");
    }
}
