package by.it.krivenkova.jd03_03.dao;

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

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }
}
