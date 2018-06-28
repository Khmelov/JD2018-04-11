package by.it.sharin.jd03_04.java.dao;

import by.it.sharin.jd03_04.java.dao.resetdb.C_Init;

public class Dao {

    private static Dao dao;

    private Dao() {
        role = new DaoRole();
        user = new DaoUser();
        ad = new DaoAd();
    }

    public DaoRole role;
    public DaoUser user;
    public DaoAd ad;

    public static void reset(){
        C_Init.main(new String[]{});
    }

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }
}
