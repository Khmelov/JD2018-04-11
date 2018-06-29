package by.it.kashayed.Project.java.dao;

public class Dao {
    private static Dao dao;
    public DaoOwner owner;
    public DaoOwners owners;
    public DaoCars cars;

    private Dao() {
        owners = new DaoOwners();
        owner = new DaoOwner();
        cars = new DaoCars();
    }

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        return dao;
    }
}
