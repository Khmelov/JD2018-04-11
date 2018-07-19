package by.it.gavrilchik.project.java.DAO;

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

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }

    public static void reset() {
        C_Init.main(new String[]{});
    }
}
