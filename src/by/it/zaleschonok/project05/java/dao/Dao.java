package by.it.zaleschonok.jd03_03.dao;

public class Dao {

    private static Dao dao;

    public DaoRoles role;
    public DaoUsers user;
    public DaoOrders order;
    public DaoProducts product;

    private Dao() {
        role = new DaoRoles();
        user = new DaoUsers();
        order = new DaoOrders();
        product = new DaoProducts();


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
