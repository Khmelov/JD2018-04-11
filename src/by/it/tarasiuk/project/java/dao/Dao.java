package by.it.tarasiuk.project.java.dao;

import by.it.tarasiuk.project.java.connection.*;

public class Dao {
    private static Dao dao;
    public RoleDao role;
    public UserDao user;
    public AdvertDao advert;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        advert = new AdvertDao();
    }

    public static void reset() {C_Init.db_init();}

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        }
        return dao;
    }
}
