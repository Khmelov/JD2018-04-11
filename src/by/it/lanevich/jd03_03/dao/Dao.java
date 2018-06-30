package by.it.lanevich.jd03_03.dao;

import by.it.lanevich.jd03_03.dao.DaoGood;
import by.it.lanevich.jd03_03.dao.DaoRole;
import by.it.lanevich.jd03_03.dao.DaoUser;
import by.it.lanevich.jd03_03.dao.DaoOrder;

public class Dao {

    private static Dao dao;

    private Dao() {
        role = new DaoRole();
        user = new DaoUser();
        order = new DaoOrder();
        good = new DaoGood();
    }

    public DaoRole role;
    public DaoUser user;
    public DaoOrder order;
    public DaoGood good;


    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }
}
