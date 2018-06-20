package by.it.kurmaz.jd03_03.DAO;

public class DAO {

    private static DAO dao;

    private DAO (){
        user = new UserDao();
        admin = new AdminDao();
        address = new AddressDao();
    }

    public DAO getDAO() {
        return dao;
    }

    public UserDao user;
    public AdminDao admin;
    public AddressDao address;

    public static DAO getDao() {
        if (dao == null)
            synchronized (DAO.class){
            if (dao == null)
                dao = new DAO();
            }
            return dao;
    }

}
