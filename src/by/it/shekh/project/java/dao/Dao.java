package by.it.shekh.project.java.dao;

import by.it.shekh.project.java.dao.resetdb.C_Init;

public class Dao {
    private static Dao dao;

    private Dao() {
        role = new DaoRole();
        user = new DaoUser();
        facadeGeneral = new DaoFacadeGeneral();
        facadeOrders = new DaoFacadeOrders();
        order = new DaoOrder();
        facadePictures = new DaoFacadePictures();
    }

    public DaoFacadeGeneral facadeGeneral;
    public DaoRole role;
    public DaoUser user;
    public DaoFacadeOrders facadeOrders;
    public DaoFacadePictures facadePictures;
    public DaoOrder order;


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
