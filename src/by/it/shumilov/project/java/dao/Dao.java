package by.it.shumilov.project.java.dao;

import by.it.shumilov.project.java.dao.resetDB.C_init;

public class Dao {

    private static Dao dao;
    private  Dao(){
        role = new DaoRole();
        user = new DaoUser();
        avto = new DaoAvto();
        order = new DaoOrder();
        passport = new DaoPassport();
    }


    public  DaoRole role;
    public  DaoUser user;
    public  DaoAvto avto;
    public  DaoPassport passport;
    public  DaoOrder order;

    public static  Dao getDao(){
        if (dao == null){
            synchronized (Dao.class){
                if (dao == null)
                    dao = new Dao();
            }
        }
        return  dao;
    }


    public static void reset(){
        C_init.main(new String[]{});
    }
}
