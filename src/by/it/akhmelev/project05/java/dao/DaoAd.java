package by.it.akhmelev.project05.java.dao;


import by.it.akhmelev.project05.java.beans.Ad;

public class DaoAd extends UniversalDAO<Ad>{
    public DaoAd() {
        super(new Ad(), "ads");
    }
}
