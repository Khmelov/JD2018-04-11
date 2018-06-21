package by.it.shumilov.jd03_03.dao;

public class Dao {

    private static Dao dao;
    private  Dao(){
        role = new DaoRole();
        user = new DaoUser();
        avto = new DaoAvto();
    }


    public  DaoRole role;
    public  DaoUser user;
    public  DaoAvto avto;

    public static  Dao getDao(){
        if (dao == null){
            synchronized (Dao.class){
                if (dao == null)
                    dao = new Dao();
            }
        }
        return  dao;
    }

}
