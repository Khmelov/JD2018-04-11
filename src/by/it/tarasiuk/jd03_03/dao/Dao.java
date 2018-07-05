package by.it.tarasiuk.jd03_03.dao;

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
