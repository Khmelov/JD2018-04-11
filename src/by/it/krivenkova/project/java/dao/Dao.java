package by.it.krivenkova.project.java.dao;

import by.it.krivenkova.project.java.dao.resetdb.C_Init;

public class Dao {
    private static Dao dao;

    private Dao() {
        role = new DaoRole();
        user = new DaoUser();
        route = new DaoRoute();
    }

    public DaoRole role;
    public DaoUser user;
    public DaoRoute route;

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
