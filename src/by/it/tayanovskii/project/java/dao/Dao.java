package by.it.tayanovskii.project.java.dao;

public class Dao {

    private static Dao dao;

    private Dao() {
        role = new DaoRole();
        user = new DaoUser();
        permission = new DaoPermission();
        publication = new DaoPublication();
    }

    public DaoRole role;
    public DaoUser user;
    public DaoPermission permission;
    public DaoPublication publication;

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }
}
