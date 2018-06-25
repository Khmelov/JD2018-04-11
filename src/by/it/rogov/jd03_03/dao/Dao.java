package by.it.rogov.jd03_03.dao;

public class Dao {

    private static Dao dao;

    public DaoRole role;
    public DaoUser user;
    public DaoPermission permission;
    public DaoLabrary labrary;

    public Dao() {
        role = new DaoRole();
        user = new DaoUser();
        permission = new DaoPermission();
        labrary = new DaoLabrary();
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
