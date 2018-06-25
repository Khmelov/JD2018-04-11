package by.it.kasiyanov.jd03_03.dao;

public class Dao {

    private static Dao dao;

    private Dao(){
        roles = new RolesDao();
        user = new UserDao();
        travelOffers = new TravelOffersDao();
    }

    public RolesDao roles;
    public UserDao user;
    public TravelOffersDao travelOffers;

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }


}
